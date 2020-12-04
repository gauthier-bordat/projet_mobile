package com.ismin.projectapp

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class ShearchLigneFragment : Fragment(){
    private lateinit var listener : LigneShearchor

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?{
        val rootView = inflater.inflate(R.layout.shearch_ligne_fragment,container, false)

        rootView.findViewById<View>(R.id.f_shearch_ligne_view_clicker).setOnClickListener{
            listener.closeLigneShearch()
        }

        rootView.findViewById<ImageView>(R.id.f_shearch_ligne_btn_shearch).setOnClickListener{
            val shearch = rootView.findViewById<EditText>(R.id.f_shearch_ligne_edt_shearch).text.toString()
            listener.onLigneShearch(shearch)
        }
        return rootView
    }
    
    override fun onAttach(context: Context){
        super.onAttach(context)
        if (context  is LigneShearchor){
            listener = context
        } else {
            throw RuntimeException("$context must implement LivreShearchor")
        }
    }
}

interface LigneShearchor{
    fun onLigneShearch(shearch : String)
    fun closeLigneShearch()
}