package com.museum.app.db.dao

import android.arch.persistence.room.*
import io.reactivex.Maybe
import com.museum.app.dto.Exhibit

@Dao
interface ExhibitDAO {

    @Query("SELECT * from Exhibit where id = :id")
    fun getModel(id : Int?) : Maybe<Exhibit>

    @Query("SELECT * from Exhibit")
    fun getAll() : List<Exhibit>


}