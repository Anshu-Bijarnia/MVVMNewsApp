package com.example.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mvvmnewsapp.R
import com.example.mvvmnewsapp.databinding.ActivityNewsBinding
import com.example.mvvmnewsapp.db.ArticleDataBase
import com.example.mvvmnewsapp.repository.NewsRepository
import com.example.mvvmnewsapp.ui.fragments.NewsViewModel
import com.example.mvvmnewsapp.ui.fragments.NewsViewModelProviderFactory

class NewsActivity : AppCompatActivity() {
    lateinit var binding : ActivityNewsBinding
    lateinit var viewModel : NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.newNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val newsRepository = NewsRepository(ArticleDataBase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}