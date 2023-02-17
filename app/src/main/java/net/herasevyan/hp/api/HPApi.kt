package net.herasevyan.hp.api

import net.herasevyan.hp.data.Hero
import net.herasevyan.hp.data.Spell
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HPApi {

    @GET("characters")
    suspend fun getAllCharacters(): Response<List<Hero>>

    @GET("characters/students")
    suspend fun getAllHogwartsStudents(): Response<List<Hero>>

    @GET("characters/staff")
    suspend fun getAllHogwartsStaff(): Response<List<Hero>>

    @GET("characters/house/{house}")
    suspend fun getAllHogwartsHouseCharacters(
        @Path("house") house: String
    ): Response<List<Hero>>

    @GET("spells")
    suspend fun getAllSpells(): Response<List<Spell>>
}