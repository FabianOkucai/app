package net.ezra.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.android.engage.shopping.datamodel.ShoppingCart
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_CONTACT
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_INSERT_PRODUCT
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER
import net.ezra.navigation.ROUTE_SHOP
import net.ezra.navigation.ROUTE_VIEW_PRODUCTS




data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {


    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }




    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Fun Facts App",
                fontSize = 50.sp,
                color = Color.Black,
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = MaterialTheme.colorScheme.primary,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(9f, 9f),
                        blurRadius = 9f
                    )

                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .clickable {
                        navController.navigate(ROUTE_INSERT_PRODUCT)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Insert Facts Icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Insert Facts",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Color.White
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .clickable {
                        navController.navigate(ROUTE_VIEW_PRODUCTS)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "View Facts Icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "View Facts",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Color.White
                    )
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(bottom = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(MaterialTheme.colorScheme.tertiary, RoundedCornerShape(8.dp))
                    .padding(16.dp)
                    .clickable {
                        navController.navigate(ROUTE_SHOP)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Shop Icon",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Facts Shop",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        color = Color.White
                    )
                )
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
                    Text(
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
                    Text(text = "About", style = MaterialTheme.typography.titleMedium)
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
                    Text(text = "Profile", style = MaterialTheme.typography.titleMedium)
                }
            }
        }



    }
}




























    @Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}
