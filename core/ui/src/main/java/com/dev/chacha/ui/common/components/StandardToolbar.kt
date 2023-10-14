package com.dev.chacha.ui.common.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dev.chacha.ui.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardToolbar(
    title: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.background,
        titleContentColor = MaterialTheme.colorScheme.onBackground
    ),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    showBackArrow: Boolean = false,
    showForwardArrow: Boolean = false,
    onNavigateBack:()->Unit = {},
    navigationCloseIcons: ImageVector? = null
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        },
        navigationIcon = {
            if (showBackArrow){
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_left),
                    contentDescription = "Localized description",
                    Modifier
                        .size(24.dp)
                        .clickable(MutableInteractionSource(), null) {
                            onNavigateBack()
                        }
                )

            }
            if (navigationCloseIcons != null) {
                Icon(
                    imageVector = navigationCloseIcons,
                    contentDescription = null,
                    modifier = Modifier.clickable(MutableInteractionSource(),null){
                        onNavigateBack()
                    }
                )
            }

        },
        actions = {
            if (showForwardArrow){
                Icon(
                    painter = painterResource(id = R.drawable.chat_icon),
                    contentDescription = "Localized description",
                    Modifier
                        .size(24.dp)
                        .clickable(MutableInteractionSource(), null) {

                        }

                )
            }

        },
        colors = colors,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
    )
}
