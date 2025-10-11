package dev.eamoretti.appue.data.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import dev.eamoretti.appue.data.local.FavoriteCountryDao
import dev.eamoretti.appue.data.local.FavoriteCountryEntity
import kotlinx.coroutines.flow.Flow

class FavoriteRepository (private val dao: FavoriteCountryDao) {


    suspend fun insert(country: FavoriteCountryEntity)
        = dao.insertFavoriteCountry(country)

    suspend fun delete(country: FavoriteCountryEntity)
        = dao.deleteFavoriteCountry(country)

    fun getAll(): Flow<List<FavoriteCountryEntity>>
        = dao.getAll()


}