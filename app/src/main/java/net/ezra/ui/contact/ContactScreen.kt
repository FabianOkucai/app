package net.ezra.ui.contact


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.navigation.ROUTE_ABOUT
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN


@Composable
fun ContactScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .fillMaxHeight()
            .padding(horizontal = 1.dp, vertical = 2.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Contact Us",
            style = MaterialTheme.typography.headlineLarge.copy(color = Color.Black),
            textAlign = TextAlign.Center,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "We're here to help! If you have any questions, feedback, or need assistance, please don't hesitate to reach out.",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray),
            textAlign = TextAlign.Center,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Feel free to contact us through the form below, or reach us at contact@fabianokucai.com.",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray),
            textAlign = TextAlign.Center,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Our team is available Monday to Friday, 9 AM to 5 PM. We aim to respond to all inquiries within 24 hours.",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray),
            textAlign = TextAlign.Center,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Thank you for getting in touch with us!",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.Gray),
            textAlign = TextAlign.Center,
            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(24.dp))


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
    ContactScreen(rememberNavController())
}

