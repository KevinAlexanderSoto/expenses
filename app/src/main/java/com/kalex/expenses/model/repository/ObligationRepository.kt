package com.kalex.expenses.model.repository

import com.kalex.expenses.data.db.Obligation
import kotlinx.coroutines.flow.Flow

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/
interface ObligationRepository {
    suspend fun getObligations(): Flow<List<Obligation>>
    suspend fun saveObligation(obligation: Obligation)
    suspend fun deleteObligation(obligation: Obligation)
}