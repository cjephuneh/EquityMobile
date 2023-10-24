package com.dev.chacha.transaction.presentation.third_party.western_union

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.dev.chacha.util.Graph.WESTERN_UNION_ROUTE

fun NavGraphBuilder.westernUnionNavGraph(
    navController: NavHostController
) {
    composable(route = WESTERN_UNION_ROUTE) {
        WesternUnionScreen(navController)
    }

}

