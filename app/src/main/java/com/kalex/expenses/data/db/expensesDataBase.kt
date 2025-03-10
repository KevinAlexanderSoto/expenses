package com.kalex.expenses.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kalex.expenses.data.db.dao.ObligationDao

/**
 * @author kevin Alexander Soto on 3/9/2025
 * **/

@Database(
    entities = [Obligation::class],
    version = 1,
    exportSchema = true,
)
abstract class ExpensesDataBase : RoomDatabase() {
    abstract val obligationDao: ObligationDao
}