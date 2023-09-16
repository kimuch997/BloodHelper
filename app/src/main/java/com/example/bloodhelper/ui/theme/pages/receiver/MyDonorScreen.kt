package com.example.bloodhelper.ui.theme.pages.receiver

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bloodhelper.R
import com.example.bloodhelper.ui.theme.LightRed

// HAS ALL ONCE DONORS AFTER SAVING AND CONTAINS THEIR NAMES AND CONTACTS PRESENTED IN A
// LAZY COLUMN MANNER TOGETHER THEN ON CLICKING POPS OUT IN AN ANIMATED MANNER

@Composable
fun MyDonorScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize()
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
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
//            .clickable { /* Handle card click here */ }
                .shadow(4.dp),
            shape = shape,
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                var context = LocalContext.current
                Image(
                    painter = painterResource(id = R.drawable.person1),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "KIM",
                style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "I am a willing donor",
//                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {
                            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"))
                            if (ContextCompat.checkSelfPermission(
                                    context,
                                    android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED
                            ) { ActivityCompat.requestPermissions(context as Activity, arrayOf<String>(
                                Manifest.permission.CALL_PHONE),
                                1
                            )
                            } else {
                                context.startActivity(intent)
                            } },
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_call_24),
                            contentDescription = "Call",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    IconButton(
                        onClick = {
                            val emailIntent =
                            Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "lxanthonykim@gmail.com", null))
                            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Donate and save ")
                            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Donor, ....")
                            context.startActivity(
                                Intent.createChooser(
                                    emailIntent,
                                    "Send email..."))},
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = "Message",
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
        }
    }


}




@Composable
@Preview
fun MyDonorScreenPreview() {
    // Preview your home screen
    MyDonorScreen(rememberNavController())
}