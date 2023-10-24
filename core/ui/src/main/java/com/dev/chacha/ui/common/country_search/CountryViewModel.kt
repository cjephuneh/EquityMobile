package com.dev.chacha.ui.common.country_search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CountryViewModel : ViewModel() {
    var mobileCountryCode by mutableStateOf("")

    val countriesList = getCountriesList()
    var mobileCountry by mutableStateOf<Country?>(null)
}