package com.chat.chatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(FirebaseAuth.getInstance().currentUser == null)
            startActivity(Intent(baseContext,SignInActivity::class.java))
        else
            startActivity(Intent(baseContext,MainActivity::class.java))
        finish()
    }
}