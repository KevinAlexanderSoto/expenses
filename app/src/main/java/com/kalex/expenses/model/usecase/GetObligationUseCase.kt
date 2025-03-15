package com.kalex.expenses.model.usecase

import com.kalex.expenses.data.db.Obligation
import com.kalex.expenses.model.repository.ObligationRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/
class GetObligationUseCase(private val repository: ObligationRepository) {

    suspend operator fun invoke(): Flow<List<Obligation>> = repository.getObligations()
}