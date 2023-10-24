package com.dev.chacha.onboarding.component

import com.dev.chacha.ui.R


sealed class OnBoardingPage(
     val image: Int,
    val title: String,
    val description: String
) {
    object First: OnBoardingPage(
        image = R.raw.intro1,
        title = "More that just banking",
        description = "With 24/7 access to your account, send money,pay your bills,buy airtime, and so much more!"
    )
    object Second: OnBoardingPage(
        image = R.raw.intro2,
        title = "Open an instant account",
        description = "Opening an Equity bank account is quick and simple. Say goodbye to long queues! "
    )
    object Third: OnBoardingPage(
        image =  R.raw.intro3,
        title = "Lifestyle ",
        description = "A convenient digital experience that can be tailored to meet your lifestyle needs"
    )
    object Four: OnBoardingPage(
        image =  R.raw.intro2,
        title = "Growth",
        description = "Grow your money to its full potential with our integrated account management functionality and credit products"
    )
}