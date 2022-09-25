package com.chachadeveloper.equitymobile.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.filled.WrongLocation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chachadeveloper.equitymobile.R
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun CustomToolbar(
    modifier: Modifier = Modifier,
    navigator: DestinationsNavigator,
    showBackArrow: Boolean = false,
    navActions: @Composable RowScope.() -> Unit = {},
    title: @Composable () -> Unit = {}
) {
    TopAppBar(
        title =  title,
        navigationIcon = {
            Box( contentAlignment = Alignment.Center){
                if (showBackArrow) {
                    IconButton(onClick = {
                        navigator.navigateUp()
                    }) {
                        Icon(imageVector = Icons.Filled.CropSquare,
                            contentDescription =  null,
                            tint = Color.White

                        )

                      /*  Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(color = Color.White)
                        )*/
                    }
                }
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        actions = navActions ,
        elevation = 0.dp,
    )


}