package com.museum.app.db

import android.content.Context
import io.reactivex.Maybe
import java.util.ArrayList

import com.museum.app.dto.Exhibit
import com.museum.app.dto.Rating

import com.museum.app.db.dao.ExhibitDao
import com.museum.app.db.dao.RatingDao

object DatabaseHelper {

    //region Exhibits
    @Synchronized
    fun getExhibits(context : Context) : List<Exhibit> {
        val database : MuseumDataBase = MuseumDataBase.getInstance(context)!!
        val dao : ExhibitDAO = database.exhibitDAO()
        val list : List<Exhibit> = dao.getAll()
        return list
    }

    @Synchronized
    fun getExhibitById(context : Context, id : Int) : Maybe<Exhibit> {
        val database : MuseumDataBase = MuseumDataBase.getInstance(context)!!
        val dao : ExhibitDAO = database.exhibitDAO()
        val data : Maybe<Exhibit> = dao.getModel(id = id)
        return data
    }
    //endregion

    //region Rating
    @Synchronized
    fun getExhibits(context : Context, exhibitId : Int) : List<Rating> {
        val database : MuseumDataBase = MuseumDataBase.getInstance(context)!!
        val dao : RatingDAO = database.ratingDAO()
        val list : List<Rating> = dao.getAllFromExhibit(exhibit= exhibitId)
        return list
    }

    @Synchronized
    fun addRating(context: Context, rating : Rating) {
        val database : MuseumDataBase = MuseumDataBase.getInstance(context)!!
        val dao : RatingDAO = database.ratingDAO()
        dao.insert(data= rating)
    }

    //endregion
}