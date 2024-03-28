package com.damaris.vyza_segundo.data

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

fun loginUserFirebase(user:String, password:String) {
    val db = Firebase.firestore
    db.collection("users")
        .whereEqualTo("user", user)
        .whereEqualTo("password", password)
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.i("xd", "${document.id} => ${document.data}")
            }
        }
        .addOnFailureListener { exception ->
            Log.w("xd", "Error getting documents.", exception)
        }
}