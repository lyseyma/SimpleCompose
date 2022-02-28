package com.seyma.simplecompose.ui.theme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seyma.simplecompose.R
import com.seyma.simplecompose.model.Profile
import com.seyma.simplecompose.model.profiles

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
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
                    Text(text = "Lists" , textAlign = TextAlign.Center )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        val intent = Intent(context, AddProfile::class.java)
                        context.startActivity(intent)}) {
                        Icon(Icons.Filled.AddCircle, "backIcon")
                    }
                },
                backgroundColor = colorResource(id = R.color.color_92A9BD),
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
    Card(backgroundColor = colorResource(id = R.color.color_D3DEDC),
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
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

@Immutable
data class ColorSystem(
    val color: Color ,
    val gradient: List<Color>
)

val LocalColorSystem = staticCompositionLocalOf {
    ColorSystem(
        color = Color.Unspecified,
        gradient = emptyList()
    )
}

object Theme{
    val colorSystem: ColorSystem
    @Composable
    get() = LocalColorSystem.current
}

@Composable
private fun SimpleButton(){
    Button(onClick = { /*TODO*/ },
        enabled = true,

    ) {

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
