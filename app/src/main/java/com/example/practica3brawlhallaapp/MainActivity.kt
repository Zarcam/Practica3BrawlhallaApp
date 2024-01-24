package com.example.practica3brawlhallaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import com.example.practica3brawlhallaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val legendViewModel: LegendViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Establecemos que la barra de herramientas sea la ActionBar
        //y que muestre el boton de retroceder
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Cuando se presione el boton de retroceso de la barra de herramientas
        //se actuará como si hubiera pulsado el boton de retroceso normal
        if(item.itemId == android.R.id.home){
            onBackPressedDispatcher.onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}