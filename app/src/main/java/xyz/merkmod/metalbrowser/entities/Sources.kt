package xyz.merkmod.metalbrowser.entities

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Required

open class Sources(@field:SerializedName("status")
              var status: String? = null, @field:SerializedName("sources")
              var sources: ArrayList<Source?>? = null)

open class Source(@field:SerializedName("id")
             var id: String? = null, @field:SerializedName("name")
             var name: String? = null, @field:SerializedName("description")
             var description: String? = null, @field:SerializedName("url")
             var url: String? = null, @field:SerializedName("category")
             var category: String? = null,
             @field:SerializedName("language")
             var language: String? = null, @field:SerializedName("country")
             var country: String? = null, @field:SerializedName("urlsToLogos")
             var urlsToLogos: UrlsToLogos? = null,
             @field:SerializedName("sortBysAvailable")
             var sortBysAvailable: RealmList<String?>? = null): RealmObject()

open class UrlsToLogos(@field:SerializedName("small")
                  var small: String? = null, @field:SerializedName("medium")
                  var medium: String? = null, @field:SerializedName("large")
                  var large: String? = null): RealmObject()
