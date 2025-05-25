package com.kalex.expenses.ui.month_payment.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kalex.core.ViewModelState
import com.kalex.expenses.data.db.Obligation
import com.kalex.expenses.data.state.MonthPaymentState
import com.kalex.expenses.ui.month_payment.MonthPaymentViewModel
import org.koin.androidx.compose.koinViewModel


/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/

@Composable
fun MonthPaymentMain(
    padding:  PaddingValues,
    viewModel: MonthPaymentViewModel = koinViewModel(),
) {

        Column(modifier = Modifier.padding(padding)) {

            when (val monthPaymentState = viewModel.obligationListState.collectAsStateWithLifecycle().value) {
                is ViewModelState.Empty<*> -> TODO()
                is ViewModelState.Error<*> ->  Text(text = monthPaymentState.exception.message.toString())
                is ViewModelState.Loading<*> ->  Text(text = "Loading")
                is ViewModelState.Success<List<Obligation>> -> ObligationList(monthPaymentState.data)
            }
        }

}

@Composable
fun ObligationList(obligations: List<Obligation>) {
    LazyColumn {
        items(obligations) { obligation ->
            ObligationItem(obligation)
        }
    }
}

@Composable
fun ObligationItem(obligation: Obligation) {
    Text(text = obligation.name) // Display obligation information as needed.
}