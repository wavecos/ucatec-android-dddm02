package bo.edu.ucatec.postgrado.cursos.android.moneyconversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtengo las referencias de la vista
        val displayTextView = findViewById<TextView>(R.id.displayTextView)
        val montoEditText = findViewById<EditText>(R.id.MontoEditText)
        val calcularButton = findViewById<FloatingActionButton>(R.id.calcularButton)

        calcularButton.setOnClickListener {
            val montoBOB = BigDecimal.valueOf(montoEditText.text.toString().toDouble())
            val montoUSD = montoBOB.divide(BigDecimal.valueOf(6.96), 2, BigDecimal.ROUND_HALF_UP)
            displayTextView.text = "$montoUSD USD"
        }

    }
}