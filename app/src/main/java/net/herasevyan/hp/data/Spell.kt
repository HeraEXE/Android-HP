package net.herasevyan.hp.data

import com.google.gson.annotations.SerializedName

class Spell(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?
)