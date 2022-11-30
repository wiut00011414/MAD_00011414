package com.example.mad_00011414.viewModels

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mad_00011414.database.Database
import com.example.mad_00011414.models.Movie

@Composable
fun MoviesListView(
    onMovieClick: (String) -> Unit = {},
    navController: NavController
) {
    val movies = Database.getAllMovies()

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(0.dp, 0.dp, 0.dp, 50.dp),
        ) {
            items(items = movies, itemContent = { item ->
                MovieItem(movie = item, onMovieClick)
            })
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(0.dp, 0.dp, 0.dp, 70.dp),
            onClick = {
                navController.navigate("newMovie")
            })
        {
            Text(
                text = "Add new movie",
                modifier = Modifier.padding(15.dp, 5.dp)
            )
        }
    }

}

@Composable
fun MovieItem(movie: Movie, onMovieClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 10.dp, 15.dp, 0.dp)
            .clickable {
                onMovieClick(movie.id)
            }
    ) {
        Title(
            title = movie.title
        )
        Author(
            author = movie.author
        )
        Divider(
            modifier = Modifier
                .padding(top = 10.dp)
                .background(Color.Gray)
        )
    }
}

@Composable
private fun Title(title: String) {
    Text(
        text = title,
        color = Color.Black,
        fontSize = 20.sp,
        fontFamily = FontFamily.Serif,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Author(author: String) {
    Text(
        text = author,
        color = Color.DarkGray,
        fontSize = 16.sp,
        fontFamily = FontFamily.SansSerif
    )
}
