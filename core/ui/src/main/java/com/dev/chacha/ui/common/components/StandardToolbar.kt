package com.dev.chacha.ui.common.components


import androidx.compose.foundation.Image
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.dev.chacha.ui.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardToolbar(
    title: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
    showBackArrow: Boolean = false,
    showForwardArrow: Boolean = false,
//    navController: NavController
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (showBackArrow){
                 IconButton(onClick = {
//                     navController.navigateUp()
                 }
                 ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_chevron_left),
                        contentDescription = "Localized description",

                        )
                }
            }
        },
        actions = {
            if (showForwardArrow){
                androidx.compose.material3.IconButton(onClick = { /* doSomething() */ }) {
                    Image(
                        painter = painterResource(id = R.drawable.chat_icon),
                        contentDescription = "Localized description"
                    )
                }
            }
        }
    )
}
