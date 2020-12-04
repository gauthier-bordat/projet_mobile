package com.ismin.projectapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_ligne_list.view.*

class LigneAdapter(var context: Context?, private val lignes: ArrayList<Ligne>,private val listener:ArretCreator) : RecyclerView.Adapter<LigneAdapter.LigneViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):LigneAdapter.LigneViewHolder {
        context = parent.context
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_lignes,parent,false)
        return LigneViewHolder(row)
    }

    override fun onBindViewHolder(holder: LigneAdapter.LigneViewHolder, position: Int) {
        val (_,favorie,nom,numero,type,couleur,_,_)= lignes[position]
        holder.bind(favorie,nom,numero,type,couleur)

        if(lignes[position] is Ligne){
            val dataItem = lignes[position]
            if(dataItem.isSelected){
                context?.let{
                    ContextCompat.getColor(it , R.color.select)
                }?.let { holder.itemView.setBackgroundColor(it) }
            } else {
                context?.let { ContextCompat.getColor(it, R.color.noselect) }
                    ?.let { holder.itemView.setBackgroundColor(it) }
            }
        }

    }


    override fun getItemCount(): Int = lignes.size

    inner class LigneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txvNom = itemView.findViewById<TextView>(R.id.f_row_ligne_text_nom)
        var txvNum = itemView.findViewById<TextView>(R.id.f_row_ligne_text_num)
        var imgvCouleur = itemView.findViewById<ImageView>(R.id.f_row_ligne_image_couleur)
        var imgvTram = itemView.findViewById<ImageView>(R.id.f_row_ligne_image_tram)
        var imgvBus = itemView.findViewById<ImageView>(R.id.f_row_ligne_image_bus)
        var imgvFavorie = itemView.findViewById<ImageView>(R.id.f_row_ligne_image_favorie)
        var imgvPasFavorie = itemView.findViewById<ImageView>(R.id.f_row_ligne_image_pas_favorie)

        init {
            itemView.setOnClickListener {

                val list = lignes as List<Ligne>
                for(item in list.indices){
                    list[item].isSelected = false
                }
                list[adapterPosition].isSelected = false
                val mCallback = DeviceClickListener()

                mCallback.onDeviceClick(listener,list[adapterPosition].nom)
                notifyDataSetChanged()
                context?.let { it1 ->ContextCompat.getColor(it1,R.color.select) }?.let { it2 -> itemView.constraint_list?.setBackgroundColor(it2) }
            }
        }

        fun bind(favorie:Boolean,nom:String,numero:String,type:String,couleur:String){
            txvNom.text = nom
            txvNum.text = numero
            if (favorie){
                imgvPasFavorie.visibility = View.GONE
                imgvFavorie.visibility = View.VISIBLE
            } else {
                imgvFavorie.visibility = View.GONE
                imgvPasFavorie.visibility = View.VISIBLE
            }
            if(type == "bus"){
                imgvBus.visibility = View.VISIBLE
                imgvTram.visibility = View.GONE
            } else{
                imgvTram.visibility = View.VISIBLE
                imgvBus.visibility = View.GONE
            }
            imgvCouleur.visibility = View.VISIBLE
            imgvCouleur.setColorFilter(Color.parseColor("#"+couleur))

        }
    }

}


class DeviceClickListener{

    fun onDeviceClick(listener:ArretCreator,nom: String) {
        println(nom)
        println(listener)
       if(listener is ArretCreator){ listener.GoToArret(nom)}
        else{
            println("bizzard")
       }
}}

