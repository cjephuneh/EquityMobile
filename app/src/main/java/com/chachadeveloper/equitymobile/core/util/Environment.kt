package com.chachadeveloper.equitymobile.core.util

sealed class Environment(val url: String) {
    object Main : Environment("https://api-uat.equitygroupholdings.com/noncustomer/")
}