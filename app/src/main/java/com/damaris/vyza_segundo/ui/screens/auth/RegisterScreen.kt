package com.damaris.vyza_segundo.ui.screens.auth

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun RegisterScreen(
    loginClick: () -> Unit
){
    Text(text = "holaaaa")
    Button(onClick = { loginClick() }) {

    }
}