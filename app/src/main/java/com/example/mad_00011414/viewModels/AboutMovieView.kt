package com.example.mad_00011414.viewModels

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mad_00011414.database.Database

@SuppressLint("UnrememberedMutableState")
@Composable
fun AboutMovieView(movieId: String, navController: NavController) {

    val movie = Database.getMovieById(movieId)

    if(movie != null) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        16.dp,
                        bottom = 60.dp
                    )
                    .verticalScroll(rememberScrollState())
            ) {
                Title(
                    title = movie.title
                )
                MyDivider()

                Spacer(Modifier.height(16.dp))

                Author(
                    author = movie.author
                )

                Spacer(Modifier.height(16.dp))

                MainRoles(
                    mainRoles = movie.mainRoles
                )

                Spacer(Modifier.height(16.dp))
                
                Description(
                    description = movie.description
                )

            }

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(0.dp, 0.dp, 0.dp, 70.dp),
                onClick = {
                    Database.deleteMovieById(movieId)
                    navController.navigate("moviesList")
                })
            {
                Text(
                    text = "Delete",
                    modifier = Modifier.padding(15.dp, 5.dp),
                )
            }
        }
    }

}

@Composable
private fun Title(title: String) {
    Column(
        modifier = Modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 34.sp,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun Author(author: String) {
    Column {
        Text(
            text = "Author",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = author,
            color = Color.DarkGray,
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif,
        )
    }
}


@Composable
private fun MainRoles(mainRoles: List<String>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Main Roles",
            modifier = Modifier.padding(top = 10.dp),
            color = Color.Black,
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
        )
        var i = 0
        for (mainRole in mainRoles) {
            ActorTextView(mainRole = mainRole, ++i == mainRoles.size)
        }
    }
}

@Composable
private fun ActorTextView(mainRole: String, isTheLastOne: Boolean) {
    Text(
        modifier = Modifier.padding(6.dp, 3.dp),
        text = if (isTheLastOne) mainRole else "$mainRole,",
        color = Color.DarkGray,
        fontSize = 19.sp,
        fontFamily = FontFamily.SansSerif,
        fontStyle = FontStyle.Italic
    )
}

@Composable
private fun Description(description: String) {
    Column(

    ) {
        Text(
            text = "Description",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = description,
            color = Color.DarkGray,
            fontSize = 22.sp,
            fontFamily = FontFamily.SansSerif
        )
    }

}


@Composable
private fun MyDivider() {
    Divider(
        color = Color.Black
    )
}