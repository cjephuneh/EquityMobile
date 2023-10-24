package com.dev.chacha.loans.presentation.loan_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.loans.presentation.navigation.BorrowScreenNavigation
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityOutlinedCard
import com.dev.chacha.ui.common.components.StandardToolbar

@Composable
fun GetLoanListScreen(navController: NavController) {
    val filterCategory = listOf<String>("Instant", "Salary", "Merchandise")

    Scaffold(
        topBar = {
            StandardToolbar(
                title = "Get Loan",
                showBackArrow = true
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
        ) {

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
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
                                        modifier = Modifier
                                            .size(48.dp)
                                            .background(
                                                MaterialTheme.colorScheme.outline,
                                                CircleShape
                                            )
                                            .clip(CircleShape),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.FilterAlt,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(24.dp),
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

                            FilterChipRow(filterCategory)
                        }
                    }
                }
                item {
                    EquityOutlinedCard(
                        onClickLearnMore = { navController.navigate(BorrowScreenNavigation.AboutOneMonthLoan.route) },
                        onClickButton = { navController.navigate(BorrowScreenNavigation.AboutOneMonthLoan.route) },
                        buttonText = stringResource(id = R.string.apply_now),
                        title = stringResource(id = R.string.one_month_loan_title),
                        subtitle = stringResource(id = R.string.one_month_loan_subtitle)
                    )

                }
                item {
                    EquityOutlinedCard(
                        onClickLearnMore = { navController.navigate(BorrowScreenNavigation.AboutInstallmentLoan.route) },
                        onClickButton = { navController.navigate(BorrowScreenNavigation.AboutInstallmentLoan.route) },
                        buttonText = stringResource(id = R.string.apply_now),
                        title = stringResource(id = R.string.installment_loan_title),
                        subtitle = stringResource(id = R.string.installment_loan_subtitle)
                    )

                }
                item {
                    EquityOutlinedCard(
                        onClickLearnMore = { navController.navigate(BorrowScreenNavigation.AboutPensionLoan.route) },
                        onClickButton = { navController.navigate(BorrowScreenNavigation.AboutPensionLoan.route) },
                        buttonText = stringResource(id = R.string.apply_now),
                        title = stringResource(id = R.string.pension_loan_title),
                        subtitle = stringResource(id = R.string.pension_loan_subtitle)
                    )

                }

                item {
                    EquityOutlinedCard(
                        onClickLearnMore = { navController.navigate(BorrowScreenNavigation.AboutSalaryAdvanceLoan.route) },
                        onClickButton = { navController.navigate(BorrowScreenNavigation.AboutSalaryAdvanceLoan.route) },
                        buttonText = stringResource(id = R.string.apply_now),
                        title = stringResource(id = R.string.salary_advance_loan_title),
                        subtitle = stringResource(id = R.string.salary_advance_loan_subtitle)
                    )

                }

                item {
                    EquityOutlinedCard(
                        onClickLearnMore = { navController.navigate(BorrowScreenNavigation.AboutEcoSystemLoan.route) },
                        onClickButton = { navController.navigate(BorrowScreenNavigation.AboutEcoSystemLoan.route) },
                        buttonText = stringResource(id = R.string.apply_now),
                        title = stringResource(id = R.string.ecosystem_loan_title),
                        subtitle = stringResource(id = R.string.ecosystem_loan_subtitle)
                    )

                }
            }

        }

    }

}


@Composable
fun FilterChipRow(
    filterCategory: List<String>,
    selected: Boolean = false
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        filterCategory.forEach { category ->
            FilterChip(
                selected = selected,
                onClick = { /* TODO */ },
                label = { Text(text = category, fontWeight = FontWeight.Bold, fontSize = 14.sp) },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = MaterialTheme.colorScheme.outline,
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.background,
                    selectedLeadingIconColor = MaterialTheme.colorScheme.background
                ),
                leadingIcon = {
                    if (selected) {
                        Icon(imageVector = Icons.Default.Check, contentDescription = null )
                    } else {
                        Box{}
                    }
                }
            )
        }
    }
}


@Composable
@Preview
fun GetLoanListPreview() {
    GetLoanListScreen(navController = rememberNavController())
}