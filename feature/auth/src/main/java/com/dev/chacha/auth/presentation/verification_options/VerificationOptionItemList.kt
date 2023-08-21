package com.dev.chacha.auth.presentation.verification_options

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dev.chacha.ui.R

@Composable
fun VerificationOptionItemList(
    @DrawableRes icon: Int,
    title: String,
    descriptionValue: String,
    selected: Boolean = false,
    onSelectedOption: () -> Unit
) {
    OutlinedCard (
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.Transparent
        )
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.outline, CircleShape),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription =  "icon",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)


                )
            }
            Column(
                modifier = Modifier.padding(start = 5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = descriptionValue,
                    style = MaterialTheme.typography.titleSmall

                )
            }
            Spacer(modifier = Modifier.weight(1f))
            RadioButton(
                selected = selected,
                onClick = { onSelectedOption()}
            )

        }

    }


}

data class VerificationOption(
    @DrawableRes val icon: Int,
    val title: String,
    val description: String
)

val verificationOptions = listOf(
    VerificationOption(
        icon = R.drawable.ic_input_24,
        title = "By Card",
        description = "ATM, debit or credit card"
    ),
    VerificationOption(
        icon = R.drawable.outline_phone_android,
        title = "By Sms",
        description = "25474*****13"
    ),
    VerificationOption(
        icon = R.drawable.mail_outline_24,
        title = "By Email",
        description = "s********A4@GMAIL>COM"
    )
)
