package com.dev.chacha.more.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.presentation.common.theme.EquityMobileTheme
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.theme.primaryGray

@Composable
fun MoreItemRow(
    @DrawableRes drawable: Int,
    @StringRes title: Int,
    @StringRes subtitle: Int?=null,
    onItemClick : () -> Unit ={},
    onClick: (Int) -> Unit = {String}

) {
    val sizeIcon24 = dimensionResource(id = R.dimen.margin_24)
    val sizeIcon = dimensionResource(id = R.dimen.margin_48)
    Column(
        modifier= Modifier.fillMaxWidth()
            .clickable(
                onClickLabel = title.toString(),
                onClick = { onClick(title) }
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier= Modifier
                    .size(40.dp)
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
                    fontSize = 14.sp
                )
                if (subtitle != null){
                    Text(
                        text = stringResource(id = subtitle),
                        fontSize = 12.sp
                    )
                }

            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_chevron_right),
                contentDescription = "",
                modifier = Modifier.size(sizeIcon24),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)

            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            color = primaryGray,
            thickness = 1.dp,
            modifier = Modifier.padding(start = 56.dp, end = 8.dp)
        )

    }


}
