package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentWelcomeBinding


class Welcome : Fragment() {
    private lateinit var binding:FragmentWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.customfbbtn.setOnClickListener {
            Toast.makeText(context,"Sigining with facebook account",Toast.LENGTH_SHORT).show()
        }

        binding.customgooglebtn.setOnClickListener {
            Toast.makeText(context,"Sigining with google account",Toast.LENGTH_SHORT).show()
        }

        binding.customanotherbtn.setOnClickListener {
            findNavController().navigate(R.id.action_welcome_to_signIn)
        }
    }


}