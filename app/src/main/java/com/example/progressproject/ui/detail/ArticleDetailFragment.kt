package com.example.progressproject.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.progressproject.R
import kotlinx.android.synthetic.main.detail_fragment.view.*

class ArticleDetailFragment: Fragment() {

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(WEB_URL)) {

                url = it.getString(WEB_URL)
            }
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.detail_fragment, container, false)

        val u = url
        rootView.webview.apply {
            val webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    /**
                     * you can show a loading indicator here if you want
                     */
                }
            }
            settings.javaScriptEnabled = true
            loadUrl(u)
        }

        return rootView
    }

    companion object {
        const val WEB_URL = "web_url"
    }
}