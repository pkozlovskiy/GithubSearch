package com.pako.githubsearch.presentation.search

import com.pako.githubsearch.presentation.base.Presenter
import io.reactivex.disposables.CompositeDisposable

class SearchPresenter: Presenter<SearchView> {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: SearchView

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: SearchView) {
        this.view = view
    }

}