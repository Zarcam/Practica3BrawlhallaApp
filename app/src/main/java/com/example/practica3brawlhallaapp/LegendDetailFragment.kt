package com.example.practica3brawlhallaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels

class LegendDetailFragment : Fragment() {
    private lateinit var v: View
    private val legendViewModel: LegendViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_legend_detail, container, false)

        this.legendViewModel.selected?.let {
            //TODO: Cambiar TextViews del DetailFragment
        }

        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LegendDetailFragment().apply {
            }
    }
}