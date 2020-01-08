package com.example.mailchimpapplication.di

import android.app.Application
import com.example.mailchimpapplication.MailChimpApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, NetModule::class, MainModule::class,ActivityBindingModule::class])
interface Injector : AndroidInjector<MailChimpApplication?> {
    @Component.Builder
    interface Builder {
        fun build(): Injector
        @BindsInstance
        fun application(application: Application): Builder

        fun netModule(netModule: NetModule): Builder
    }
}
