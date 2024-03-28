package com.damaris.vyza_segundo.ui.navigation

import androidx.annotation.StringRes
import com.damaris.vyza_segundo.R

enum class Screens(
    @StringRes title: Int
) {
    Login(title = R.string.ls_login),
    Register(title = R.string.rs_register)
}