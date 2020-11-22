package com.ismin.projectapp

import java.io.Serializable

data class Arrets(val aller : Array<Arret>,
                    val retour : Array<Arret>) :Serializable {

}