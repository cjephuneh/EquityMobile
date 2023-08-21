package com.dev.chacha.auth.presentation.register

import android.content.res.Configuration
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.auth.presentation.AuthScreen
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.AppTextField
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.StandardTextField
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun SignUpScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    onClick: () -> Unit,
    onLoginClick: () -> Unit,
    navController: NavController
) {
    // Other content...
    var isCountrySelectionSheetOpen by remember { mutableStateOf(false) }
    var selectedCountry by remember { mutableStateOf<Country?>(null) }

    // This state will track whether the arrow icon should be rotated
    var isArrowRotated by remember { mutableStateOf(false) }

    AppTextField(
        text = registerViewModel.usernameText.value,
        onValueChange = {
            registerViewModel.setUsernameText(it)
        },
        keyboardType = KeyboardType.Text,
        error = registerViewModel.usernameError.value,
        hint = stringResource(id = R.string.country),
        modifier = Modifier.clickable {
            isCountrySelectionSheetOpen = true
            isArrowRotated = !isArrowRotated // Toggle the rotation
        },
        title = stringResource(id = R.string.select_country),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Arrow Drop Down",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
                    .rotate(if (isArrowRotated) 180f else 0f) // Rotate the icon if needed
                    .clickable {
                        isCountrySelectionSheetOpen = !isCountrySelectionSheetOpen
                        isArrowRotated = !isArrowRotated // Toggle the rotation
                    }
            )
        }
    )

    if (isCountrySelectionSheetOpen) {
        CountrySelectionBottomSheet(
            countries = registerViewModel.countriesList,
            onCountrySelected = {
                selectedCountry = it
                isCountrySelectionSheetOpen = false
                isArrowRotated = false // Reset the rotation state
            },
            currentCountry = selectedCountry
        )
    }

}
