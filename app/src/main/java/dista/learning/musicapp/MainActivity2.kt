package dista.learning.musicapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var mediaIcon: ImageView
    private lateinit var btnPlayPause: ImageButton
    private lateinit var btnMute: ImageButton
    private lateinit var btnRepeat: ImageButton
    private lateinit var seekBar: SeekBar
    private lateinit var audioName: TextView
    private lateinit var startTime: TextView
    private lateinit var endTime: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnPlayPause = findViewById(R.id.btnPlayPause)
        btnMute = findViewById(R.id.btnMute)
        btnRepeat = findViewById(R.id.btnRepeat)
        seekBar = findViewById(R.id.seekBar)
        mediaIcon = findViewById(R.id.musicIcon)
        audioName = findViewById(R.id.audioName)
        startTime = findViewById(R.id.textStartTime)
        endTime = findViewById(R.id.textEndTime)



        mediaPlayer = MediaPlayer.create(this@MainActivity2,R.raw.my_audio)

            // play and pause button in app
        btnPlayPause.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.pause()
                btnPlayPause.setImageResource(R.drawable.play)
            } else {
                mediaPlayer.start()
                btnPlayPause.setImageResource(R.drawable.pause)
            }
        }

        // repe


    }
}