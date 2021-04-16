package com.example.viniciussobralac2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cadastrarCachorro(view: View) {
        val cadastrarCachorro = Intent(this,CadastrarCachorro::class.java)
        startActivity(cadastrarCachorro)
    }

    fun listarCachorros(view: View) {
        val listarCachorros = Intent(this,ListarCachorros::class.java)
        startActivity(listarCachorros)

    }
}