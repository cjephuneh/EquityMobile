package com.dev.chacha.auth.presentation.register

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.base.AppViewModel
import com.dev.chacha.ui.common.base.PathState
import com.dev.chacha.ui.common.components.AppTopBar
import com.dev.chacha.ui.common.components.EquityTextField


@Composable
fun CountrySelectionListItems(
    country: Country,
    selectedCountry: Boolean = false,
    onCountrySelected: (Country) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .clickable(MutableInteractionSource(),null){
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











