package com.museum.app.dto

import android.support.annotation.*
import com.google.gson.annotations.*
import android.arch.persistence.room.*

@Entity(tableName = "Rating")
class Rating {

    @NonNull
    @Expose
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @SerializedName("id")
    var id : Int? = null

    @Expose
    @ColumnInfo(name = "rateDate")
    @SerializedName("rateDate")
    var date : Date? = null

    @Expose
    @ColumnInfo(name = "rateUser")
    @SerializedName("rateUser")
    var username : String? = null

    @Expose
    @ColumnInfo(name = "rateDescription")
    @SerializedName("rateDescription")
    var description : String? = null

    @Expose
    @ColumnInfo(name = "rateValue")
    @SerializedName("rateValue")
    var value : Int? = null
    
    @Expose
    @ColumnInfo(name = "rateExhibit")
    @SerializedName("rateExhibit")
    var exhibitId : Int? = null
}
