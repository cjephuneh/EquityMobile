package com.dev.chacha.ui.common.base

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheets(
    appViewModel: AppViewModel = hiltViewModel(),
) {
    val coroutineScope = rememberCoroutineScope()

   /* BottomSheetWrapper(
        name = CURRENCY_EDITOR,
    ) { state ->
        PayBillSelection(
            onClose = {
                coroutineScope.launch {
                    state.hide()
                }
            },
            onPayBillSelected = {
                coroutineScope.launch {
                    state.hide()
                }
            },
            payBillViewModel = PayBillViewModel(),
            navController = rememberNavController()

        )
    }*/



    BottomSheetWrapper(
        name = FINISH_DATE_SELECTOR_SHEET,
    ) { state ->
        FinishDateSelector(
            selectDate = state.args["initialDate"] as Date?,
            onBackPressed = {
                coroutineScope.launch {
                    state.hide()
                }
            },
            onApply = {
                coroutineScope.launch {
                    state.hide(mapOf("finishDate" to it))
                }
            },
        )
    }

    BottomSheetWrapper(name = ACCOUNT_BALANCE) {

    }
    BottomSheetWrapper(name = SEND_MONEY_TO_BANK) {


    }

}

@Composable
fun CurrencyEditor( onClose: () -> Unit) {
    Column {
        Text(text = "Strings")

    }

}

const val ACCOUNT_BALANCE = "account_balance"
const val SEND_MONEY_TO_BANK = "send_money_to_bank"
const val WALLET_SHEET = "wallet_sheet"
const val DEFAULT_RECALC_BUDGET_CHOOSER = "default_recalc_budget_chooser"
const val CURRENCY_EDITOR = "currency_editor"
const val FINISH_DATE_SELECTOR_SHEET = "finish_date_selector_sheet"
const val SETTINGS_SHEET = "settings_sheet"
const val RECALCULATE_DAILY_BUDGET_SHEET = "recalculate_daily_budget_sheet"
const val FINISH_PERIOD_SHEET = "finish_period_sheet"
const val ON_BOARDING_SHEET = "on_boarding_sheet"
const val NEW_DAY_BUDGET_DESCRIPTION_SHEET = "new_day_budget_description_sheet"
const val BUDGET_IS_OVER_DESCRIPTION_SHEET = "budget_is_over_description_sheet"
const val DEBUG_MENU_SHEET = "debug_menu_sheet"
const val BUG_REPORTER_SHEET = "bug_reporter_sheet"
const val SETTINGS_CHANGE_THEME_SHEET = "settings_change_theme_sheet"
const val SETTINGS_CHANGE_LOCALE_SHEET = "settings_change_locale_sheet"
