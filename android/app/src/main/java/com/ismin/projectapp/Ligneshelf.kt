package com.ismin.projectapp

class Ligneshelf{
    private val lignesStorage : HashMap<String, Ligne> = HashMap<String, Ligne>()


    private val ar1 =Arret("1","a", arrayListOf(43,13))
    private val ar2 =Arret("2","a", arrayListOf(42,13))
    private val ar3 =Arret("3","a", arrayListOf(41,13))
    private val ar4 =Arret("4","a", arrayListOf(40,13))
    private val ar5 =Arret("5","a", arrayListOf(43,12))
    private val ar6 =Arret("6","a", arrayListOf(43,11))
    private val ar7 =Arret("7","a", arrayListOf(43,10))

    private val arretPremier = Arrets(arrayListOf(ar1,ar1,ar1,ar2,ar3, ar4,ar5,ar6,ar7),arrayListOf(ar4))
    private val premier = Ligne("ligne1","1","tram","ffffff",false,arretPremier)

    private val second = Ligne("bouaye - bougnais","C1 ","bus","904030",true,null)

    private val troisieme = Ligne("saint-herblain - commerce","113","bus","0000ff",false,null)

    fun deselted(){
        for(item in this.lignesStorage.values.filter{it.isSelected}){
            item.isSelected = false
            addLigne(item)
        }
    }

    fun addFavorie(){
        for(item in this.lignesStorage.values.filter{it.isSelected}){
            item.favorie = !item.favorie
            addLigne(item)
        }
    }


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
         val rep = ArrayList<Ligne>(this.lignesStorage.values.filter { it.numero.contains(shearch) || it.nom.contains(shearch)}.filter{it.favorie}+
                 this.lignesStorage.values.filter { it.numero.contains(shearch) || it.nom.contains(shearch)}.filter{!it.favorie})
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

    fun clear() :Unit{
        clearLigne()
    }




}