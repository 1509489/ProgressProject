package com.example.progressproject.ui.home

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.example.progressproject.R
import com.example.progressproject.adapters.ArticleListAdapter
import com.example.progressproject.common.AppInjector
import com.example.progressproject.data.models.Doc
import com.example.progressproject.di.activity.ActivityComponent
import com.example.progressproject.di.activity.ActivityModule
import com.example.progressproject.di.application.ApplicationComponent
import com.example.progressproject.ui.detail.ArticleDetailActivity
import com.example.progressproject.ui.detail.ArticleDetailFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ArticleListAdapter.OnItemClickedListener {

    @Inject lateinit var articleListViewModel: ArticleListViewModel
    @Inject lateinit var activityComponent: ActivityComponent

    private lateinit var adapter: ArticleListAdapter
    private var docList = ArrayList<Doc>()
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependancies()
        docList = ArrayList()
        linearLayoutManager = LinearLayoutManager(this)
        //setupRecycler(rvArticle)
        rvArticle.layoutManager = linearLayoutManager
        rvArticle.addItemDecoration(DividerItemDecoration(this, linearLayoutManager.orientation))
    }

    /**
     * setup recycler view method not needed
     */
    /*fun setupRecycler(recyclerView: RecyclerView){


        for(i in 0 until 10){
            docList.add(Doc(docList[i].webUrl, docList[i].snippet, docList[i].blog, docList[i].multimedia,
                docList[i].headline, docList[i].keywords, docList[i].documentType, docList[i].sectionName,
                docList[i].typeOfMaterial, docList[i].id, docList[i].wordCount, docList[i].score, docList[i].printPage,
                docList[i].source, docList[i].pubDate, docList[i].newsDesk, docList[i].byline, docList[i].uri) )
        }

        recyclerView.adapter = ArticleListAdapter(docList, this)
        rvArticle.layoutManager = linearLayoutManager
        rvArticle.adapter = adapter
    }*/

    fun searchArticle(view: View) {
        val searchQuery: String = etSearchQuery.text.toString()
        articleListViewModel.getSearch(searchQuery).observe(this, Observer {
            rvArticle.adapter = ArticleListAdapter( it?.docs!!, this)
            docList = it.docs as ArrayList<Doc>
        })
    }

    private fun injectDependancies(){
        activityComponent =
                (application as AppInjector).applicationComponent.newActivityComponent(ActivityModule(this))
        activityComponent.injectHomeScreen(this)
    }

    /**
     * perform your click actions here
     */
    override fun onItemClicked(position: Int) {
        startActivity(Intent(this, ArticleDetailActivity::class.java).also {
            it.putExtra(ArticleDetailFragment.WEB_URL, docList[position].webUrl)
        })
    }
}
