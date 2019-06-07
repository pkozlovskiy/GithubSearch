package com.pako.githubsearch.view.injection.base

import android.content.Context
import com.pako.githubsearch.App
import dagger.Binds
import dagger.Module

@Module
abstract class ContextModule {

    @Binds
    internal abstract fun provideContext(application: App): Context
}
