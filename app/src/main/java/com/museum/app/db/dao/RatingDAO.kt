package com.museum.app.db.dao

import android.arch.persistence.room.*
import io.reactivex.Maybe
import com.museum.app.dto.Rating

@Dao
interface RatingDAO {

    @Query("SELECT * from Rating where id = :id")
    fun getModel(id : Int?) : Maybe<Rating>

    @Query("SELECT * from Rating where rateExhibit = :exhibit")
    fun getAllFromExhibit(exhibit: Int) : Maybe<Rating>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(data : Rating)

    @Update
    fun update(data : Rating)
}