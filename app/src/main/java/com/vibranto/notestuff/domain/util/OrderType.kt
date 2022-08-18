package com.vibranto.notestuff.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
