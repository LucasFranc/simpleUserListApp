package com.example.simpleuserlistapplication.di

import com.example.simpleuserlistapplication.data.UsersRepository
import com.example.simpleuserlistapplication.data.UsersService
import com.example.simpleuserlistapplication.data.UsersUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

fun provideHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient
        .Builder()
        .readTimeout(20, TimeUnit.SECONDS)
        .connectTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}

fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}

fun provideService(retrofit: Retrofit): UsersService =
    retrofit.create(UsersService::class.java)

fun provideRepository(service: UsersService): UsersRepository =
    UsersRepository(service)

fun provideUseCase(repository: UsersRepository): UsersUseCase =
    UsersUseCase(repository)


val networkModule = module {
    single { provideHttpClient() }
    single { provideRetrofit(get()) }
    single { provideService(get()) }
    single { provideRepository(get()) }
    single { provideUseCase(get()) }
}