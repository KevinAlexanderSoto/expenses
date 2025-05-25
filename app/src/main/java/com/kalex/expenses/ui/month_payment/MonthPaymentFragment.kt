package com.kalex.expenses.ui.month_payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.kalex.expenses.databinding.FragmentMonthPaymentBinding
import com.kalex.expenses.ui.month_payment.compose.MonthPaymentMain

class MonthPaymentFragment : Fragment() {

    private var _binding: FragmentMonthPaymentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMonthPaymentBinding.inflate(inflater, container, false)
        val view = binding.root
        // ... rest of the setup ...
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.mainMonthPayment.apply { // Assuming 'main_month_payment' is the ID of your ComposeView in XML
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                // Your Scaffold and MonthPaymentMain Composable
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            modifier = Modifier.padding(2.dp, 2.dp),
                            onClick = {  },
                        ) {
                            Icon(Icons.Default.Add, contentDescription = "add")
                        }
                    },
                ) { paddingValues ->
                    MonthPaymentMain(paddingValues)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}