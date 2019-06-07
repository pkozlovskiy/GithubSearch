package com.pako.githubsearch.view.injection.base

import com.pako.githubsearch.remote.base.service.GithubSearchService
import dagger.Module
import dagger.Provides

@Module
class FragmentModule {
    @Provides
    fun provideApiService(): GithubSearchService {
        return GithubSearchService.create()
    }
}
