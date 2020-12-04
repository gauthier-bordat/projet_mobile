package com.ismin.projectapp

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_ARRETS = "ARG_ARRETS"

class ArretsListFragment : Fragment(){
    private lateinit var ligne: Ligne
    private lateinit var arrets : ArrayList<Arret>
    private lateinit var rcvArrets : RecyclerView
private lateinit var arretsAdapter: ArretAdapter


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        ligne = arguments!!.getSerializable(ARG_ARRETS) as Ligne
        if(ligne.arrets == null){arrets = ArrayList()}
        else{arrets = ligne.arrets!!.aller}

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        val rootView = inflater.inflate(R.layout.fragment_ligne,container,false)
        this.rcvArrets = rootView.findViewById(R.id.f_ligne_rcv_arret)
        arretsAdapter = ArretAdapter(arrets,ligne)
        this.rcvArrets.adapter = arretsAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        this.rcvArrets.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.rcvArrets.addItemDecoration(dividerItemDecoration)
        ligne.isSelected = true

        var txvNom = rootView.findViewById<TextView>(R.id.f_ligne_text_nom)
        var txvNum = rootView.findViewById<TextView>(R.id.f_ligne_text_num)
        var imgvCouleur = rootView.findViewById<ImageView>(R.id.f_ligne_image_couleur)
        var imgvTram = rootView.findViewById<ImageView>(R.id.f_ligne_image_tram)
        var imgvBus = rootView.findViewById<ImageView>(R.id.f_ligne_image_bus)
        var imgvFavorie = rootView.findViewById<ImageView>(R.id.f_ligne_image_favorie)
        var imgvPasFavorie = rootView.findViewById<ImageView>(R.id.f_ligne_image_pas_favorie)
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
        return rootView
    }





    companion object{
        @JvmStatic
        fun newInstance(arretToDisplay: Ligne) : ArretsListFragment {
            val bundle = Bundle()
            bundle.putSerializable(ARG_ARRETS,arretToDisplay)

            val arretListFragment = ArretsListFragment()
            arretListFragment.arguments = bundle

            return arretListFragment
        }

}}