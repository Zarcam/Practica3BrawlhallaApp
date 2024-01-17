package com.example.practica3brawlhallaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
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
            v.findViewById<TextView>(R.id.legendDetailName).text = it.name

            v.findViewById<TextView>(R.id.detailDamageStat).text = it.damage.toString()
            v.findViewById<TextView>(R.id.detailDefenseStat).text = it.defense.toString()
            v.findViewById<TextView>(R.id.detailDexterityStat).text = it.dexterity.toString()
            v.findViewById<TextView>(R.id.detailSpeedStat).text = it.speed.toString()

            v.findViewById<TextView>(R.id.detailweapon1).text = it.weapons[0]
            v.findViewById<TextView>(R.id.detailweapon2).text = it.weapons[1]

            v.findViewById<TextView>(R.id.detailLegendDesc).text = it.description

            v.findViewById<ImageView>(R.id.legendImage)

            //TODO: Cambiar imagen
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