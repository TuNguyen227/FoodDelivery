package com.example.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fooddelivery.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var IsAccountSignOut:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        IsAccountSignOut=intent.getBooleanExtra("IsAccountSignOut",false)
        if (IsAccountSignOut)
        {
            var navhostFra=supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
            var navInflater=navhostFra.navController.navInflater
            var graph=navInflater.inflate(R.navigation.nav_graph)
            graph.setStartDestination(R.id.welcome)
            navhostFra.navController.graph=graph


        }

    }
}