package com.example.heroes.ui.heroList.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.heroes.core.Resource
import com.example.heroes.data.repository.HeroRepository
import kotlinx.coroutines.Dispatchers

class HeroListViewModel(private val repo: HeroRepository) : ViewModel() {
    fun fetchHeroList() = liveData(viewModelScope.coroutineContext + Dispatchers.Main) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getAllHeroList()))

        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}

class HeroListViewModelFactory(private val repo: HeroRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HeroRepository::class.java).newInstance(repo)
    }
}
