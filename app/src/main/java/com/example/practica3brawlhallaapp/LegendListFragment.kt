package com.example.practica3brawlhallaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LegendListFragment : Fragment() {
    private lateinit var v: View
    private val legendViewModel: LegendViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        var adaptador = LegendRecycleViewAdapter(this.legendViewModel.legends)
        adaptador.click = {position, legend -> run{
            this.legendViewModel.selected = legend
            val fm = parentFragmentManager
            fm.commit {
                replace(R.id.fragmentContainerView, LegendDetailFragment.newInstance())
                addToBackStack("replacement")
            }
        }}
        val layourManager = GridLayoutManager(this.context, 1)
        recyclerView.layoutManager = layourManager
        recyclerView.adapter = adaptador
        return v
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LegendListFragment().apply {

            }
    }
}