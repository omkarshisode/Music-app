package dista.learning.musicapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        val retrofitData = RetrofitHelper.retrofit

        // TODO: Add the searchBar to search the music
        // Ctl + Shift + space get the full code in the method
        val musicData = retrofitData.getData("eminem")
        musicData.enqueue(object : Callback<MusicData?> {
            override fun onResponse(call: Call<MusicData?>, response: Response<MusicData?>) {
                val data = response.body()?.data
                val tvResponse = findViewById<TextView>(R.id.tvResponse)
                tvResponse.text = data.toString()
                Log.d("Response", data.toString())
            }

            override fun onFailure(call: Call<MusicData?>, t: Throwable) {
                Log.d("Failure", "Getting failure")
            }
        })
    }
}