package vn.edu.hust.mychplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vn.edu.hust.mychplay.R.id.primary_recyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.primary_recyclerView)
        val Catalog = arrayListOf<String>("Game", "App", "Social", "Education", "Kid")
        val array = ArrayList<RowModel>()
        repeat(5) {
            array.add(RowModel(Catalog[it], ArrayList<ItemModel>()))
        }

        repeat(33) {
            array[it/7].itemList.add(
                ItemModel(resources.getIdentifier("image__${it}_","drawable", packageName), "app $it", it % 5 * 1.0F)
            )
        }

        recyclerView.adapter = PrimaryAdapter(array)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
