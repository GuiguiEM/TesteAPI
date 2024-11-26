package br.senai.sp.jandira.myapplication.sevice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "https://crud-03-09.onrender.com/"

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // ********************************** VIAGEM ********************************** //

    fun getViagemService(): ViagemService{
        return retrofitFactory.create(ViagemService::class.java)
    }

}