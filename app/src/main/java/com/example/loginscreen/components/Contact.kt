package com.example.loginscreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginscreen.R

@Composable
fun Contact(name: String, phone: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Foto de contacto",
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = phone,
                fontSize = 14.sp,
                fontWeight = FontWeight.Thin
            )
        }
    }
}