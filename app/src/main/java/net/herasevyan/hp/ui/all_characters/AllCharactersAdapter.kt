package net.herasevyan.hp.ui.all_characters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.herasevyan.hp.data.Hero
import net.herasevyan.hp.databinding.ItemCharacterBinding

class AllCharactersAdapter : RecyclerView.Adapter<AllCharactersAdapter.ViewHolder>() {

    private val characters = mutableListOf<Hero>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateCharacters(characters: List<Hero>) {
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCharacterBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount() = characters.size

    class ViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Hero) {
            binding.nameTv.text = character.name
        }
    }
}