package com.seyma.simplecompose.ui.theme

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text

/**
 * @since 27.12.2021
 * @author Seyma_android
 */
class More : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent { 
            Text(text = "Welcome my home")
        }
    }
}