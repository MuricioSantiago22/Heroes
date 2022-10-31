package com.example.heroes.data.network

import com.example.heroes.core.AppConstants
import com.example.heroes.data.model.HeroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServiceHero {
    @GET("/{id}")
    suspend fun getAllHeroList(@Path("id")id:String): Response<HeroResponse>
}