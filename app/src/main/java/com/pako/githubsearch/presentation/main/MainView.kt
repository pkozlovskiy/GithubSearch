package com.pako.githubsearch.presentation.main

import com.pako.githubsearch.view.base.View

interface MainView: View {
    fun showSearchFragment()
    fun showBookmarkFragment()
}