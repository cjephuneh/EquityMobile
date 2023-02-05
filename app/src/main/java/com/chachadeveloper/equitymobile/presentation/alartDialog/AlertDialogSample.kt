package com.chachadeveloper.equitymobile.presentation.alartDialog

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.dev.chacha.ui.R

@Composable
@Preview(showBackground = true)
fun AlertDialogSample() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        var openDialog by remember {
            mutableStateOf(false) // Initially dialog is closed
        }

        ButtonClick(buttonText = "Open Dialog") {
            openDialog = true
        }

        if (openDialog) {
            DialogBoxDeleteItem {
                openDialog = false
            }
        }




    }
    
    
}


@Composable
fun ButtonClick(
    buttonText: String,
    onButtonClick: () -> Unit
) {
    Button(
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.primary
        ),
        onClick = {
            onButtonClick()
        }) {
        Text(
            text = buttonText,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

// For Roboto font: https://fonts.google.com/specimen/Roboto?query=roboto
@Composable
fun DialogBoxDeleteItem(
    cornerRadius: Dp = 12.dp,
    deleteButtonColor: Color = Color(0xFFFF0000),
    cancelButtonColor: Color = Color(0xFF35898F),
    titleTextStyle: TextStyle = TextStyle(
        color = Color.Black.copy(alpha = 0.87f),
        fontFamily = FontFamily(Font(R.font.poppin_bold, FontWeight.Bold)),
        fontSize = 20.sp
    ),
    messageTextStyle: TextStyle = TextStyle(
        color = Color.Black.copy(alpha = 0.95f),
        fontFamily = FontFamily(Font(R.font.poppins_regular, FontWeight.Normal)),
        fontSize = 16.sp,
        lineHeight = 22.sp
    ),
    buttonTextStyle: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium, FontWeight.Medium)),
        fontSize = 16.sp
    ),
    onDismiss: () -> Unit
) {

    val context = LocalContext.current.applicationContext

    // This helps to disable the ripple effect
    val interactionSource = remember {
        MutableInteractionSource()
    }

    val buttonCorner = 6.dp

    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(size = cornerRadius)
        ) {

            Column(modifier = Modifier.padding(all = 16.dp)) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 6.dp,
                        alignment = Alignment.Start
                    )
                ) {

                    // For icon, visit feathericons.com
                    // Icon name: trash-2
                    Icon(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Delete Icon",
                        tint = deleteButtonColor
                    )

                    Text(
                        text = "Delete Item?",
                        style = titleTextStyle
                    )

                }

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 20.dp),
                    text = "Are you sure you want to delete this item from the list?",
                    style = messageTextStyle
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 10.dp,
                        alignment = Alignment.End
                    )
                ) {

                    // Cancel button
                    Box(
                        modifier = Modifier
                            .clickable(
                                // This is to disable the ripple effect
                                indication = null,
                                interactionSource = interactionSource
                            ) {
                                Toast
                                    .makeText(context, "Cancel", Toast.LENGTH_SHORT)
                                    .show()
                                onDismiss()
                            }
                            .border(
                                width = 1.dp,
                                color = cancelButtonColor,
                                shape = RoundedCornerShape(buttonCorner)
                            )
                            .padding(top = 6.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                    ) {
                        Text(
                            text = "Cancel",
                            style = buttonTextStyle,
                            color = cancelButtonColor
                        )
                    }

                    // Delete button
                    Box(
                        modifier = Modifier
                            .clickable(
                                // This is to disable the ripple effect
                                indication = null,
                                interactionSource = interactionSource
                            ) {
                                Toast
                                    .makeText(context, "Delete", Toast.LENGTH_SHORT)
                                    .show()
                                onDismiss()
                            }
                            .background(
                                color = deleteButtonColor,
                                shape = RoundedCornerShape(buttonCorner)
                            )
                            .padding(top = 6.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                    ) {
                        Text(
                            text = "Delete",
                            style = buttonTextStyle,
                            color = Color.White
                        )
                    }

                }
            }

        }

    }
}