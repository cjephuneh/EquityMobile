package com.dev.chacha.ui.common.modal_sheet

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EquityModalSheet(
    modifier: Modifier = Modifier,
    modalSheetHeight: Modifier = Modifier.fillMaxHeight(0.85f),
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {

     BoxWithConstraints {
         Surface {
             ModalBottomSheet(
                 sheetState = sheetState,
                 onDismissRequest = {
                     onDismissRequest()
                 },
                 modifier = modalSheetHeight,
                 dragHandle = null,
                 shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                 containerColor = MaterialTheme.colorScheme.background
             ) {
                 Column {
                     content()
                     Spacer(modifier = Modifier.weight(1f))
                 }
             }
         }

     }


}


