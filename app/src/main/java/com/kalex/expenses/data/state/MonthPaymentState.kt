package com.kalex.expenses.data.state


sealed class MonthPaymentState<T> {
    object Loading : MonthPaymentState<Nothing>()
    data class Success<T>(val data: T) : MonthPaymentState<T>()
    data class Error(val message: String) : MonthPaymentState<Nothing>()
}