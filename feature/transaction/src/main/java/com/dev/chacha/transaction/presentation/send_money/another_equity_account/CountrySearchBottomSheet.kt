package com.dev.chacha.transaction.presentation.send_money.another_equity_account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTopBar
import com.dev.chacha.ui.common.country_search.Country
import com.dev.chacha.ui.common.country_search.CountrySelectionListItems
import com.dev.chacha.ui.common.country_search.CountryViewModel
import kotlinx.coroutines.launch

@Composable
fun CountrySearchBottomSheet(
    onClose:()->Unit
) {
    val equityAccountViewModel: EquityAccountViewModel = viewModel()
    val selectedCountry = equityAccountViewModel.mobileCountry
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxWidth()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            ) {
            AppTopBar(
                title = "Country",
                initialValue = "",
                onSearchParamChange = {},
                showSearchBar = true,
                searchHint = stringResource(id = R.string.search_for_country),
                showTopBar = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(equityAccountViewModel.countriesList) { country ->
                    CountrySelectionListItems(
                        country = country,
                        selectedCountry = selectedCountry == country,
                        onCountrySelected = {
                            equityAccountViewModel.onEquityAccountEvent(EquityAccountUiEvent.OnCountryCodeSelected(it.code))
                            equityAccountViewModel.onEquityAccountEvent(EquityAccountUiEvent.OnCountryFullNameSelected(it.fullName))
                            equityAccountViewModel.onEquityAccountEvent(EquityAccountUiEvent.OnCountrySelected(it))
                            coroutineScope.launch {
                                onClose()
                            }

                        }
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }

    }
}