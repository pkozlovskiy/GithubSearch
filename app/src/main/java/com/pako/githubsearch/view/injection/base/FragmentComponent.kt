package com.pako.githubsearch.view.injection.base

import com.pako.githubsearch.view.search.ui.ScrollingSearchFragment
import dagger.Component

@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(searchFragment: ScrollingSearchFragment)

}