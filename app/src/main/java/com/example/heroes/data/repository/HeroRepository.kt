package com.example.heroes.data.repository

import com.example.heroes.data.model.HeroResponse
import com.example.heroes.data.network.HeroDataSource

class HeroRepository {

    private val api = HeroDataSource()


    suspend fun getAllHeroList(): HeroResponse {
        val response = api.getHeroList()
        return response
    }

}