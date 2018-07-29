package com.example.administrator.kotlinfiltiration2.Model

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.Database
import android.arch.persistence.room.DatabaseConfiguration
import android.arch.persistence.room.InvalidationTracker
import android.arch.persistence.room.RoomDatabase
import com.example.administrator.kotlinfiltiration2.ViewModel.DataBaseOperations
import java.sql.Array
import kotlin.reflect.KClass

@Database(entities = arrayOf(Currency.Datum::class),version = 1)
abstract class currencyDataBase : RoomDatabase()
{

   abstract fun insert():DataBaseOperations




}