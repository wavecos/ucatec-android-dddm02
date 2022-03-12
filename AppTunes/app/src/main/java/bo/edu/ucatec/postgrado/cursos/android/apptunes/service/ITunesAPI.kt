package bo.edu.ucatec.postgrado.cursos.android.apptunes.service

import bo.edu.ucatec.postgrado.cursos.android.apptunes.model.Resultado
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesAPI {

    @GET("/search")
    fun buscarCanciones(@Query("term") artista: String, @Query("entity") tipo: String, @Query("limit") limite: Int) : Call<Resultado>

}