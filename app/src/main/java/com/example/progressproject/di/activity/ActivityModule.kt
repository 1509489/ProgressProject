package com.example.progressproject.di.activity

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import com.example.progressproject.data.repository.RepositoryImpl
import com.example.progressproject.factories.ArticleListFactory
import com.example.progressproject.ui.home.ArticleListViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: AppCompatActivity) {

    @Provides
    @ActivityScope
    fun providesItemListViewModelFactory(repositoryImpl: RepositoryImpl) = ArticleListFactory(repositoryImpl)

    @Provides
    @ActivityScope
    fun providesItemListViewModel(itemListFactory: ArticleListFactory) =
        ViewModelProviders.of(activity, itemListFactory).get(ArticleListViewModel::class.java)

//    @Provides
//    @ActivityScope
//    fun providesItemListDataBinding() = DataBindingUtil.setContentView<ActivityItemListBinding>(activity, R.layout.activity_item_list)

}