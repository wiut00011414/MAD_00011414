package com.example.mad_00011414.database

import com.example.mad_00011414.models.Movie

object Database {
    private val moviesLiveData = mutableListOf<Movie>(
        Movie(
            id = "1",
            title = "The Dark Knight",
            description = "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            author = "Christopher Jonathan James Nolan",
            mainRoles = listOf("Christian Bale", "Heath Andrew Ledger"),
        ),
        Movie(
            id = "2",
            title = "Spider-Man (2002)",
            description = "Spider-Man\" centers on student Peter Parker (Tobey Maguire) who, after being bitten by a genetically-altered spider, gains superhuman strength and the spider-like ability to cling to any surface. He vows to use his abilities to fight crime, coming to understand the words of his beloved Uncle Ben: \"With great power comes great responsibility.",
            author = "Sam Raimi",
            mainRoles = listOf("Tobey Maguire", "Willem Dafoe"),
        ),
    )

    fun getAllMovies(): List<Movie> {
        return moviesLiveData
    }

    fun getMovieById(id: String): Movie? {
        return moviesLiveData.find { movie ->
            movie.id == id
        }
    }

    fun deleteMovieById(id: String) {
        val movie = moviesLiveData.find { movie ->
            movie.id == id
        }

        if(movie in moviesLiveData) {
            moviesLiveData.remove(movie)
        }
    }

    fun addNewMovie(title: String, author: String, roles: String, description: String): Boolean {
        if(
            title != ""
            && author != ""
            && roles != ""
            && description != ""
        ) {
            val movie = Movie(
                id =  (0..9999).random().toString(),
                title = title,
                description = description,
                author = author,
                mainRoles = roles.split(",")
            )
            moviesLiveData.add(movie)
            return true
        } else {
            return false
        }

    }
}


