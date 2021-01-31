package com.example.calculoaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.Spinner
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.ArrayAdapter

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //definindo o arquivo de layout
        setContentView(R.layout.activity_main)

        //acessando o spinner
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        //acessando a caixa de texto
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        //acessando o botao
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        //acessando o texto de resultado
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("masculino", "feminino"))

        btn_calcular.setOnClickListener{

            //capturando o sexo selecionado
            val sexo = spn_sexo.selectedItem as String

            //capturando a idade digitada
            val idade = txt_idade.text.toString().toInt()

            //variável para guardar o resultado do cálculo
            var resultado = 0

            //verificando o sexo da pessoa
            if (sexo == "masculino"){

                resultado = 65 - idade

            }else{

                resultado = 62 - idade

            }

            //Atualizando a tela de acordo com o resultado do cálculo
            txt_resultado.text = "Faltam $resultado anos para vc se aposentar"
        }

    }


}