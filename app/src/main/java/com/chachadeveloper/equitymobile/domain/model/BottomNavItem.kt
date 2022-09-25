package com.chachadeveloper.equitymobile.domain.model

import com.chachadeveloper.equitymobile.R

import com.chachadeveloper.equitymobile.presentation.destinations.*


sealed class BottomNavItem(var title: String, var icon: Int, var destination: Destination) {
    object Home : BottomNavItem(
        title = "Home",
        icon = R.drawable.home,
        destination = HomeDestination
    )

    object Transact : BottomNavItem(
        title = "Transact",
        icon = R.drawable.ic_creditcard,
        destination = TransactDestination
    )

    object Borrow : BottomNavItem(
        title = "Borrow",
        icon = R.drawable.ic_loan,
        destination = BorrowDestination
    )
    object More : BottomNavItem(
        title = "More",
        icon = R.drawable.more,
        destination = MoreDestination
    )

}