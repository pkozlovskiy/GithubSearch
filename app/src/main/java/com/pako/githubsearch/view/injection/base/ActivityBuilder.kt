package com.pako.githubsearch.view.injection.base

import com.pako.githubsearch.view.injection.main.MainActivityModule
import dagger.android.ContributesAndroidInjector
import com.pako.githubsearch.view.main.ui.MainActivity
import dagger.Module


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity

}