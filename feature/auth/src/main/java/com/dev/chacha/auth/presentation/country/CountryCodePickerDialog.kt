package com.dev.chacha.auth.presentation.country

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.dev.chacha.auth.presentation.register.Country
import com.dev.chacha.auth.presentation.register.getFlagEmojiFor
import com.dev.chacha.ui.common.country_search.getCountriesList
@Preview
@Composable
fun CountryCodePickerDialog(
    countries: List<Country> = com.dev.chacha.auth.presentation.register.getCountriesList(),
    onSelection: (Country) -> Unit ={},
    dismiss: () -> Unit = {},
) {
    Dialog(onDismissRequest = dismiss) {
        Box {
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
                    .background(shape = RoundedCornerShape(20.dp), color = Color.White)
            ) {
                for (country in countries) {
                    item {
                        Text(
                            modifier = Modifier
                                .clickable {
                                    onSelection(country)
                                    dismiss()
                                }
                                .fillMaxWidth()
                                .padding(10.dp),
                            text = "${getFlagEmojiFor(country.nameCode)}",
                            fontSize = 50.sp
                        )
                    }
                }
            }
        }
    }
}

