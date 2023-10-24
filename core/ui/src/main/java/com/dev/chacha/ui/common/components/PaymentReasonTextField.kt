package com.dev.chacha.ui.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PaymentReasonTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit,
    title: String = "",
    hint: String = "",
    maxLines: Int = 1,
    readOnly: Boolean = true,
    enabled: Boolean = true,
) {

    val textFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        focusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(
                MutableInteractionSource(),
                null, onClickLabel = title
            ) {
                onValueChange(title)
            },
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            modifier = modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = .56f),
            style = MaterialTheme.typography.labelSmall

        )
        BoxWithConstraints(
            modifier = Modifier.height(50.dp).clipToBounds(),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredWidth(maxWidth + 16.dp)
                    .offset(x = (-8).dp),
                value = value,
                onValueChange = {
                    onValueChange(it)
                },
                maxLines = maxLines,
                placeholder = {
                    Text(
                        text = hint,
                        modifier = Modifier
                            .clickable(
                                MutableInteractionSource(),
                                null, onClickLabel = hint
                            ) {
                                onValueChange(hint)
                            },
                        style = MaterialTheme.typography.labelSmall

                    )


                },
                colors = textFieldColors,
                readOnly = readOnly,
                enabled = enabled


            )
        }


    }

}


@Composable
@Preview(showBackground = true)
fun PaymentReasonTextFieldPreview() {
    PaymentReasonTextField(
        value = "",
        onValueChange = {},
        title = "From",
        hint = "Available balance is 52.80"
    )
}