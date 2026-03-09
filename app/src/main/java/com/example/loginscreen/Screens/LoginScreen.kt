package com.example.loginscreen.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginscreen.R

@Composable
fun LoginScreen(navController: NavHostController) {
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
            Image(
                painter = painterResource(id = R.drawable.userinterface),
                contentDescription = "Ilustración de bienvenida",
                modifier = Modifier.size(280.dp).padding(top = 20.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Hello", style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.Black))

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Welcome To Little Drop, where\nyou manage you daily tasks",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray, textAlign = TextAlign.Center),
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(60.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF4A47A3)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Login", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 40.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFF4A47A3), CircleShape)
                    .background(Color.White)
                    .clickable {
                        navController.navigate("register_screen") // Salto al registro
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Sign Up", color = Color(0xFF4A47A3), fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Sign up using", style = TextStyle(fontSize = 14.sp, color = Color.Gray))
            Spacer(modifier = Modifier.height(16.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(15.dp), verticalAlignment = Alignment.CenterVertically) {
                SocialIcon(text = "f", color = Color(0xFF3B5998))
                SocialIcon(text = "G", color = Color(0xFFEA4335))
                SocialIcon(text = "in", color = Color(0xFF0077B5))
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

@Composable
fun SocialIcon(text: String, color: Color) {
    Box(
        modifier = Modifier.size(45.dp).clip(CircleShape).background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}