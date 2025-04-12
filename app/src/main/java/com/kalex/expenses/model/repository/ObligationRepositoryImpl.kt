package com.kalex.expenses.model.repository

import com.kalex.expenses.data.db.Obligation
import com.kalex.expenses.data.db.dao.ObligationDao

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/
class ObligationRepositoryImpl(private val obligationDao: ObligationDao): ObligationRepository {
    override suspend fun getObligations() = obligationDao.getAll()

    override suspend fun saveObligation(obligation: Obligation) {
        obligationDao.upsertObligation(obligation)
    }

    override suspend fun deleteObligation(obligation: Obligation) {
        TODO("Not yet implemented")
    }
}