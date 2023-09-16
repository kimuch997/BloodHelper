package com.example.bloodhelper.ui.theme.pages.signup

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bloodhelper.data.AuthRepository
//import com.example.bloodhelper.data.AuthRepository
import com.example.bloodhelper.navigation.ROUTE_LOGIN_PAGE
import com.example.bloodhelper.ui.theme.BloodHelperTheme
import com.example.bloodhelper.ui.theme.LightRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        var  context = LocalContext.current
        Text(
            text ="SignUp",
            fontSize = 30.sp,
            color = LightRed,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            letterSpacing = 0.5.em
        )
        var name by remember { mutableStateOf(TextFieldValue("")) }
        var phoneNumber by remember { mutableStateOf("") }
        var bloodtype by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }
        var gender  by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var confirmPassword  by remember { mutableStateOf(TextFieldValue("")) }


        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text(text = "Name...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {phoneNumber=it},
            label = { Text(text = "Phone number*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = bloodtype,
            onValueChange = {bloodtype=it},
            label = { Text(text = "Blood type*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = age,
            onValueChange = {age=it},
            label = { Text(text = "Age*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = gender,
            onValueChange = {gender=it},
            label = { Text(text = "Gender*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f)

        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {confirmPassword=it},
            label = { Text(text = "Confirm Password...") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text) ,
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                var  authRepository = AuthRepository(navController, context)
                authRepository.signup(name.text.trim(), email.text.trim(), password.text.trim()) },
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Color.LightGray)
        ) {
            Text(text = "Signup", color = LightRed)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN_PAGE)
        },
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, color = Color.LightGray)
        ) {
            Text(text = "Have account login?", color = LightRed)
        }


    }
}



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun SignUpScreenPreview() {
    BloodHelperTheme{
        SignUpScreen(rememberNavController())
    }

}