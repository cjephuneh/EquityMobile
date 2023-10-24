package com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet


import android.Manifest
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.dev.chacha.ui.common.components.AppTopBar
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet.component.ContactItem
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun ContactSelectionScreen(
    contactViewModel: ContactListViewModel = viewModel(),
    navController: NavController,
    onContactSelected: (Contact) -> Unit,
    onClose:()->Unit ={}
) {
    val context = LocalContext.current
    val contactState by contactViewModel.state.collectAsStateWithLifecycle()
    val lazyState = rememberLazyListState()

    val coroutineScope = rememberCoroutineScope()

    // Check for permission to read contacts
    val permissionState = rememberPermissionState(Manifest.permission.READ_CONTACTS)

    LaunchedEffect(permissionState) {
        if (permissionState.status.isGranted) {
            contactViewModel.send(ContactUiEvent.GetContacts, context)
        } else{
            permissionState.launchPermissionRequest()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        AppTopBar(
            title = "Select contact",
            initialValue = contactState.searchParams,
            onSearchParamChange = { searchParams ->
                contactViewModel.send(ContactUiEvent.SearchContact(searchParams), context)
            },
            showSearchBar = true,
            showTopBar = true,
            navigationIcon = Icons.Outlined.Close,
            onNavigateBack = {
                coroutineScope.launch {
                    onClose()
                }
            }

        )

        Column(
            modifier = Modifier
                .safeGesturesPadding()
                .fillMaxWidth()

        ) {
            if (contactState.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            } else if (contactState.contact.isNotEmpty()) {
                Text(text = contactState.contact.size.toString())
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        state = lazyState,
                    ) {
                        val contacts = contactState.contact
                        items(contacts) { contact ->
                            ContactItem(contact = contact) {
                                val updatedPhoneNumber = contact.phoneNumber
                                if (updatedPhoneNumber.length > 10 && updatedPhoneNumber.startsWith("+")) {
                                    val formattedPhoneNumber = "0${updatedPhoneNumber.substring(4)}"
                                    val updatedContacts = contact.copy(phoneNumber = formattedPhoneNumber)
                                    onContactSelected(updatedContacts)

                                    if (formattedPhoneNumber.length<10){
                                        val secondUpdate = "0${formattedPhoneNumber}"
                                        val secondUpdatedContacts = contact.copy(phoneNumber = secondUpdate)
                                        onContactSelected(secondUpdatedContacts)
                                        coroutineScope.launch {
                                            onClose()
                                        }
                                    }
                                } else {
                                    onContactSelected(contact)
                                    coroutineScope.launch {
                                        onClose()
                                    }
                                }
                                // Refresh the contact list
                                contactViewModel.send(ContactUiEvent.GetContacts, context)
                                navController.previousBackStackEntry?.savedStateHandle?.set("selectedContact", contact)
                            }
                        }
                    }
                }

            } else if (contactState.error.isNotEmpty()) {
                Text(
                    text = contactState.error,
                    modifier = Modifier.clickable(MutableInteractionSource(),null){
                        contactViewModel.send(ContactUiEvent.GetContacts, context)
                    }

                )
            } else {
//            NoMatchFound(lottie = R.raw.no_match_found_lottie)
                Text(text = "No Match found")
            }

        }
    }


}

