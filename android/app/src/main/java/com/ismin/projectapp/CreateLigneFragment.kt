package com.ismin.projectapp


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class CreateLigneFragment : Fragment(){

    private lateinit var listener:LigneCreator

    override fun onCreateView(
            inflater:LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ):View? {
        val rootView = inflater.inflate(R.layout.fragment_create_ligne,container,false)

        rootView.findViewById<View>(R.id.f_create_ligne_view_clicker).setOnClickListener{listener.closeLigneCreation()}

        rootView.findViewById<Button>(R.id.f_create_ligne_btn_save).setOnClickListener{
            val nom: String = rootView.findViewById<EditText>(R.id.f_create_ligne_edt_name).text.toString()
            val numero : String = rootView.findViewById<EditText>(R.id.f_create_ligne_edt_num).text.toString()
            val type:String = rootView.findViewById<EditText>(R.id.f_create_ligne_edt_type).text.toString()
            val color:String = rootView.findViewById<EditText>(R.id.f_create_ligne_edt_color).text.toString()
            val ligne = Ligne(nom,numero,type,color)
            listener.onLigneCreated(ligne)
        }

        return rootView

    }

    override fun onAttach(context: Context){
        super.onAttach(context)
        if(context is LigneCreator){
            listener =context
        } else {
            throw RuntimeException("$context must implement LigneCreator")
        }

    }


}

interface LigneCreator{
    fun onLigneCreated(ligne:Ligne)
    fun closeLigneCreation()
}