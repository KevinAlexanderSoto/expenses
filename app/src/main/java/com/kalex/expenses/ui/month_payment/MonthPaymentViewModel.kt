package com.kalex.expenses.ui.month_payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kalex.core.ViewModelState
import com.kalex.expenses.data.db.Obligation
import com.kalex.expenses.data.state.MonthPaymentState
import com.kalex.expenses.model.usecase.GetObligationUseCase
import com.kalex.expenses.model.usecase.SaveObligationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MonthPaymentViewModel(
    internal val getObligationUseCase: GetObligationUseCase,
    internal val saveObligationUseCase: SaveObligationUseCase,
    internal val coroutineContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    private val _obligationListState = MutableStateFlow<ViewModelState<List<Obligation>>>(ViewModelState.Loading(true))
    val obligationListState: StateFlow<ViewModelState<List<Obligation>>> = _obligationListState

    private val _obligationUpsertState = MutableStateFlow<ViewModelState<Boolean>>(ViewModelState.Loading(true))
    val obligationUpsertState: StateFlow<ViewModelState<Boolean>> = _obligationUpsertState

    internal fun getObligations() {
        viewModelScope.launch(coroutineContext) {

            getObligationUseCase()
                .catch { e ->
                    _obligationListState.value =
                        ViewModelState.Error(Exception("Error getting Obligations: ${e.message}"))
                }
                .collectLatest { list ->
                    _obligationListState.update { current -> ViewModelState.Success(list) }
                }

        }
    }

    internal fun saveObligation(obligation: Obligation) {
        viewModelScope.launch(coroutineContext) {
            saveObligationUseCase.invoke(obligation).onSuccess {
                _obligationUpsertState.value = ViewModelState.Success(true)
                getObligations()
            }.onFailure { e ->
                _obligationUpsertState.value =
                    ViewModelState.Error(Exception("Error saving Obligation: ${e.message}"))
            }
        }
    }
}