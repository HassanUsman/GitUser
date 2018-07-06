package com.gituser.hassanusman.Network

import com.gituser.hassanusman.Model.Result
import com.gituser.hassanusman.Model.Result2
import com.gituser.hassanusman.Model.User
import com.gituser.hassanusman.Model.userInfo
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Path


/**
 * Created by hassanusman on 7/1/18.
 */
interface GithubApiService {

    @GET("search/users")
    fun search(@Query("q") query: String,
               @Query("page") page: Int = 1,
               @Query("per_page") perPage: Int = 20): Observable<Result>

    @GET("users/{input}")
    fun user(@Path("input") user:String): Observable<userInfo>

    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): GithubApiService {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor(logging)  // <-- this is the important line!

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/")
                    .client(httpClient.build())
                    .build()

            return retrofit.create(GithubApiService::class.java)
        }
    }
}