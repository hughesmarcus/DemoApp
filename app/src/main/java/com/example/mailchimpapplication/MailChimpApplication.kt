package com.example.mailchimpapplication

import com.example.mailchimpapplication.di.DaggerInjector
import com.example.mailchimpapplication.di.NetModule
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication


class MailChimpApplication : DaggerApplication() {

    private val url = "https://us14.api.mailchimp.com"

    override fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
        return DaggerInjector.builder()
            .application(this)
            .netModule(
                NetModule(url)
            )
            .build()
    }
}