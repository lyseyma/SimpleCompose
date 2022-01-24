package com.seyma.simplecompose.animation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.seyma.simplecompose.R

/**
 * @since  21-Jan-22
 * @author AOS-SEYMA
 */
@Composable
fun CircleImage(imageSize: Dp){

    Image(painter = painterResource(id = R.drawable.jimin1), contentDescription ="CircleImage", contentScale = ContentScale.Crop,
    modifier = Modifier.size(imageSize)
        .clip(CircleShape)
        .border(5.dp, androidx.compose.ui.graphics.Color.Gray, CircleShape))

}

@Composable
fun AnimateDpAsState() {
    val isNeedExpansion = rememberSaveable{ mutableStateOf(false) }

    val animatedSizeDp: Dp by animateDpAsState(targetValue = if (isNeedExpansion.value) 350.dp else 100.dp)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircleImage(animatedSizeDp)
        Button(
            onClick = {
                isNeedExpansion.value = !isNeedExpansion.value
            },
            modifier = Modifier
                .padding(top = 50.dp)
                .width(300.dp)
        ) {
            Text(text = "animateDpAsState")
        }
    }
}



