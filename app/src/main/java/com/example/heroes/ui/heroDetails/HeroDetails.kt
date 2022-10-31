package com.example.heroes.ui.heroDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.heroes.R
import com.example.heroes.databinding.FragmentHeroDetailsBinding


class HeroDetails : Fragment(R.layout.fragment_hero_details) {

    private lateinit var binding: FragmentHeroDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHeroDetailsBinding.bind(view)
    }
}

