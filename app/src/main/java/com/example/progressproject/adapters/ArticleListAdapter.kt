package com.example.progressproject.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.progressproject.R
import com.example.progressproject.common.BASE_IMAGE_URL
import com.example.progressproject.data.models.ApiResponse
import com.example.progressproject.data.models.Doc
import com.example.progressproject.data.models.Multimedium
import com.example.progressproject.ui.detail.ArticleDetailActivity
import com.example.progressproject.ui.detail.ArticleDetailFragment
import com.example.progressproject.ui.home.MainActivity

class ArticleListAdapter(private val articleList: List<Doc>, private val listener: OnItemClickedListener) :
    RecyclerView.Adapter<ArticleListAdapter.ViewHolder>() {

    private lateinit var context: Context
/*
    private var onClickListener: View.OnClickListener
*/


    /*init {
        onClickListener = View.OnClickListener { v ->
            val item = v.tag as ApiResponse
            *//*if (twoPane) {
                val fragment = ArticleDetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(ArticleDetailFragment.WEB_URL, item.response.docs[0].id)
                    }
                }
                parentActivity.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit()
            } else {
                val intent = Intent(v.context, ArticleDetailActivity::class.java).apply {
                    putExtra(ArticleDetailFragment.WEB_URL, item.response.docs[0].id)
                }*//*

                val intent = Intent(v.context, ArticleDetailActivity::class.java).apply {
                    putExtra(ArticleDetailFragment.WEB_URL, item.response.docs[0].id)
                v.context.startActivity(intent)
            }
        }
    }*/

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ArticleListAdapter.ViewHolder {
        context = viewGroup.context
        val view = LayoutInflater.from(context).inflate(
            R.layout.recycler_view_article, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: ArticleListAdapter.ViewHolder, position: Int) {
        val temp = articleList[position]
        holder.apply {
            headline.text = temp.headline.main
            snippet.text = temp.snippet

            /**
             * Added this bit to get the image to be displayed in the recyclerView
             */
            val multimedia: ArrayList<Multimedium> = temp.multimedia as ArrayList<Multimedium>
            var thumbnail = ""

            for (media in multimedia)
            {
                if (media.type == "image" && media.subtype == "thumbnail"){
                    thumbnail = BASE_IMAGE_URL + media.url
                    break
                }
            }

            Glide.with(context)
                .load(thumbnail).into(image)
            /*with(holder.itemView) {
                tag = temp
                setOnClickListener(onClickListener)
            }*/
        }

        //Handle the click here
        holder.itemView.setOnClickListener { listener.onItemClicked(position) }

    }

    class ViewHolder(articleView: View) : RecyclerView.ViewHolder(articleView){
        val headline: TextView = articleView.findViewById(R.id.tvHeadline)
        val snippet:TextView = articleView.findViewById(R.id.tvSnippet)
        val image: ImageView = articleView.findViewById(R.id.imageView)
    }

    /**
     * Interface to handle recycler view item click
     * implemented in the main activity
     */
    interface OnItemClickedListener{
        fun onItemClicked(position: Int)
    }
}