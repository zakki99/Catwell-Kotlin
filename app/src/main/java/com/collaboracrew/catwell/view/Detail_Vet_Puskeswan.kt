package com.collaboracrew.catwell.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.collaboracrew.catwell.R

class Detail_Vet_Puskeswan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_vet_puskeswan)

        val backButton = findViewById(R.id.ivBack) as ImageView
        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}