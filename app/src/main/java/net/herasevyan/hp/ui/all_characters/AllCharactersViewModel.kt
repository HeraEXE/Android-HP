package net.herasevyan.hp.ui.all_characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.herasevyan.hp.api.HPApiHelper
import net.herasevyan.hp.data.Hero
import net.herasevyan.hp.util.network.NetworkResult
import javax.inject.Inject

@HiltViewModel
class AllCharactersViewModel @Inject constructor(
    private val apiHelper: HPApiHelper
) : ViewModel() {

    val allCharacters: StateFlow<NetworkResult<List<Hero>>> get() = allCharactersMutable

    private val allCharactersMutable = MutableStateFlow<NetworkResult<List<Hero>>>(NetworkResult.None())

    init {
        loadAllCharacters()
    }

    private fun loadAllCharacters() {
        viewModelScope.launch {
            allCharactersMutable.value = NetworkResult.Loading()
            allCharactersMutable.value = apiHelper.getAllCharacters()
        }
    }
}