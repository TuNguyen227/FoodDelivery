package com.example.fooddelivery

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentSignUpBinding


class SignUp : Fragment() {
    private lateinit var binding:FragmentSignUpBinding
    private lateinit var model: viewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSignUpBinding.inflate(inflater,container,false)
        model=ViewModelProvider(this).get(viewmodel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonsign.setOnClickListener {
            var name=binding.textname.text.toString()
            var email=binding.emailsignup.text.toString()
            var password=binding.Password.text.toString()
            var repassword=binding.repasswork.text.toString()
            model.checkemailandpass(name,email,password,repassword)
        }

        signup_success_listener()
        signup_error_listener()
    }

    private fun signup_success_listener()
    {
        model.success.observe(viewLifecycleOwner){isSuccess ->
            if (isSuccess)
            {

                Toast.makeText(context,"Success", Toast.LENGTH_SHORT).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    findNavController().navigate(R.id.action_signUp_to_signIn)

                },2000)

            }

        }
    }

    private fun signup_error_listener()
    {
        model.error.observe(viewLifecycleOwner){error->
            Toast.makeText(context,error,Toast.LENGTH_SHORT).show()

        }
    }


}