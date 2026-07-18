package dev.alimansour.springboot.thymeleafdemo.model

class Student(
    val firstName: String = "",
    val lastName: String = "",
    val country: String = "",
    val favoriteLanguage: String = "",
    val favoriteSystems: List<String> = listOf(),
)
