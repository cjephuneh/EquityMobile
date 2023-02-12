package com.dev.chacha.home.presentation.homePager

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.dev.chacha.ui.R
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview(showBackground = true)
fun HomePager() {
    val slideImage = remember { mutableStateOf(R.drawable.ic_chevron_right) }

//    val pagerState = rememberPagerState()

    HorizontalPager(count = 3) { page ->
        when (page) {

            0 -> {
                slideImage.value = R.drawable.ic_launcher_foreground
            }

            1 -> {
                slideImage.value = R.drawable.ic_notifications_foreground
            }

            2 -> {
                slideImage.value = R.drawable.ic_security_foreground
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painterResource(slideImage.value),
                contentDescription = ""
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        DotsIndicator(
            totalDots = 3,
            selectedIndex = currentPage,
            selectedColor = Color.Red,
            unSelectedColor = Color.White
        )


    }


}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
) {

    LazyRow(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()

    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(selectedColor)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(5.dp)
                        .clip(CircleShape)
                        .background(unSelectedColor)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}


@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        HomePager()
    }

}
