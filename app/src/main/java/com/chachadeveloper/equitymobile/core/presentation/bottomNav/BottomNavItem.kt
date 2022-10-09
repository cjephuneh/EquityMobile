package com.chachadeveloper.equitymobile.core.presentation.bottomNav

import com.chachadeveloper.equitymobile.R
import com.chachadeveloper.equitymobile.destinations.*


sealed class BottomNavItem(var title: String, var icon: Int, var destination: Destination) {
    object Home : BottomNavItem(
        title = "Home",
        icon = R.drawable.home,
        destination = HomeScreenDestination
    )

    object Transact : BottomNavItem(
        title = "Transact",
        icon = R.drawable.mobilepayment,
        destination = TransactionScreenDestination
    )

    object Borrow : BottomNavItem(
        title = "Borrow",
        icon = R.drawable.ic_loan,
        destination = BorrowScreenDestination
    )
    object More : BottomNavItem(
        title = "More",
        icon = R.drawable.more,
        destination = MoreScreenDestination
    )

}