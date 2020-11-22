package com.ismin.projectapp

import java.io.Serializable

data class Arret(
                val ligne : String,
                val type : String,
                val coordonnee : ArrayList<Int>) : Serializable{
}