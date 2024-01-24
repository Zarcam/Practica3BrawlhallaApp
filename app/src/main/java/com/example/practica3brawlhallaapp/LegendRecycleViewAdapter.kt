package com.example.practica3brawlhallaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practica3brawlhallaapp.databinding.FragmentItemBinding

class LegendRecycleViewAdapter(private val legends: List<Legend>): RecyclerView.Adapter<LegendRecycleViewAdapter.ViewHolder>() {
    var click: ((Int, Legend) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = legends[position]

        //Establecemos los campos del ViewHolder a los valores de cada personaje
        holder.legendName.text = item.name
        holder.damageStat.text = item.damage.toString()
        holder.defenseStat.text = item.defense.toString()
        holder.dexterityStat.text = item.dexterity.toString()
        holder.speedStat.text = item.speed.toString()

        holder.weapon1.text = item.weapons[0]
        holder.weapon2.text = item.weapons[1]

        holder.detailsButton.setOnClickListener {
            this.click?.let {it1 -> it1(position, legends[position])}
        }
    }

    override fun getItemCount(): Int {
        return legends.size
    }

    inner class ViewHolder(binding: FragmentItemBinding): RecyclerView.ViewHolder(binding.root) {
        val legendName = binding.legendName

        val damageStat = binding.damageStat
        val defenseStat = binding.defenseStat
        val dexterityStat = binding.dexterityStat
        val speedStat = binding.speedStat

        val weapon1 = binding.weapon1
        val weapon2 = binding.weapon2

        val detailsButton = binding.detailsButton
    }
}
