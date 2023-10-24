package com.dev.chacha.transaction.presentation.buy_airtime

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R
import com.dev.chacha.ui.common.components.EquityDivider

@Composable
fun BuyAirtimeComponent(
    buyAirtimeItem: BuyAirtimeItem,
    selected: Boolean = false,
    onSelectedOperator: (BuyAirtimeItem) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(MutableInteractionSource(), null) {
                onSelectedOperator(buyAirtimeItem)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Transparent, CircleShape)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(
                        id = when (buyAirtimeItem.simOperator) {
                            "safaricom" -> R.drawable.cd
                            "equitel" -> R.drawable.rw
                            "airtel" -> R.drawable.ke
                            "telkom" -> R.drawable.ss
                            else -> R.drawable.paypal_icons // A placeholder image
                        }
                    ),
                    contentDescription = buyAirtimeItem.simOperator,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

           
            Text(
                text = buyAirtimeItem.simOperator,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))


            RadioButton(
                selected = selected,
                onClick = { onSelectedOperator(buyAirtimeItem) },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        EquityDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 56.dp, end = 16.dp),
            thickness = 1.dp
        )
    }

}

data class BuyAirtimeItem(
    val country: String,
    val simOperator: String,
)

val simOperatorsList = listOf(
    BuyAirtimeItem(
        country = "Kenya",
        simOperator = "safaricom",
    ),
    BuyAirtimeItem(
        country = "Kenya",
        simOperator = "telkom",
    ),
    BuyAirtimeItem(
        country = "Kenya",
        simOperator = "airtel",
    )

)