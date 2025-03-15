package com.kalex.expenses.di

import com.kalex.expenses.model.repository.ObligationRepository
import com.kalex.expenses.model.repository.ObligationRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/

val coreModule = module {
    single<ObligationRepository>{ObligationRepositoryImpl()}
}