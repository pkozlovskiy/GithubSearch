package com.pako.githubsearch.view.injection.base

import android.app.Application
import com.pako.githubsearch.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, ApplicationModule::class, AndroidSupportInjectionModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
