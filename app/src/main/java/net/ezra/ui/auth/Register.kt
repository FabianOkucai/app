package net.ezra.ui.auth

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_REGISTER


@Composable
fun SignUpScreen(navController: NavController, onSignUpSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var error by remember { mutableStateOf<String?>(null) }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current





    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(1.dp),
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

        Text("Sign Up", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(48.dp))
        } else {
            Button(
                onClick = {
                    if (email.isBlank()) {
                        error = "Email is required"
                    } else if (password.isBlank()) {
                        error = "Password is required"
                    } else if (confirmPassword.isBlank()) {
                        error = "Password Confirmation required"
                    } else if (password != confirmPassword) {
                        error = "Passwords do not match"
                    } else {
                        isLoading = true
                        // Replace with your sign-up logic
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text("Sign Up")
            }

            Button(
                onClick = {
                    navController.navigate(ROUTE_LOGIN) {
                        popUpTo(ROUTE_REGISTER) { inclusive = true }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.Black
                )
            ) {
                Text("Login", color = Color.White)
            }
        }





        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Spacer(modifier = Modifier.weight(1f))

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
                color = MaterialTheme.colors.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }















}
private fun signUp(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
    FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val signInMethods = task.result?.signInMethods ?: emptyList()
                if (signInMethods.isNotEmpty()) {
                    onError("Email is already registered")
                } else {
                    // Email is not registered, proceed with sign-up
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { signUpTask ->
                            if (signUpTask.isSuccessful) {
                                onSuccess()
                            } else {
                                onError(signUpTask.exception?.message ?: "Sign-up failed")
                            }
                        }
                }
            } else {
                onError(task.exception?.message ?: "Failed to check email availability")
            }
        }
}


