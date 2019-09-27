package com.example.mymall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class FaceBookActivty extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_book_activty);

        webView = findViewById(R.id.webViewId);
        webView.loadUrl("https://www.facebook.com/");
    }
}
