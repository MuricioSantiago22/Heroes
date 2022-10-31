package com.example.heroes.ui.heroList.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroes.R
import com.example.heroes.core.Resource
import com.example.heroes.data.model.Hero
import com.example.heroes.data.repository.HeroRepository
import com.example.heroes.databinding.FragmentHeroBinding
import com.example.heroes.ui.heroList.adapter.HeroListAdapter
import com.example.heroes.ui.heroList.viewModel.HeroListViewModel
import com.example.heroes.ui.heroList.viewModel.HeroListViewModelFactory

class HeroFragment : Fragment(R.layout.fragment_hero), HeroListAdapter.OnHeroListClickListener {

    private lateinit var binding: FragmentHeroBinding

    private lateinit var adapter: HeroListAdapter

    private val viewModel by viewModels<HeroListViewModel>{HeroListViewModelFactory(HeroRepository())}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeroBinding.bind(view)


        viewModel.fetchHeroList().observe(viewLifecycleOwner, Observer { result->
            when(result){
                is Resource.Loading ->{
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    binding.progressBar.visibility = View.GONE
                    val heroes = result.data.response
                    Log.d("LiveData", "${result.data}")
                    initRecyclerView(heroes)
                }
                is Resource.Failure ->{
                    binding.progressBar.visibility = View.GONE

                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }

    private fun initRecyclerView(list: List<Hero>?) {
        list?.let { _list->
            adapter = HeroListAdapter(listHero = _list, itemClickListener = this)
            binding.characterRecyclerView.layoutManager = LinearLayoutManager(context)
            binding.characterRecyclerView.adapter = adapter


        }
    }

    override fun onHeroListClick(hero: Hero) {
        val action = HeroFragmentDirections.actionHeroFragmentToHeroDetails()
    }
}