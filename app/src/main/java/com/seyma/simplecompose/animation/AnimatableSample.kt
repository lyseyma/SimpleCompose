package com.seyma.simplecompose.animation

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun AnimatableSample(){
    var isAnimated by remember {
        mutableStateOf(false)
    }
    
    val color = remember {
        Animatable(Color.DarkGray)
    }
    // animate to green/red based on `button click`
    LaunchedEffect(isAnimated) {
        color.animateTo(if (isAnimated) Color.Green else Color.Red, animationSpec = tween(2000))
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.8f)
        .background(color = color.value))
    Button(onClick = { isAnimated = !isAnimated},
        Modifier.padding(top = 10.dp)
    ) {
        Text(text = "Animate Color")
    }


}
