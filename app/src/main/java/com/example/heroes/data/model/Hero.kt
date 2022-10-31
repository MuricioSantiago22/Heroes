package com.example.heroes.data.model

import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("id") val id: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("powerstats") val powerstats: List<Powerstats>,
    @SerializedName("biography") val biography: List<Biography>,
    @SerializedName("appearance") val appearance : List<Appearance>,
    @SerializedName("work") val work : List<Work>,
    @SerializedName("connections") val connections : List<Connections>,
    @SerializedName("image")val image : String
)
