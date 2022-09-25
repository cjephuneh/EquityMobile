package com.chachadeveloper.equitymobile.presentation.home

import android.media.midi.MidiDevice
import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingHome(navigator: DestinationsNavigator) {
    val items = ArrayList<OnBoardingItem>()
    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
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

            HorizontalPager(state = pagerState){ page ->
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

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @androidx.annotation.IntRange(from = 0) pageCount: Int,
    @androidx.annotation.IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @androidx.annotation.IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
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
