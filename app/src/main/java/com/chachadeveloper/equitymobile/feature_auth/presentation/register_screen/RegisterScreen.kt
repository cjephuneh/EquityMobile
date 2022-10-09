package com.chachadeveloper.equitymobile.feature_auth.presentation.register_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryGray
import com.chachadeveloper.equitymobile.core.presentation.common.theme.primaryPink
import com.chachadeveloper.equitymobile.core.presentation.common.components.BottomSheetToolbar
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardTextField
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardToolbar
import com.chachadeveloper.equitymobile.destinations.CreatePasswordScreenDestination
import com.chachadeveloper.equitymobile.destinations.SecurityScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get

@OptIn( ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
@Destination
fun RegisterScreen(
    navigator: DestinationsNavigator,
    viewModel: RegisterViewModel = get()
) {
    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed)
    
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState)

    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                .fillMaxWidth()
                .height(650.dp),
                contentAlignment = Alignment.TopStart
            ){
                Column(
                    modifier = Modifier
                    .fillMaxSize()
                ) {
                    BottomSheetToolbar(
                        navigator = navigator,
                        modifier = Modifier.fillMaxSize(),
                        showBackArrow = true,
                        title = {
                            Text(
                                text = "Country",
                                modifier = Modifier.fillMaxWidth(),
                            )
                        }
                    )
                    Column(
                        modifier = Modifier.fillMaxSize()
                        .padding(start = 30.dp, end =30.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navigator.navigate(SecurityScreenDestination)
                                }
                        ) {
                            Image(
                                painter =
                                painterResource(id = R.drawable.ic_security_foreground) ,
                                contentDescription =  null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                                    .background(Color.DarkGray),
                                colorFilter = ColorFilter.tint(color = primaryPink)
                            )
                            Column(
                                modifier = Modifier
                                    .padding(start = 10.dp)
                            ){
                                Text(
                                    text = "Kenya",
                                    maxLines = 1,
                                    color = Color.White
                                )
                            }
                            Column {
                                Box(
                                    modifier = Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.CenterEnd
                                ){
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,
                                        )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        Divider(
                            color = primaryGray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(
                                    start = 8.dp,
                                    end = 8.dp
                                )
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navigator.navigate(SecurityScreenDestination)
                                }
                        ) {

                            Image(
                                painter =
                                painterResource(id = R.drawable.ic_security_foreground) ,
                                contentDescription =  null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(CircleShape)
                                    .background(Color.DarkGray),
                                colorFilter = ColorFilter.tint(color = primaryPink)

                            )
                            Column(modifier = Modifier.padding(start = 10.dp)){
                                Text(
                                    text = "Tanzania",
                                    maxLines = 1,
                                )

                            }
                            Column {
                                Box(modifier =
                                Modifier.fillMaxWidth(),
                                    contentAlignment = Alignment.CenterEnd
                                ){
                                    Icon(
                                        painter =
                                        painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,
                                        )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Divider(
                            color = primaryGray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(
                                    start = 70.dp,
                                    end = 8.dp
                                )
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }

        },
        sheetPeekHeight = 0.dp,
        sheetBackgroundColor = Color.DarkGray
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            StandardToolbar(
                navigator = navigator,
                title = "Register",
                showForwardArrow = true,
                showBackArrow = true
            )
            Spacer(modifier = Modifier.height(16.dp))
            val rememberMeState = viewModel.rememberMeState.value
            Column {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Text(text = "Create your profile",
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = stringResource(id = R.string.signin),
                            maxLines = 2,
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        Text(text = "Country",
                                modifier = Modifier
                                    .clickable {
                                    scope.launch {
                                        if (sheetState.isCollapsed) {
                                            sheetState.expand()
                                        } else {
                                            sheetState.collapse()
                                        }
                                    }

                                }
                                    .padding(start = 20.dp, end = 20.dp)


                            )
/*
                val focusManager = LocalFocusManager.current

                AppTextField(
                    text = viewModel.mobileNumber,
                    placeholder = "Country",
                    onChange = {
                        viewModel.mobileNumber = it
                    },
                    imeAction = ImeAction.Next,//Show next as IME button
                    keyboardType = KeyboardType.Phone, //Plain text keyboard
                    keyBoardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    leadingIcon = {
                        viewModel.mobileCountry?.let {
                            CountryPickerView(
                                countries = viewModel.countriesList,
                                selectedCountry = it,
                                onSelection = { selectedCountry ->
                                    viewModel.mobileCountry = selectedCountry
                                },
                            )
                        }
                    }

                )*/

                            StandardTextField(
                                text = viewModel.usernameText.value,
                                onValueChange = {
                                    viewModel.setUsernameText(it)
                                },
                                keyboardType = KeyboardType.Text,
                                error = viewModel.usernameError.value,
                                hint = stringResource(id = R.string.country),
                                modifier = Modifier.clickable {
                                    scope.launch {
                                        if (sheetState.isCollapsed) {
                                            sheetState.expand()
                                        } else {
                                            sheetState.collapse()
                                        }
                                    }

                                }

                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Account Number",
                                modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                            )
                            StandardTextField(
                                text = viewModel.usernameText.value,
                                onValueChange = {
                                    viewModel.setUsernameText(it)
                                },
                                keyboardType = KeyboardType.Number,
                                error = viewModel.usernameError.value,
                                hint = stringResource(id = R.string.account_hint),
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "ID number",
                                modifier = Modifier.padding(start = 20.dp, end = 20.dp)

                            )
                            StandardTextField(
                                text = viewModel.usernameText.value,
                                onValueChange = {
                                    viewModel.setUsernameText(it)
                                },
                                keyboardType = KeyboardType.Number,
                                error = viewModel.usernameError.value,
                                hint = stringResource(id = R.string.idnumber_hint),
                            )

                            Spacer(modifier = Modifier.height(15.dp))

                            Row(
                                Modifier.fillMaxWidth().padding(start = 5.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = rememberMeState,
                                        onCheckedChange = {
                                            viewModel.setRememberMe(it)
                                        },
                                    )
                                    Text(
                                        text = "I agree to the terms and privacy policy",
                                        fontSize = 12.sp,
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 20.dp, end = 20.dp),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Button(
                                    onClick = {
                                        navigator.navigate(CreatePasswordScreenDestination)
                                    },
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.Red,
                                        containerColor = Color.DarkGray
                                    )
                                ) {
                                    Text(
                                        text = "Create profile + add accounts",
                                        modifier = Modifier.padding(10.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.height(30.dp))

                            }



                    }
                }
            }


        }
    }


}


