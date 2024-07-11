package net.ezra.ui.shop

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.ui.contact.ContactScreen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.google.android.engage.shopping.datamodel.ShoppingCart
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN


@Composable
fun ShopScreen(navController: NavHostController){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Welcome to the Fun Facts Shop!",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Explore our collection of fun facts!",
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.DarkGray
            ),
            textAlign = TextAlign.Center
        )
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


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    ShopScreen(rememberNavController())
}
