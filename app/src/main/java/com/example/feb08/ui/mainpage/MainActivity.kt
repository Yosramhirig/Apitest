package com.example.feb08.ui.mainpage

import PostAdapter
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.feb08.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = PostAdapter()
        binding.rvPosts.adapter = adapter

        //start observing our data
        viewModel.posts.observe(this) { posts ->
            if (posts.isEmpty()) {
                //show a progress bar if the list is empty
                binding.pbPosts.visibility = View.VISIBLE
            } else {
                //otherwise hide the progress bar
                binding.pbPosts.visibility = View.GONE
                adapter.submitList(posts)
            }
        }
    }
}