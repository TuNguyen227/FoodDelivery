package com.example.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fooddelivery.databinding.ActivityNavigationViewBinding

class NavigationView : AppCompatActivity() {
    private lateinit var binding:ActivityNavigationViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_navigation_view)

        val bottomNavigationBar=binding.bottomNavigationBar

        val navController=findNavController(R.id.nav_view)
        bottomNavigationBar.setupWithNavController(navController)


    }
}