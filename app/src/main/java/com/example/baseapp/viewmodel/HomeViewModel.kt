package com.example.baseapp.viewmodel

import androidx.lifecycle.*
import com.example.baseapp.repository.HomeRepository
import com.example.baseapp.vo.Repo
import com.example.baseapp.vo.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {
    val username = MutableLiveData<String>()

    val repos = username.switchMap { username ->
        listRepos(username)
    }

    private fun listRepos(username: String): LiveData<Resource<List<Repo>>> = liveData {
        emitSource(repository.listRepos(username).asLiveData(Dispatchers.IO))
    }
}
