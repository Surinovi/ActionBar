package com.action_bar_ab2018.action_bar;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity
{
    WebView webView;
    EditText search;
    Button search_btn;
    public final static String url = "https://www.google.com.tr/search?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        webView = findViewById(R.id.webview);
        search = findViewById(R.id.search_et);
        search_btn = findViewById(R.id.search_btn);

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGoogle(search.getText().toString());
            }
        });
    }

    public void goToGoogle(String arananEleman)
    {
        String URL = url+arananEleman;
        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(URL);
        final ProgressDialog progressDialog = ProgressDialog.show(this,"Arama","Yükleniyor",true);
        progressDialog.show();
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                super.onPageFinished(view, url);
                progressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressDialog.dismiss();
            }
        });
    }
}
