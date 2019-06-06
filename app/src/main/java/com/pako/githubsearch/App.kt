package com.pako.githubsearch

import com.pako.githubsearch.presentation.injection.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerApplicationComponent.builder().application(this).build()
        component.inject(this)

        return component
    }
}