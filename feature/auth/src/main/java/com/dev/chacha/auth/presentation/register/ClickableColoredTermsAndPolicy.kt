package com.dev.chacha.auth.presentation.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dev.chacha.auth.presentation.AuthScreen


@Composable
fun ClickableColoredTermsAndPolicy(
    navController: NavController,
) {

    Column(modifier =  Modifier) {
        val styleCommon = SpanStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        val clickableText = SpanStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.primary
        )
        val annotatedString = buildAnnotatedString {
            withStyle(style = styleCommon) {
                append("I agree to the ")
            }
            pushStringAnnotation("Terms", "Terms")
            withStyle(style = clickableText) {
                append("terms")
            }
            pop()
            withStyle(style = styleCommon) {
                append(" and ")
            }
            pushStringAnnotation("PrivacyPolicy", "Privacy Policy")
            withStyle(style = clickableText) {
                append("privacy policy")
            }
            pop()
        }

        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                val annotations = annotatedString.getStringAnnotations(offset, offset)
                annotations.firstOrNull()?.let { annotation ->
                    when (annotation.tag) {
                        "Terms" -> navController.navigate(AuthScreen.TermsCondition.route)
                        "PrivacyPolicy" -> navController.navigate(AuthScreen.PrivacyTerms.route)
                    }
                }
            },
        )
    }

}

