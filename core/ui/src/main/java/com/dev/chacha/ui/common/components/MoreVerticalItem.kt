package com.dev.chacha.ui.common.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.theme.DpDimensions


@Composable
fun MoreVerticalItem(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int? = null,
    @StringRes title: Int,
    @StringRes subtitle: Int? = null,
    onClick: (Int) -> Unit = { String },
    onCheckChange: (Boolean) -> Unit = {},
    isChecked: Boolean = false ,
    showSwitcher: Boolean = false,
    statusNotification: Boolean = false,
    showColorFilter: Boolean = false,


) {
    val sizeIcon24 = dimensionResource(id = R.dimen.margin_24)
    val sizeIcon = dimensionResource(id = R.dimen.margin_48)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(MutableInteractionSource(), null, onClickLabel = title.toString()) {
                onClick(title)
                onCheckChange(isChecked)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = if (drawable != null) 0.dp else 0.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (drawable != null) {
                Box(
                    modifier = Modifier
                        .size(sizeIcon)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.outline),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = drawable),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        colorFilter = if(showColorFilter) null else ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = if (drawable != null) 10.dp else 0.dp, end = 10.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = title),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                if (subtitle != null) {
                    Text(
                        text = stringResource(id = subtitle),
                        color = Color(0xFF8B8B8B),
                        style = MaterialTheme.typography.labelSmall
                    )
                }

            }
            if (drawable ==null && statusNotification){
                Text(
                    text = "On",
                    textAlign = TextAlign.End,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
            if (showSwitcher) {
                Switch(
                    checked = isChecked,
                    onCheckedChange = onCheckChange,
                )
            } else {

                Image(
                    painter = painterResource(id = R.drawable.ic_chevron_right),
                    contentDescription = "",
                    modifier = Modifier
                        .size(sizeIcon24),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)

                )

            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        if (drawable != null) {
            EquityDivider(
                modifier = Modifier.padding(start = 56.dp, end = 8.dp)
            )
        } else {
            EquityDivider()
        }


    }

}

@Composable
fun MoreVerticalItemWithCard(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int? = null,
    @StringRes title: Int,
    @StringRes subtitle: Int? = null,
    onClick: (Int) -> Unit = { String },
    onCheckChange: (Boolean) -> Unit = {},
    isChecked: Boolean = false ,
    showSwitcher: Boolean = false,
    statusNotification: Boolean = false,
    showColorFilter: Boolean = false,


    ) {
    val sizeIcon24 = dimensionResource(id = R.dimen.margin_24)
    val sizeIcon = dimensionResource(id = R.dimen.margin_48)
    StandardCard {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(MutableInteractionSource(), null, onClickLabel = title.toString()) {
                    onClick(title)
                    onCheckChange(isChecked)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = if (drawable != null) 0.dp else 0.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (drawable != null) {
                    Box(
                        modifier = Modifier
                            .size(sizeIcon)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.outline),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = drawable),
                            contentDescription = "",
                            modifier = Modifier.size(24.dp),
                            colorFilter = if(showColorFilter) null else ColorFilter.tint(MaterialTheme.colorScheme.primary)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = if (drawable != null) 10.dp else 0.dp, end = 10.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(id = title),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    if (subtitle != null) {
                        Text(
                            text = stringResource(id = subtitle),
                            color = Color(0xFF8B8B8B),
                            style = MaterialTheme.typography.labelSmall
                        )
                    }

                }
                if (drawable ==null && statusNotification){
                    Text(
                        text = "On",
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
                if (showSwitcher) {
                    Switch(
                        checked = isChecked,
                        onCheckedChange = onCheckChange,
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_chevron_right),
                        contentDescription = "",
                        modifier = Modifier.size(sizeIcon24),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)

                    )

                }

            }

        }
    }


}

@Composable
@Preview(showBackground = true)
fun MoreVerticalItemPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        MoreVerticalItem(
            title = R.string.savings_title,
            subtitle = null,
            drawable = null,
            onClick = {}
        )
        MoreVerticalItem(
            title = R.string.savings_title,
            subtitle = R.string.salary_advance_loan_title,
            drawable = null,
            onClick = {},
        )
        MoreVerticalItem(
            title = R.string.savings_title,
            subtitle = R.string.salary_advance_loan_title,
            drawable = null,
            onClick = {},
            statusNotification = true
        )
        MoreVerticalItem(
            title = R.string.savings_title,
            subtitle = R.string.call_savings_title,
            drawable = R.drawable.ic_arrow_back,
            onClick = {}
        )
        MoreVerticalItem(
            title = R.string.savings_title,
            subtitle = R.string.call_savings_title,
            drawable = R.drawable.ic_arrow_back,
            onClick = {},
            showSwitcher = true
        )

    }

}