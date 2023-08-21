package com.dev.chacha.loans.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityOutlinedCard
import com.dev.chacha.ui.common.components.StandardToolbar


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GetLoanLandingScreen(
    onNavigateToLearnMore :()->Unit,
    onNavigateToApplyLoan :()->Unit,
) {
    val filterCategory = listOf("Instant","Salary","Merchandise")
    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Get Loan",
                showBackArrow = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopStart
            ) {


                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Apply for a Loan",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = stringResource(id = R.string.loanDesc),
                        style = MaterialTheme.typography.titleSmall

                    )

                    TextButton(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.background
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Box(
                                modifier = Modifier.size(32.dp),
                                contentAlignment = Alignment.Center
                            ){
                                Icon(
                                    imageVector = Icons.Default.FilterAlt,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(32.dp)
                                        .background(MaterialTheme.colorScheme.outline, CircleShape),
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }

                            Text(
                                text = "Filter by",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }
                    
                    
                    Row(){
                        repeat(filterCategory.size){
                            FilterChip(
                                selected = true,
                                onClick = { /*TODO*/ },
                                label = { Text(text = it.toString()) },

                                )
                        }
                    }
                    

                    
                    EquityOutlinedCard(
                        onClickLearnMore = { onNavigateToLearnMore()},
                        onClickButton = {onNavigateToApplyLoan()},
                        buttonText = stringResource(id = R.string.apply_now),
                        title = "General purpose Loan",
                        subtitle = stringResource(id = R.string.purpose)
                    )

                }

            }
        }
    }

}


