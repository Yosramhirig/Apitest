package com.example.feb08.model

interface PostsApi {
    suspend fun getPosts(): List<Post>
}