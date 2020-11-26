package com.ismin.projectapp

class Ligneshelf (){
    private val lignes : ArrayList<Ligne> = ArrayList<Ligne>()
    private val favories : ArrayList<Ligne> = ArrayList<Ligne>()

    fun addFavorie(ligne: Ligne){
        if(this.getLigneByNum(ligne.numero) == null){
            this.favories.add(ligne)
        }
    }

    fun getLigneByNum(numero : String) = this.lignes.find{it.numero == numero}

    fun getLigneByNom(nom : String) = this.lignes.find{it.nom == nom}

    fun getLignesPlusProche(coord : ArrayList<Int>) : ArrayList<Ligne>? {
        if(coord.size > 2 ){ return null}
        if(coord[0] < 1 || coord[0] > 2 || coord[1] < 47 || coord[1] > 48){return null}
        var distance = 0.005
        while(distance < 0.03){
            val list = ArrayList(this.lignes.filter{ArrayList(it.arrets.aller.filter{
                it.coordonnee[0] < coord[0]+distance &&
                it.coordonnee[0] > coord[0]-distance &&
                it.coordonnee[1] < coord[1]+distance &&
                it.coordonnee[1] > coord[1]-distance }).contains(it.arrets.aller)})
            if(list.size > 0){return list}
            distance += 0.005
        }
        return null
    }
    
    fun getAllLignes() = ArrayList(this.lignes.sortedBy { it.numero})
    
    fun getAllFavorit() =  ArrayList(this.favories.sortedBy { it.numero})

}