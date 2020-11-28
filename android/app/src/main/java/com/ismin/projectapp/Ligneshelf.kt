package com.ismin.projectapp

class Ligneshelf (){
    private val lignesStorage : HashMap<String, Ligne>()
    private val favoriesStorage : HashMap<String,Ligne>()

    fun addFavorie(ligne: Ligne){
        this.favoriesStorage[ligne.nom]=ligne
    }

    fun getLigneByNom(nom : String):Ligne? {
        return this.lignesStorage[nom]
    }

    fun getFavorie(nom: String):Ligne?{
        return this.favoriesStorage[nom]
    }

    /**fun getLigneByNum(numero : String) = this.lignesStorage.filter{it.value.numero == numero}[0]**/



    fun getLignesPlusProche(coord : ArrayList<Int>) : Map<String, Ligne>? {
        if(coord.size > 2 ){ return null}
        if(coord[0] < 1 || coord[0] > 2 || coord[1] < 47 || coord[1] > 48){return null}
        var distance = 0.005
        while(distance < 0.03){
            val list = this.lignesStorage.filter{ArrayList(it.value.arrets.aller.filter{
                it.coordonnee[0] < coord[0]+distance &&
                it.coordonnee[0] > coord[0]-distance &&
                it.coordonnee[1] < coord[1]+distance &&
                it.coordonnee[1] > coord[1]-distance }).contains(it.value.arrets.aller)})
            if(list.size > 0){return list}
            distance += 0.005
        }
        return null
    }
    
    fun getAllLignes() {

    }
    
    fun getAllFavorit(){

    }

    fun clearLigne():Unit{
        this.lignesStorage.clear()
    }

    fun clearFavorie():Unit{
        this.favoriesStorage.clear()
    }

}