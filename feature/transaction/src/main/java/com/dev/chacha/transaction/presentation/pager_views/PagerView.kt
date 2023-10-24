package com.dev.chacha.transaction.presentation.pager_views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.common.pager.BasicIndicator
import com.dev.chacha.ui.common.pager.StackPager
import com.dev.chacha.ui.common.pager.rememberPagerSwipeState


data class StackData(
    val accountName: String,
    val amount: String,
    val accountNumber: String
)

val accounts = listOf(
    StackData(
        "Stephen Chacha",
        "200",
        "01234567890"
    ),
    StackData(
        "Stephen Chacha Marwa",
        "2000",
        "01234067890"
    )
)



@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview(showBackground = true)
fun PagerView() {
    val linearPagerSwipeState = rememberPagerSwipeState()
    val stackPagerSwipeState = rememberPagerSwipeState()
    val context = LocalContext.current
    val density = LocalDensity.current


    // Calculate the screen width in pixels
    val screenWidthPx = density.run {
        context.resources.displayMetrics.widthPixels.toFloat()
    }

    Column(Modifier.fillMaxWidth()) {

        Box {
            StackPager(
                modifier = Modifier,
                data = accounts,
                pagerSwipeState = stackPagerSwipeState,
                stackOffsetStep = 10.dp,
                widthPx = screenWidthPx
            ) { account, index ->

                AccountCard(stackData = account)

            }




        }

        BasicIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp), swipeState = stackPagerSwipeState
        )
    }
}

@Composable
fun AccountCard(
    stackData: StackData,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, RoundedCornerShape(10.dp))
                .padding(vertical = 10.dp, horizontal = 50.dp)
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {
                Text(
                    text = stackData.accountName,
                    fontSize = 12.sp

                )
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Savings Account",
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 12.sp

                    )
                    Text(
                        text = stackData.accountNumber,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 12.sp

                    )
                }
            }
        }

    }


}
