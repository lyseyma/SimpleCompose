package com.seyma.simplecompose.animation

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateOffset
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.seyma.simplecompose.R

/**
 * @since  21-Jan-22
 * @author AOS-SEYMA
 */
@Composable
fun TransitionAnimation (){
    var isAnimated by remember {
        mutableStateOf(false)
    }
    val transition = updateTransition(targetState = isAnimated , label = "transition")

    val rocketOffset by transition.animateOffset(transitionSpec = {
        if (this.targetState) tween(1000)
        else tween(1500)
    },label = "rocket offset") {
            animated ->
        if (animated) Offset(200f, 0f) else Offset(200f, 500f)
    }

    val rocketSize by transition.animateDp(transitionSpec = { tween(1000)}, "") {
            animated ->
        if (animated) 75.dp else 150.dp
    }


    
    Column(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.jimin1),
            contentDescription = "Rocket",
            modifier = Modifier
                .size(rocketSize)
                .alpha(1.0f)
                .offset(rocketOffset.x.dp, rocketOffset.y.dp))
        Button(
            onClick = { isAnimated = !isAnimated },
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = if (isAnimated) "Land rocket" else "Launch rocket")
        }
    }
    

}