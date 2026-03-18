package com.example.loginscreen.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loginscreen.components.Contact

@Composable
fun MainScreen(navController: NavController) {

    val contactList = remember {
        mutableStateListOf(
            Pair("Juan Pérez", "612-123-4567"),
            Pair("Ana López", "612-987-6543")
        )
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { contactList.add(Pair("Nuevo", "0000000000")) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("AGREGAR")
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn {
            items(contactList) { contact ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.weight(1f)) {
                        Contact(name = contact.first, phone = contact.second)
                    }

                    TextButton(onClick = { contactList.remove(contact) }) {
                        Text("X", color = androidx.compose.ui.graphics.Color.Red)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    val navController = rememberNavController()

    MainScreen(navController)
}
