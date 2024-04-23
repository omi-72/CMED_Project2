package com.example.cmed_project2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.cmed_project2.databinding.ListItemCharacterBinding
import com.squareup.picasso.Picasso

class CharacterAdapter : ListAdapter<com.example.cmed_project2.model.Character, CharacterAdapter.CharacterViewHolder>(CharacterDiffCallback()) {

    private var onItemClickListener: ((com.example.cmed_project2.model.Character) -> Unit)? = null

    fun setOnItemClickListener(listener: (com.example.cmed_project2.model.Character) -> Unit) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterViewHolder(binding)


    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CharacterViewHolder(private val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: com.example.cmed_project2.model.Character) {
            binding.firstName.text = character.firstName
            binding.lastName.text = character.lastName
            binding.mobileNumber.text = character.mobileNumber
            Picasso.get().load(character.profileImage).into(binding.profileImage)

        }
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.invoke(getItem(position))
                }
            }
        }
    }
}

class CharacterDiffCallback : DiffUtil.ItemCallback<com.example.cmed_project2.model.Character>() {
    override fun areItemsTheSame(oldItem: com.example.cmed_project2.model.Character, newItem: com.example.cmed_project2.model.Character): Boolean {
        return oldItem.firstName == newItem.firstName
    }

    override fun areContentsTheSame(oldItem: com.example.cmed_project2.model.Character, newItem: com.example.cmed_project2.model.Character): Boolean {
        return oldItem == newItem
    }
}
