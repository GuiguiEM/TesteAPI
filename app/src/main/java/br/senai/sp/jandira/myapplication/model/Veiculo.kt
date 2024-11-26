package br.senai.sp.jandira.myapplication.model

data class Veiculo(
    val placa: String = "",
    val modelo: String = "",
    val ano: String = "",
    val tipo: String = "",
    val capacidade_carga: Int = 0
)
