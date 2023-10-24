package com.dev.chacha.ui.common.modal_sheet_layouts

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.screen_sheets.AddAccountsBottomSheet
import com.dev.chacha.ui.common.screen_sheets.WithdrawFromPayPalSheetContent


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun StandardModalSheetLayout(
    bottomSheetType: TransactionBottomSheetType,
    onClose: () -> Unit,
    navController: NavController
) {

    AnimatedContent(
        label = "",
        targetState = bottomSheetType,
    ) { bottomSheetTypes ->
        when (bottomSheetTypes) {
            TransactionBottomSheetType.PAY_PAL -> AddAccountsBottomSheet(navController)
            TransactionBottomSheetType.WITHDRAW_FROM_PAYPAL -> WithdrawFromPayPalSheetContent(navController)
        }
    }


}

enum class TransactionBottomSheetType {
    PAY_PAL,
    WITHDRAW_FROM_PAYPAL

}