package com.example.listasdesplegables.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Album(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
