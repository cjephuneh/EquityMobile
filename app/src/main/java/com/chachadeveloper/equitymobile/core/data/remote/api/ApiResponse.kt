package com.chachadeveloper.equitymobile.core.data.remote.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(
    @Json(name = "responseObject")
    val responseObject: T?,
    @Json(name = "statusCode")
    val statusCode: Int,
    @Json(name = "statusMessage")
    val statusMessage: String,
    @Json(name = "success")
    val success: Boolean
)