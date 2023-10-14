package com.dev.chacha.more.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.dev.chacha.ui.R

@Composable
@Preview
fun SignOutAlertDialog(
    modifier: Modifier = Modifier,
    onDismissClick:()->Unit = {},
    onClick: () -> Unit ={}
) {
    AlertDialog(
        modifier = modifier
            .safeGesturesPadding()
            .wrapContentHeight(),
        containerColor = MaterialTheme.colorScheme.outline,
        iconContentColor = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(0.dp),
        onDismissRequest = { onDismissClick() },
        textContentColor = MaterialTheme.colorScheme.onBackground,
        titleContentColor = MaterialTheme.colorScheme.onBackground,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            decorFitsSystemWindows = true
        ),
        tonalElevation = 0.dp,
        text = {
            Column(
                modifier = modifier.wrapContentHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                IconButton(
                    onClick = { onDismissClick() },
                    modifier = modifier
                        .align(Alignment.End)
                        .background(MaterialTheme.colorScheme.outline, CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Text(
                    text = "Good News!",
                    modifier = modifier,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = stringResource(id = R.string.create_dialog_description ),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        },
        confirmButton = {
            Button(
                onClick = { onClick() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onBackground
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Crate PIN now",
                    style = MaterialTheme.typography.labelSmall

                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismissClick()},
            ) {
                Text(
                    text = "Create PIN later",
                    style = MaterialTheme.typography.labelSmall
                )

            }
        }
    )
}