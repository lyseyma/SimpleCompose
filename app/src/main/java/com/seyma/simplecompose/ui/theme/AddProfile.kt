package com.seyma.simplecompose.ui.theme

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seyma.simplecompose.R

/**
 * @since 18.01.2022
 * @author Seyma_android
 */
class AddProfile: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SimpleComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    WeightModifier()
                }
            }
        }
    }
}
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES , showBackground = true , name = "Dark Mode")
@Composable
fun WeightModifier(){
    val activity = (LocalContext.current as? Activity)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top App Bar")
                },
                navigationIcon = {
                    IconButton(onClick = { activity?.finish()}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = colorResource(id = R.color.teal_700),
                contentColor = White,
                elevation = 10.dp
            )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xff8d6e63)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row() {
                    Column(
                        Modifier
                            .weight(1f)
                            .background(color = Cyan)){
                        Text(text = "Weight = 1", color = White)
                    }
                    Column(
                        Modifier
                            .weight(1f)
                            .background(color = Blue)){
                        Text(text = "Weight = 1", color = White)
                    }
                    Column(
                        Modifier
                            .weight(2f)
                            .background(color = Green)) {
                        Text(text = "Weight = 2")
                    }

                }
            }

        })

}

@Preview
@Composable
fun getWeigh(){
    WeightModifier()
}