package com.dev.chacha.home.presentation.transaction_history

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.R


@Composable
@Preview
fun TransactionServices() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TransactionServiceItem(
            drawable = R.drawable.transact,
            text = R.string.transact,
            onClick = {}
        )
        TransactionServiceItem(
            drawable = R.drawable.coin_stack,
            text = R.string.account_information,
            onClick = {}
        )
        TransactionServiceItem(
            drawable = R.drawable.receipt_long,
            text = R.string.view_your_statement,
            onClick = {}
        )

        TransactionServiceItem(
            drawable = R.drawable.outline_info_24,
            text = R.string.account_balance,
            onClick = {}
        )

    }

}

@Composable
fun TransactionServiceItem(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    onClick:()->Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(95.dp)
            .clickable(MutableInteractionSource(), null){ onClick() },
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(id = drawable) ,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = text),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
        )

    }

}