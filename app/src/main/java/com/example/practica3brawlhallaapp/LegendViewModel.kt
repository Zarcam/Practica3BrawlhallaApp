package com.example.practica3brawlhallaapp

import androidx.lifecycle.ViewModel

class LegendViewModel : ViewModel() {
    private var _legends: MutableList<Legend>
    private var _selected: Legend? = null
    val legends: List<Legend>
        get() = _legends.toList()
    var selected: Legend?
        get() = _selected
        set(item){_selected=item}

    init{
        this._legends = mutableListOf()
        this._legends.add(
            Legend("Mako", arrayOf("Katars", "Greatsword"), 6, 4, 4, 8,
                "Of all the children of Poseidon and The Sea, the largest is Kraken, the strongest is Maelstrom, but the most feared is Mako")
        )

        this._legends.add(
            Legend("Hattori", arrayOf("Spear", "Sword"), 4, 6, 4, 8,
                "A half-demon ninja who sold her soul to the devil? Well that's one, frankly rather negative, way of looking at it")
        )

        this._legends.add(
            Legend("Thea", arrayOf("Battle Boots", "Rocket Lance"), 4, 6, 3, 9,
                "Sent by Zeus to retrieve the Winged Helm of Hermes from Odin. This speedster's built herself an Eternal Sports sponsorship empire in Valhalla!")
        )

        this._legends.add(
            Legend("Red Raptor", arrayOf("Battle Boots", "Orb"), 6, 6, 4, 6,
                "The jaws of death descended. Red Raptor raised his fist. With it he grasped salvation, for Shensekai, not for him")
        )
    }
}