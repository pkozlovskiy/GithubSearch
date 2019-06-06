package com.pako.githubsearch.presentation.injection

import android.content.Context
import com.pako.githubsearch.App
import dagger.Binds
import dagger.Module

@Module
abstract class ContextModule {

    @Binds
    internal abstract fun provideContext(application: App): Context
}
