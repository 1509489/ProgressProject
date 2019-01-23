package com.example.progressproject.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.progressproject.R
import com.example.progressproject.adapters.ArticleListAdapter
import com.example.progressproject.common.AppInjector
import com.example.progressproject.data.models.Doc
import com.example.progressproject.di.activity.ActivityComponent
import com.example.progressproject.di.activity.ActivityModule
import com.example.progressproject.di.application.ApplicationComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var articleListViewModel: ArticleListViewModel
    @Inject lateinit var activityComponent: ActivityComponent

    lateinit var adapter: ArticleListAdapter
    private var docList = ArrayList<Doc>()
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependancies()
        linearLayoutManager = LinearLayoutManager(this)
        setupRecycler(rvArticle)
    }

    fun setupRecycler(recyclerView: RecyclerView){


        for(i in 0 until 10){
            docList.add(Doc(docList[i].webUrl, docList[i].snippet, docList[i].blog, docList[i].multimedia,
                docList[i].headline, docList[i].keywords, docList[i].documentType, docList[i].sectionName,
                docList[i].typeOfMaterial, docList[i].id, docList[i].wordCount, docList[i].score, docList[i].printPage,
                docList[i].source, docList[i].pubDate, docList[i].newsDesk, docList[i].byline, docList[i].uri) )
        }

        recyclerView.adapter = ArticleListAdapter(this, docList, false)
        rvArticle.layoutManager = linearLayoutManager
        rvArticle.adapter = adapter
    }

    fun searchArticle(view: View) {
        val searchQuery: String
        searchQuery = etSearchQuery.text.toString()
        articleListViewModel.getSearch(searchQuery)
    }

    private fun injectDependancies(){
        activityComponent =
                (application as AppInjector).applicationComponent.newActivityComponent(ActivityModule(this))
        activityComponent.injectHomeScreen(this)
    }
}
