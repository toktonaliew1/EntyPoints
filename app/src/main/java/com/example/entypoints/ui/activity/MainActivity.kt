package com.example.entypoints.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.entypoints.R
import com.example.entypoints.uitel.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint
import java.util.logging.Handler

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
        loading()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }

    private fun loading(){
        val loading  = LoadingDialog(this)
        loading.startLoading()
        val handler = android.os.Handler()
        handler.postDelayed(object : Runnable{
            override fun run (){
                loading.isDismiss()
            }
        },5000)
    }
}