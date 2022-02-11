package com.example.moviesearch

import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.entity.entity.Movie
import com.example.moviesearch.view.MovieAdapter
import com.example.moviesearch.view.MovieSearchViewModel
import com.example.util.EndlessRecyclerViewScrollListener

@BindingAdapter("setItems")
fun RecyclerView.setAdapterItems(items: MutableList<Movie>?) {
    items?.let {
        (adapter as MovieAdapter).submitList(it.toMutableList())
    }
}

@BindingAdapter("movieRating")
fun RatingBar.setMovieRating(score: String) {
    rating = (score.toFloatOrNull() ?: 0f) / 2
}

@BindingAdapter("urlImage")
fun ImageView.setUrlImage(url: String) {
    Glide.with(this).load(url)
        .placeholder(R.drawable.ic_launcher_background)
        .into(this)
}

@BindingAdapter("htmlText")
fun TextView.setHtmlText(html: String) {
    text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT)
}

@BindingAdapter("endlessScroll")
fun RecyclerView.setEndlessScroll(
    viewModel: MovieSearchViewModel
) {
    val scrollListener =
        object : EndlessRecyclerViewScrollListener(layoutManager as LinearLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                viewModel.requestPagingMovie(totalItemsCount + 1)
            }
        }
    addOnScrollListener(scrollListener)
}