package com.ismin.projectapp

import java.io.Serializable

data class Arrets(val aller : ArrayList<Arret>,
                    val retour : ArrayList<Arret>) :Serializable {
}