package com.seyma.simplecompose.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seyma.simplecompose.R
import com.seyma.simplecompose.animation.TransitionAnimation

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
//                    AnimatableSample()
//
//                    AnimateDpAsState()
//                    AnimateColorAsState()
                    TransitionAnimation()
//                    InfiniteAnimation()
                }
            }
        }
    }
}
@ExperimentalAnimationApi
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES , showBackground = true , name = "Dark Mode")
@Composable
fun WeightModifier(){
    val activity = (LocalContext.current as? Activity)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Add")
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
            Column(
                modifier = Modifier
                    .fillMaxSize(),
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
                Row() {
                    Greeting("Hello")

                }
            }

        })

}

@ExperimentalAnimationApi
@SuppressLint("ResourceType")
@Composable
fun Greeting(name: String) {
    val context = LocalContext.current
    Column {
        Row {
            Column {
                Text(text = "Hello $name!" , modifier = Modifier.padding(6.dp))
                Text(text = "It me !!!" , modifier = Modifier.padding(6.dp))
            }
            Column {
                Text(text = "Hello $name!" , modifier = Modifier.padding(6.dp))
                Text(text = "It me !!!" , modifier = Modifier.padding(6.dp))
            }

            Column {
                Text(text = "Hello $name!" , modifier = Modifier.padding(6.dp))
                Text(text = "It me !!!" , modifier = Modifier.padding(6.dp))
            }

        }
        Row {
            Column {
                Button(onClick = { Toast.makeText(context, "Hello Hana", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context, Home::class.java))
                },modifier = Modifier.padding(6.dp) ,
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.color_7C99AC)) ) {
                    Text(text = "Click me" , color = androidx.compose.ui.graphics.Color.White)
                }
            }

            Column {
                Image(painter = painterResource(id = R.drawable.studiocompose) , contentDescription = "Android compose",
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp))
            }
            Column {
                Image(painter = painterResource(id = R.drawable.img_1) , contentDescription = "Android compose" ,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp))
            }

        }

        Row {

            Card(backgroundColor = colorResource(id = R.color.color_92A9BD),elevation = 10.dp) {
                var expended by remember {
                    mutableStateOf(false)
                }
                Column(
                    Modifier
                        .clickable { expended = !expended }
                        .height(200.dp)
                        .width(200.dp),
                    verticalArrangement = Arrangement.Center ,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(id = R.drawable.img_1) , contentDescription = "Android compose" ,
                        modifier = Modifier
                            .height(100.dp)
                            .width(100.dp))
                    AnimatedVisibility(visible = expended) {
                        Text(text = "JetPack Compose" , style = MaterialTheme.typography.h6 , color = androidx.compose.ui.graphics.Color.White)
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES , showBackground = true , name = "Dark Mode")
@Composable
fun getWeigh(){
    TransitionAnimation()
}