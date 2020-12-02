package com.ismin.projectapp

import java.io.Serializable


data class Ligne(
             val favorie : Boolean,
             val nom: String,
             val numero : String,
             val type:String,
             val coulor:String,
             val arrets : Arrets?) :Serializable {
}