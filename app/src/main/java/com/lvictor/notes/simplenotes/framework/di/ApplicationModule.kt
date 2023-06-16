package com.lvictor.notes.simplenotes.framework.di

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val app: Application) {

    @Provides
    fun providesApp() = app
}