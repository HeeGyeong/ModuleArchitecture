package com.example.moviesearch.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.core.base.BaseActivity
import com.example.core.base.BaseViewModel
import com.example.moviesearch.R
import com.example.moviesearch.databinding.ActivityMovieSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieSearchActivity : BaseActivity<ActivityMovieSearchBinding>(R.layout.activity_movie_search) {
    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MovieSearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = viewModel
        initViewModelCallback()
        initAdapter()
        initDataCheck()

        binding.moveBtn.setOnClickListener {
            Log.d("moveBtnClick", "moveBtn onClick")
            viewModel.changeToActivity(this, BaseViewModel.ActivityAction.MOVE, "MAIN")
            finish()
        }
    }

    private fun initDataCheck() {
        if (intent.getStringExtra("text") != null) {
            viewModel.query.value = intent.getStringExtra("text")
        }
    }

    private fun initAdapter() {
        movieAdapter = MovieAdapter { movie ->
            Log.d("clickSample" , "check movie ? .. $movie")
            Intent(Intent.ACTION_VIEW, Uri.parse(movie.link)).run(this::startActivity)
        }
        binding.rvMovies.adapter = movieAdapter
    }

    private fun initViewModelCallback() {
        with(viewModel) {
            // toastMsg 가 변경 시, 변경된 text 로 toast 를 띄워준다.
            toastMsg.observe(
                this@MovieSearchActivity,
                Observer {
                    when (toastMsg.value) {
                        MovieSearchViewModel.MessageSet.LAST_PAGE -> showToast(getString(R.string.last_page_msg))
                        MovieSearchViewModel.MessageSet.EMPTY_QUERY -> showToast(getString(R.string.search_input_query_msg))
                        MovieSearchViewModel.MessageSet.NETWORK_NOT_CONNECTED -> showToast(getString(R.string.network_error_msg))
                        MovieSearchViewModel.MessageSet.SUCCESS -> showToast(getString(R.string.load_movie_success_msg))
                        MovieSearchViewModel.MessageSet.NO_RESULT -> showToast(getString(R.string.no_movie_error_msg))
                        MovieSearchViewModel.MessageSet.ERROR -> showToast(getString(R.string.error_msg))
                        MovieSearchViewModel.MessageSet.LOCAL_SUCCESS -> showToast(getString(R.string.local_db_msg))
                    }
                }
            )
        }
    }
}
