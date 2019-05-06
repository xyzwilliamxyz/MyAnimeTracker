package com.think4software.myanimetracker.utils

import java.util.*

object DateUtils {

    fun getCurrentYear(): Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }

    fun getCurrentSeason(): String {
        return when (Calendar.getInstance().get(Calendar.MONTH) - 1) {
            Calendar.NOVEMBER, Calendar.DECEMBER, Calendar.JANUARY, Calendar.FEBRUARY -> "winter"
            Calendar.MARCH, Calendar.APRIL -> "spring"
            Calendar.MAY, Calendar.JUNE, Calendar.JULY, Calendar.AUGUST -> "summer"
            Calendar.SEPTEMBER, Calendar.OCTOBER -> "fall"
            else -> throw IllegalArgumentException("Unknown month")
        }
    }
}
