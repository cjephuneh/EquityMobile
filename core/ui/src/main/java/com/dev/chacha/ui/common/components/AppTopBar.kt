package com.dev.chacha.ui.common.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.chacha.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    title: String,
    showSearchBar: Boolean = false,
    initialValue: String,
    onSearchParamChange: (searchParam: String) -> Unit,
    showMenuBar: Boolean = false,
    showBackArrow: Boolean = false,
    searchHint: String = "Search",
    showTopBar: Boolean = false,
    navigationIcon: ImageVector? = null,
    onNavigateBack: ()->Unit = {}
) {
    Surface {
        Column(
            modifier = modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            if (showTopBar){
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 18.sp
                        )

                    },
                    navigationIcon = {
                        if (showBackArrow) {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_arrow_back),
                                    contentDescription = null,
                                    tint = Color.Black
                                )
                            }
                        }
                        if (navigationIcon != null) {
                            Icon(
                                imageVector = navigationIcon,
                                contentDescription = null,
                                modifier = modifier.clickable(MutableInteractionSource(),null){
                                    onNavigateBack()
                                }
                            )
                        }
                    },

                    actions = {
                        if (showMenuBar) {
                            IconButton(onClick = { }) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_menu),
                                    contentDescription = null
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                )
            }

            AnimatedVisibility(
                visible = showSearchBar,
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {
                Box(
                    modifier = modifier
                        .padding(bottom = 4.dp)
                        .clip(CircleShape)
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    var searchParam: String by remember { mutableStateOf(initialValue) }
                    val focusRequester = remember { FocusRequester() }
                    val focusManager = LocalFocusManager.current

                    OutlinedTextField(
                        value = searchParam,
                        onValueChange = { newValue ->
                            searchParam = if (newValue.trim().isNotEmpty()) newValue else ""
                            onSearchParamChange(newValue)
                        },
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .focusRequester(focusRequester = focusRequester),
                        singleLine = true,
                        placeholder = {
                            Text(
                                text = searchHint,
                                color = colorScheme.onSurface.copy(alpha = .32F),
                                style = MaterialTheme.typography.labelSmall
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorScheme.onBackground,
                            unfocusedBorderColor = colorScheme.onBackground,
                            focusedContainerColor = colorScheme.onSurface.copy(alpha = .08F),
                            unfocusedContainerColor = colorScheme.onSurface.copy(alpha = .08F)
                        ), keyboardOptions = KeyboardOptions(
                            autoCorrect = true,
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(
                            onSearch = {
                                onSearchParamChange(searchParam)
                            }
                        ),
                        trailingIcon = {
                            Row {
                                AnimatedVisibility(visible = searchParam.trim().isNotEmpty()) {
                                    IconButton(onClick = {
                                        focusManager.clearFocus()
                                        searchParam = ""
                                        onSearchParamChange(searchParam)
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = null
                                        )
                                    }
                                }

                                IconButton(onClick = {
                                    onSearchParamChange(searchParam)
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_search),
                                        contentDescription = null
                                    )
                                }
                            }
                        },
                        shape = CircleShape
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewAppTopBar() {
    AppTopBar(
        title = "Search",
        initialValue = "",
        onSearchParamChange = {},
        showMenuBar = true,
        showBackArrow = true,
        showSearchBar = true
    )
}