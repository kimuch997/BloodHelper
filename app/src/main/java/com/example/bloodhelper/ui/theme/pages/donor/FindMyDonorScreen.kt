package com.example.bloodhelper.ui.theme.pages.donor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bloodhelper.R
import com.example.bloodhelper.models.DonorRepository
import com.example.bloodhelper.ui.theme.BloodHelperTheme
import com.example.bloodhelper.ui.theme.LightRed

//ALL THE REGISTERED DONOR TO APPEAR HERE AS A LAZY COLUMN AFTER SEARCHING
// A SAVE BUTTON AT THE END OF THIS SO AS TO SAVE TO MY DONORS

@Composable
fun FindMyDonorScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.blood_donation), // Replace with your background image resource
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )

            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // App Logo or Icon
                Image(
                    painter = painterResource(id = R.drawable.blood_donation),
                    contentDescription = null,
                    modifier = Modifier.size(48.dp)
                )
                // App Title
                Text(
                    text = "BloodHelper",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Default,
                    ),
                    color = Color.White
                )
                // Navigation Icons or Text
                // Include your navigation elements here
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Search Bar
        BasicTextField(
            value = "",
            onValueChange = { /* Handle search input */ },
            keyboardOptions = KeyboardOptions(
                // imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = { /* Perform search action */ }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                .padding(8.dp)
                .clip(MaterialTheme.shapes.medium)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var context = LocalContext.current
        var donorRepository = DonorRepository(navController, context)
        var donors = donorRepository.viewDonor()

        LazyColumn(){
            items(donors.count()){
                var donorName = donors.get(it).name
                var donorEmail = donors.get(it).email
                var donorBloodtype = donors.get(it).bloodtype
                var donorPhoneNumber = donors.get(it).phonenumber
                var id =donors.get(it).id
                Donor(name = donorName, donorEmail = donorEmail, donorBloodtype = donorBloodtype,donorPhoneNumber = donorPhoneNumber, id = id, navController = navController, donorRepository = donorRepository)
            }
        }
    }
}
fun Donor(name:String, donorEmail:String, donorBloodtype:String,donorPhoneNumber:String, id:String,
          navController: NavHostController, donorRepository:DonorRepository
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "name")
        Text(text = "quantity")
        Text(text = "price")
//        CARD LOGIC

        }

    }




@Composable
@Preview
fun FindMyDonorPreview(){
    BloodHelperTheme {
        FindMyDonorScreen(rememberNavController())

    }
}