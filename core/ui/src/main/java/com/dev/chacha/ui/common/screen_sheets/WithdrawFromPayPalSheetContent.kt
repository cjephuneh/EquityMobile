package com.dev.chacha.ui.common.screen_sheets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityDivider
import com.dev.chacha.ui.common.components.StandardHorizontalItem
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import com.dev.chacha.ui.common.modal_sheet_layouts.StandardModalSheetLayout
import com.dev.chacha.ui.common.modal_sheet_layouts.TransactionBottomSheetType
import com.dev.chacha.ui.common.navigation.Graph.WITHDRAW_FROM_PAYPAL_ROUTE
import kotlinx.coroutines.launch



@Composable
fun WithdrawFromPayPalSheetContent(
    navController: NavController
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "PayPal",
                showBackArrow = true,
                onNavigateBack = {}
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {


            StandardHorizontalItem(
                drawable = R.drawable.coin_stack ,
                title = R.string.withdraw_from_paypal,
                onItemClick = {
                    navController.navigate(WITHDRAW_FROM_PAYPAL_ROUTE)
                },
                showLastLineDivider = true
            )

        }
    }
    if (isSheetOpen) {
        EquityModalSheet(
            onDismissRequest = {
                isSheetOpen = false
            },
        ) {
            currentBottomSheet?.let {
                StandardModalSheetLayout(
                    bottomSheetType = it,
                    onClose = {
                        coroutineScope.launch {
                            isSheetOpen = false
                        }
                    },
                    navController = navController
                )
            }
        }
    }

}
