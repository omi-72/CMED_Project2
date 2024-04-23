package com.example.cmed_project2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cmed_project2.adapter.CharacterAdapter
import com.example.cmed_project2.databinding.FragmentCharacterListBinding
import com.example.cmed_project2.viewmodel.CharacterViewModel

class CharacterListFragment : Fragment() {

    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var characterAdapter: CharacterAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCharacterListBinding.inflate(inflater, container, false)

        characterAdapter.setOnItemClickListener {
            val action = CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment()
            findNavController().navigate(action)
        }

        characterAdapter = CharacterAdapter()
        binding.characterRecyclerView.apply {
            adapter = characterAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.getCharacters().observe(viewLifecycleOwner, Observer {
            characterAdapter.submitList(it)
        })
        return binding.root
    }


}