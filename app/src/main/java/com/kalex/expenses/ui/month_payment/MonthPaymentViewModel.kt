package com.kalex.expenses.ui.month_payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kalex.expenses.data.state.MonthPaymentState
import com.kalex.expenses.model.usecase.GetObligationUseCase
import com.kalex.expenses.model.usecase.SaveObligationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MonthPaymentViewModel(
    internal val getObligationUseCase: GetObligationUseCase,
    internal val saveObligationUseCase: SaveObligationUseCase,
    internal val coroutineContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    private val _monthPaymentState = MutableStateFlow<MonthPaymentState>(MonthPaymentState.Loading)
    val monthPaymentState: StateFlow<MonthPaymentState> = _monthPaymentState

    init {
        getObligations()
    }

    private fun getObligations() {
        viewModelScope.launch(coroutineContext) {

            getObligationUseCase()
                .catch { e ->
                    _monthPaymentState.value =
                        MonthPaymentState.Error("Error getting Obligations: ${e.message}")
                }
                .collectLatest { list ->
                    _monthPaymentState.value = MonthPaymentState.Success(list)
                }

        }
    }
}