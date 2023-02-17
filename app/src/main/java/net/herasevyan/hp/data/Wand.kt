package net.herasevyan.hp.data

import com.google.gson.annotations.SerializedName

class Wand(
    @SerializedName("wood") val wood: String?,
    @SerializedName("core") val core: String?,
    @SerializedName("length") val length: Float?
)