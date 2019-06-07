package com.pako.githubsearch.cache.search.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pako.githubsearch.cache.search.structure.UserDbScheme

@Entity(tableName = UserDbScheme.TABLE_NAME)
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = UserDbScheme.ID) val id: Long,
    @ColumnInfo(name = UserDbScheme.LOGIN) val login: String,
    @ColumnInfo(name = UserDbScheme.NAME) val name: String,
    @ColumnInfo(name = UserDbScheme.AVATAR_URL) val avatarUrl: String
)