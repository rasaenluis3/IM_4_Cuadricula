package com.example.cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.model.DataSource
import com.example.cuadricula.model.Topic
import com.example.cuadricula.ui.theme.CuadriculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    CuadriculaApp()
                }
            }
        }
    }
}

@Composable
fun Cuadricula(tList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        items(tList) {
            topic -> Tema(t = topic)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CuadriculaApp() {
    CuadriculaTheme {
        Cuadricula(tList = DataSource.topics)
    }
}

@Composable
fun Tema(t: Topic, modifier: Modifier = Modifier){
    Card() {
        Row(){
            Box() {
                Image(
                    painter = painterResource(id = t.imgResId),
                    contentDescription = null,
                    modifier = Modifier
                        .height(68.dp)
                        .width(68.dp)
                        .aspectRatio(1f)
                )
            }

            Column() {
                Text(
                    text = stringResource(id = t.strResId),
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ) 
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = "Número de cursos",
                        modifier = Modifier.padding(start= 16.dp, end = 8.dp)
                    )
                    Text(text = t.numCursos.toString())

                }
            }
        }
    }
}