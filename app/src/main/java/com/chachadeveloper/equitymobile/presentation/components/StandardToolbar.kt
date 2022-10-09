package com.chachadeveloper.equitymobile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chachadeveloper.equitymobile.R
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
fun StandardToolbar(
    modifier: Modifier = Modifier,
    title: String = "",
    showBackArrow: Boolean = false,
    showForwardArrow: Boolean = false,
    navigator: DestinationsNavigator
) {
    val modifier = Modifier.size(width = 50.dp, height = 30.dp)
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                color = Color.White
            ) },
        navigationIcon = {
            Box(modifier = modifier, contentAlignment = Alignment.Center) {
                if (showBackArrow){
                    IconButton(onClick = {
                        navigator.navigateUp()
                    }) {
                        Icon(painter = painterResource(id = R.drawable.back)
                            , contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.White
                        )
                    }
                }

            }
        },
        actions = {
            Box(modifier = modifier, contentAlignment = Alignment.Center) {
                if (showForwardArrow){
                    IconButton(onClick = {
                        navigator.navigateUp()
                    }) {
                        Icon(painter =
                        painterResource(id = R.drawable.chat_icon),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                        )

                    }

                }

            }
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp
    )
}