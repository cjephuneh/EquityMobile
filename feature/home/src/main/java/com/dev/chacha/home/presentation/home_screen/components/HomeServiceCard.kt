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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R

@Composable
fun HomeServiceCard(
    onClickTransact: () -> Unit,
    onClickBorrow: () -> Unit,
    onClickSave: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
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
            .wrapContentHeight()
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(MaterialTheme.colorScheme.primary, CircleShape)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription =  null,
                tint = Color.White
            )
        }
    }

}