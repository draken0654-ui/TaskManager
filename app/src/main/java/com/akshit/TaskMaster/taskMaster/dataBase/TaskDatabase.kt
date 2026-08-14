package com.akshit.TaskMaster.taskMaster.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//knows how to create and manage the Room database
@Database(
    entities = [Task::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(TaskConverters::class)
abstract class TaskDatabase : RoomDatabase(){

    abstract fun taskDao() : TaskDao
    companion object {
        @Volatile
        private var INSTANCE:  TaskDatabase? = null

        //changing version 1 to 2
        val Migration_1_2 = object : Migration(1,2){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL( //ALTER means modify
                    """
                    ALTER TABLE tasks
                    ADD COLUMN priority TEXT NOT NULL DEFAULT 'MEDIUM'
                    """.trimIndent()
                )
            }
        }

        fun getDatabase(context: Context): TaskDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task_database"
                ).addMigrations(Migration_1_2)
                    .build()

                INSTANCE = instance //stores the data

                return instance
            }
        }
    }
}