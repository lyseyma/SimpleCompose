package com.seyma.simplecompose.ui.theme

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seyma.simplecompose.R

/**
 * @since 27.12.2021
 * @author Seyma_android
 */
class Home: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SimpleComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    mData()
                }
            }
        }
    }
}
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES , showBackground = true , name = "Dark Mode")
@Composable
fun mData(){
    val activity = (LocalContext.current as? Activity)
    val intent = (activity as Home).intent
    val mProfile = intent.getIntExtra("IMAGERES",0)
    val mName = intent.getStringExtra("NAME")
    val mDescription = intent.getStringExtra("DESCRIPTION")
    var mInputName by remember { mutableStateOf(mName) }
    var mInputDes by remember { mutableStateOf(mDescription) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Profile")
                },
                navigationIcon = {
                    IconButton(onClick = {  val intent = Intent()
                        intent.putExtra("NAME",mInputName )
                        intent.putExtra("DESCRIPTION",mInputDes )
                        activity.setResult(RESULT_OK, intent)
                        activity.finish()}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = colorResource(id = R.color.color_92A9BD),
                contentColor = Color.White,
                elevation = 10.dp
            )
        }, content = {
            Column {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .size(100.dp),horizontalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = mProfile), contentDescription = "My profile" , modifier = Modifier
                        .height(400.dp)
                        .width(500.dp))
                }
                Row(modifier = Modifier.padding(all = 10.dp)) {
                    if (mName != null) {
                        mInputName?.let { it ->
                            OutlinedTextField(value = it, onValueChange = {mInputName = it} , label = { Text(
                                text = "Name"
                            )},modifier = Modifier.fillMaxWidth())
                        }
                    }
                }

                Row(modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth()) {
                    if (mName != null) {
                        mInputDes?.let { it ->
                            OutlinedTextField(value = it, onValueChange = {mInputDes = it} , label = { Text(
                                text = "Description"
                            )},modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
                Row(
                    Modifier
                        .padding(all = 10.dp)
                        .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Button(onClick = {
                        val intent = Intent()
                        intent.putExtra("NAME",mInputName )
                        intent.putExtra("DESCRIPTION",mInputDes )
                        activity.setResult(RESULT_OK, intent)
                        activity.finish() }) {
                        Text(text = "Submit")
                    }

                }
            }

        })
}

@Preview
@Composable
fun getPreview(){
    mData()
}

