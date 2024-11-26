package br.senai.sp.jandira.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.myapplication.model.Results
import br.senai.sp.jandira.myapplication.model.Viagem
import br.senai.sp.jandira.myapplication.sevice.RetrofitFactory
import br.senai.sp.jandira.myapplication.utils.encurtarData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun listAllViagens(controleDeNavegacao: NavHostController) {

    var viagemList by remember{
        mutableStateOf(listOf<Viagem>())
    }

    val viagemCall = RetrofitFactory()
        .getViagemService()
        .getAllViagens()

    viagemCall.enqueue(
        object : Callback<Results>{
            override fun onResponse(p0: Call<Results>, response: Response<Results>) {
                viagemList = response.body()!!.results
            }

            override fun onFailure(p0: Call<Results>, response: Throwable) {

            }
        }
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Rick and Morty",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0x850B8991)
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn() {
                items(viagemList){
                    ViagemCard(it, controleDeNavegacao)
                }
            }
        }
    }
}

@Composable
fun ViagemCard(viagem: Viagem, controleDeNavegacao: NavHostController) {

    val context = LocalContext.current

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 18.dp, end = 18.dp)
            .height(110.dp)
            .background(Color.White, shape = RoundedCornerShape(20.dp)),
        colors = CardDefaults
            .cardColors(
                containerColor = Color.Transparent,
            ),
    ){
        Row (
            modifier = Modifier
                .fillMaxSize()
        ){
            Column (
                modifier = Modifier
                    .width(250.dp)
                    .fillMaxHeight()
                    .background(Color.Transparent)
            ){
                Row (
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, start = 24.dp),
                ){
                    Box(
                        modifier = Modifier
                            .width(80.dp)
                            .height(25.dp)
                            .background(Color.Gray, shape = RoundedCornerShape(4.dp))
                    ){
                        Text(
                            text = viagem.status_entregue,
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                    Text(
                        text = viagem.id_viagem,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(top = 14.dp, start = 24.dp)
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(color = Color(0xFFDADADA))
                ){

                }
                Row (
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .padding(top = 4.dp, start = 20.dp)
                ){
                    Text(
                        "De: ",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "-"
                    )
                    Text(
                        "Para: ",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Row (
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                ){
                    Text(
                        text = "${encurtarData(viagem.dia_partida)}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        "${encurtarData(viagem.dia_chegada)}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}