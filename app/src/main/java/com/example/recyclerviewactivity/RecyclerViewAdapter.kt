package com.example.recyclerviewactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.RecyclerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

class RecyclerViewAdapter(var videoIds: List<String>, var lifecycle: Lifecycle): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    class ViewHolder(private val youTubePlayerView: YouTubePlayerView) : RecyclerView.ViewHolder(youTubePlayerView) {
        private var youTubePlayer: YouTubePlayer? = null
        private var currentVideoId: String? = null

        fun cueVideo(videoId: String?) {
            currentVideoId = videoId
            if (youTubePlayer == null) return
            youTubePlayer!!.loadVideo(videoId!!,0f)
        }

        init {
            youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    this@ViewHolder.youTubePlayer = youTubePlayer
                    this@ViewHolder.youTubePlayer!!.loadVideo(currentVideoId!!, 0f)
                }
            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val youTubePlayerView:YouTubePlayerView=LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false) as YouTubePlayerView
        lifecycle.addObserver(youTubePlayerView)

        return ViewHolder(youTubePlayerView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.cueVideo(videoIds.get(position))
        
        holder.itemView.setOnFocusChangeListener { v, hasFocus ->
            if(!hasFocus){
                v.requestFocus()
            }
        }
    }

    override fun getItemCount(): Int {
        return videoIds.size
    }


}