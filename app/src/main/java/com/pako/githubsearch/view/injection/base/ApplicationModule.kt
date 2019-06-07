package com.pako.githubsearch.view.injection.base

import com.pako.githubsearch.remote.base.service.GithubSearchService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import javax.inject.Singleton

@Module
class ApplicationModule{

    private val BASE_URL = "https://api.github.com/"

    @Singleton
    @Provides
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    internal fun provideRetrofitService(retrofit: Retrofit): GithubSearchService {
        return retrofit.create(GithubSearchService::class.java)
    }
}
