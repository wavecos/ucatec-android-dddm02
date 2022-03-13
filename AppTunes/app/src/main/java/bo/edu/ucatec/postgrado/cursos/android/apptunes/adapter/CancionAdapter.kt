package bo.edu.ucatec.postgrado.cursos.android.apptunes.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bo.edu.ucatec.postgrado.cursos.android.apptunes.CancionActivity
import bo.edu.ucatec.postgrado.cursos.android.apptunes.R
import bo.edu.ucatec.postgrado.cursos.android.apptunes.model.Cancion
import com.squareup.picasso.Picasso

class CancionAdapter(val context: Context, val cancionesData: List<Cancion>) :
    RecyclerView.Adapter<CancionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CancionViewHolder {
        val cancionView = LayoutInflater.from(context).inflate(R.layout.item_cancion, parent, false)
        return CancionViewHolder(cancionView)
    }

    override fun onBindViewHolder(holder: CancionViewHolder, position: Int) {
        val cancion = cancionesData[position]
        //
        holder.tituloTextView.text = cancion.titulo
        holder.infoTextView.text = "${cancion.artista} - ${cancion.album}"
        holder.precioTextView.text = "${cancion.genero} (${cancion.precio} USD)"

        // Imagen del Cover (usamos la librería Picasso)
        Picasso.get()
            .load(cancion.portadaUrl)
            .into(holder.coverImageView)

        // Cuando se haga click en el Item abrir el Activity de Cancion
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CancionActivity::class.java)

            intent.putExtra("CANCION_COVER_URL", cancion.portadaUrl)
            intent.putExtra("CANCION_TITULO", cancion.titulo)
            intent.putExtra("CANCION_ARTISTA", cancion.artista)
            intent.putExtra("CANCION_URL", cancion.cancionUrl)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return cancionesData.size
    }
}