package net.ezra.ui.auth

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER

@Composable
fun LoginScreen(navController: NavController, onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    BackHandler {
        navController.popBackStack()
    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 1.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.acc),
            contentDescription = null,
            modifier = Modifier
                .size(220.dp)
                .clip(CircleShape)
                .border(10.dp, Color.Gray, CircleShape)
                .shadow(15.dp, CircleShape)
                .background(Color.White, CircleShape)
        )


        Text(
            text = "Login",
            style = MaterialTheme.typography.h4.copy(color = Color.Black),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.body1.copy(color = Color.Black)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = Color.Black) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.body1.copy(color = Color.Black)
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp),
                color = Color.Black
            )
        } else {
            Button(
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        error = "Please fill in all fields"
                    } else {
                        isLoading = true
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener { task ->
                                isLoading = false
                                if (task.isSuccessful) {
                                    navController.navigate(ROUTE_DASHBOARD)
                                } else {
                                    error = task.exception?.message ?: "Login failed"
                                }
                            }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp), // Adjusted padding to match the sign-up page
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text("Login")
            }


            Button(
                onClick = {
                    navController.navigate(ROUTE_REGISTER) {
                        popUpTo(ROUTE_LOGIN) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 1.dp), // Adjusted padding to match the sign-up page
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Sign Up",
                    textAlign = TextAlign.Center
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
                    .background(androidx.compose.material3.MaterialTheme.colorScheme.surface, RoundedCornerShape(16.dp))
                    .padding(vertical = 1.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home Icon",
                        tint = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                navController.navigate(ROUTE_HOME)
                            }
                    )
                    androidx.compose.material3.Text(
                        text = "Home",
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium,
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Info Icon",
                        tint = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                navController.navigate(ROUTE_ABOUT)
                            }
                    )
                    androidx.compose.material3.Text(
                        text = "About",
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    androidx.compose.material3.Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile Icon",
                        tint = androidx.compose.material3.MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier
                            .size(28.dp)
                            .clickable {
                                navController.navigate(ROUTE_LOGIN)
                            }
                    )
                    androidx.compose.material3.Text(
                        text = "Profile",
                        style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                    )
                }
            }
        }






        error?.let {
            Text(
                text = it,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 18.dp)
            )
        }
    }


















}
