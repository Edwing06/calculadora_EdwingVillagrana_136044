package mx.edu.itson.potros.calculadora_edwingvillagrana_136044

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var displaySuperior: TextView
    private lateinit var displayInferior: TextView

    private var primerNumero: Int? = null
    private var segundoNumero: Int? = null
    private var operador: Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displaySuperior = findViewById(R.id.tvSuperior)
        displayInferior = findViewById(R.id.tvInferior)

        val btn0: Button = findViewById(R.id.button0)
        val btn1: Button = findViewById(R.id.button1)
        val btn2: Button = findViewById(R.id.button2)
        val btn3: Button = findViewById(R.id.button3)
        val btn4: Button = findViewById(R.id.button4)
        val btn5: Button = findViewById(R.id.button5)
        val btn6: Button = findViewById(R.id.button6)
        val btn7: Button = findViewById(R.id.button7)
        val btn8: Button = findViewById(R.id.button8)
        val btn9: Button = findViewById(R.id.button9)

        val btnSumar: Button = findViewById(R.id.buttonSuma)
        val btnRestar: Button = findViewById(R.id.buttonRestar)
        val btnMultiplicar: Button = findViewById(R.id.buttonMultiplicar)
        val btnDividir: Button = findViewById(R.id.buttonDividir)
        val btnResultado: Button = findViewById(R.id.buttonResultado)

        val digitButtons = listOf(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        digitButtons.forEach { button ->
            button.setOnClickListener {
                val digito = button.text.toString().toInt()
                actualizarDisplay(digito)
            }
        }

        btnSumar.setOnClickListener { asignarOperador('+') }
        btnRestar.setOnClickListener { asignarOperador('-') }
        btnMultiplicar.setOnClickListener { asignarOperador('*') }
        btnDividir.setOnClickListener { asignarOperador('/') }
        btnResultado.setOnClickListener { calcularResultado() }
    }

    private fun actualizarDisplay(digit: Int) {
        val currentText = displayInferior.text.toString()
        val newText = if (currentText == "0") {
            digit.toString()
        } else {
            currentText + digit.toString()
        }
        displayInferior.text = newText
    }

    private fun asignarOperador(op: Char) {
        primerNumero = displayInferior.text.toString().toInt()
        operador = op
        displaySuperior.text = "$primerNumero $operador"
        displayInferior.text = "0"
    }

    private fun calcularResultado() {
        segundoNumero = displayInferior.text.toString().toInt()
        val result = when (operador) {
            '+' -> primerNumero!! + segundoNumero!!
            '-' -> primerNumero!! - segundoNumero!!
            '*' -> primerNumero!! * segundoNumero!!
            '/' -> primerNumero!! / segundoNumero!!
            else -> throw IllegalArgumentException("Operador inválido")
        }
        displayInferior.text = result.toString()
        displaySuperior.text = ""
    }
}