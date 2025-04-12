package com.kalex.expenses.di

import com.kalex.expenses.model.repository.ObligationRepository
import com.kalex.expenses.model.repository.ObligationRepositoryImpl
import com.kalex.expenses.model.usecase.GetObligationUseCase
import com.kalex.expenses.model.usecase.SaveObligationUseCase
import com.kalex.expenses.ui.month_payment.MonthPaymentViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/

val coreModule = module {
    single<ObligationRepository>{ObligationRepositoryImpl(get())}

    factory { GetObligationUseCase(get()) }
    factory { SaveObligationUseCase(get()) }
    factory<CoroutineContext> { Dispatchers.IO }

    viewModel { MonthPaymentViewModel(get(),get(), get()) }
}