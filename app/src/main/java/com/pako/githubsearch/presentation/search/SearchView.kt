package com.pako.githubsearch.presentation.search

import com.pako.githubsearch.view.base.View

interface SearchView: View {
    fun showSearchFragment()
    fun showBookmarkFragment()
}