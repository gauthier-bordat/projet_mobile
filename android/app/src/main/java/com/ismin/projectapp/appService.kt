package com.ismin.projectapp

import retrofit2.Call
import retrofit2.http.*
import java.util.ArrayList

interface appService {
    @GET("ligne_tan")
    fun getAll():Call<ArrayList<Ligne>>

    @GET( "ligne_tan/{nom}")
    fun getbyName(@Path("nom") nom: String): Call<Ligne>
}