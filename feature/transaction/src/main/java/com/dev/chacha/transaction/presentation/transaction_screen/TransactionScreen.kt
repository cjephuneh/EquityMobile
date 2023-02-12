package com.dev.chacha.transaction.presentation.transaction_screen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardToolbar
import com.dev.chacha.ui.common.theme.primaryGray
import com.dev.chacha.ui.common.theme.primaryPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionScreen() {
    Scaffold(topBar = {
        StandardToolbar(
            title = "Transact",
            showForwardArrow = true
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn {
                item {
                    Column {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.TopStart
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 20.dp, vertical = 20.dp)

                            ) {
                                Text(
                                    text = "What would you like to do?",
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(150.dp)
                                        .clip(RoundedCornerShape(8.dp))
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(16.dp)
                                    ) {
                                        Text(
                                            text = "Favourite"
                                        )
                                        Text(
                                            text = stringResource(id = R.string.favourite),
                                            maxLines = 2
                                        )
                                    }
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(20.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier.fillMaxSize(),
                                            contentAlignment = Alignment.BottomEnd,
                                        ) {
                                            Text(
                                                text = "Add favourite",
                                                color = primaryPink
                                            )
                                        }
                                    }

                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "Send Money",
                                    fontSize = 18.sp
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_support_foreground),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                            .background(Color.DarkGray),
                                        colorFilter = ColorFilter.tint(color = primaryPink)

                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Own Equity account",
                                            maxLines = 1,
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )
                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier
                                        .padding(start = 60.dp, end = 8.dp)
                                )
                                Spacer(modifier = Modifier.height(12.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Another Equity account",
                                            maxLines = 1,
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )
                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(
                                            start = 60.dp, end = 8.dp
                                        )
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Pay to or top up card",
                                            maxLines = 1,
                                        )
                                        Text(
                                            text = "credit and prepaid cards",
                                            maxLines = 1,
                                            fontSize = 12.sp

                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )

                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(
                                            start = 60.dp, end = 8.dp
                                        )
                                )


                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Mobile wallet",
                                            maxLines = 1,
                                        )
                                        Text(
                                            text = "send to mobile money providers",
                                            maxLines = 1,
                                            fontSize = 12.sp
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )

                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(
                                            start = 60.dp, end = 8.dp
                                        )
                                )


                                /*Row 5*/

                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Another Bank",
                                            maxLines = 1,
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )


                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(
                                            start = 0.dp, end = 0.dp
                                        )
                                )

                                Spacer(modifier = Modifier.height(12.dp))


                                Text(
                                    text = "Pay With Equity",
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Pay bill",
                                            maxLines = 1,
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )

                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(
                                            start = 60.dp, end = 8.dp
                                        )
                                )

                                /*Row 5*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Buy goods",
                                            maxLines = 1,
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )
                                }
                                Spacer(modifier = Modifier.height(12.dp))

                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(
                                            start = 0.dp, end = 0.dp
                                        )
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                Text(
                                    text = "Buy",
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Buy airtime",
                                            maxLines = 1,
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )
                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(
                                            start = 0.dp, end = 0.dp
                                        )
                                )


                                Spacer(modifier = Modifier.height(12.dp))
                                Text(
                                    text = "Withdraw cash",
                                )

                                /* Row 3*/
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.ic_launcher_background),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(CircleShape)
                                    )
                                    Column(
                                        modifier = Modifier.padding(start = 10.dp)
                                    ) {
                                        Text(
                                            text = "Agent",
                                            maxLines = 1,
                                        )
                                    }
                                    Spacer(modifier = Modifier.weight(1f))
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_chevron_right),
                                        tint = primaryPink,
                                        contentDescription = null,

                                        )

                                }

                                Spacer(modifier = Modifier.height(12.dp))

                                Divider(
                                    color = primaryGray,
                                    thickness = 1.dp,
                                    modifier = Modifier.padding(
                                            start = 0.dp, end = 0.dp
                                        )
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }

                }
            }
        }
    }
}

@Composable
@Preview("Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
fun FingerPrintScreenPreview() {
    EquityMobileTheme {
        TransactionScreen()
    }

}
