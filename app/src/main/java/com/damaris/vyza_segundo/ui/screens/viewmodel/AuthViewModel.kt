package com.damaris.vyza_segundo.ui.screens.viewmodel

import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var currentUser: String? = null

    companion object {
        private var userInstance: AuthViewModel? = null

        fun getInstance(): AuthViewModel {
            return userInstance ?: AuthViewModel().also { userInstance = it }
        }
    }
}