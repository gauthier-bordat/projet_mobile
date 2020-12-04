package com.ismin.projectapp

class Ligneshelf{
    private val lignesStorage : HashMap<String, Ligne> = HashMap<String, Ligne>()



    private val premier = Ligne(
        favorie = false,
        nom = "ligne1",
        numero = "1",
        type = "tram",
        coulor="ffffff",
        arrets = null
    )


    private val second = Ligne(
        favorie = true,
        nom = "bouaye - bougnais",
        numero = "C1 ",
        type = "bus",
        coulor="904030",
        arrets = null
    )

    private val troisieme = Ligne(
        favorie = false,
        nom = "saint-herblain - commerce",
        numero = "113 ",
        type = "bus",
        coulor="0000ff",
        arrets = null
    )

    fun getLigne(nom : String):Ligne? {
        return this.lignesStorage[nom]
    }

    fun essai(){
        addLigne(premier)
        addLigne(second)
        addLigne(troisieme)
    }
    
    fun getLigneArret(nom : String):ArrayList<Arret>{
        if(getLigne(nom) == null || getLigne(nom)?.arrets == null){return ArrayList()}
        else{return getLigne(nom)!!.arrets!!.aller}
    }

    fun clearLigne():Unit{
        this.lignesStorage.clear()
    }


    fun addLigne(ligne: Ligne){
            this.lignesStorage[ligne.nom]=ligne
    }

    fun shearch(shearch :String) : ArrayList<Ligne>{
         val rep = ArrayList<Ligne>(this.lignesStorage.values.filter { it.numero.contains(shearch) || it.nom.contains(shearch)})
        println(rep)
        return rep
    }




    fun getLigneByNum(numero : String) = this.lignesStorage.filter{it.value.numero == numero}[0]



    fun getLignesPlusProche(coord : ArrayList<Int>) : Map<String, Ligne>? {
        if(coord.size > 2 ){ return null}
        if(coord[0] < 1 || coord[0] > 2 || coord[1] < 47 || coord[1] > 48){return null}
        var distance = 0.005
        while(distance < 0.03){
            val list = this.lignesStorage.filter{ArrayList(it.value.arrets?.aller?.filter{
                it.coordonnee[0] < coord[0]+distance &&
                        it.coordonnee[0] > coord[0]-distance &&
                        it.coordonnee[1] < coord[1]+distance &&
                        it.coordonnee[1] > coord[1]-distance }).contains(it.value.arrets?.aller)}
            if(list.size > 0){return list}
            distance += 0.005
        }
        return null
    }

    fun getNumberOfLignes():Int{
        return this.lignesStorage.size
    }
    
    fun getAllLignes() : ArrayList<Ligne> {
        return ArrayList<Ligne>(this.lignesStorage.values.filter{it.favorie} + this.lignesStorage.values.filter{!it.favorie})
    }
/*
    fun getAll() : ArrayList<Ligne>{
        return
    }*/

    fun clear() :Unit{
        clearLigne()
    }




}