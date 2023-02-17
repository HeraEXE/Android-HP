package net.herasevyan.hp.api

import net.herasevyan.hp.data.Hero
import net.herasevyan.hp.data.HogwartsHouse
import net.herasevyan.hp.data.Spell
import net.herasevyan.hp.util.network.NetworkResult

interface HPApiHelper {

    suspend fun getAllCharacters(): NetworkResult<List<Hero>>

    suspend fun getAllHogwartsStudents(): NetworkResult<List<Hero>>

    suspend fun getAllHogwartsStaff(): NetworkResult<List<Hero>>

    suspend fun getAllHogwartsHouseCharacters(house: HogwartsHouse): NetworkResult<List<Hero>>

    suspend fun getAllSpells(): NetworkResult<List<Spell>>
}