package com.example.mad_00011414.models

data class Movie(
    val id: String,
    val title: String,
    val description: String,
    val author: String,
    val mainRoles: List<String>,
)