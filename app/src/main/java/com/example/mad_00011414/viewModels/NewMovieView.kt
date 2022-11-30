package com.example.mad_00011414.viewModels

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mad_00011414.database.Database

@Composable
fun NewMovieView(navController: NavController) {

    val title = remember { mutableStateOf("") }
    val author = remember { mutableStateOf("") }
    val roles = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    val isValidated = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        TitleInput(
            title = title.value,
            onTitleChange = {
                title.value = it
            })

        Spacer(Modifier.height(16.dp))

        AuthorInput(
            author = author.value,
            onAuthorChange = {
                author.value = it
            })

        Spacer(Modifier.height(16.dp))

        MainRolesInput(
            roles = roles.value,
            onRoleChange = {
                roles.value = it
            })

        Spacer(Modifier.height(16.dp))

        DescriptionInput(
            description = description.value,
            onDescriptionChange = {
                description.value = it
            })

        Spacer(Modifier.height(16.dp))

        Spacer(Modifier.height(16.dp))

        if(!isValidated.value) {
            Text(
                text = "Please fill out all the fields",
                color = Color.Red
            )
        }

        AddNewButton {
            val isAdded = Database.addNewMovie(
                title.value,
                author.value,
                roles.value,
                description.value
            )
            isValidated.value = isAdded
            if(isAdded){
                navController.navigate("moviesList")
            }
        }
    }
}


@Composable
private fun TitleInput(title: String, onTitleChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        value = title,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onTitleChange(it) },
        label = {
            Text(text = "Title")
        }
    )
}


@Composable
private fun AuthorInput(author: String, onAuthorChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.LightGray),
        value = author,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onAuthorChange(it) },
        label = {
            Text(text = "Author")
        }
    )
}

@Composable
private fun MainRolesInput(roles: String, onRoleChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.LightGray),
        value = roles,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onRoleChange(it) },
        label = {
            Text(text = "Main roles")
        }
    )
}

@Composable
private fun DescriptionInput(description: String, onDescriptionChange: (String) -> Unit) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = Color.LightGray),
        value = description,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        onValueChange = { onDescriptionChange(it) },
        label = {
            Text(text = "Description")
        }
    )
}


@Composable
private fun AddNewButton(onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = "Add"
        )
    }
}