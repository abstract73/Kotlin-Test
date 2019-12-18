package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    //Variable qui ne bougera jamais grâce au final.
    //Elle détermine aussi la durée de chargement de notre page.
    //Cette durée est déterminé en millisecondes (Oui il faut savoir convertir c:).
    private val duree = 3000

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //rediriger vers la page principale "MainAcitivity" après 3 secondes.
        Handler().postDelayed({
            //Demarage de notre nouvelle page après 3 secondes.
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, duree.toLong())
    }
}
