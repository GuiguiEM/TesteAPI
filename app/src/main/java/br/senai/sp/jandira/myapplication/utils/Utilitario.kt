package br.senai.sp.jandira.myapplication.utils

import java.time.LocalDate

fun encurtarData(data: LocalDate): String{
    return "${data.dayOfMonth} ${data.month.toString().substring(0..2)}"
}