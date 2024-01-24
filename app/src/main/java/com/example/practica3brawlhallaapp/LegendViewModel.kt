package com.example.practica3brawlhallaapp

import android.net.Uri
import androidx.lifecycle.ViewModel

class LegendViewModel : ViewModel() {
    private var _legends: MutableList<Legend> = mutableListOf()
    private var _selected: Legend? = null

    //Estos parametros son usados para que otras clases no accedan directamente
    //a los parametros reales
    val legends: List<Legend>
        get() = _legends.toList()
    var selected: Legend?
        get() = _selected
        set(item){_selected=item}

    /**
     * Añade un personaje a la lista
     *
     * @param legend El personaje que se va a añadir
     */
    fun add(legend: Legend){
        this._legends.add(legend)
    }

    private val drawablePath = "android.resource://com.example.practica3brawlhallaapp/drawable/"

    //Añadimos unos cuantos personajes a la lista
    init{
        this._legends.add(
            Legend("Mako", arrayOf("Katars", "Greatsword"), 6, 4, 4, 8,
                "Of all the children of Poseidon and The Sea, the largest is Kraken, the strongest is Maelstrom, but the most feared is Mako",
                Uri.parse(drawablePath+"mako"))
        )

        this._legends.add(
            Legend("Hattori", arrayOf("Spear", "Sword"), 4, 6, 4, 8,
                "A half-demon ninja who sold her soul to the devil? Well that's one, frankly rather negative, way of looking at it",
                Uri.parse(drawablePath+"hattori"))
        )

        this._legends.add(
            Legend("Thea", arrayOf("Battle Boots", "Rocket Lance"), 4, 6, 3, 9,
                "Sent by Zeus to retrieve the Winged Helm of Hermes from Odin. This speedster's built herself an Eternal Sports sponsorship empire in Valhalla!",
                Uri.parse(drawablePath+"thea"))
        )

        this._legends.add(
            Legend("Red Raptor", arrayOf("Battle Boots", "Orb"), 6, 6, 4, 6,
                "The jaws of death descended. Red Raptor raised his fist. With it he grasped salvation, for Shensekai, not for him",
                Uri.parse(drawablePath+"redraptor"))
        )
    }
}