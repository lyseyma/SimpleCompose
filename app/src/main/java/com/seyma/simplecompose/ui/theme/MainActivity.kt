package com.seyma.simplecompose.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ClipDescription
import android.content.Intent
import android.net.wifi.hotspot2.pps.Credential
import android.os.Bundle
import android.os.Message
import android.provider.MediaStore.Images.ImageColumns.DESCRIPTION
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seyma.simplecompose.R
import com.seyma.simplecompose.model.Profile
import com.seyma.simplecompose.model.profiles

class MainActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                    SetList(profiles)
                }
            }
        }
    }
}

@Composable
fun SetList(profileList: List<Profile>){
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Lists" )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        val intent = Intent(context, AddProfile::class.java)
                        context.startActivity(intent)}) {
                        Icon(Icons.Filled.AddCircle, "backIcon")
                    }
                },
                backgroundColor = colorResource(id = R.color.teal_700),
                contentColor = Color.White,
                elevation = 10.dp
            )
        }, content = {
            LazyColumn(Modifier.fillMaxWidth(),contentPadding = PaddingValues(0.dp)){
                items(profileList){ profile ->
                    for (i in 1..10)
                        myProfile(name = profile.name.plus(" $i"), description = profile.description, imageRes = profile.imageRes)
                }
            }
        })

}

@SuppressLint("ResourceType")
@Composable
fun myProfile(name: String, description: String, imageRes: Int){
    val context = LocalContext.current

    var getName by remember { mutableStateOf(name) }
    var getDes by remember { mutableStateOf(description) }
    val profileAutoCompleteLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()){
        getName = it.data!!.getStringExtra("NAME").toString()
        getDes = it.data!!.getStringExtra("DESCRIPTION").toString()
    }
    Card(backgroundColor = colorResource(id = R.color.white),elevation = 10.dp,
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
            .selectable(true, true, null, onClick = {
                val intent = Intent(context, Home::class.java)
                intent.putExtra("IMAGERES", imageRes)
                intent.putExtra("NAME", getName)
                intent.putExtra("DESCRIPTION", getDes)
                profileAutoCompleteLauncher.launch(intent)
            })) {
        Row(modifier = Modifier.padding(all = 20.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = imageRes), contentDescription = "Jimin profile" ,
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(80.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape))
            // Add a horizontal space between the image and the column
            Spacer(modifier = Modifier.width(8.dp))

            Column(verticalArrangement = Arrangement.Center) {
               Text(text = getName)
                // Add a vertical space between the author and message texts
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = getDes)
            }

        }
    }

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
                Button(onClick = { Toast.makeText(context, "Hello Hana",Toast.LENGTH_SHORT).show()
                   context.startActivity(Intent(context, Home::class.java))
                                 },modifier = Modifier.padding(6.dp) ,
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.teal_200)) ) {
                    Text(text = "Click me" , color = Color.White)
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

            Card(backgroundColor = colorResource(id = R.color.teal_700),elevation = 10.dp) {
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
                        Text(text = "JetPack Compose" , style = MaterialTheme.typography.h6 , color = Color.White)
                    }
                }
            }
        }
    }
}
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleComposeTheme {
        SetList(profiles)
    }
}
