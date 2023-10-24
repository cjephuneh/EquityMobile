package com.dev.chacha.transaction.presentation.modalsheet_layout

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.transaction.presentation.equity_accounts_balance.AccountBalanceScreen
import com.dev.chacha.transaction.presentation.buy_airtime.bottom_sheet.BuyAirtimeBottomSheet
import com.dev.chacha.transaction.presentation.buy_airtime.BuyAirtimeViewModel
import com.dev.chacha.transaction.presentation.send_money.another_equity_account.CountrySearchBottomSheet
import com.dev.chacha.transaction.presentation.send_money.another_equity_account.EquityAccountFirstBottomSheet
import com.dev.chacha.transaction.presentation.send_money.another_equity_account.EquityAccountSecondBottomSheet
import com.dev.chacha.transaction.presentation.send_money.another_equity_account.EquityAccountViewModel
import com.dev.chacha.transaction.presentation.send_money.another_bank.bank_bottoms_sheets.SendMoneyToBankBottomSheet
import com.dev.chacha.transaction.presentation.send_money.another_bank.bank_bottoms_sheets.SendToBankFirstScreen
import com.dev.chacha.transaction.presentation.send_money.another_bank.bank_bottoms_sheets.SendToPhoneLinkedBankAccount
import com.dev.chacha.transaction.presentation.send_money.another_equity_account.CurrencyBottomSheet
import com.dev.chacha.transaction.presentation.send_money.another_equity_account.EquityAccountUiEvent
import com.dev.chacha.transaction.presentation.buy_airtime.bottom_sheet.BuyAirtimeCountrySearch
import com.dev.chacha.transaction.presentation.pay_with_Equity.pay_bill.PayBillLandingSheet
import com.dev.chacha.transaction.presentation.send_money.mobile_money.MobileMoneyUiEvent
import com.dev.chacha.transaction.presentation.send_money.mobile_money.MobileMoneyViewModel
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_first_sheet.MobileMoneyFirstBottomSheetScreen
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_second_sheet.MobileMoneySecondBottomSheetScreen
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobile_third_sheet.ContactSelectionScreen
import com.dev.chacha.transaction.presentation.send_money.mobile_money.send_money_operator_sheet.SendMoneyOperators
import com.dev.chacha.transaction.presentation.send_money.own_equity_bank.OwnEquityFirstBottomSheet
import com.dev.chacha.transaction.presentation.send_money.pay_to_card.PayToCardFirstBottomSheet
import com.dev.chacha.transaction.presentation.third_party.pay_pal.PayPalFirstScreenSheet
import com.dev.chacha.transaction.presentation.third_party.western_union.WesternUnionScreen
import com.dev.chacha.transaction.presentation.withdraw_cash.WithdrawCashAgentScreen
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.ui.Alignment
import com.dev.chacha.transaction.presentation.third_party.pay_pal.WithdrawFromPayPalSheet


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EquityModalSheetLayout(
    bottomSheetType: TransactionBottomSheetType,
    onClose: () -> Unit,
    navController: NavController = rememberNavController()
) {
    val mobileMoneyViewModel: MobileMoneyViewModel = viewModel()
    val equityAccountViewModel: EquityAccountViewModel = viewModel()
    val buyAirtimeViewModel: BuyAirtimeViewModel = viewModel()
    val selectedCountry = equityAccountViewModel.mobileCountry

    AnimatedContent(
        label = "",
        targetState =  bottomSheetType,
    ) {bottomSheetTypes->
        when (bottomSheetTypes) {
            TransactionBottomSheetType.ACCOUNT_BALANCE -> AccountBalanceScreen()
            TransactionBottomSheetType.BUY_GOODS -> BuyAirtimeBottomSheet()
            TransactionBottomSheetType.SEND_MONEY_TO_BANK_FIRST_SCREEN -> SendToBankFirstScreen()
            TransactionBottomSheetType.SEND_MONEY_TO_BANK -> SendMoneyToBankBottomSheet()
            TransactionBottomSheetType.SEND_MONEY_TO_PHONE_LINKED_ACCOUNT -> SendToPhoneLinkedBankAccount()
            TransactionBottomSheetType.MOBILE_MONEY_FIRST_SCREEN -> MobileMoneyFirstBottomSheetScreen()
            TransactionBottomSheetType.MOBILE_MONEY_CONTACTS -> ContactSelectionScreen(
                navController = navController ,
                onContactSelected = { contact->
                    mobileMoneyViewModel.onMobileMoneyEvent(
                        MobileMoneyUiEvent.OnMobileNumberChanged(contact.phoneNumber)
                    )
                    onClose()
                },
                onClose = onClose
            )

            TransactionBottomSheetType.MOBILE_MONEY_SECOND_SCREEN -> MobileMoneySecondBottomSheetScreen()
            TransactionBottomSheetType.SEND_MONEY_OPERATORS -> SendMoneyOperators()
            TransactionBottomSheetType.PAY_TO_CARD_FIRST_SHEET -> PayToCardFirstBottomSheet()
            TransactionBottomSheetType.OWN_EQUITY_ACCOUNT_FIRST_SHEET -> OwnEquityFirstBottomSheet()
            TransactionBottomSheetType.EQUITY_COUNTRY_BOTTOM_SHEET -> CountrySearchBottomSheet(
                onClose = {onClose()},
            )
            TransactionBottomSheetType.EQUITY_ACCOUNT_SECOND_BOTTOM_SHEET -> EquityAccountSecondBottomSheet()
            TransactionBottomSheetType.EQUITY_ACCOUNT_FIRST_BOTTOM_SHEET -> EquityAccountFirstBottomSheet()
            TransactionBottomSheetType.BUY_AIRTIME_COUNTRY_SHEET -> BuyAirtimeCountrySearch {
                onClose()
            }
            TransactionBottomSheetType.EQUITY_ACCOUNT_CONTACT_BOTTOM_SHEET -> ContactSelectionScreen(
                navController = navController,
                onContactSelected = { contact->
                    equityAccountViewModel.onEquityAccountEvent(
                        EquityAccountUiEvent.OnMobileNumberChanged(contact.phoneNumber)
                    )
                    onClose()
                }
            )


            TransactionBottomSheetType.CURRENCY_BOTTOM_SHEET -> CurrencyBottomSheet()
            TransactionBottomSheetType.WITHDRAWAL_AGENT_SHEET -> WithdrawCashAgentScreen(
                navController = navController
            )
            TransactionBottomSheetType.PAY_BILL_SHEET -> PayBillLandingSheet()
            TransactionBottomSheetType.WESTERN_UNION_SCREEN -> WesternUnionScreen(
                navController = navController)
        }
    }


}

enum class TransactionBottomSheetType{
    BUY_AIRTIME_COUNTRY_SHEET,
    ACCOUNT_BALANCE,
    BUY_GOODS,
    SEND_MONEY_TO_BANK_FIRST_SCREEN,
    SEND_MONEY_TO_BANK,
    SEND_MONEY_TO_PHONE_LINKED_ACCOUNT,
    MOBILE_MONEY_FIRST_SCREEN,
    MOBILE_MONEY_SECOND_SCREEN,
    MOBILE_MONEY_CONTACTS,
    SEND_MONEY_OPERATORS,
    PAY_TO_CARD_FIRST_SHEET,
    OWN_EQUITY_ACCOUNT_FIRST_SHEET,
    EQUITY_ACCOUNT_FIRST_BOTTOM_SHEET,
    EQUITY_ACCOUNT_CONTACT_BOTTOM_SHEET,
    EQUITY_ACCOUNT_SECOND_BOTTOM_SHEET,
    EQUITY_COUNTRY_BOTTOM_SHEET,
    CURRENCY_BOTTOM_SHEET,
    WITHDRAWAL_AGENT_SHEET,
    PAY_BILL_SHEET,
    WESTERN_UNION_SCREEN,

}