package com.example.viniciussobralac2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.viniciussobralac2.conexaoApi.Cachorro
import com.example.viniciussobralac2.conexaoApi.ConexaoApiCachorro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListarCachorros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_cachorros)


        //        Listagem de usuarios
        val layoutLista: LinearLayout = findViewById(R.id.layout_lista)

        val apiCachorro = ConexaoApiCachorro.criar()

        apiCachorro.get().enqueue(object : Callback<List<Cachorro>> {
            override fun onResponse(call: Call<List<Cachorro>>, response: Response<List<Cachorro>>) {
                response.body()?.forEach {
                    val tvCachorro = TextView(baseContext)
                    tvCachorro.text = "Id: ${it.id} - Raça: ${it.raca} - Preço Médio: ${it.precoMedio} - Indicado para crianças: ${it.indicadoCriancas}"
                    tvCachorro.setTextColor(Color.parseColor("#9911AA"))

                    layoutLista.addView(tvCachorro)
                }
            }

            override fun onFailure(call: Call<List<Cachorro>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message}", Toast.LENGTH_SHORT).show()
            }

        })


    }
}