package com.ismin.projectapp

import java.io.Serializable


data class ligne( val _id: String,
             val favorie : Boolean,
             val nom: String,
             val numero : String,
             val type:String,
             val color:String,
             val arrets : Arrets) :Serializable {
}