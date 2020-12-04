package com.ismin.projectapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArretAdapter(private val arrets : ArrayList<Arret>) : RecyclerView.Adapter<ArretAdapter.ArretViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArretViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.row_arrets,parent,false)
        return ArretViewHolder(row)
    }

    override fun onBindViewHolder(holder: ArretViewHolder, position: Int) {
        val(_,_,coordonnee) =  arrets[position]
        holder.bind(coordonnee)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    inner class ArretViewHolder(itemView  : View): RecyclerView.ViewHolder(itemView){
        var txvordonnee = itemView.findViewById<TextView>(R.id.f_row_arret_ordonnee_val)
        var txvabssyce = itemView.findViewById<TextView>(R.id.f_row_arret_abssyce_val)

        fun bind(coordonnee : ArrayList<Int>){
            txvordonnee.text = coordonnee[0].toString()
            txvabssyce.text = coordonnee[1].toString()
        }

    }
}
