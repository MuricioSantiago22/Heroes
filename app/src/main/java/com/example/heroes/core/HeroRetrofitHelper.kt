package com.example.heroes.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HeroRetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(AppConstants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).build()
    }
}