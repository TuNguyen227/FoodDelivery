package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.FragmentMovieNowPlayingBinding
import com.example.fooddelivery.modelMovieData.Movie
import com.example.fooddelivery.modelMovieData.movieModel

class MovieNowPlaying : Fragment() {
    private lateinit var binding: FragmentMovieNowPlayingBinding
    private lateinit var _movieModel: movieModel

    private lateinit var adapter:MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMovieNowPlayingBinding.inflate(inflater,container,false)
        _movieModel=ViewModelProvider(this).get(movieModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        registerMovieList()

        setUpMovieList()

    }

    override fun onStart() {
        super.onStart()
        _movieModel.getMovieNowPlaying()
    }


    fun setUpMovieList()
    {

        adapter=MovieAdapter()
        val layout=LinearLayoutManager(context)
        binding.movieNowPlayingRV.adapter=adapter
        binding.movieNowPlayingRV.layoutManager=layout
    }

    fun registerMovieList() {
        _movieModel._movieData.observe(viewLifecycleOwner)
        {
            adapter.submitList(it)
        }

    }


}