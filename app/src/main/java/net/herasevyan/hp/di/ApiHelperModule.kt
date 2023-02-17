package net.herasevyan.hp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.herasevyan.hp.api.HPApiHelper
import net.herasevyan.hp.api.HpApiHelperImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ApiHelperModule {

    @Binds
    @Singleton
    fun bindHpApiHelper(impl: HpApiHelperImpl): HPApiHelper
}