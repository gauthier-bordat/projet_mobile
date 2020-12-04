package com.ismin.projectapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val ARG_ARRETS = "ARG_ARRETS"

class ArretsListFragment : Fragment(){
    private lateinit var arrets : ArrayList<Arret>
    private lateinit var rcvArrets : RecyclerView
private lateinit var arretsAdapter: ArretAdapter
private lateinit var listener: DeviceClickListener

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arrets = arguments!!.getSerializable(ARG_ARRETS) as ArrayList<Arret>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        val rootView = inflater.inflate(R.layout.activity_ligne,container,false)
        this.rcvArrets = rootView.findViewById(R.id.f_ligne_rcv_arret)
        arretsAdapter = ArretAdapter(arrets)
        this.rcvArrets.adapter = arretsAdapter
        val linearLayoutManager = LinearLayoutManager(context)
        this.rcvArrets.layoutManager = linearLayoutManager

        val dividerItemDecoration = DividerItemDecoration(context, linearLayoutManager.orientation)
        this.rcvArrets.addItemDecoration(dividerItemDecoration)

        return rootView
    }





    companion object{
        @JvmStatic
        fun newInstance(arretToDisplay: ArrayList<Arret>) : ArretsListFragment {
            val bundle = Bundle()
            bundle.putSerializable(ARG_ARRETS,arretToDisplay)

            val arretListFragment = ArretsListFragment()
            arretListFragment.arguments = bundle

            return arretListFragment
        }

}}