package com.example.bloodhelper.ui.theme.pages.donor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bloodhelper.R
import com.example.bloodhelper.ui.theme.BloodHelperTheme
import com.example.bloodhelper.ui.theme.LightRed

//ALL THE REGISTERED DONOR TO APPEAR HERE AS A LAZY COLUMN AFTER SEARCHING
// A SAVE BUTTON AT THE END OF THIS SO AS TO SAVE TO MY DONORS

@Composable
fun FindMyDonorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(LightRed)
        ) {
            Text(
                text = "Donate and save a life",
                fontSize = 30.sp,
                color = Color.White,
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(horizontal = 15.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
            //               HOW TO PUT BACKGROUND IMAGE ON THIS ROW
        ) {
            // App Logo or Icon
            Image(
                painter = painterResource(id = R.drawable.blood_donation),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
                //               HOW TO PUT BACKGROUND IMAGE ON THIS IMAGE
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
        Spacer(modifier = Modifier.height(20.dp))
        // Search Bar
        BasicTextField(
            value = "",
            onValueChange = { /* Handle search input */ },
            keyboardOptions = KeyboardOptions(
//                    imeAction = ImeAction.Search
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
}

@Composable
@Preview
fun FindMyDonorPreview(){
    BloodHelperTheme {
        FindMyDonorScreen()

    }
}