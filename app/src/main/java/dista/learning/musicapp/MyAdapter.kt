package dista.learning.musicapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context:Activity, private val data:List<Data>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
// create the view here i case the layout manager fails to create view for the data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
   return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
  // populate the data in the view
    }
}