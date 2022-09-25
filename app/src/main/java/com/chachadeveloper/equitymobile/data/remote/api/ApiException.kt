package com.chachadeveloper.equitymobile.data.remote.api

class ApiException(val statusCode: Int = 0, val statusMessage: String) : Throwable(statusMessage)