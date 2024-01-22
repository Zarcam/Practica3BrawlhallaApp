package com.example.practica3brawlhallaapp

import android.net.Uri

class Legend(
    val name: String,
    val weapons: Array<String>,
    val damage: Int,
    val defense: Int,
    val dexterity: Int,
    val speed: Int,
    val description: String,
    val image: Uri)
{}