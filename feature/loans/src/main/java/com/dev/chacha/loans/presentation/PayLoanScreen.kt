package com.dev.chacha.loans.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.EquityButton
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
            StandardToolbar(title = "Pay Loan")
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .navigationBarsPadding()
            ) {
                EquityButton(
                    onClick = { /*TODO*/ },
                    text = "Make the payment",
                )

            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)

        ) {
            var mExpanded by remember { mutableStateOf(false) }

            // Create a list of cities
            val mCities =
                listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

            // Create a string value to store the selected city
            var mSelectedText by remember { mutableStateOf("") }

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


        }
    }

}
