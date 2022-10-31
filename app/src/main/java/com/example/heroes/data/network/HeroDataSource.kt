package com.example.heroes.data.network

import com.example.heroes.core.AppConstants
import com.example.heroes.core.HeroRetrofitHelper
import com.example.heroes.data.model.HeroResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroDataSource {
    private val retrofit = HeroRetrofitHelper.getRetrofit()
    suspend fun getHeroList(): HeroResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(WebServiceHero::class.java)
                .getAllHeroList(AppConstants.API_KEY)
            response.body() ?: HeroResponse()
        }
    }
}