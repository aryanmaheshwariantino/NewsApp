
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.imageview)
    private val nameTextView: TextView = itemView.findViewById(R.id.name)
    private val emailTextView: TextView = itemView.findViewById(R.id.email)

    fun bind(name: String, email: String, image: Int) {
        // Bind data to views
        imageView.setImageResource(image)
        nameTextView.text = name
        emailTextView.text = email
    }
}
