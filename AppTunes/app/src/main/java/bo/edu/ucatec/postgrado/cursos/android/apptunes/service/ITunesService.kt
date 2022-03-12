package bo.edu.ucatec.postgrado.cursos.android.apptunes.service

import bo.edu.ucatec.postgrado.cursos.android.apptunes.model.Cancion
import bo.edu.ucatec.postgrado.cursos.android.apptunes.model.Resultado
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ITunesService {
    val iTunesAPI: ITunesAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://itunes.apple.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        iTunesAPI = retrofit.create(ITunesAPI::class.java)
    }

    fun obtenerCanciones(artista: String) : Call<Resultado> {
        val call = iTunesAPI.buscarCanciones(artista, "song", 25)
        return call
    }

}