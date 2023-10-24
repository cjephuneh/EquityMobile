package com.dev.chacha.loans.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityButton
import com.dev.chacha.ui.common.components.EquityOutlinedButton
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun GetLoanScreen(
    onNavigateToCheckLoanLimit :()->Unit,
    onNavigateToApplyLoan :()->Unit,
) {
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Get Loan",
                showBackArrow = true
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .navigationBarsPadding(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                EquityOutlinedButton(
                    onClick = { onNavigateToCheckLoanLimit() },
                    text = "Check loan limit",
                )
                EquityButton(
                    onClick = { onNavigateToApplyLoan()},
                    text = "Apply now",
                )

            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal =24.dp)
        ) {
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopStart
                ){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_loan),
                            contentDescription =  null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                        )
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 1.dp,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Text(
                            text = "General purpose Loan",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = stringResource(id = R.string.purpose1),
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = stringResource(id = R.string.purpose2),
                            style = MaterialTheme.typography.titleSmall

                        )
                        Text(
                            text = stringResource(id = R.string.purpose3),
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = stringResource(id = R.string.purpose4),
                            style = MaterialTheme.typography.titleSmall
                        )

                    }


                }

            }


        }



}
