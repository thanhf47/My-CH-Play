package vn.edu.hust.mychplay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SecondaryAdapter(val items: ArrayList<ItemModel>) : RecyclerView.Adapter<SecondaryAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.app_icon)
        val app_name = view.findViewById<TextView>(R.id.app_name)
        val rate = view.findViewById<TextView>(R.id.rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false);
        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.image.setImageResource(items[position].imageResource);
        holder.app_name.text = items[position].name
        holder.rate.text = items[position].rate.toString()
    }
}