package com.mateuszkoslacz.movipershowcase.viper.profile

import android.content.Context
import android.content.Intent
import com.mateuszkoslacz.movipershowcase.data.UserModel
import com.mateuszkoslacz.movipershowcase.model.LoginResponse

const val EXTRA_USERNAME_STRING = "EXTRA_USERNAME_STRING"

class ProfileStarter {

    fun start(context: Context, user: LoginResponse) {
        val starter = Intent(context, ProfileActivity::class.java)
        starter.putExtra(EXTRA_USERNAME_STRING, user.message)
        context.startActivity(starter)
    }
}
