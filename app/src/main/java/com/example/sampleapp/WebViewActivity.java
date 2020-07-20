package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.Helpers.WebViewHelp;

public class WebViewActivity extends AppCompatActivity {

    private final String URL = "file:///android_asset/WebView.html";
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webview = findViewById(R.id.webView1);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.addJavascriptInterface(new WebViewHelp(this), "AndroidJs");
        refreshWebView();

    }

    private void refreshWebView() {
        webview.loadUrl(URL);
    }
}