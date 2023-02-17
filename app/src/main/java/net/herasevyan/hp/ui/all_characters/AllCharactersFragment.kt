package net.herasevyan.hp.ui.all_characters

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import net.herasevyan.hp.R
import net.herasevyan.hp.databinding.FragmentAllCharactersBinding
import net.herasevyan.hp.util.network.NetworkResult
import net.herasevyan.hp.util.network.onError
import net.herasevyan.hp.util.network.onLoading
import net.herasevyan.hp.util.network.onSuccess

@AndroidEntryPoint
class AllCharactersFragment : Fragment(R.layout.fragment_all_characters) {

    private val viewModel: AllCharactersViewModel by viewModels()

    private val binding: FragmentAllCharactersBinding by viewBinding(FragmentAllCharactersBinding::bind)

    private val adapter = AllCharactersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                collectAllCharacters()
            }
        }

        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = adapter
        }
    }

    private suspend fun collectAllCharacters() {
        viewModel.allCharacters.collect { result ->
            with(binding) {
                recyclerView.isVisible = result is NetworkResult.Success
            }
            result
                .onLoading {
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                .onSuccess {
                    adapter.updateCharacters(it)
                }
                .onError {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                }
        }
    }
}