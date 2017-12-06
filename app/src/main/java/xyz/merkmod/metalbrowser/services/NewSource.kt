package xyz.merkmod.metalbrowser.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap
import xyz.merkmod.metalbrowser.entities.Articles
import xyz.merkmod.metalbrowser.entities.Sources

/**
 * Created by thepunkprogrammer on 12/7/17.
 */
interface NewSource {

    @GET("/sources")
    fun getSources(@QueryMap queries: Map<String, String>): Call<Sources>

    @GET("/articles")
    fun getArticles(@QueryMap queries: Map<String, String>): Call<Articles>
}