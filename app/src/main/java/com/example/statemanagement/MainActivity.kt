package com.example.statemanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.statemanagement.ui.theme.StateManagementTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val count = remember { mutableStateOf(0) }
            Greeting(count.value, increaseCount = {
                count.value++
            })
            {
                count.value = 0
            }
        }
    }
}

@Composable
fun Greeting(count: Int, increaseCount: () -> Unit, resetFunction: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("You have sent $count notifications")
        Button(onClick = increaseCount, colors = ButtonDefaults.buttonColors(Color.Blue)) {
            Text("Send Notification")
        }
        MessageBar(count)
        Button(onClick = resetFunction, colors = ButtonDefaults.buttonColors(Color.Blue)) {
            Text("Rest")
        }
    }
}
@Composable
fun MessageBar(count: Int){
    Card {
        Text("Message sent: $count")
    }
}