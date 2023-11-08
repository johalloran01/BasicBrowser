package edu.temple.basicbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var urlEditText: EditText
    lateinit var goButton: ImageButton
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urlEditText = findViewById(R.id.urlEditText)
        goButton = findViewById(R.id.goButton)
        webView = findViewById(R.id.webView)

        // Allow your browser to intercept hyperlink clicks
        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }
        //Enable javascript
        webView.settings.javaScriptEnabled = true

        //Set onclick listener for send button
        goButton.setOnClickListener {
            val url = urlEditText.text.toString()
            val formatted = formatUrl(url)
            webView.loadUrl(formatted)
        }

    }
    //Format Url method
    private fun formatUrl(url: String): String {
        var formattedUrl = url
        if (!url.startsWith("http://") && !url.startsWith("https://")){
            formattedUrl = "https://$url"
        }
        return formattedUrl

    }
}