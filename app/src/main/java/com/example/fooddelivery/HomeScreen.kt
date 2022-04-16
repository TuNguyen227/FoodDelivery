package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.FragmentHomeScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class HomeScreen : Fragment() {
    private lateinit var binding:FragmentHomeScreenBinding
    private lateinit var _adapter:adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset=Restaurant_DATA.getdata()
        _adapter=adapter(dataset)

        binding.rvRestaurant.adapter=_adapter
        var layout=LinearLayoutManager(context)
        binding.rvRestaurant.layoutManager=layout
        val tooglebutton=binding.toggleButton
        tooglebutton.setOnClickListener {
            if (tooglebutton.isChecked)
            {
                 layout=GridLayoutManager(context,2)
                binding.rvRestaurant.layoutManager=layout
                binding.rvRestaurant.adapter=_adapter

            }
            else
            {
                layout=LinearLayoutManager(context)
                binding.rvRestaurant.layoutManager=layout
                binding.rvRestaurant.adapter=_adapter
            }
        }
    }


}