package com.pako.githubsearch.remote.base.service

import com.pako.githubsearch.remote.users.model.Result
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubSearchService {

    @GET("search/users")
    fun search(
        @Query("q") query: String
    ): Observable<Result>
}

