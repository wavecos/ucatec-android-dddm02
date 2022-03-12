package bo.edu.ucatec.postgrado.cursos.android.apptunes.model

import com.google.gson.annotations.SerializedName

class Cancion(
    @SerializedName("artistName")
    var artista: String,

    @SerializedName("collectionName")
    var album: String,

    @SerializedName("trackName")
    var titulo: String,

    @SerializedName("artworkUrl100")
    var portadaUrl: String,

    @SerializedName("previewUrl")
    var cancionUrl: String,

    @SerializedName("primaryGenreName")
    var genero: String,

    @SerializedName("trackPrice")
    var precio: Double
)

