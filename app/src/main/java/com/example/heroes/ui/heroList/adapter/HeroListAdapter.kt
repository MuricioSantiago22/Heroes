package com.example.heroes.ui.heroList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.heroes.core.BaseViewHolder
import com.example.heroes.data.model.Hero
import com.example.heroes.databinding.HeroItemBinding

class HeroListAdapter(
    private val listHero: List<Hero>,
    private val itemClickListener: OnHeroListClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnHeroListClickListener {
        fun onHeroListClick(hero: Hero)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            HeroItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = HeroListViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onHeroListClick(listHero[position])
        }
        return holder


    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is HeroListViewHolder -> holder.bind(listHero[position])
        }
    }

    override fun getItemCount(): Int =
        listHero.size

    private inner class HeroListViewHolder(
        val binding: HeroItemBinding, val context: Context
    ) : BaseViewHolder<Hero>(binding.root) {
        override fun bind(item: Hero) {
            val imageUrl = item.image
            Glide.with(context).load(imageUrl).centerCrop().into(binding.HeroImage)
        }

    }
}