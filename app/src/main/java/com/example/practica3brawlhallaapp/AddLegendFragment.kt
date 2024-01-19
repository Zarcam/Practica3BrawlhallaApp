package com.example.practica3brawlhallaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practica3brawlhallaapp.databinding.FragmentAddLegendBinding

class AddLegendFragment : Fragment() {
    private lateinit var binding: FragmentAddLegendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentAddLegendBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_add_legend, container, false)


        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddLegendFragment().apply {

            }
    }
}