package com.example.meditationuicompse

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Features(
    val title : String ,
    @DrawableRes val iconId : Int ,
    val background : Color
)
