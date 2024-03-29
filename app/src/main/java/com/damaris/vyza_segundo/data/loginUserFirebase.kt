package com.damaris.vyza_segundo.data

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import com.damaris.vyza_segundo.ui.screens.viewmodel.AuthViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import io.grpc.Context

fun loginUserFirebase(user:String, password:String, onSuccess: () -> Unit) {
    val db = Firebase.firestore
    db.collection("users")
        .whereEqualTo("user", user)
        .whereEqualTo("password", password)
        .get()
        .addOnSuccessListener { result ->
            if (!result.isEmpty) {
                onSuccess()
            }else{
                Log.i("xd", "no existe un user o password así papa")

            }
        }
        .addOnFailureListener { exception ->
            Log.i("xd", "Error getting documents.", exception)
        }
}