package com.dev.chacha.home.presentation.home_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.R
import com.dev.chacha.util.Graph.ANOTHER_BANK_ROUTE
import com.dev.chacha.util.Graph.ANOTHER_EQUITY_ACCOUNT_ROUTE
import com.dev.chacha.util.Graph.BUY_AIRTIME_ROUTE
import com.dev.chacha.util.Graph.BUY_GOODS_ROUTE
import com.dev.chacha.util.Graph.MOBILE_WALLET_ROUTE
import com.dev.chacha.util.Graph.OWN_EQUITY_ACCOUNT_ROUTE
import com.dev.chacha.util.Graph.PAY_BILL_ROUTE
import com.dev.chacha.util.Graph.PAY_TO_CARD_ROUTE
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingHome(
    navController: NavController
) {
    val items = ArrayList<OnBoardingItem>()
    val pagerState = rememberPagerState(
        initialPage = 0,
    )

    items.add(
        OnBoardingItem(
            id = 0,
            "Send to",
            "Equity",
            R.drawable.sync_alt
        )
    )

    items.add(
        OnBoardingItem(
            id = 1,
            "Send to",
            "Mobile",
            R.drawable.outline_send_to_mobile_24
        )
    )

    items.add(
        OnBoardingItem(
            id = 2,
            "Send to",
            "Another",
            R.drawable.account_balance
        )
    )
    items.add(
        OnBoardingItem(
            id = 3,
            "Pay",
            "Bill",
            R.drawable.receipt
        )
    )

    items.add(
        OnBoardingItem(
            id = 4,
            "Buy",
            "Goods",
            R.drawable.trolley
        )
    )
    items.add(
        OnBoardingItem(
            id = 5,
            "Buy",
            "Airtime",
            R.drawable.outline_phone_android
        )
    )

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OnBordingHomePager(
            item = items,
            pagerState = pagerState,
            onItemClick = { itemId ->
                // Handle click action here based on itemId
                when (itemId) {
                    0 -> { navController.navigate(OWN_EQUITY_ACCOUNT_ROUTE) }
                    1 -> { navController.navigate(MOBILE_WALLET_ROUTE) }
                    2 -> { navController.navigate(ANOTHER_BANK_ROUTE) }
                    3 -> { navController.navigate(PAY_BILL_ROUTE) }
                    4 -> { navController.navigate(BUY_GOODS_ROUTE) }
                    5 -> { navController.navigate(BUY_AIRTIME_ROUTE) }
                    else  -> {navController.popBackStack()}
                }
            }
        )
        PagerIndicator(items.size, pagerState.currentPage) // Pass currentPage here
    }




}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBordingHomePager(
    item: ArrayList<OnBoardingItem>,
    pagerState: PagerState,
    onItemClick: (Int) -> Unit // Add this parameter
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(item) { onboardItem ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(85.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = onboardItem.image),
                        contentDescription = onboardItem.title,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { onItemClick(onboardItem.id) } ,// Set onClick action
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = onboardItem.title,
                    fontSize = 14.sp,
                    overflow = TextOverflow.Clip,
                    maxLines = 1
                )
                Text(
                    text = onboardItem.desc,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary,
                    overflow = TextOverflow.Clip,
                    maxLines = 1

                )
            }
        }
    }
}

@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}



@Composable
fun Indicator(isSelected: Boolean) {
    val size = animateDpAsState(targetValue = if (isSelected) 10.dp else 5.dp, label = "")

    Box(
        modifier = Modifier
            .padding(2.dp)
            .size(size.value)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colorScheme.primary else Color.DarkGray.copy(alpha = 0.5f)
            )

    )
}


@Composable
fun CommonDots() {
    Box(
        modifier = Modifier
            .padding(2.dp)
            .size(10.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)

    )
}
