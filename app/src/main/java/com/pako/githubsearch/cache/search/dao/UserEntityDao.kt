package com.pako.githubsearch.cache.search.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pako.githubsearch.cache.search.model.UserEntity
import com.pako.githubsearch.cache.search.structure.UserDbScheme

@Dao
interface UserEntityDao {
    @Insert
    fun insert(user: UserEntity)

    @Query("SELECT * FROM ${UserDbScheme.TABLE_NAME}")
    fun getAll(): LiveData<List<UserEntity>>
}