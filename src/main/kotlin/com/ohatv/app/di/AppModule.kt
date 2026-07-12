package com.ohatv.app.di

import android.content.Context
import androidx.room.Room
import com.ohatv.app.data.db.OhaTVDatabase
import com.ohatv.app.data.network.OhaTVApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val requestBuilder = originalRequest.newBuilder()
                
                // Ad-Blocking Interceptor
                val url = originalRequest.url.toString()
                if (isAdUrl(url)) {
                    // Blockiere Werbungs-URLs
                    return@addInterceptor chain.proceed(requestBuilder.build())
                }
                
                chain.proceed(requestBuilder.build())
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val json = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl("https://oha.to/")
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Singleton
    @Provides
    fun provideOhaTVApiService(retrofit: Retrofit): OhaTVApiService {
        return retrofit.create(OhaTVApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideOhaTVDatabase(
        @ApplicationContext context: Context
    ): OhaTVDatabase {
        return Room.databaseBuilder(
            context,
            OhaTVDatabase::class.java,
            "ohatv_database"
        ).build()
    }

    private fun isAdUrl(url: String): Boolean {
        val adDomains = listOf(
            "doubleclick.net",
            "googlesyndication.com",
            "adservice.google.com",
            "ads.google.com",
            "pagead2.googlesyndication.com",
            "googleadservices.com",
            "facebook.com/tr",
            "analytics.google.com",
            "connect.facebook.net"
        )
        return adDomains.any { url.contains(it) }
    }
}
