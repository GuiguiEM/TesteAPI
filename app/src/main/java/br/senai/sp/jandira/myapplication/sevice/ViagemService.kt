package br.senai.sp.jandira.myapplication.sevice

import br.senai.sp.jandira.myapplication.model.Results
import br.senai.sp.jandira.myapplication.model.Viagem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViagemService {

    @GET("/v1/transportaweb/viagem/{id}")
    fun getViagemById(@Path("id") id: Int): Call<Viagem>

    @GET("/v1/transportaweb/viagens")
    fun getAllViagens(): Call<Results>
}