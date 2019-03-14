package com.mateuszkoslacz.movipershowcase.data

import android.util.Base64

data class LoginBundle(val login: String,
                       val password: String) {

    val username=login;
    val pass=password;
    //val authorization = "Basic " + Base64.encodeToString(("$login:$password").toByteArray(), Base64.NO_WRAP)
}

