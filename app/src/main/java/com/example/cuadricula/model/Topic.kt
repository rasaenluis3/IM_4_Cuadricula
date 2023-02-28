package com.example.cuadricula.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val strResId: Int,
    val numCursos: Int,
    @DrawableRes val imgResId: Int,
)
