package com.dev.chacha.loans.presentation.my_loans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.common.components.AppTopBar

@Composable
fun LoanTransactionSearch(
    initialValue: String,
    onSearchParamChange: (String)->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Transaction history",
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            AppTopBar(
                title = "" ,
                initialValue = initialValue ,
                onSearchParamChange = {
                    onSearchParamChange(initialValue)
                },
                showSearchBar = true,
                modifier = Modifier.fillMaxWidth(0.88f)

            )


            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.outline, CircleShape)
                    .size(48.dp),
                contentAlignment = Alignment.Center,
            ){
                Icon(
                    imageVector = Icons.Outlined.FilterList ,
                    contentDescription =null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }

}