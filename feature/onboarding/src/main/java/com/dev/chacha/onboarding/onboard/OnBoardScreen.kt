package com.dev.chacha.onboarding.onboard

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.HintGray
import com.dev.chacha.util.Graph
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun OnBoardScreen(
    navController: NavHostController = rememberNavController(),
    onClickAction: () -> Unit = {},
    onboardViewModel: OnBoardViewModel = hiltViewModel()
) {

    val onBoardViewModel: OnBoardViewModel = hiltViewModel()
    val isOnBoardingCompleted by onBoardViewModel.isOnBoardingCompleted().collectAsState(false)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StandardToolbar(title = "Welcome to Equity Mobile")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val pages = listOf(
                OnBoardingPage.First,
                OnBoardingPage.Second,
                OnBoardingPage.Third,
                OnBoardingPage.Four
            )
            val pageState = rememberPagerState(initialPage = 0)
            val coroutineScope = rememberCoroutineScope()

            val autoScrollEnabled = !isOnBoardingCompleted
            val autoScrollInterval = 5000L // Time in milliseconds between auto-scrolls

            LaunchedEffect(autoScrollEnabled) {
                if (autoScrollEnabled) {
                    while (true) {
                        delay(autoScrollInterval)
                        coroutineScope.launch {
                            val nextPage = (pageState.currentPage + 1) % pages.size
                            pageState.animateScrollToPage(page = nextPage)
                        }
                    }
                }
            }

            val buttonState  = remember{
                derivedStateOf {
                    when(pageState.currentPage){
                        0 -> listOf("","Next")
                        1 -> listOf("","Next")
                        2 -> listOf("","Next")
                        3 -> listOf("","Get Started")
                        else -> listOf("","")
                    }
                }
            }

            HorizontalPager(
                count = 4,
                state = pageState,
            ) { position ->
                PagerScreen(onBoardingPage = pages[position])
            }

            Column(
                modifier = Modifier.fillMaxWidth()
                    .navigationBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                PageIndicator(
                    pageSize = pages.size,
                    selectedPage = pageState.currentPage
                )
                Spacer(modifier = Modifier.weight(1f))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    if (buttonState.value[0].isNotEmpty()){
                        OnBoardingButton(
                            text = buttonState.value[0],
                            onClick = {
                                coroutineScope.launch {
                                    pageState.animateScrollToPage(page = pageState.currentPage-1)
                                }
                            }
                        )

                    }

                    OnBoardingButton(
                        text =  buttonState.value[1],
                        onClick = {
                            coroutineScope.launch {
                                if (pageState.currentPage == 3){
                                    // Naviagte To Next screen
                                    onClickAction()
                                    onboardViewModel.isOnBoardingCompleted()

                                } else{
                                    pageState.animateScrollToPage(page = pageState.currentPage+1)
                                }
                            }
                        }
                    )

                }

            }

            Spacer(modifier = Modifier.weight(0.6f))

        }
    }


}

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize:Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unSelectedColor: Color = HintGray
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pageSize){ page->
            Box(
                modifier = modifier
                    .size(25.dp)
                    .clip(CircleShape)
                    .padding(8.dp)
                    .background(
                        color = if (page == selectedPage) selectedColor else unSelectedColor,
                        shape = CircleShape
                    )
            )

        }

    }

}


@Composable
fun PagerScreen(
    modifier: Modifier = Modifier,
    onBoardingPage: OnBoardingPage
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .padding(top = 40.dp)
    ) {
        LoaderIntro(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .align(alignment = Alignment.CenterHorizontally),
            onBoardingPage.image
        )
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = onBoardingPage.title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            text = onBoardingPage.description,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(60.dp))

    }
}

@Composable
fun OnBoardingButton(
    text: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ){
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.primary,
                containerColor = MaterialTheme.colorScheme.background
            ),
            border = BorderStroke(1.dp,MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.primary
            )
        }

    }

}
