package com.chachadeveloper.equitymobile.feature_auth.presentation.security_qsn_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardSecurityQn
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardTextField
import com.chachadeveloper.equitymobile.core.presentation.common.components.StandardToolbar
import com.chachadeveloper.equitymobile.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.get

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination
fun SecurityQnScreen(
    navigator: DestinationsNavigator,
    viewModel: SecurityQnViewModel = get()

) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Declaring a boolean value to store
        // the expanded state of the Text Field
        var mExpanded by remember { mutableStateOf(false) }

        // Create a list of cities
        val mCities = listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

        // Create a string value to store the selected city
        var mSelectedText by remember { mutableStateOf("") }

//        var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

        // Up Icon when expanded and down icon when collapsed
        val icon = if (mExpanded)
            Icons.Filled.KeyboardArrowUp
        else
            Icons.Filled.KeyboardArrowDown

        StandardToolbar(
            navigator = navigator,
            title = "Security questions",
            showBackArrow = true,
        )

        Spacer(modifier = Modifier.height(2.dp))

        Column {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp, end = 20.dp)
                ){
                    LazyColumn(){
                        item {
                            Text(
                                text = "Create security_screen questions"
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(
                                text = "Make the answers easy to remember"
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            Text(text = "Question")
                            Spacer(modifier = Modifier.height(1.dp))
                            StandardSecurityQn(
                                text = mSelectedText,
                                onValueChange = { mSelectedText = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                        // This value is used to assign to
                                        // the DropDown the same width
//                                        mTextFieldSize = coordinates.size.toSize()
                                    },
                            )
                            Spacer(modifier = Modifier.height(0.dp))
                            StandardTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = stringResource(id = R.string.password_hint),
                                keyboardType = KeyboardType.Password,
                                error = viewModel.passwordError.value,
                                isPasswordVisible = viewModel.showPassword.value,
                                onPasswordToggleClick = {
                                    viewModel.setShowPassword(it)
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = "Question")
                            Spacer(modifier = Modifier.height(1.dp))
                            StandardSecurityQn(
                                text = mSelectedText,
                                onValueChange = { mSelectedText = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                        // This value is used to assign to
                                        // the DropDown the same width
//                                        mTextFieldSize = coordinates.size.toSize()
                                    },
                            )
                            Spacer(modifier = Modifier.height(0.dp))
                            StandardTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = stringResource(id = R.string.password_hint),
                                keyboardType = KeyboardType.Password,
                                error = viewModel.passwordError.value,
                                isPasswordVisible = viewModel.showPassword.value,
                                onPasswordToggleClick = {
                                    viewModel.setShowPassword(it)
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = "Question")
                            Spacer(modifier = Modifier.height(1.dp))
                            StandardSecurityQn(
                                text = mSelectedText,
                                onValueChange = { mSelectedText = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                        // This value is used to assign to
                                        // the DropDown the same width
//                                        mTextFieldSize = coordinates.size.toSize()
                                    },
                            )
                            Spacer(modifier = Modifier.height(0.dp))
                            StandardTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = stringResource(id = R.string.password_hint),
                                keyboardType = KeyboardType.Password,
                                error = viewModel.passwordError.value,
                                isPasswordVisible = viewModel.showPassword.value,
                                onPasswordToggleClick = {
                                    viewModel.setShowPassword(it)
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))


                            Text(text = "Question")
                            Spacer(modifier = Modifier.height(1.dp))
                            StandardSecurityQn(
                                text = mSelectedText,
                                onValueChange = { mSelectedText = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                        // This value is used to assign to
                                        // the DropDown the same width
//                                        mTextFieldSize = coordinates.size.toSize()
                                    },
                            )
                            Spacer(modifier = Modifier.height(0.dp))
                            StandardTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = stringResource(id = R.string.password_hint),
                                keyboardType = KeyboardType.Password,
                                error = viewModel.passwordError.value,
                                isPasswordVisible = viewModel.showPassword.value,
                                onPasswordToggleClick = {
                                    viewModel.setShowPassword(it)
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(text = "Question")
                            Spacer(modifier = Modifier.height(0.dp))
                            StandardSecurityQn(
                                text = mSelectedText,
                                onValueChange = { mSelectedText = it },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .onGloballyPositioned { coordinates ->
                                        // This value is used to assign to
                                        // the DropDown the same width
//                                        mTextFieldSize = coordinates.size.toSize()
                                    },
                            )
                            Spacer(modifier = Modifier.height(0.dp))
                            StandardTextField(
                                text = viewModel.passwordText.value,
                                onValueChange = {
                                    viewModel.setPasswordText(it)
                                },
                                hint = stringResource(id = R.string.password_hint),
                                keyboardType = KeyboardType.Password,
                                error = viewModel.passwordError.value,
                                isPasswordVisible = viewModel.showPassword.value,
                                onPasswordToggleClick = {
                                    viewModel.setShowPassword(it)
                                }
                            )
                            Spacer(modifier = Modifier.height(20.dp))

                            Button(
                                onClick = {
                                    navigator.navigate(HomeScreenDestination)
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.Red,
                                    containerColor = Color.DarkGray
                                ),

                                ) {
                                Text(
                                    text = "Confirm",
                                    color = Color.Black,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }

                }
            }

        }

    }


}

