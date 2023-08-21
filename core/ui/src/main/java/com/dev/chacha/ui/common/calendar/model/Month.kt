package com.dev.chacha.presentation.calendar.model

import com.dev.chacha.ui.common.calendar.model.Week
import java.time.YearMonth

data class Month(
    val yearMonth: YearMonth,
    val weeks: List<Week>
)
