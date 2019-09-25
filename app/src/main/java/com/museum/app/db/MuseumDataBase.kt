package com.museum.app.db

import android.arch.persistence.room.*
import android.content.Context

import com.museum.app.dto.Exhibit
import com.museum.app.dto.Rating

import com.museum.app.db.dao.ExhibitDAO
import com.museum.app.db.dao.RatingDAO

@Database(version = 1,
        exportSchema = false,
        entities = [(Exhibit::class), (Rating::class)])
abstract class MuseumDataBase : RoomDataBase() {
    companion object {

        @Volatile
        internal var INSTANCE: MuseumDataBase? = null

        fun getInstance(context : Context) : MuseumDataBase? {
            LoggerUtils.log("Retrieving DataBase Instance")
            if (INSTANCE == null) {
                synchronized(SalesForceDataBase::class) {
                    LoggerUtils.log("Initialize DataBase...")
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MuseumDataBase::class.java, "museum.db").allowMainThreadQueries().build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance() {
            LoggerUtils.log("Closing DataBase...")
            INSTANCE = null
        }
    }

    //region DAO
    abstract fun exhibitDAO() : ExhibitDAO
    abstract fun ratingDAO() : RatingDAO
    //endregion
}
