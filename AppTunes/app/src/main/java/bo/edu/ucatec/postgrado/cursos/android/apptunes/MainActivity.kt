package bo.edu.ucatec.postgrado.cursos.android.apptunes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bo.edu.ucatec.postgrado.cursos.android.apptunes.adapter.CancionAdapter
import bo.edu.ucatec.postgrado.cursos.android.apptunes.model.Cancion
import bo.edu.ucatec.postgrado.cursos.android.apptunes.model.Resultado
import bo.edu.ucatec.postgrado.cursos.android.apptunes.service.ITunesService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val itunesService = ITunesService()
    var canciones = ArrayList<Cancion>()

    lateinit var progressBar: ProgressBar

    lateinit var cancionAdapter: CancionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Indicador de Progreso (al inicio invisile)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = ProgressBar.INVISIBLE

        // RecyclerView
        val cancionesRecyclerView = findViewById<RecyclerView>(R.id.cancionesRecyclerView)
        val busquedaTextView = findViewById<TextView>(R.id.busquedaTextView)

        val searchButton = findViewById<ImageButton>(R.id.searchButton)
        searchButton.setOnClickListener {
            buscarCanciones(busquedaTextView.text.toString())
        }

        cancionAdapter = CancionAdapter(this, canciones)
        val cancionLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        cancionesRecyclerView.adapter = cancionAdapter
        cancionesRecyclerView.layoutManager = cancionLayoutManager
    }

    fun buscarCanciones(artista: String) {
        progressBar.visibility = ProgressBar.VISIBLE
        cerrarteclado()
        val call = itunesService.obtenerCanciones(artista)

        call.enqueue(object : Callback<Resultado?> {
            override fun onResponse(call: Call<Resultado?>, response: Response<Resultado?>) {

                if (response.isSuccessful) {
                    progressBar.visibility = ProgressBar.INVISIBLE

                    val resultado = response.body()

                    if (resultado != null) {
                        canciones.clear()
                        canciones.addAll(resultado.canciones)
                        cancionAdapter.notifyDataSetChanged()
                    }
                } else {
                    progressBar.visibility = ProgressBar.INVISIBLE
                }
            }

            override fun onFailure(call: Call<Resultado?>, t: Throwable) {
                progressBar.visibility = ProgressBar.INVISIBLE

                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

    fun cerrarteclado() {
        val view = this.currentFocus
        if (view != null) {
            val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}