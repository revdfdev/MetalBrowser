package xyz.merkmod.metalbrowser.entities

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Articles(@field:SerializedName("status")
               var status: String? = null, @field:SerializedName("source")
               var source: String? = null, @field:SerializedName("sortBy")
               var sortBy: String? = null, @field:SerializedName("articles")
               var articles: ArrayList<Article?>? = null)

open class Article(@field:SerializedName("author")
              var author: String? = null, @field:SerializedName("title")
              var title: String? = null, @field:SerializedName("description")
              var description: String? = null, @field:SerializedName("url")
              var url: String? = null,
              @field:SerializedName("urlToImage")
              var urlToImage: String? = null, @field:SerializedName("publishedAt")
              var publishedAt: String? = null): RealmObject()
