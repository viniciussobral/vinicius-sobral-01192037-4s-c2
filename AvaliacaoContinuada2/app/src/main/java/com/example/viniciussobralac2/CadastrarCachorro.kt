package com.example.viniciussobralac2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.viniciussobralac2.conexaoApi.Cachorro
import com.example.viniciussobralac2.conexaoApi.ConexaoApiCachorro
import com.example.viniciussobralac2.conexaoApi.CriarCachorro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ThreadLocalRandom

class CadastrarCachorro : AppCompatActivity() {

    lateinit var etRaca: EditText
    lateinit var etPreco: EditText
    lateinit var etIndicadoCriancas: EditText

//    var indicadoCrianca: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_cachorro)

        etRaca = findViewById(R.id.et_raca)
        etPreco = findViewById(R.id.et_preco)
        etIndicadoCriancas = findViewById(R.id.et_indicadoCriancas)
    }

    fun cadastrarCachorro(view: View) {

//        indicadoCrianca = true

        val apiCachorro = ConexaoApiCachorro.criar()
        val imgCachorro:ImageView = findViewById(R.id.iv_cachorro)
        val cachorroCadastro = CriarCachorro(
            etRaca.text.toString(),
            etPreco.text.toString().toInt(),
            etIndicadoCriancas.text.toString().toBoolean()

        )

        apiCachorro.post(cachorroCadastro).enqueue(object : Callback<Cachorro> {
            override fun onFailure(call: Call<Cachorro>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Cachorro>, response: Response<Cachorro>) {
                if (response.code() == 201){
                    val filmeCriado = response.body()
                    imgCachorro.setImageResource(R.drawable.cachorro)
                } else{
                    Toast.makeText(baseContext, "Raça e/ou Preço e/ou Indicador de Crianças ", Toast.LENGTH_SHORT).show()
                }
            }
        })


    }


}