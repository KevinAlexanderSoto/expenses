package com.kalex.expenses.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow
import androidx.room.Query
import androidx.room.Upsert
import com.kalex.expenses.data.db.Obligation

/**
 * @author kevin Alexander Soto on 3/9/2025
 * **/
@Dao
interface ObligationDao {
    @Upsert
    suspend fun upsertObligation(obligation: Obligation)

    @Query("SELECT * FROM Obligation")
    fun getAll(): Flow<List<Obligation>>

    @Delete
    suspend fun deleteObligation(obligation: Obligation)

}