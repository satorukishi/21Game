package com.example.logonrm.a21game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.ivLogo

class SplashActivity : AppCompatActivity() {

    // Como eu estou usando o "kotlinx", não precisa declarar
    // lateinit var ivLogo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        carregar()

        // Como eu estou usando o "kotlinx", não precisa pontuar
        // ivLogo = findViewById(R.id.ivLogo)

    }

    fun carregar() {
        val animacao = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        ivLogo.clearAnimation()
        ivLogo.startAnimation(animacao)

        // Executa o que está dentro das {} após o delayMillis de 3000
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            this@SplashActivity.finish() // Mata a SplashActivity
        }, 3000)
    }
}
