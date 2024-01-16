package dista.learning.musicapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface{
//    val  baseUrl = "https://deezerdevs-deezer.p.rapidapi.com/"
    // Header that required to pass he additional information to backend to authenticate the request
    @Headers("X-RapidAPI-Key: 3e3727f2ffmsh6d78ee6be99278fp1157b3jsn6dae14d68f1a"
            ,"X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String):Call<MusicData>
}
object RetrofitHelper {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

 val retrofit: ApiInterface = Retrofit.Builder()
     .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
     .client(okHttpClient) // this print the request in log
     .addConverterFactory(GsonConverterFactory.create())
     .build()
     .create(ApiInterface::class.java)
}