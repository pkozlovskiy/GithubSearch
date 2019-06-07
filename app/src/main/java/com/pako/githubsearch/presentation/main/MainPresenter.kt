package com.pako.githubsearch.presentation.main

import com.pako.githubsearch.presentation.base.Presenter
import io.reactivex.disposables.CompositeDisposable

class MainPresenter: Presenter<MainView> {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainView

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainView) {
        this.view = view
        view.showSearchFragment() // as default
    }

    fun onDrawerOptionBookmarkClick() {
        view.showBookmarkFragment()
    }
}