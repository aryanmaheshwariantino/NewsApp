
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R


class MyAdapter : RecyclerView.Adapter<MyViewHolder> {
    private val context: Context
    private val itemList: List<ItemModel>

    constructor(context: Context, itemList: List<ItemModel>) {
        this.context = context
        this.itemList = itemList
    }
    override fun getItemCount(): Int {
        return itemList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.bind(currentItem.name, currentItem.email, currentItem.image)
    }



}
