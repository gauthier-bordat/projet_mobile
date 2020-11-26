package com.ismin.projectapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class shearchLigneFragment : Fragment() {

    companion object {
        fun newInstance() = shearchLigneFragment()
    }

    private lateinit var viewModel: ShearchLigneViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shearch_ligne_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShearchLigneViewModel::class.java)
        // TODO: Use the ViewModel
    }

}