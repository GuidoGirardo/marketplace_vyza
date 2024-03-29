package com.damaris.vyza_segundo.ui.screens.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.damaris.vyza_segundo.R
import com.damaris.vyza_segundo.data.loginUserFirebase
import com.damaris.vyza_segundo.ui.screens.auth.ui.theme.backgroundApp
import com.damaris.vyza_segundo.ui.screens.auth.ui.theme.textColor
import com.damaris.vyza_segundo.ui.screens.auth.ui.theme.wowColor
import com.damaris.vyza_segundo.ui.screens.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    registerClick: () -> Unit,
    homeClick: () -> Unit
) {
    var user by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val authViewModel = viewModel<AuthViewModel>()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundApp)
            .padding(horizontal = 32.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_app),
            contentDescription = "Descripción de tu imagen",
            modifier = Modifier
                .width(370.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(text = "LOGIN", fontSize = 32.sp, color = textColor, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "User", fontSize = 22.sp, color = textColor, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("User")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Password", fontSize = 22.sp, color = textColor, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Password")
            }
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                val authViewModel = AuthViewModel.getInstance()
                authViewModel.currentUser = user.toString();
                loginUserFirebase(user, password, homeClick);
                Log.i("xd", authViewModel.currentUser.toString())
            },
            modifier = Modifier
                .width(180.dp)
                .height(60.dp)
        ) {
            Text(text = "login", fontSize = 22.sp, fontWeight = FontWeight.Normal)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "don't have an account? register",
            fontSize = 20.sp,
            color = wowColor,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .clickable { registerClick() }
        )

    }
}

