package com.example.listasdesplegables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listasdesplegables.datos.Datos
import com.example.listasdesplegables.model.Album
import com.example.listasdesplegables.ui.theme.ListasDesplegablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListasDesplegablesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaDesplegables(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ListaDesplegables(modifier: Modifier = Modifier){
    val lista = Datos().cargarAlbums()
    GridAlbums2(lista, modifier)
}

@Composable
fun ListaAlbums(lista: List<Album>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(lista) { album ->
            TarjetaAlbum(album = album,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun GridAlbums(lista: List<Album>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(lista) { album ->
            TarjetaAlbum(
                album = album
            )
        }
    }
}

@Composable
fun GridAlbums2(lista: List<Album>, modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(lista) { album ->
            TarjetaAlbum(
                album = album
            )
        }
    }
}

@Composable
fun TarjetaAlbum(album: Album, modifier: Modifier = Modifier){
    Card(modifier = modifier){
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
           Image(
               painter = painterResource(album.imageResourceId),
               contentDescription = stringResource(album.stringResourceId),
               modifier = Modifier
                   .height(56.dp)

           )
            Text(
                text = stringResource(album.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListasDesplegablesTheme {
        ListaDesplegables()
    }
}