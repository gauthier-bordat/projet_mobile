package com.ismin.projectapp

import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_LIGNES = "ARG_LIGNES"

class LigneListFragment : Fragment(){
    private lateinit var lignes : ArrayList<Ligne>
    private lateinit var rcvLignes : RecyclerView
    private lateinit var ligneAdapter: LigneAdapter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        lignes = arguments!!.getSerializable(ARG_LIGNES) as ArrayList<Ligne>
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ) :View?{
        val rootView = inflater.inflate(R.layout.fragment_ligne_list, container,false)
        this.rcvLignes = rootView.findViewById(R.id.f_ligne_list_rcv_ligne)
        ligneAdapter = LigneAdapter(lignes)
        this.rcvLignes.adapter = ligneAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        this.rcvLignes.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.rcvLignes.addItemDecoration(dividerItemDecoration)

        return rootView

    }

    companion object{
        @JvmStatic
        fun newInstance(ligneToDisplay: ArrayList<Ligne>) : LigneListFragment {
            val bundle = Bundle()
            bundle.putSerializable(ARG_LIGNES,ligneToDisplay)

            val ligneListFragment = LigneListFragment()
            ligneListFragment.arguments = bundle

            return ligneListFragment
        }
    }
}