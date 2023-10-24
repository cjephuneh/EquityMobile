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
import kotlinx.coroutines.launch

@Composable
fun AddAccountsBottomSheet(
    navController: NavController
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Add",
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
            Text(
                text = "Add an account, card or mobile wallet",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Add an account,card or mobile wallet",
                style = MaterialTheme.typography.titleSmall
            )

            StandardHorizontalItem(
                drawable = R.drawable.coin_stack ,
                title = R.string.add_an_equity_account,
                subtitle  = R.string.add_an_equity_account_des,
                onItemClick = {},
                showLastLineDivider = true
            )

            StandardHorizontalItem(
                drawable = R.drawable.paypal_large_icon,
                title = R.string.add_your_paypal_account,
                subtitle  = R.string.add_your_paypal_account_desc,
                onItemClick = {},
                showLastLineDivider = true,
                showDrawableColorFilter = true
            )

          /*  LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                items(addAccountOptions.size) { index ->
                    StandardHorizontalItem(
                        drawable = addAccountOptions[index].drawable,
                        title = addAccountOptions[index].title,
                        subtitle = addAccountOptions[index].subtitle,
                        onItemClick = { sendMoneyOption ->
                            when (sendMoneyOption) {
                                R.string.mobile_wallet -> {}
                                R.string.another_bank -> {}
                            }
                        }
                    )
                    if (index < addAccountOptions.size - 1) {
                        EquityDivider(
                            modifier = Modifier.padding(start = 65.dp, end = 8.dp, top = 5.dp, bottom = 5.dp)
                        )
                    }
                }
            }*/

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

data class AddAccount(
    @StringRes val title: Int,
    @StringRes val subtitle: Int? = null,
    @DrawableRes val drawable: Int
)

private val addAccountOptions = listOf(
    AddAccount(
        drawable = R.drawable.coin_stack ,
        title = R.string.add_an_equity_account,
        subtitle  = R.string.add_an_equity_account_des,
    ),
    AddAccount(
        drawable = R.drawable.paypal_large_icon,
        title = R.string.add_your_paypal_account,
        subtitle  = R.string.add_your_paypal_account_desc,
    )
)