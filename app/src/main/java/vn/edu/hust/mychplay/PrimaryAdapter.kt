package vn.edu.hust.mychplay

import android.inputmethodservice.Keyboard.Row
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PrimaryAdapter(val rows: ArrayList<RowModel>) : RecyclerView.Adapter<PrimaryAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        var catalog = view.findViewById<TextView>(R.id.catalog)
        var recyclerView = view.findViewById<RecyclerView>(R.id.second_recyclerView)
        val viewContext = view.context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layout = LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false);
        return MyViewHolder(layout);
    }

    override fun getItemCount(): Int {
        return rows.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.catalog.text = rows[position].name
        holder.recyclerView.adapter = SecondaryAdapter(rows[position].itemList)
        holder.recyclerView.layoutManager = LinearLayoutManager(holder.viewContext, LinearLayoutManager.HORIZONTAL, false)
    }
}