package com.dev.chacha.ui.common.country_search

class Country(
    val nameCode: String,
    val code: String,
    val fullName: String
)
fun getFlagEmojiFor(countryCode: String): String {
    return when (countryCode.lowercase()) {
        "cd" -> "🇨🇩"
        "ke" -> "🇰🇪"
        "rw" -> "🇷🇼"
        "ss" -> "🇸🇸"
        "tz" -> "🇹🇿"
        "ug" -> "🇺🇬"
        else -> " "
    }
}

fun getCountriesList(): List<Country> {
    val countries = mutableListOf<Country>()
    countries.add(Country("cd", "243", "Congo, The Democratic Republic Of The"))
    countries.add(Country("ke", "254", "Kenya"))
    countries.add(Country("rw", "250", "Rwanda"))
    countries.add(Country("ss", "211", "South Sudan"))
    countries.add(Country("tz", "255", "Tanzania, United Republic Of"))
    countries.add(Country("ug", "256", "Uganda"))
    return countries
}