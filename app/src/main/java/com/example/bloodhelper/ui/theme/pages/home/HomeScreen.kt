package com.example.bloodhelper.ui.theme.pages.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bloodhelper.R
import com.example.bloodhelper.ui.theme.ButtonBlue
import com.example.bloodhelper.ui.theme.LightRed
import com.example.bloodhelper.ui.theme.TextWhite



@Composable
fun HomeScreen() {
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
            // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(LightRed)
                .padding(horizontal = 15.dp, vertical = 20.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "1 unit makes all the difference",
//                    style = MaterialTheme.typography.body1,
                    color = TextWhite
                )
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_bloodtype_24),
                    contentDescription = "Play",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

            // Featured Donor/Donation Section
            // Include your featured donor or donation details here

            // CTA Buttons
            // Include your CTA buttons here

            // Donor Locator Map
            // Include your map or relevant content here

            // Footer
            // Include your footer links here
        }

    }



@Composable
@Preview
fun HomeScreenPreview() {
    // Preview your home screen
    HomeScreen()
}