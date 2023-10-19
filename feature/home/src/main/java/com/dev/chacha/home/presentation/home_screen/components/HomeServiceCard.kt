package com.dev.chacha.home.presentation.home_screen.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.StandardCard

@Composable
fun HomeServiceCard(
    onClickTransact: () -> Unit,
    onClickBorrow: () -> Unit,
    onClickSave: () -> Unit
) {
    StandardCard(
        modifier = Modifier.padding(horizontal = 16.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            VerticalImageText(
                text = R.string.transact ,
                icon = R.drawable.transact,
                onClick = onClickTransact
            )

            VerticalImageText(
                text = R.string.borrow ,
                icon = R.drawable.loan,
                onClick = onClickBorrow
            )

            VerticalImageText(
                text = R.string.save ,
                icon = R.drawable.spa,
                onClick = onClickSave
            )

        }
    }

}

@Composable
fun VerticalImageText(
    @StringRes text: Int,
    @DrawableRes icon: Int,
    onClick:()->Unit
) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .wrapContentHeight()
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription =  null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center
        )
    }

}

val CardColors = Color(0xFFF7f7f7)