package com.pako.githubsearch.view.injection.search

import com.pako.githubsearch.presentation.search.SearchPresenter
import dagger.Module
import dagger.Provides

@Module
class SearchModule(){
    @Provides
    fun provideSearchPresenter():SearchPresenter{
        return SearchPresenter()
    }
}
