package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    // Une WebView est juste la partie du moteur de navigateur
    // que vous pouvez insérer un peu comme une iframe dans votre
    // application native et lui dire par programme quel contenu Web à charger
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // On recherche notre webview avec l'id préalablement
        // défini dans notre activity_splash.xml
        webView = findViewById(R.id.webview)
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        // On loadUrl du website pour l'injecter dans notre application.
        webView!!.loadUrl("http://abstract73.github.io/abstract73/")

        // On initalise les paramètre de notre WebView
        val webSettings = webView!!.settings
        // On active les scripts de javascript
        webSettings.javaScriptEnabled = true
    }

    // onBackPressed est une activité qui s'active quand notre utilisateur
    // appuie sur la touche retour de son téléphone
    override fun onBackPressed() {
        // On regarde si il peut revenir en arrière sur le moteur de recherché
        // implanter au préalable. Si oui il retournera sur la page
        // qu'il a consulter juste avant
        if (webView!!.canGoBack()) {
            webView!!.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
