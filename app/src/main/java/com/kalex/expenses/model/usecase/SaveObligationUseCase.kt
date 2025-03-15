package com.kalex.expenses.model.usecase

import com.kalex.expenses.model.repository.ObligationRepository

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/
class SaveObligationUseCase(private val repository: ObligationRepository) {

    suspend operator fun invoke() = repository.saveObligation()

}