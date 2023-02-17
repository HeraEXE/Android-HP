package net.herasevyan.hp.api

import net.herasevyan.hp.data.Hero
import net.herasevyan.hp.data.HogwartsHouse
import net.herasevyan.hp.data.Spell
import net.herasevyan.hp.util.network.NetworkResult
import net.herasevyan.hp.util.network.safeApiCall
import javax.inject.Inject

class HpApiHelperImpl @Inject constructor(val api: HPApi) : HPApiHelper {

    override suspend fun getAllCharacters(): NetworkResult<List<Hero>> {
        return safeApiCall { api.getAllCharacters() }
    }

    override suspend fun getAllHogwartsStudents(): NetworkResult<List<Hero>> {
        return safeApiCall { api.getAllHogwartsStudents() }
    }

    override suspend fun getAllHogwartsStaff(): NetworkResult<List<Hero>> {
        return safeApiCall { api.getAllHogwartsStaff() }
    }

    override suspend fun getAllHogwartsHouseCharacters(house: HogwartsHouse): NetworkResult<List<Hero>> {
        return safeApiCall { api.getAllHogwartsHouseCharacters(house.tag) }
    }

    override suspend fun getAllSpells(): NetworkResult<List<Spell>> {
        return safeApiCall { api.getAllSpells() }
    }
}