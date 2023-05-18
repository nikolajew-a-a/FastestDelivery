package ru.app.fastestdelivery.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.app.fastestdelivery.data.models.database.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun spaceDao(): SpacesDao

}