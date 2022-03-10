package bo.edu.ucatec.postgrado.cursos.android.noticiasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NoticiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticia)

        // Recibimos informacion de los Extras
        val elTitular = intent.getStringExtra("titular")
        val likes = intent.getIntExtra("nroLikes", 0)

        val tituloTextView = findViewById<TextView>(R.id.tituloTextView)
        tituloTextView.text = "$elTitular - $likes"
    }
}