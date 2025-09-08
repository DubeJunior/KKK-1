package com.example.fitkagehealth

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_page)

        // Apply insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find FAQs button (ImageView from your layout)
        val faqsBtn: ImageView = findViewById(R.id.FAQs)


        faqsBtn.setOnClickListener {
            val intent = Intent(this, FAQsScreen::class.java)
            startActivity(intent)
        }
            val aboutusbtn: ImageView = findViewById(R.id.aboutus)

            aboutusbtn.setOnClickListener {
                val intent = Intent(this, aboutus::class.java)
                startActivity(intent)

            }
        val downloadbtn: ImageView = findViewById(R.id.personaldata)

        downloadbtn.setOnClickListener {
            val intent = Intent(this, Download::class.java)
            startActivity(intent)

        }
        val messagbtn: ImageView = findViewById(R.id.messages)

        messagbtn.setOnClickListener {
            val intent = Intent(this, message::class.java)
            startActivity(intent)

        }
        val languagebtn: ImageView = findViewById(R.id.Languages)
        languagebtn.setOnClickListener {
            val intent = Intent(this, Languages::class.java)
            startActivity(intent)

        }
        }
    }

