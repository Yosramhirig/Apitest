package com.example.feb08.ui.mainpage

import PostsApiImpl
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feb08.model.Post
import com.example.feb08.model.PostsApi
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    private var postsApi: PostsApi = PostsApiImpl(Provider.client)
    private val _posts: MutableLiveData<List<Post>> = MutableLiveData()
    val posts: LiveData<List<Post>> get() = _posts

    init {
        loadPostsFromApi()
    }

    fun loadPostsFromApi(){
        viewModelScope.launch {
            _posts.value = postsApi.getPosts()
        }
    }
}