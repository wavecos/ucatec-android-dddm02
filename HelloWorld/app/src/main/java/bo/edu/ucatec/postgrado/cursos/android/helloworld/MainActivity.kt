package bo.edu.ucatec.postgrado.cursos.android.helloworld

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d("MainActivity", "Hola Mundo :)")
        Log.e("MainActivity", "Ha ocurrido un error!")
        Log.w("MainActivity", "Aviso")
        Log.i("MainActivity", "Informacion")

        val mensajeTextView = findViewById<TextView>(R.id.mensajeTextView)
        val saludarButton = findViewById<Button>(R.id.saludarButton)

        Log.d("MainActivity", "Texto del Boton : ${saludarButton.text}")

        saludarButton.setOnClickListener {
            Log.d("MainActivity", "Se ha presionado el Boton")
            mensajeTextView.setTextColor(Color.RED)
            mensajeTextView.textSize = 50.0f
            mensajeTextView.text = getString(R.string.mensaje_saludo)
        }

        val despedidaTextView = TextView(this) // this es el contexto a nivel de Activity
        despedidaTextView.text = "Adios"

        //Contexto a nivel de aplicacion
        val contexto = applicationContext
    }

    fun despedida(view: View) {
        Log.d("MainActivity", "Adios muchachos!!!")
    }

}