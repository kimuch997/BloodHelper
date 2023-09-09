package com.example.bloodhelper.ui.theme.pages.RegisterDonor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bloodhelper.navigation.ROUTE_HOME
import com.example.bloodhelper.ui.theme.BloodHelperTheme
import com.example.bloodhelper.ui.theme.LightRed

// CONFIRM PASSWROD UNSEE PASSWORD USING THE DATABASE TO SAVE THIS DATA

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
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
        Spacer(modifier = Modifier.height(40.dp))


        var name by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var bloodtype by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }
        var gender by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = {name=it},
            label = { Text(text = "Name*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {phoneNumber=it},
            label = { Text(text = "Phone number*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.height(20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = bloodtype,
            onValueChange = {bloodtype=it},
            label = { Text(text = "Blood type*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.height(20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = age,
            onValueChange = {age=it},
            label = { Text(text = "Age*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.height(20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = gender,
            onValueChange = {gender=it},
            label = { Text(text = "Gender*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.height(20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = { Text(text = "Enter email...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.height(20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = { Text(text = "Enter password...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.height(20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {confirmPassword=it},
            label = { Text(text = "Confirm Password...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.height(20.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {confirmPassword=it},
            label = { Text(text = "Confirm Password...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.height(20.dp)
        )

        Button(onClick = {
            navController.navigate(ROUTE_HOME)
        },
            colors = ButtonDefaults.buttonColors(LightRed)) {
            Text(text = "Save a life")
        }
    }
}
@Preview
@Composable
fun RegisterScreenPreview(){
    BloodHelperTheme{
        RegisterScreen(rememberNavController())
    }

}