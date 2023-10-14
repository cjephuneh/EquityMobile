package com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_second_sheet

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContactPhone
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dev.chacha.transaction.presentation.modalsheet_layout.EquityModalSheetLayout
import com.dev.chacha.transaction.presentation.modalsheet_layout.TransactionBottomSheetType
import com.dev.chacha.transaction.presentation.send_money.mobile_money.MobileMoneyUiEvent
import com.dev.chacha.transaction.presentation.send_money.mobile_money.MobileMoneyViewModel
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet.ContactListViewModel
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet.ContactUiEvent
import com.dev.chacha.ui.common.components.AmountCurrencyTextField
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.modal_sheet.EquityModalSheet
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
@Preview
fun MobileMoneySecondBottomSheetScreen() {
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var currentBottomSheet: TransactionBottomSheetType? by remember { mutableStateOf(null) }
    val contactViewModel: ContactListViewModel = viewModel()
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val permissionState = rememberPermissionState(Manifest.permission.READ_CONTACTS)
    val mobileMoneyViewModel: MobileMoneyViewModel = viewModel()
    val mobileState by mobileMoneyViewModel.uiState.collectAsStateWithLifecycle()



    LaunchedEffect(permissionState) {
        if (permissionState.status.isGranted) {
            contactViewModel.send(ContactUiEvent.GetContacts, context)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            title = "Send to someone new ",
            showBackArrow = true,
            onNavigateBack = {
                coroutineScope.launch {
                    isSheetOpen = false
                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "Please enter the recipient's detail",
                style = MaterialTheme.typography.titleLarge
            )

           Text(text = "Mobile Number")
           AmountCurrencyTextField(
               leftTextFieldTitleHint = "",
               rightTextFieldPlaceholderHint = "Mobile Number",
               leftTextFieldPlaceholderHint = "254",
               leftTextFieldValue = mobileState.currency,
               rightTextFieldValue = mobileState.mobileNumber,
               onLeftValueChange = {
                     mobileMoneyViewModel.onMobileMoneyEvent(MobileMoneyUiEvent.OnCurrencyChanged(it))
               },
               onRightValueChange = {
                   mobileMoneyViewModel.onMobileMoneyEvent(MobileMoneyUiEvent.OnMobileNumberChanged(it))
               },
               rightTextFieldTrailingIcon = Icons.Default.ContactPhone,
               onClick = {
                   if (permissionState.status.isGranted) {
                       isSheetOpen = true
                       currentBottomSheet = TransactionBottomSheetType.MOBILE_MONEY_CONTACTS
                   } else {
                       permissionState.launchPermissionRequest()
                   }
               }

           )

        }
    }

    if (isSheetOpen) {
        EquityModalSheet(
            onDismissRequest = {
                isSheetOpen = false
            },
        ) {
            currentBottomSheet?.let {
                EquityModalSheetLayout(
                    bottomSheetType = it,
                    onClose = {
                        coroutineScope.launch {
                            isSheetOpen = false
                        }
                    }
                )
            }
        }
    }

}