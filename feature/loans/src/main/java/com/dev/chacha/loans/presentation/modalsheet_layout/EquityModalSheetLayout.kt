package com.dev.chacha.loans.presentation.modalsheet_layout

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun EquityModalSheetLayout(
    bottomSheetType: LoanBottomSheetType,
    onClose: () -> Unit,
    navController: NavController = rememberNavController()
) {


    when (bottomSheetType) {
        LoanBottomSheetType.ACCOUNT_BALANCE -> AccountBalance()
        LoanBottomSheetType.AMOUNT_LOAN -> AmountLoan()
        LoanBottomSheetType.SELECT_LOAN -> SelectLoanTypeSheet()
    }

}

enum class LoanBottomSheetType{
    ACCOUNT_BALANCE,
    AMOUNT_LOAN,
    SELECT_LOAN
}

@Composable
fun SelectLoanTypeSheet() {

}
@Composable
fun AmountLoan() {

}
@Composable
fun AccountBalance() {

}