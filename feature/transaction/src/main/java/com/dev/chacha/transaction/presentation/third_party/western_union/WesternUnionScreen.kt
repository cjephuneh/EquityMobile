package com.dev.chacha.transaction.presentation.third_party.western_union

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.MaterialTheme
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
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import kotlinx.coroutines.launch

@Composable
fun WesternUnionScreen(
    navController: NavController
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxHeight(.85f)
    ) {
        StandardToolbar(
            title = "Western Union ",
            showBackArrow = false,
            navigationCloseIcons = Icons.Outlined.Close,
            onNavigateBack = {
                coroutineScope.launch {
                    isSheetOpen = false
                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Text(
                text = "What would you like to do?",
                style = MaterialTheme.typography.titleLarge
            )

            MoreVerticalItem(
                title = R.string.send_money,
                subtitle = R.string.western_union_send_money_subtitle,
                drawable = R.drawable.sync_alt,
                onClick = {
                    isSheetOpen = true
                }
            )

            MoreVerticalItem(
                title = R.string.receive_money,
                subtitle = R.string.western_union_receive_money_subtitle,

                drawable = R.drawable.pay_loan,
                onClick = {
                    isSheetOpen = true
                }
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
                EquityModalSheetLayout(
                    bottomSheetType = it,
                    onClose = {}
                )
            }
        }
    }

}