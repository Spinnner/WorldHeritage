package com.spinner.worldheritage.di

import android.content.Context
import com.spinner.worldheritage.data.repository.HeritageRepositoryImpl
import com.spinner.worldheritage.domain.repository.HeritageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHeritageRepository(@ApplicationContext context: Context): HeritageRepository {
        return HeritageRepositoryImpl(context)
    }
}