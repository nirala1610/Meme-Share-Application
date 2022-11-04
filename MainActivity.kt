package com.example.memeshares

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import android.widget.ImageView as ImageView1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun loadMeme(){



            // Instantiate the RequestQueue.
                    val queue = Volley.newRequestQueue(this)
                    val url = "https://meme-api.herokuapp.com/gimme"     // meme api link

            // Request a string response from the provided URL.

        val jsonObjectRequest = JsonObjectRequest(
            /* method = */ Request.Method.GET, /* url = */ url,null,   // GET use for receive data from API
            /* listener = */ { response ->    // API send response than this part call

                            val url = response.getString("url")
                           Glide.with(this).load(url).into(memeImageView)

                        },
            /* errorListener = */ { } )// error in response than this part call

            // Add the request to the RequestQueue.
                    queue.add(jsonObjectRequest)
    }

    object memeImageView : ImageView1()

    fun ShareMeme(view: View) {}
    fun nextMeme(view: View) {}
}


