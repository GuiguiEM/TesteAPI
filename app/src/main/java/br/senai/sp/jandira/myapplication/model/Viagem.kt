package br.senai.sp.jandira.myapplication.model

import java.time.LocalDate
import java.time.LocalTime

data class Viagem(
    val id_viagem: String = "",
    val dia_partida: LocalDate = LocalDate.now(), // Agora usando LocalDate para a data
    val horario_partida: LocalTime = LocalTime.now(), // Agora usando LocalTime para a hora
    val dia_chegada: LocalDate = LocalDate.now(), // Agora usando LocalDate para a data de chegada
    val remetente: String = "",
    val destinatario: String = "",
    val status_entregue: String = "",
    val id_partida: Partida = Partida(),
    val id_destino: Destino  = Destino(),
    val id_motorista: Motorista = Motorista(),
    val id_veiculo: Veiculo = Veiculo()
)
