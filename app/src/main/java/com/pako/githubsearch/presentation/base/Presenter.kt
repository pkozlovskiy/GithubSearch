package com.pako.githubsearch.presentation.base

interface Presenter<in T> {
    fun subscribe()
    fun unsubscribe()
    fun attach(view: T)
}