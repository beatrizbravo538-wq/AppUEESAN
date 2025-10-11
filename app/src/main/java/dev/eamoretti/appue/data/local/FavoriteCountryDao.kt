package dev.eamoretti.appue.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCountryDao{
    @Insert
    suspend fun insertFavoriteCountry(favoriteCountryEntity: FavoriteCountryEntity)

    @Delete
    suspend fun deleteFavoriteCountry(favoriteCountryEntity: FavoriteCountryEntity)

    @Query("SELECT * FROM favorite_countries")
    fun getAll(): Flow<List<FavoriteCountryEntity>>
}