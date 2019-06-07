package com.pako.githubsearch.view.injection.base

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }
}