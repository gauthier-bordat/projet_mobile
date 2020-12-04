package com.ismin.projectapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ligne_table")
data class Ligne(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "favorie")
    var favorie: Boolean,

    @ColumnInfo(name = "nom")
    val nom: String,

    @ColumnInfo(name = "numero")
    val numero: String,

    @ColumnInfo(name = "type")
    val type:String,

    @ColumnInfo(name = "couleur")
    val coulor:String,

    @ColumnInfo(name = "les_arrets")
    val arrets: Arrets?,

    @ColumnInfo(name = "Selected")
    var isSelected: Boolean = false,
        ) :Serializable {
            constructor(nom:String,numero: String,type:String,coulor: String) : this(0,false,nom,numero,type,coulor,null,false)
            constructor(nom:String,numero: String,type:String,coulor: String,favorie: Boolean,arrets: Arrets?) : this(1,favorie,nom,numero,type,coulor,arrets,false)
}