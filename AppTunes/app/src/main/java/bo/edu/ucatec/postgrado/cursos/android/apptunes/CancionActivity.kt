package bo.edu.ucatec.postgrado.cursos.android.apptunes

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class CancionActivity : AppCompatActivity() {

    lateinit var player: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancion)

        val coverUrl = intent.getStringExtra("CANCION_COVER_URL")
        val titulo = intent.getStringExtra("CANCION_TITULO")
        val artista = intent.getStringExtra("CANCION_ARTISTA")
        val cancionUrl = intent.getStringExtra("CANCION_URL")

        Picasso.get()
            .load(coverUrl)
            .into(findViewById<ImageView>(R.id.imageView))

        findViewById<TextView>(R.id.tituloTextView).text = titulo
        findViewById<TextView>(R.id.artistTextView).text = artista

        // Reproducir la Cancion con la Url con MediaPlayer

        val playImageView = findViewById<ImageView>(R.id.playImageView)

        player = MediaPlayer()

        playImageView.setOnClickListener {
            player.setVolume(1.0f, 1.0f)

            player.setDataSource(cancionUrl)
            player.prepare()
            player.start()
        }

    }

    // Detenemos la reproduccion antes de salir del activitu
    override fun onDestroy() {
        super.onDestroy()
        if (player.isPlaying) {
            player.stop()
        }
    }

}