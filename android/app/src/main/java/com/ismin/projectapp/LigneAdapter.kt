package com.ismin.projectapp

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class LigneAdapter(private val lignes: ArrayList<Ligne>) : RecyclerView.Adapter<LigneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LigneViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_lignes,parent,false)
        return LigneViewHolder(row)
    }

    override fun onBindViewHolder(holder: LigneViewHolder, position: Int) {
        val (favorie,nom,numero,type,couleur,_)= lignes[position]
        holder.txvNom.text = nom
        holder.txvNum.text = numero
        if (favorie){
            holder.imgvPasFavorie.visibility = View.GONE
            holder.imgvFavorie.visibility = View.VISIBLE
        } else {
            holder.imgvFavorie.visibility = View.GONE
            holder.imgvPasFavorie.visibility = View.VISIBLE
        }
        if(type == "bus"){
            holder.imgvBus.visibility = View.VISIBLE
            holder.imgvTram.visibility = View.GONE
        } else{
            holder.imgvTram.visibility = View.VISIBLE
            holder.imgvBus.visibility = View.GONE
        }
        holder.imgvCouleur.visibility = View.VISIBLE
        holder.imgvCouleur.setColorFilter(Color.parseColor("#"+couleur))

    }

    override fun getItemCount(): Int = lignes.size

}
