package com.ismin.projectapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArretAdapter(private val arrets : ArrayList<Arret>,private val ligne:Ligne) : RecyclerView.Adapter<ArretAdapter.ArretViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArretViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_arrets,parent,false)
        return ArretViewHolder(row)
    }

    override fun onBindViewHolder(holder: ArretViewHolder, position: Int) {
        val(_,_,coordonnee) =  arrets[position]
        holder.bind(coordonnee)
    }

    override fun getItemCount(): Int {
        return arrets.size
    }


    inner class ArretViewHolder(itemView  : View): RecyclerView.ViewHolder(itemView){

        var txvordonnee = itemView.findViewById<TextView>(R.id.f_row_arret_ordonnee_val)
        var txvabssyce = itemView.findViewById<TextView>(R.id.f_row_arret_abssyce_val)

        var txvNom = itemView.findViewById<TextView>(R.id.f_ligne_text_nom)
        var txvNum = itemView.findViewById<TextView>(R.id.f_ligne_text_num)
        var imgvCouleur = itemView.findViewById<ImageView>(R.id.f_ligne_image_couleur)
        var imgvTram = itemView.findViewById<ImageView>(R.id.f_ligne_image_tram)
        var imgvBus = itemView.findViewById<ImageView>(R.id.f_ligne_image_bus)
        var imgvFavorie = itemView.findViewById<ImageView>(R.id.f_ligne_image_favorie)
        var imgvPasFavorie = itemView.findViewById<ImageView>(R.id.f_ligne_image_pas_favorie)


        fun bind(coordonnee : ArrayList<Int>){
            txvordonnee.text = coordonnee[0].toString()
            txvabssyce.text = coordonnee[1].toString()
            txvNom.text = ligne.nom
            txvNum.text = ligne.numero
            if (ligne.favorie){
                imgvPasFavorie.visibility = View.GONE
                imgvFavorie.visibility = View.VISIBLE
            } else {
                imgvFavorie.visibility = View.GONE
                imgvPasFavorie.visibility = View.VISIBLE
            }
            if(ligne.type == "bus"){
                imgvBus.visibility = View.VISIBLE
                imgvTram.visibility = View.GONE
            } else{
                imgvTram.visibility = View.VISIBLE
                imgvBus.visibility = View.GONE
            }
            imgvCouleur.visibility = View.VISIBLE
            imgvCouleur.setColorFilter(Color.parseColor("#"+ligne.coulor))
        }

    }
}


