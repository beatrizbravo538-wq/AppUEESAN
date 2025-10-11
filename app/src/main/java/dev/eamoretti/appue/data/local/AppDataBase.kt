package dev.eamoretti.appue.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteCountryEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract val favoriteCountryDao: FavoriteCountryDao
        companion object {
            @Volatile
            private var INSTANCE: AppDataBase? = null
            fun getInstance(context: Context): AppDataBase {
                return INSTANCE ?: synchronized(this) {
                    Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "country_app_db"
                    ).build().also { INSTANCE = it }
                }
            }
        }
}