package com.ismin.projectapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),LigneCreator,LigneShearchor{
    private val ligneshelf = Ligneshelf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.ligneshelf.essai()

        displayList()
    }

    private fun displayList(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val ligneListFragment = LigneListFragment.newInstance(this.ligneshelf.getAllLignes())

        fragmentTransaction.replace(R.id.a_main_lyt_fragment_container, ligneListFragment)
        fragmentTransaction.commit()

        a_main_btn_creation.visibility = View.VISIBLE
        a_main_btn_search.visibility = View.VISIBLE

    }

    fun GoToArrets(nom :String) = displayArrte(nom)

    private fun displayArrte(nom :String){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        this.ligneshelf.essai()
        val arretListFragment = ArretsListFragment.newInstance(this.ligneshelf.getLigneArret(nom))

        fragmentTransaction.replace(R.id.a_main_lyt_fragment_container, arretListFragment)
        fragmentTransaction.commit()

        a_main_btn_creation.visibility = View.GONE
        a_main_btn_search.visibility = View.GONE
    }

    private fun displayCreation(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val createLigneFragment = CreateLigneFragment()
        fragmentTransaction.add(R.id.a_main_lyt_fragment_container, createLigneFragment)
        fragmentTransaction.commit()

        a_main_btn_creation.visibility = View.GONE
        a_main_btn_search.visibility = View.GONE
    }

    fun goToCreation(view: View) = displayCreation()

    fun displayShearch(){
        println("displayShearch")
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val shearchLigneFragment = ShearchLigneFragment()
        fragmentTransaction.add(R.id.a_main_lyt_fragment_container, shearchLigneFragment)
        fragmentTransaction.commit()

        a_main_btn_creation.visibility = View.GONE
        a_main_btn_search.visibility = View.GONE
    }

    fun displayShearchDone(shearch: String){
        println("displayShearchDone")
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val ligneListFragment = LigneListFragment.newInstance(this.ligneshelf.shearch(shearch))

        fragmentTransaction.replace(R.id.a_main_lyt_fragment_container, ligneListFragment)
        fragmentTransaction.commit()

        a_main_btn_creation.visibility = View.VISIBLE
        a_main_btn_search.visibility = View.VISIBLE

    }
    fun goToShearch(view: View)=  displayShearch()

    override fun onLigneCreated(ligne: Ligne) {
        ligneshelf.addLigne(ligne)
        displayList()
    }

    override fun closeLigneCreation() =  displayList()

    override fun onLigneShearch(shearch: String) = displayShearchDone(shearch)

    override fun closeLigneShearch() =  displayList()

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        println("onOptionsItemSelected")
        return when (item.itemId) {
            R.id.menu_action_clear -> {
                ligneshelf.clear()
                displayList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}