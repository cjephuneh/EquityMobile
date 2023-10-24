package com.chachadeveloper.equitymobile.presentation.activity

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dev.chacha.auth.presentation.navigation.authNavGraph
import com.dev.chacha.onboarding.presentation.OnBoardViewModel
import com.dev.chacha.home.presentation.navigation.homeScreenNavGraph
import com.dev.chacha.home.presentation.navigation.accountScreenNavGraph
import com.dev.chacha.loans.presentation.navigation.borrowNavGraph
import com.dev.chacha.more.navigation.moreScreenNavGraph
import com.dev.chacha.onboarding.navigation.onboardingNavGraph
import com.dev.chacha.savings.navigation.savingsNavGraph
import com.dev.chacha.transaction.presentation.buy_airtime.buyAirtimeNavGraph
import com.dev.chacha.transaction.presentation.pay_with_Equity.buy_goods.buyGoodsNavGraph
import com.dev.chacha.transaction.presentation.pay_with_Equity.pay_bill.payBillNavGraph
import com.dev.chacha.transaction.presentation.schedule_payment.schedulePaymentNavGraph
import com.dev.chacha.transaction.presentation.send_money.another_bank.anotherBankNavGraph
import com.dev.chacha.transaction.presentation.send_money.another_equity_account.anotherEquityAccountNavGraph
import com.dev.chacha.transaction.presentation.send_money.mobile_money.mobileWalletNavGraph
import com.dev.chacha.transaction.presentation.send_money.own_equity_bank.ownEquityAccountNavGraph
import com.dev.chacha.transaction.presentation.send_money.pay_to_card.payToCardNavGraph
import com.dev.chacha.transaction.presentation.third_party.pay_pal.payPalNavGraph
import com.dev.chacha.transaction.presentation.third_party.western_union.westernUnionNavGraph
import com.dev.chacha.transaction.navigation.transactionNavGraph
import com.dev.chacha.transaction.presentation.withdraw_cash.withDrawCashAgentNavGraph
import com.dev.chacha.util.Graph


@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    val onBoardViewModel: OnBoardViewModel = hiltViewModel()
    val isOnBoardingCompleted by onBoardViewModel.isOnBoardingCompleted().collectAsState(false)
    NavHost(
        navController = navController,
        route = Graph.ROOT_ROUTE,
        startDestination = Graph.ONBOARDING_ROUTE
    ) {
        onboardingNavGraph(navController)
        authNavGraph(navController)
        homeScreenNavGraph(navController)
        accountScreenNavGraph(navController)
        transactionNavGraph(navController)
        borrowNavGraph(navController)
        savingsNavGraph(navController)
        moreScreenNavGraph(navController)
        schedulePaymentNavGraph(navController)
        ownEquityAccountNavGraph(navController)
        anotherEquityAccountNavGraph(navController)
        payToCardNavGraph(navController)
        mobileWalletNavGraph(navController)
        anotherBankNavGraph(navController)
        payBillNavGraph(navController)
        buyGoodsNavGraph(navController)
        buyAirtimeNavGraph(navController)
        withDrawCashAgentNavGraph(navController)
        payPalNavGraph(navController)
        westernUnionNavGraph(navController)
    }

}


