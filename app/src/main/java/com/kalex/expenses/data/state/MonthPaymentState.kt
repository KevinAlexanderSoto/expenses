package com.kalex.expenses.data.state

import com.kalex.expenses.data.db.Obligation

sealed class MonthPaymentState {
    object Loading : MonthPaymentState()
    data class Success(val obligations: List<Obligation>) : MonthPaymentState()
    data class Error(val message: String) : MonthPaymentState()
}