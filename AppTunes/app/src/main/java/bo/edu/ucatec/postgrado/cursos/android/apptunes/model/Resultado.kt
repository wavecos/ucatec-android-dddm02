package bo.edu.ucatec.postgrado.cursos.android.apptunes.model

import com.google.gson.annotations.SerializedName

class Resultado(

    @SerializedName("resultCount")
    var numeroCanciones: Int,

    @SerializedName("results")
    var canciones: List<Cancion>
)