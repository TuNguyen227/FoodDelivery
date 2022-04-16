package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentSignInBinding


class SignIn : Fragment() {
    private lateinit var binding:FragmentSignInBinding
    private lateinit var _signin_model:Sign_In_model
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSignInBinding.inflate(inflater,container,false)
        _signin_model=ViewModelProvider(this).get(Sign_In_model::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signupbtn.setOnClickListener {
            findNavController().navigate(R.id.action_signIn_to_signUp)
        }

        binding.login.setOnClickListener {
            var email=binding.usernamesignin.text.toString()
            var password=binding.passwordsignin.text.toString()
            val isAccountExist=Validators.checkaccountIsMatchData(email,password)
            if (isAccountExist)
            {
                _signin_model.signin(email,password)
                val intent= Intent(context,NavigationView::class.java)
                intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)


            }
            else
                Toast.makeText(context,"no",Toast.LENGTH_SHORT).show()
        }
    }


}