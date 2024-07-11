package net.ezra.ui.products

import android.annotation.SuppressLint
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InsertProductScreen(navController: NavController, onProductAdded: () -> Unit) {
    var productName by remember { mutableStateOf("") }
    var productDescription by remember { mutableStateOf("") }
    var productPrice by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }
    var productImageUri by remember { mutableStateOf<Uri?>(null) }

    var productNameError by remember { mutableStateOf(false) }
    var productDescriptionError by remember { mutableStateOf(false) }
    var productPriceError by remember { mutableStateOf(false) }
    var productQuantityError by remember { mutableStateOf(false) }
    var productImageError by remember { mutableStateOf(false) }

    var isUploading by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {

            productImageUri = it

        }
    }



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp)
    ) {
        item {
            if (productImageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(productImageUri),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Image Selected", modifier = Modifier.padding(8.dp))
                }
            }
            Spacer(modifier = Modifier
                .height(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                onClick = { launcher.launch("image/*") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)

            ) {
                Text(
                    text = "Select Image",
                    color = Color.White,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = productName,
                onValueChange = { productName = it },
                label = { Text("Fact Name") },
                isError = productNameError,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = productQuantity,
                onValueChange = { productQuantity = it },
                label = { Text("Fact Rate") },
                isError = productNameError,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = productDescription,
                onValueChange = { productDescription = it },
                label = { Text("Fact Source") },
                isError = productDescriptionError,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = productPrice,
                onValueChange = { productPrice = it },
                label = { Text("Fact Number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                isError = productPriceError,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (productNameError) {
                Text("Fact Name is required", color = Color.Red)
            }

            if (productDescriptionError) {
                Text("Fact Source is required", color = Color.Red)
            }

            if (productPriceError) {
                Text("Fact Number is required", color = Color.Red)
            }

            if (productImageError) {
                Text("Fact Image is required", color = Color.Red)
            }

            if (productQuantityError) {
                Text("Fact Rate is required", color = Color.Red)
            }


                Button(
                    onClick = {
                        productNameError = productName.isBlank()
                        productDescriptionError = productDescription.isBlank()
                        productPriceError = productPrice.isBlank()
                        productQuantityError = productQuantity.isBlank()
                        productImageError = productImageUri == null

                        if (!productNameError && !productDescriptionError && !productPriceError && !productImageError && !productQuantityError) {
                            isUploading = true
                            addProductToFirestore(
                                navController,
                                onProductAdded,
                                productName,
                                productDescription,
                                productQuantity,
                                productPrice.toDouble(),
                                productImageUri,
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth() ,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),


                    ) {



                    Text(
                        text = "Save Fact",
                        color = Color.White,
                    )
                }



        }
    }




    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.weight(1f))  // This will push the icons to the bottom

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(16.dp))
                .padding(vertical = 1.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home Icon",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            navController.navigate(ROUTE_HOME)
                        }
                )
                androidx.compose.material3.Text(
                    text = "Home",
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Info Icon",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            navController.navigate(ROUTE_ABOUT)
                        }
                )
                androidx.compose.material3.Text(text = "About", style = MaterialTheme.typography.titleMedium)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile Icon",
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .size(28.dp)
                        .clickable {
                            navController.navigate(ROUTE_LOGIN)
                        }
                )
                androidx.compose.material3.Text(text = "Profile", style = MaterialTheme.typography.titleMedium)
            }
        }
    }




}

private fun addProductToFirestore(
    navController: NavController,
    onProductAdded: () -> Unit,
    productName: String,
    productDescription: String,
    productQuantity: String,
    productPrice: Double,
    productImageUri: Uri?,
) {
    if (productImageUri == null){
        return
    }

    val productId = UUID.randomUUID().toString()
    val firestore = Firebase.firestore
    val productData = hashMapOf(
        "name" to productName,
        "description" to productDescription,
        "price" to productPrice,
        "quantity" to productQuantity,
        "imageUrl" to ""
    )

    firestore.collection("products").document(productId)
        .set(productData)
        .addOnSuccessListener {
            uploadImageToStorage(productId, productImageUri) { imageUrl ->
                firestore.collection("productse").document(productId)
                    .update("imageUrl", imageUrl)
                    .addOnSuccessListener {
                        Toast.makeText(navController.context, "Fact added successfully!", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_HOME)
                        onProductAdded()
                    }
                    .addOnFailureListener { e ->
                    }
            }
        }
        .addOnFailureListener { e ->

        }
}

private fun uploadImageToStorage(productId: String, imageUri: Uri?, onSuccess: (String) -> Unit) {
    if (imageUri == null) {
        onSuccess("")
        return
    }

    val storageRef = Firebase.storage.reference
    val imagesRef = storageRef.child("products/$productId.jpg")

    imagesRef.putFile(imageUri)
        .addOnSuccessListener { taskSnapshot ->
            imagesRef.downloadUrl
                .addOnSuccessListener { uri ->
                    onSuccess(uri.toString())
                }
                .addOnFailureListener {
                    // Handle failure to get download URL
                }
        }
        .addOnFailureListener {
            // Handle failure to upload image
        }
}