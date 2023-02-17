package net.herasevyan.hp.data

import com.google.gson.annotations.SerializedName

class Hero(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("alternate_names") val alternateNames: List<String>?,
    @SerializedName("species") val species: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("house") val house: String?,
    @SerializedName("dateOfBirth") val dateOfBirth: String?,
    @SerializedName("yearOfBirth") val yearOfBirth: Int?,
    @SerializedName("wizard") val wizard: Boolean?,
    @SerializedName("ancestry") val ancestry: String?,
    @SerializedName("eyeColour") val eyeColour: String?,
    @SerializedName("hairColour") val hairColour: String?,
    @SerializedName("wand") val wand: Wand?,
    @SerializedName("patronus") val patronus: String?,
    @SerializedName("hogwartsStudent") val hogwartsStudent: Boolean?,
    @SerializedName("hogwartsStaff") val hogwartsStaff: Boolean?,
    @SerializedName("actor") val actor: String?,
    @SerializedName("alternate_actors") val alternateActors: List<String>?,
    @SerializedName("alive") val alive: Boolean?,
    @SerializedName("image") val image: String?
)