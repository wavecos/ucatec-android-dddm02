package bo.edu.ucatec.postgrado.cursos.android.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var num1 = 0.0
    var num2 = 0.0
    var operacion = Operacion.NO_OPERACION

    lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia al Display
        display = findViewById(R.id.displayTextView)

        // Botones
        inicializarBotones()
    }

    fun inicializarBotones() {
        // Digitos
        findViewById<Button>(R.id.digit0Button).setOnClickListener { digitoPresionado("0") }
        findViewById<Button>(R.id.digit1Button).setOnClickListener { digitoPresionado("1") }
        findViewById<Button>(R.id.digit2Button).setOnClickListener { digitoPresionado("2") }
        findViewById<Button>(R.id.digit3Button).setOnClickListener { digitoPresionado("3") }
        findViewById<Button>(R.id.digit4Button).setOnClickListener { digitoPresionado("4") }
        findViewById<Button>(R.id.digit5Button).setOnClickListener { digitoPresionado("5") }
        findViewById<Button>(R.id.digit6Button).setOnClickListener { digitoPresionado("6") }
        findViewById<Button>(R.id.digit7Button).setOnClickListener { digitoPresionado("7") }
        findViewById<Button>(R.id.digit8Button).setOnClickListener { digitoPresionado("8") }
        findViewById<Button>(R.id.digit9Button).setOnClickListener { digitoPresionado("9") }
        findViewById<Button>(R.id.decimalButton).setOnClickListener { digitoPresionado(".") }
        // Operadores
        findViewById<Button>(R.id.opDivButton).setOnClickListener { operacionPresionado(Operacion.DIVIDIR) }
        findViewById<Button>(R.id.opMulButton2).setOnClickListener { operacionPresionado(Operacion.MULTIPLICAR) }
        findViewById<Button>(R.id.opRestaButton).setOnClickListener { operacionPresionado(Operacion.RESTAR) }
        findViewById<Button>(R.id.opSumaButton2).setOnClickListener { operacionPresionado(Operacion.SUMAR) }
        // Boton Igual
        findViewById<Button>(R.id.calcularButton).setOnClickListener { calcular() }
        // Boton Limpiar
        findViewById<Button>(R.id.clearButton).setOnClickListener { limpiar() }
    }

    fun digitoPresionado(valor: String) {

        if (display.text == "0" && display.text != ".") {
            display.text = "$valor"
        } else {
            display.text = "${display.text}${valor}"
        }

        if (operacion == Operacion.NO_OPERACION) {
            num1 = display.text.toString().toDouble()
        } else {
            num2 = display.text.toString().toDouble()
        }
    }

    fun operacionPresionado(op: Operacion) {
        operacion = op
        num1 = display.text.toString().toDouble()
        display.text = "0"
    }

    fun calcular() {
        var resultado = 0.0
        when (operacion) {
            Operacion.DIVIDIR -> resultado = num1 / num2
            Operacion.MULTIPLICAR -> resultado = num1 * num2
            Operacion.RESTAR -> resultado = num1 - num2
            Operacion.SUMAR -> resultado = num1 + num2
        }

        if (resultado.isInfinite()) {
            display.text = "oo"
        } else {
            val decimalFormat = DecimalFormat("#.######")
            display.text = decimalFormat.format(resultado)
        }
    }

    fun limpiar() {
        display.text = "0"
        num1 = 0.0
        num2 = 0.0
        operacion = Operacion.NO_OPERACION
    }
}