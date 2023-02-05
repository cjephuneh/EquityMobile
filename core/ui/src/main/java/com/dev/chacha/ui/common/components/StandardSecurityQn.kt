package com.dev.chacha.ui.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.theme.primaryPink




@Composable
fun StandardSecurityQn(
    modifier: Modifier = Modifier,
    text: String = "",
    hint: String = "",
    label: String = "",
    singleLine: Boolean = true,
    maxLines: Int = 1,
/*    trailingIcon: ImageVector? = null,
    leadingIcon: ImageVector? = null,*/
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String) -> Unit,
    style: TextStyle = TextStyle(
        color = MaterialTheme.colorScheme.onBackground
    )
) {

    val color = Color.White.copy(alpha = 0.78F)
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = color,
        cursorColor = color,
        focusedBorderColor = primaryPink,
        unfocusedBorderColor = color.copy(alpha = 0.5F),
        focusedLabelColor = Color.White,
        unfocusedLabelColor = color

    )
    var mExpanded by remember { mutableStateOf(false) }
    val icon = if (mExpanded) Icons.Filled.KeyboardArrowUp
    else Icons.Filled.KeyboardArrowDown


    // Create a list of cities
    val mCities = listOf("Delhi", "Mumbai", "Chennai", "Kolkata", "Hyderabad", "Bengaluru", "Pune")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    val mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    DropdownMenu(expanded = mExpanded,
        onDismissRequest = { mExpanded = false },
        modifier = Modifier.width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
    ) {

    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp)
    ) {
        TextField(value = text, onValueChange = {
            onValueChange(it)
        }, maxLines = maxLines, textStyle = style, placeholder = {
            Text(
                text = hint,
                textAlign = TextAlign.Start,
                color = Color.DarkGray,
                modifier = Modifier.padding(start = 0.dp)

            )
        }, keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ), singleLine = singleLine, trailingIcon = {
            Icon(icon, "contentDescription", Modifier.clickable { mExpanded = !mExpanded })

        }, modifier = Modifier
            .fillMaxWidth()
            .semantics {
//                testTag = TestTags.STANDARD_TEXT_FIELD
            }, colors = textFieldColors
        )

    }


}