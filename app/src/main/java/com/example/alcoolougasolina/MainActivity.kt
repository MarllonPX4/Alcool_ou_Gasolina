package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editAlcool: TextInputEditText
    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private  lateinit var buttonCalcular: Button
    private  lateinit var textResult: TextView
    private lateinit var  textCalculo: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()
        buttonCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    private fun calcularMelhorPreco() {
        val precoAlcool = editAlcool.text.toString()
        val precoGasolina = editGasolina.text.toString()


        val validacao = validarCampos(precoAlcool, precoGasolina)

        if(validacao){
            val resultado = precoAlcool.toDouble() / precoGasolina.toDouble()

            if (resultado >= 0.7){
                textResult.text = "Melhor utilizar Gasolina"
                textCalculo.text = "$resultado"
                textCalculo.text = "O resultado do calculo foi: $resultado"
            }else{
                textResult.text = "Melhor utilizar Álcool"
                textCalculo.text = "O resultado do calculo foi: $resultado"
            }
        }
    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if(pAlcool.isEmpty()){
            textInputAlcool.error = "Digite o preço do Álcool"
            return false
        }else if (pGasolina.isEmpty()){
            textInputGasolina.error = "Digite o preço da Gasolina"
            return false
        }
        return true
    }

    private fun inicializarComponentesInterface(){
        textInputAlcool = findViewById(R.id.text_Input_Alcool)
        editAlcool = findViewById(R.id.edit_Alcool)
        textInputGasolina = findViewById(R.id.text_Input_Gasolina)
        editGasolina = findViewById(R.id.edit_Gasolina)

        buttonCalcular = findViewById(R.id.button_Calcular)
        textResult = findViewById(R.id.text_Result)
        textCalculo = findViewById(R.id.textCalculo)
    }
}