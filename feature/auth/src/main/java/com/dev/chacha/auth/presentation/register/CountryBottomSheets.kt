package com.dev.chacha.auth.presentation.register

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.chacha.auth.presentation.code_verification.PermissionBottomSheet
import com.dev.chacha.auth.presentation.code_verification.SMS_BOTTOMSHEET
import com.dev.chacha.ui.common.base.AppViewModel
import com.dev.chacha.ui.common.base.BottomSheetWrapper
import kotlinx.coroutines.launch
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CountriesBottomSheets(
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
        name = SMS_BOTTOMSHEET,
    ) { state ->
        PermissionBottomSheet(
            onPermissionGranted = {},
            onPermissionDenied = {}
        )

    }



    BottomSheetWrapper(
        name = COUNTRY_BOTTOMSHEET,
    ) { state ->
        Box(modifier = Modifier.fillMaxWidth()){
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ){
                items(getCountriesList()){ country ->
                    CountrySelectionListItems(
                        country = country,
                        onCountrySelected ={}
                    )

                }
            }
        }

    }

}

@Composable
fun CurrencyEditor( onClose: () -> Unit) {
    Column {
        Text(text = "Strings")

    }

}

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
