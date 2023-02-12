package com.dev.chacha.loans.presentation.pay_loan_screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.loans.presentation.borrow_screen.BorrowScreen
import com.dev.chacha.ui.common.components.StandardSecurityQn
import com.dev.chacha.ui.common.components.StandardTextField
import com.dev.chacha.ui.common.components.StandardToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayLoanScreen(
    onPayLoan: () -> Unit
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Pay Loan",

                )
        }
    ) { paddingValues ->

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(start = 20.dp, end = 20.dp)

        ) {
                var mExpanded by remember { mutableStateOf(false) }

                // Create a list of cities
                val mCities =
                    listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

                // Create a string value to store the selected city
                var mSelectedText by remember { mutableStateOf("") }

//            var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

                // Up Icon when expanded and down icon when collapsed
                val icon = if (mExpanded)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown


                /* Toobar*/

                Text(text = "Please enter the loan payment detail")

                Text(text = "From")
                Text(text = "Account No")
                StandardTextField(
                    text = mSelectedText,
                    onValueChange = { mSelectedText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to
                            // the DropDown the same width
//                        mTextFieldSize = coordinates.size.toSize()
                        },
                    hint = "Account No",
                )

                Text(text = "To")
                Text(text = "Select loan to pay")
                StandardSecurityQn(
                    text = mSelectedText,
                    onValueChange = { mSelectedText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to
                            // the DropDown the same width
//                        mTextFieldSize = coordinates.size.toSize()
                        },
                )

                Text(text = "Amount")
                Text(text = "Select amount")
                StandardSecurityQn(
                    text = mSelectedText,
                    onValueChange = { mSelectedText = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to
                            // the DropDown the same width
//                        mTextFieldSize = coordinates.size.toSize()
                        },
                )




                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Button(
                        onClick = {
//                    navigator.navigate(CreatePasswordDestination)
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Red,
                            containerColor = Color.DarkGray
                        )
                    ) {
                        Text(
                            text = "Make the payment",
                            color = Color.Black,
                            modifier = Modifier.padding(10.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                }

            }

    }

}

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        PayLoanScreen {

        }
    }

}