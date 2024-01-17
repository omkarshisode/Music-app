package dista.learning.musicapp

import android.app.Activity
import android.graphics.Typeface
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(private val context:Activity, private val data:List<Data>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount(): Int {
   return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
  // populate the data in the view
        val currentData = data[position]
        val mediaPlayer = MediaPlayer.create(context, currentData.preview.toUri())
        holder.musicTitle.text = currentData.title
        holder.musicTitle.setTypeface(null, Typeface.BOLD_ITALIC)
        Picasso.get().load(currentData.album.cover).into(holder.musicImage) // to load the music image
        holder.play.setOnClickListener {
            mediaPlayer.start()
            holder.musicTitle.isSelected = true
        }
        holder.pause.setOnClickListener {
            mediaPlayer.stop()
        }
    }

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
// create the view here i case the layout manager fails to create view for the data
         val musicImage:ImageView
         val musicTitle:TextView
         val play:ImageButton
         val pause:ImageButton

        init {
            musicImage = itemView.findViewById(R.id.ivMusic)
            musicTitle = itemView.findViewById(R.id.tvMusicTitle)
            play = itemView.findViewById(R.id.btnPlay)
            pause = itemView.findViewById(R.id.btnPause)
        }

    }
}