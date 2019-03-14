package com.mateuszkoslacz.movipershowcase.rdp

import com.mateuszkoslacz.movipershowcase.data.LoginBundle
import com.mateuszkoslacz.movipershowcase.data.UserModel
import com.mateuszkoslacz.movipershowcase.model.LoginResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

class LoginRepository {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://35.186.191.127:1377/api/user/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()!!

    fun performLogin(loginBundle: LoginBundle): Single<LoginResponse> {
        return retrofit
                .create(LoginAndGetUser::class.java)
                .getUser(loginBundle.username, loginBundle.pass)
    }

    private interface LoginAndGetUser {
        @FormUrlEncoded
        @POST("login")
        fun getUser(@Field("username") authorization: String,@Field("password") password: String): Single<LoginResponse>

    }
}