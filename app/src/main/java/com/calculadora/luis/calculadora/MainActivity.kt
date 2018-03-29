package com.calculadora.luis.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    var txResultado: EditText? = null

    var valores: Array<String> = arrayOf()
    var operandos: Array<String> = arrayOf()
    var ultValor: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txResultado = findViewById<EditText>(R.id.txResultado) as EditText
    }

    fun imprimirValor(v: View) {
        val btn: Button = v as Button

        val valor = when(btn.id) {
            R.id.btn0 -> "0"
            R.id.btn1 -> "1"
            R.id.btn2 -> "2"
            R.id.btn3 -> "3"
            R.id.btn4 -> "4"
            R.id.btn5 -> "5"
            R.id.btn6 -> "6"
            R.id.btn7 -> "7"
            R.id.btn8 -> "8"
            R.id.btn9 -> "9"
            else -> ""
        }

        Log.i("Calculadora", "Valor: $valor")

        this.ultValor += valor
        txResultado?.setText("${txResultado?.text}$valor")
    }

    fun imprimirOperando(v: View) {
        val btn: Button = v as Button

        val operador = when(btn.id) {
            R.id.btnDiv -> "/"
            R.id.btnMult -> "x"
            R.id.btnRes -> "-"
            R.id.btnSum -> "+"
            else -> ""
        }

        Log.i("Calculadora", "Operador: $operador")

        if(this.ultValor != "") {
            this.valores.plus(ultValor)
            this.ultValor = ""
        }

        if(this.valores.isNotEmpty() && this.valores.size > this.operandos.size){
            this.operandos.plus(operador)
            txResultado?.setText("${txResultado?.text}$operador")
        }
    }
}
