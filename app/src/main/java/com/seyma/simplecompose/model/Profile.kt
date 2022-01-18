package com.seyma.simplecompose.model

import com.seyma.simplecompose.R

/**
 * @since 30.12.2021
 * @author Seyma_android
 */
data class Profile (
    val id: Int,
    val name: String,
    val description: String,
    val imageRes: Int
        )

val profiles = listOf(
    Profile(
        1,"Momojuni","I'm a student at UK.I want to become a good software dev." , R.drawable.jimin1)
)