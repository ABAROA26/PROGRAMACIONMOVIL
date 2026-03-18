package com.example.loginscreen.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginscreen.R

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,}$".toRegex()
    val isEmailValid = email.matches(emailRegex)
    val isPasswordValid = password.isNotEmpty()
    val isFormValid = isEmailValid && isPasswordValid

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4A47A3))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(40.dp))
                .background(Color.White)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Asegúrate que el recurso exista
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )

            Text(
                text = "Welcome Back",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A47A3)
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                modifier = Modifier.fillMaxWidth(),
                isError = email.isNotEmpty() && !isEmailValid
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                isError = password.isEmpty() && email.isNotEmpty()
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    navController.navigate("main_screen")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4A47A3),
                    disabledContainerColor = Color.LightGray
                ),
                shape = RoundedCornerShape(25.dp),
                enabled = isFormValid
            ) {
                Text(text = "LOGIN", color = Color.White, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF4A47A3), CircleShape)
                    .background(Color.White)
                    .clickable {
                        navController.navigate("register_screen")
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Sign Up",
                    color = Color(0xFF4A47A3),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}