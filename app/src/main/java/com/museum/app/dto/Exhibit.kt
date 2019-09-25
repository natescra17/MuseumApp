package com.museum.app.dto

import android.support.annotation.*
import com.google.gson.annotations.*
import android.arch.persistence.room.*

import com.museum.app.dto.Exhibit
import com.museum.app.dto.Rating

import com.museum.app.db.dao.ExhibitDao
import com.museum.app.db.dao.RatingDao

@Entity(tableName = "Exhibit")
class Exhibit {

    @NonNull
    @Expose
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id : Int? = null

    @Expose
    @ColumnInfo(name = "exhibitName")
    @SerializedName("exhibitName")
    var name : String? = null

    @Expose
    @ColumnInfo(name = "exhibitDescription")
    @SerializedName("exhibitDescription")
    var description : String? = null

    @Ignore
    var ratings : List<Rating>? = null

}
