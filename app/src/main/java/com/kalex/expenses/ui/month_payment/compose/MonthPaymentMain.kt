package com.kalex.expenses.ui.month_payment.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kalex.expenses.data.db.Obligation
import com.kalex.expenses.data.state.MonthPaymentState
import com.kalex.expenses.ui.month_payment.MonthPaymentViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * @author kevin Alexander Soto on 3/15/2025
 * **/

@Composable
fun MonthPaymentMain(
    viewModel: MonthPaymentViewModel = koinViewModel(),
) {

    when (val monthPaymentState = viewModel.monthPaymentState.collectAsStateWithLifecycle().value) {
        is MonthPaymentState.Loading -> {
            Text(text = "Loading")
        }

        is MonthPaymentState.Success -> {
            ObligationList(monthPaymentState.obligations)
        }

        is MonthPaymentState.Error -> {
            Text(text = monthPaymentState.message)
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