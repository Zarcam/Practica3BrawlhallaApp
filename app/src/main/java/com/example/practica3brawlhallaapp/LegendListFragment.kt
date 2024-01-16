package com.example.practica3brawlhallaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LegendListFragment : Fragment() {
    private lateinit var v: View
    private var legends: MutableList<Legend>

    init{
        this.legends = mutableListOf()
        this.legends.add(
            Legend("Mako", arrayOf("Katars", "Greatsword"), 6, 4, 4, 8,
                "Of all the children of Poseidon and The Sea, the largest is Kraken, the strongest is Maelstrom, but the most feared is Mako")
        )

        this.legends.add(
            Legend("Hattori", arrayOf("Spear", "Sword"), 4, 6, 4, 8,
                "A half-demon ninja who sold her soul to the devil? Well that's one, frankly rather negative, way of looking at it")
        )

        this.legends.add(
            Legend("Thea", arrayOf("Battle Boots", "Rocket Lance"), 4, 6, 3, 9,
                "Sent by Zeus to retrieve the Winged Helm of Hermes from Odin. This speedster's built herself an Eternal Sports sponsorship empire in Valhalla!")
        )

        this.legends.add(
            Legend("Red Raptor", arrayOf("Battle Boots", "Orb"), 6, 6, 4, 6,
                "The jaws of death descended. Red Raptor raised his fist. With it he grasped salvation, for Shensekai, not for him")
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_list, container, false)

        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerview)
        var adaptador = LegendRecycleViewAdapter(this.legends)
        adaptador.click = {position, legend -> run{
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