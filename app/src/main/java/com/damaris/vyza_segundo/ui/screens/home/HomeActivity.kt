package com.damaris.vyza_segundo.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.damaris.vyza_segundo.R
import com.damaris.vyza_segundo.data.loginUserFirebase
import com.damaris.vyza_segundo.ui.screens.auth.ui.theme.backgroundApp
import com.damaris.vyza_segundo.ui.screens.auth.ui.theme.textColor
import com.damaris.vyza_segundo.ui.screens.auth.ui.theme.wowColor
import com.damaris.vyza_segundo.ui.screens.auth.ui.theme.wowColorOscuro
import com.damaris.vyza_segundo.ui.screens.viewmodel.AuthViewModel

@Preview
@Composable
fun HomeActivity() {
    val authViewModel = AuthViewModel.getInstance()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundApp)
            .padding(horizontal = 32.dp, vertical = 16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "How are you " + authViewModel.currentUser.toString() + "?",
                fontSize = 20.sp,
                color = textColor,
                fontWeight = FontWeight.Light
            )
            Spacer(modifier = Modifier.height(4.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_app),
                contentDescription = "Descripción de tu imagen",
                modifier = Modifier
                    .width(290.dp)
                    .height(70.dp)
                    .clip(RoundedCornerShape(40.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "deals of the day",
                fontSize = 24.sp,
                color = wowColor,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(wowColor, RoundedCornerShape(12.dp))
                .align(Alignment.BottomCenter)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {},
                modifier = Modifier
                    .width(70.dp)
                    .height(45.dp)
                    .padding(vertical = 1.dp)
                    .background(wowColorOscuro, RoundedCornerShape(5.dp))
            ) {
                Text(text = "📺", fontSize = 24.sp, fontWeight = FontWeight.Normal)
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .width(70.dp)
                    .height(45.dp)
                    .padding(vertical = 1.dp)
                    .background(wowColor, RoundedCornerShape(5.dp))
            ) {
                Text(text = "🛒", fontSize = 24.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}