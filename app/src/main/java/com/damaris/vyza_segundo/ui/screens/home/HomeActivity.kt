package com.damaris.vyza_segundo.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.damaris.vyza_segundo.ui.screens.viewmodel.AuthViewModel

@Composable
fun HomeActivity() {
    val authViewModel = AuthViewModel.getInstance()
    Text(text = "Hola " + authViewModel.currentUser.toString())
}