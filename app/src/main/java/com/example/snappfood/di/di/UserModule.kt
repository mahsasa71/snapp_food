package com.example.snappfood.di.di

import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UserModule {

    @Singleton
    @Provides
    fun provideContact():Contact{
        return Contact()

    }

    @Singleton
    @Provides
    fun provideuser():User{
        return User(Contact())
    }

}