package com.example.heroes.data.model

import com.google.gson.annotations.SerializedName

data class Biography(
    @SerializedName("full-name") val full_name: String = "",
    @SerializedName("alter-egos") val alter_egos: String = "",
    @SerializedName("place-of-birth") val place_of_birth: String = "",
    @SerializedName("first-appearance") val first_appearance: String = "",
    @SerializedName("publisher") val publisher: String = "",
    @SerializedName("alignment") val alignment: String = ""
)