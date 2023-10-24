package com.dev.chacha.transaction.presentation.third_party.pay_pal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import com.dev.chacha.ui.R

@Composable
fun PayPalScreen(
    navController: NavController
) {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val email = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "PayPalScreen",
                showBackArrow = true,
                onNavigateBack = {navController.navigateUp()}
            )
        },
        bottomBar = {

            EquityButton(
                onClick = {
                    isSheetOpen = true
                    navController.navigate(PayPalNavigation.PayPalFirstScreenSheet.route)
                },
                text = stringResource(id = R.string.continue_hint),
                enable = true
            )

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Please enter your Paypal account details",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold
            )

            AppTextField(
                text = email.value,
                onValueChange = {
                    email.value = it
                },
                title = "Email"
            )
        }
    }

    if (isSheetOpen) {
        EquityModalSheet(
            onDismissRequest = {
                isSheetOpen = false
            },
        ) {
            PayPalFirstScreenSheet(navController = navController)
        }
    }

}