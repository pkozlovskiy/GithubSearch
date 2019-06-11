package com.pako.githubsearch.view.injection.main

import com.pako.githubsearch.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }
}
