package com.seyma.simplecompose.animation

import android.app.Activity
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.seyma.simplecompose.R

/**
 * @since  21-Jan-22
 * @author AOS-SEYMA
 */
@Composable
fun InfiniteAnimation(){
    val infiniteTransition = rememberInfiniteTransition()
    val hearSize by infiniteTransition.animateFloat(
        initialValue = 100.0f,
        targetValue = 250.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, delayMillis = 100 , easing = FastOutLinearInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val activity = (LocalContext.current as? Activity)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My Heart")
                },
                navigationIcon = {
                    IconButton(onClick = { activity?.finish()}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = colorResource(id = R.color.color_92A9BD),
                contentColor = White,
                elevation = 10.dp
            )
        }, content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.color_7C99AC)),
                horizontalAlignment = Alignment.CenterHorizontally ,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.heart),
                    contentDescription = "My Heart",
                    modifier = Modifier.size(hearSize.dp))
            }
        })



}

