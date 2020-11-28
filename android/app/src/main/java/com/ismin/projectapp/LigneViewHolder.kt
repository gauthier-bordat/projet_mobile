package com.ismin.projectapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LigneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var txvNom = itemView.findViewById<TextView>(R.id.text_nom)
    var txvNum = itemView.findViewById<TextView>(R.id.text_num)
    var imgvCouleur = itemView.findViewById<ImageView>(R.id.image_couleur)
    var imgvTram = itemView.findViewById<ImageView>(R.id.image_tram)
    var imgvBus = itemView.findViewById<ImageView>(R.id.image_bus)
    var imgvFavorie = itemView.findViewById<ImageView>(R.id.image_favorie)
    var imgvPasFavorie = itemView.findViewById<ImageView>(R.id.image_pas_favorie)
}