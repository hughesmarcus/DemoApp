package com.example.mailchimpapplication.di

import com.example.mailchimpapplication.data.SubRepository
import com.example.mailchimpapplication.data.SubService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetModule(private val mailChimpUrl: String) {

    @Provides
    @Singleton
    fun providesSubRepository(subService: SubService) = SubRepository(subService)

    @Provides
    @Singleton
    fun provideSubService(retrofit: Retrofit): SubService {
        return retrofit.create(SubService::class.java)
    }

    @Singleton
    @Provides
    fun provideMailChimpRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(mailChimpUrl)
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                chain.proceed(
                    chain
                        .request()
                        .newBuilder()
                        .header(
                            AUTHORIZATION_HEADER_KEY,
                            AUTHORIZATION_PREFIX + "8ac1de26a49c4cca30ca8c0b62b8e68c-us14"
                        )
                        .build()
                )
            }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideGsonBuilder(): GsonBuilder {
        return GsonBuilder()
    }

    @Provides
    @Singleton
    fun provideGson(builder: GsonBuilder): Gson {
        return builder.create()
    }

    companion object {
        private const val AUTHORIZATION_PREFIX = "apikey "
        private const val AUTHORIZATION_HEADER_KEY = "Authorization"
    }

}
