package com.example.heroes.data.model

import com.google.gson.annotations.SerializedName

data class Appearance(
    @SerializedName("gender")val gender:String = "",
    @SerializedName("race")val race: String = "",
    @SerializedName("height")val height : String = "",
    @SerializedName("weight")val weight: String= "",
    @SerializedName("eye-color")val eye_color : String= "",
    @SerializedName("air-color")val air_color: String= ""
)