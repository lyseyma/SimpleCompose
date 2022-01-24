package com.seyma.simplecompose.animation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * @since  21-Jan-22
 * @author AOS-SEYMA
 */
@Composable
fun AnimateColorAsState(){
    var isNeedColorChange by remember {
        mutableStateOf(false)
    }
    val startColor = Color.Blue
    val endColor = Color.Green
    val backgroundColor by animateColorAsState(if (isNeedColorChange) endColor else startColor ,
        animationSpec = tween(
            durationMillis = 2000,
            delayMillis = 100,
            easing = LinearEasing))

    Column {
        Box(modifier = Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth()
            .background(backgroundColor))
        Button(
            onClick = { isNeedColorChange = !isNeedColorChange },
            modifier = Modifier.padding(top = 1.dp)
        ){
            Text(text = "Switch Color")
        }

    }
}