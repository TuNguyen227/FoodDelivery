package com.example.fooddelivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fooddelivery.databinding.ItemviewBinding
import com.example.fooddelivery.modelMovieData.Movie

class MovieAdapter() : ListAdapter<Movie,MovieAdapter.MovieVH>(MovieDiffUtilCallBack()){

    class MovieDiffUtilCallBack() : DiffUtil.ItemCallback<Movie>() {

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return  oldItem==newItem
        }
    }

    class MovieVH(var binding:ItemviewBinding) :RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): MovieVH {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemviewBinding.inflate(layoutInflater, parent, false)
                return MovieVH(binding)
            }
        }

        fun binding(item: Movie) {
            binding.ivName.text = item.title?.trim()
            binding.ivDescription.text = item.overview?.trim()
            val urlImage = "https://image.tmdb.org/t/p/w500${item.posterPath}"
            Glide.with(itemView.context).load(urlImage)
                .into(binding.ivImg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        return MovieVH.from(parent)
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val movie = getItem(position)
        holder.binding(movie)
    }


}





