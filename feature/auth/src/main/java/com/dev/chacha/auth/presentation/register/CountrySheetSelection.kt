package com.dev.chacha.auth.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.common.theme.HintGray


@Composable
fun CountrySelectionListItems(
    country: Country,
    selectedCountry: Boolean = false,
    onCountrySelected: (Country) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(MutableInteractionSource(), null) {
                onCountrySelected(country)
            },
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
                    .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape),
                contentAlignment = Alignment.TopCenter
            ){
                Text(
                    text = getFlagEmojiFor(country.nameCode),
                    fontSize = 48.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxHeight().clipToBounds()

                )
            }



            Text(
                text = country.fullName,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(end = 8.dp),
                overflow = TextOverflow.Clip
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
                .padding(start = 56.dp, end = 16.dp),
            thickness = 1.dp
        )
    }
}











