package com.chachadeveloper.equitymobile.feature_home.presentation.home_screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingHome(navigator: DestinationsNavigator) {
    val items = ArrayList<OnBoardingItem>()
    val pagerState = rememberPagerState(
        initialPage = 0,
    )

    items.add(
        OnBoardingItem(
            "Send to",
            "Equity account",
            R.drawable.ic_launcher_background
        )
    )

    items.add(
        OnBoardingItem(
            "Send to",
            "Equity account",
            R.drawable.ic_launcher_background
        )
    )

    items.add(
        OnBoardingItem(
            "Send to",
            "Equity account",
            R.drawable.ic_launcher_background
        )
    )
    items.add(
        OnBoardingItem(
            "Send to",
            "Equity account",
            R.drawable.ic_launcher_background
        )
    )

    items.add(
        OnBoardingItem(
            "Send to",
            "Equity account",
            R.drawable.ic_launcher_background
        )
    )

    OnBordingHomePager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier,
        navigator = navigator )

}
@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBordingHomePager(
    item: ArrayList<OnBoardingItem>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator) {

    Column {
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopStart
        ){

            HorizontalPager(count = 3){ page ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        painter = painterResource(id = item[page].image),
                        contentDescription = item[page].title,
                        modifier = Modifier.size(60.dp)
                    )

                    Text(
                        text = item[page].title,
                        fontSize = 15.sp
                    )
                    Text(
                        text = item[page].desc,
                        fontSize = 15.sp
                    )

                    PagerIndicator(item.size, pagerState.currentPage)

                }


            }


        }
    }

}

@Composable
fun PagerIndicator(size: Int, currentPage: Int) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 20.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(5.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colors.primary else Color.DarkGray.copy(alpha = 0.5f)
            )
    )
}
