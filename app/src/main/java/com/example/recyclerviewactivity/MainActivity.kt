package com.example.recyclerviewactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomname.setHasFixedSize(true)
        randomname.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)

        val videoIds = listOf<String>(
                "zjlxEmTDb6U",
                "If56guGJIsU",
                "vjdrU_WOg54",
                "b-WViLMs_4c",
                "OOPWzhFnCZg",
                "xj7abSp07w0",
                "tbd93cJpJ6g",
                "8jo4I7uhe50",
                "TMk-UG_MEM4",
                "TGCwBVFKD74",
                "noOlR2kqcc4",
                "C_nLU-ZgKxQ",
                "KmntziBBTrg",
                "UKmFukSdih0",
                "3WV3ZI3nGfk",
                "P8jVISOOUL4"
        )

        randomname.adapter=RecyclerViewAdapter(videoIds,lifecycle)


    }
}