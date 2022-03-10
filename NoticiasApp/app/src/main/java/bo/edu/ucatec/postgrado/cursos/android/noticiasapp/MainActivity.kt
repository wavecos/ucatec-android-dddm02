package bo.edu.ucatec.postgrado.cursos.android.noticiasapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webTextView = findViewById<TextView>(R.id.webTextView)
        val fonoTextView = findViewById<TextView>(R.id.telefonoTextView)
        val fotoNoticiaImageView = findViewById<ImageView>(R.id.imageView)

        webTextView.setOnClickListener {
            // Llamada Intent Implicito
            val webpage = Uri.parse("https://www.newsmax.com/")
            val webIntent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(webIntent)
        }

        fonoTextView.setOnClickListener {
            // Llamada Intent Implicito
            val fono = Uri.parse("tel:4485256")
            val fonoIntent = Intent(Intent.ACTION_DIAL, fono)
            startActivity(fonoIntent)
        }

        fotoNoticiaImageView.setOnClickListener {
            // Llamada Intent Explicito
            val detalleNoticiaIntent = Intent(this, NoticiaActivity::class.java)
            // Envio de informacion por medio de Extras
            detalleNoticiaIntent.putExtra("titular", "Crisis en Ukrania!")
            detalleNoticiaIntent.putExtra("nroLikes", 256)
            startActivity(detalleNoticiaIntent)
        }

    }
}