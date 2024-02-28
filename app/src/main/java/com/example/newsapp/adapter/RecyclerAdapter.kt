
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.aryan.recyclerview.models.NewsData
import com.bumptech.glide.Glide
import com.example.newsapp.databinding.ItemViewBinding

class RecyclerAdapter(
    private var resp: NewsData,
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        val itemTitle: TextView = binding.tvTitle
        val itemDetail: TextView = binding.tvDescription
        val itemPicture: ImageView = binding.ivImage

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            val url = resp.articles[position].url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(itemView.context, intent, null)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = resp.articles[position].title
        holder.itemDetail.text = resp.articles[position].description

        Glide.with(holder.itemPicture.context)
            .load(resp.articles[position].urlToImage)
            .into(holder.itemPicture)
    }

    override fun getItemCount(): Int {
        return resp.articles.size
    }
}
