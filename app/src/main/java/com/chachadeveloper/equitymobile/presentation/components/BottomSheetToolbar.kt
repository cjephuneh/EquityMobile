package com.chachadeveloper.equitymobile.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.R
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun BottomSheetToolbar(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    showBackArrow: Boolean = false,
    navActions: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {}
) {
    TopAppBar(
        title =  title,
        navigationIcon = {
            Box(modifier= Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){
                if (showBackArrow) {
                    IconButton(onClick = {
                        navigator.popBackStack()
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp),
                            tint = Color.White,
                        )
                    }
                }
            }
        },
        backgroundColor = Color.DarkGray,
        actions = navActions ,
        elevation = 0.dp,
    )


}