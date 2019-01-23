package com.example.progressproject.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.progressproject.R

class ArticleDetailActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = ArticleDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        ArticleDetailFragment.WEB_URL,
                        intent.getStringExtra(ArticleDetailFragment.WEB_URL)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment, fragment)
                .commit()
        }
    }
}