package com.dev.chacha.more.presentation.get_touch

import android.content.Intent
import android.graphics.ColorFilter
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.MoreVerticalItem
import com.dev.chacha.ui.common.components.StandardToolbar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GetInTouchScreen() {
    val bottomSheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val sheetState = rememberModalBottomSheetState()


    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()


    BottomSheetScaffold(
        sheetContent = {
                BottomSheetContent(
                    title = stringResource(R.string.get_in_touch),
                    content = stringResource(R.string.get_in_touch ?: 0),
                    onCloseSheet = {
                        scope.launch {
                            scaffoldState.bottomSheetState.hide()
                        }
                    }
                )

        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        topBar = {
            StandardToolbar(
                title = stringResource(R.string.get_in_touch),
                showBackArrow = true
            )
        },
        sheetDragHandle = null,
        containerColor = MaterialTheme.colorScheme.background

    ) { paddingValues->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(R.string.how_can_we_help_you),
                            modifier = Modifier.clickable {
                                scope.launch {
                                    scaffoldState.bottomSheetState.expand()
                                }
                            }
                        )
                    }

                }

                item {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = stringResource(R.string.get_in_touch_desc))
                    }

                }

                items(getInTouchList){ getInTouchItem->
                    MoreVerticalItem(
                        title =  getInTouchItem.title,
                        drawable = getInTouchItem.drawableRes,
                        subtitle = getInTouchItem.subTitle,
                        onClick = {
                            when(it){
                                R.string.contact_us ->{}
                                R.string.email_us ->{}
                                R.string.website ->{}
                            }
                        },
                    )
                }

                items(getInTouchWithColorFilterList){ getInTouchItem->
                    MoreVerticalItem(
                        title =  getInTouchItem.title,
                        drawable = getInTouchItem.drawableRes,
                        subtitle = getInTouchItem.subTitle,
                        onClick = {
                            when(it){
                                R.string.twitter ->{

                                }
                                R.string.facebook ->{}
                                R.string.linkedin ->{}
                            }
                        },
                        showColorFilter = true
                    )
                }
            }

        }

    }





}

data class GetInTouchItem(
    @StringRes val title: Int,
    @StringRes val subTitle: Int? = null,
    @DrawableRes val drawableRes: Int?=null,
    val colorFilter: ColorFilter? = null

    )

private val getInTouchList = listOf(
    GetInTouchItem(
        R.string.contact_us,
        R.string.equity_contact,
        R.drawable.outline_call_24
    ),
    GetInTouchItem(
        R.string.email_us,
        R.string.equity_email,
        R.drawable.mail_outline_24
    ),
    GetInTouchItem(
        R.string.website,
        R.string.equity_website,
        R.drawable.outline_desktop_windows_24
    ),

)
private val getInTouchWithColorFilterList = listOf(
    GetInTouchItem(
        R.string.twitter,
        R.string.equity_twitter,
        R.drawable.ic_twitter
    ),
    GetInTouchItem(
        R.string.facebook,
        R.string.equity_facebook,
        R.drawable.ic__facebook
    ),
    GetInTouchItem(
        R.string.linkedin,
        R.string.equity_linkedin,
        R.drawable.ic__linkedin
    )

)

@Composable
fun BottomSheetContent(
    title: String,
    content: String,
    onCloseSheet: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = title, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = content)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onCloseSheet,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(text = "Close")
        }
    }
}


@Composable
fun OpenUrlWithIntent(url: String) {
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { }

    Button(
        onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            launcher.launch(intent)
        },
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(text = "Open URL")
    }
}

