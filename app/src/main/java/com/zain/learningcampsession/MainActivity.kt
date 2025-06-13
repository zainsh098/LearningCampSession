package com.zain.learningcampsession

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.zain.learningcampsession.ui.adapter.PostAdapter
import com.zain.learningcampsession.databinding.ActivityMainBinding
import com.zain.learningcampsession.state.UiState
import com.zain.learningcampsession.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PostAdapter
    private val viewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = PostAdapter()
        binding.recyvlerView.layoutManager = LinearLayoutManager(this)
        binding.recyvlerView.adapter = adapter


        lifecycleScope.launch {
            viewModel.uiState.collectLatest { state ->
                when (state) {
                    is UiState.Loading -> {
                        binding.apply {

                            progressBar.visibility = View.VISIBLE

                        }
                    }

                    is UiState.Success -> {

                        binding.apply {
                            adapter.submitList(state.post)
                            progressBar.visibility = View.GONE

                        }
                    }

                    is UiState.Error -> {
                        binding.apply {
                            progressBar.visibility = View.GONE

                        }

                    }


                }


            }


        }

        lifecycleScope.launch {

            viewModel.uiEvents.collectLatest { events ->
                when (events) {
                    PostViewModel.UiEvents.NavigateToNextScreen -> {


// here we will do naviationn

                    }

                    is PostViewModel.UiEvents.ShowToast -> {

                        Toast.makeText(this@MainActivity, events.mes, Toast.LENGTH_SHORT)

                    }
                }

            }


        }


    }
}

