package net.ezra.ui.about

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
import net.ezra.navigation.ROUTE_HOME


@Composable
fun AboutScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "About",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )

        Text(
            text = """
    Welcome to the About screen!

    FunFacts is an innovative app designed to bring your unique facts to life. Developed by Fabian Okucai, this app allows users to insert their own fun facts and share them with others. Whether you want to share a quirky piece of trivia or a fascinating bit of knowledge, FunFacts has you covered.

    In addition to viewing and sharing facts, FunFacts also offers a shopping feature where you can browse and purchase a variety of interesting products related to the facts shared on the app. We hope you enjoy using FunFacts and discovering new and exciting information every day.
""",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 18.dp)
        )

        Text(
            text = "Contact Us:",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {











                navController.navigate(ROUTE_CONTACT)









            }
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Email Icon",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Click Here to Contact Us",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))


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

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AboutScreen(rememberNavController())
}

