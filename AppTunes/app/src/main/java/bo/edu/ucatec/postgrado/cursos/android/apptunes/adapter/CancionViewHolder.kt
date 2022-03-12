package bo.edu.ucatec.postgrado.cursos.android.apptunes.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bo.edu.ucatec.postgrado.cursos.android.apptunes.R

class CancionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val coverImageView: ImageView
    val tituloTextView: TextView
    val infoTextView: TextView
    val precioTextView: TextView

    init {
        coverImageView = itemView.findViewById(R.id.coverImageView)
        tituloTextView = itemView.findViewById(R.id.tituloTextView)
        infoTextView = itemView.findViewById(R.id.infoTextView)
        precioTextView = itemView.findViewById(R.id.precioTextView)
    }

}