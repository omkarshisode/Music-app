package dista.learning.musicapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter

    private val _dataList = MutableLiveData<List<Data>>()
    val dataList: LiveData<List<Data>> get() = _dataList

    private var currentPage = 1
    private val pageSize = 20
    private var isLoading = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvMusicList)
        val retrofitData = RetrofitHelper.retrofit

        if (isLoading){
            return
        }
        isLoading = true
        // TODO: Add the searchBar to search the music
        // Ctl + Shift + space get the full code in the method
        val musicData = retrofitData.getData("eminem")
        musicData.enqueue(object : Callback<MusicData?> {
            override fun onResponse(call: Call<MusicData?>, response: Response<MusicData?>) {
                isLoading = false

                    val newData = response.body()?.data ?: emptyList()
                if (currentPage == 1) {
                    // If it's the first page, initialize the adapter
                    myAdapter = MyAdapter(this@MainActivity, newData)
                    recyclerView.adapter = myAdapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                } else {
                    // For subsequent pages, add data to the existing adapter
                    myAdapter = MyAdapter(this@MainActivity, newData)
                }
                currentPage++
                Log.d("Response", newData.toString())
            }

            override fun onFailure(call: Call<MusicData?>, t: Throwable) {
                isLoading = false
                Log.d("Failure", "Getting failure")
            }
        })
    }
}