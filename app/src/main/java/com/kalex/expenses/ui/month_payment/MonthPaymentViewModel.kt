package com.kalex.expenses.ui.month_payment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kalex.expenses.model.usecase.GetObligationUseCase
import com.kalex.expenses.model.usecase.SaveObligationUseCase

class MonthPaymentViewModel(
    internal val getObligationUseCase: GetObligationUseCase,
    internal val saveObligationUseCase: SaveObligationUseCase
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}