package com.dev.chacha.transaction.presentation.transaction

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.R

@Composable
fun TransactionTitle(
    @DrawableRes drawable: Int,
    @StringRes title: Int,
    onItemClick : () -> Unit,

    ) {
    val sizeIcon = dimensionResource(id = R.dimen.margin_24)
    Column(
        modifier= Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .clickable(MutableInteractionSource(),null){
                    onItemClick()
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Box(
                modifier= Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.outline),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = drawable),
                    contentDescription = "",
                    modifier = Modifier.size(sizeIcon),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)

                )

            }
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = title),
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_chevron_right),
                contentDescription = "",
                modifier = Modifier.size(sizeIcon),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)

            )
        }


    }


}