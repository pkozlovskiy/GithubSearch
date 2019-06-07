package com.pako.githubsearch.remote.base.service

import com.pako.githubsearch.remote.search.model.SearchResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubSearchService {

    @GET("search/users")
    fun search(
        @Query("q") query: String
    ): Observable<SearchResponse>


    companion object Factory {
        fun create(): GithubSearchService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(GithubSearchService::class.java)
        }
    }
}

