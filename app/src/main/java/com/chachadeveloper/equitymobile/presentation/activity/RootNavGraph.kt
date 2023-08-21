package com.chachadeveloper.equitymobile.presentation.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chachadeveloper.equitymobile.presentation.bottomNav.BottomNavigationBar
import com.dev.chacha.auth.presentation.authNavGraph
import com.dev.chacha.onboarding.onboard.OnBoardViewModel
import com.dev.chacha.home.presentation.homeScreenNavGraph
import com.dev.chacha.loans.presentation.borrowNavGraph
import com.dev.chacha.more.presentation.moreScreenNavGraph
import com.dev.chacha.onboarding.onboard.onboardingNavGraph
import com.dev.chacha.savings.presentation.savingsNavGraph
import com.dev.chacha.transaction.presentation.buy_airtime.buyAirtimeNavGraph
import com.dev.chacha.transaction.presentation.pay_with_Equity.buyGoodsNavGraph
import com.dev.chacha.transaction.presentation.pay_with_Equity.payBillNavGraph
import com.dev.chacha.transaction.presentation.schedule_payment.schedulePaymentNavGraph
import com.dev.chacha.transaction.presentation.send_money.anotherBankNavGraph
import com.dev.chacha.transaction.presentation.send_money.anotherEquityAccountNavGraph
import com.dev.chacha.transaction.presentation.send_money.mobileWalletNavGraph
import com.dev.chacha.transaction.presentation.send_money.ownEquityAccountNavGraph
import com.dev.chacha.transaction.presentation.send_money.payToCardNavGraph
import com.dev.chacha.transaction.presentation.third_party.payPalNavGraph
import com.dev.chacha.transaction.presentation.third_party.westernUnionNavGraph
import com.dev.chacha.transaction.presentation.transactionNavGraph
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


