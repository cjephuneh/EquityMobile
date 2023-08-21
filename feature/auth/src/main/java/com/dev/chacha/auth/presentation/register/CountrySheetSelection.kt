package com.dev.chacha.auth.presentation.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dev.chacha.auth.presentation.AuthScreen
import com.dev.chacha.ui.R



@Composable
fun CountrySelectionListItem(
    countryIcon: String,
    country: Country,
    selectedCountry: Boolean = false,
    onCountrySelected: (Country) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = countryIcon,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape),
                textAlign = TextAlign.Center
            )

            Text(
                text = country.fullName,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = selectedCountry,
                onClick = { onCountrySelected(country) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 16.dp),
            thickness = 1.dp
        )

    }

}

@Composable
@Preview
fun CountrySheetSelection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(getCountriesList()) { country ->
                CountrySelectionListItem(
                    countryIcon = getFlagEmojiFor(country.nameCode),
                    country = country,
                    onCountrySelected = {

                    }
                )
            }
        }
    }

}
@Composable
fun CountrySelectionListItems(
    country: Country,
    selectedCountry: Boolean = false,
    onCountrySelected: (Country) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Transparent, CircleShape)
                    .clip(CircleShape)
            ){
                Image(
                    painter = painterResource(
                        id = when (country.nameCode) {
                            "cd" -> R.drawable.cd
                            "ke" -> R.drawable.ke
                            "rw" -> R.drawable.rw
                            "ss" -> R.drawable.ss
                            "tz" -> R.drawable.tz
                            "ug" -> R.drawable.ug
                            else -> R.drawable.paypal_icons // A placeholder image
                        }
                    ),
                    contentDescription = country.fullName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()

                )

            }

            Text(
                text = country.fullName,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = selectedCountry,
                onClick = { onCountrySelected(country) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 48.dp, end = 16.dp),
            thickness = 1.dp
        )
    }
}

@Composable
@Preview
fun CountrySelectionListItemsPreview() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(getCountriesList()){ country ->
            CountrySelectionListItems(
                country = country,
                onCountrySelected ={}
            )

        }
    }

}






