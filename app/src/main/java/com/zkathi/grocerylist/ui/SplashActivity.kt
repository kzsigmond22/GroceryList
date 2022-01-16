package com.zkathi.grocerylist.ui

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.zkathi.grocerylist.R

class SplashActivity : AppCompatActivity() {

    private lateinit var animation: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        animation = findViewById(R.id.splash_lottie_animation)
        animation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                Log.i("onAnimationRepeat", "not used")
            }

            override fun onAnimationEnd(animation: Animator?) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
                Log.i("onAnimationCancel", "not used")
            }

            override fun onAnimationStart(animation: Animator?) {
                Log.i("onAnimationStart", "not used")
            }

        })
    }

    override fun onStart() {
        super.onStart()
        animation.resumeAnimation()
    }

    override fun onPause() {
        super.onPause()
        animation.pauseAnimation()
    }
}