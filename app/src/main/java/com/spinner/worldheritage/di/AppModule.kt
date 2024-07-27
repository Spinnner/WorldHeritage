package com.spinner.worldheritage.di

import android.content.Context
import com.spinner.worldheritage.data.repository.HeritageRepositoryImpl
import com.spinner.worldheritage.domain.repository.HeritageRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    companion object {
        @Provides
        @Singleton
        fun provideApplicationContext(@ApplicationContext appContext: Context): Context {
            return appContext
        }
    }

    @Binds
    @Singleton
    fun provideHeritageRepository(heritageRepositoryImpl: HeritageRepositoryImpl): HeritageRepository
}