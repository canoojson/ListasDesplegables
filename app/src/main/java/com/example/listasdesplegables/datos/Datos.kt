package com.example.listasdesplegables.datos

import com.example.listasdesplegables.R
import com.example.listasdesplegables.model.Album

class Datos {
    fun cargarAlbums(): List<Album> = listOf(
        Album(R.string.deltoya, R.drawable.deltoya),
        Album(R.string.rockTrangresivo, R.drawable.rocktransgresivo),
        Album(R.string.yoMinoriaAbsoluta, R.drawable.yominoriaabsoluta),
        Album(R.string.materialDefectuoso, R.drawable.materialdefectuoso),
        Album(R.string.cancionesProhibidas, R.drawable.cancionesprohibidas)
    )
}
