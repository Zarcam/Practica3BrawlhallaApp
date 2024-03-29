package com.example.practica3brawlhallaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.ListFragment
import androidx.fragment.app.commit

class HomeFragment : Fragment() {
    private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Infla el layour de este fragmento
        view = inflater.inflate(R.layout.fragment_home, container, false)

        //Cuando se pulse la imagen se pasará al siguiente fragmento que es LegendListFragment
        //Y este fragmento pasará a estar debajo en la pila
        view.findViewById<ImageView>(R.id.main_icon).setOnClickListener {
            val fm: FragmentManager = parentFragmentManager
            fm.commit {
                replace(R.id.fragmentContainerView, LegendListFragment.newInstance())
                addToBackStack("replacement")
            }
        }

        return view
    }

    companion object {
        fun newInstance() =
            HomeFragment().apply {
            }
    }
}