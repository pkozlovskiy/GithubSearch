package com.pako.githubsearch.view.injection.base

import com.pako.githubsearch.view.main.ui.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}