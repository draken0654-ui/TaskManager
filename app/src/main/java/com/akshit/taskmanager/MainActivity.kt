package com.akshit.taskmanager

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.akshit.taskmanager.ui.theme.TaskManagerTheme
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Surface() {
                    Center_image(
                        task = "Android",
                        work = "u"
                    )
                }
            }
        }
    }
}

@Composable
fun Manager(task: String, work: String, modifier: Modifier = Modifier) {
    Column(
            horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = task,
            fontWeight = Bold,
            modifier= Modifier.padding(top= 24.dp, bottom = 8.dp)

        )
        Text(
            text = work,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        Center_image(task= "All task completed", work= "Nice work")
    }
}

@Composable
fun Center_image(task: String, work: String){
    val ima= painterResource(R.drawable.ic_task_completed)
  Column(modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center) {
      Image(
          painter = ima,
          contentDescription = null,
          alignment= Alignment.Center
      )
      Manager(
          task = task,
          work = work
      )
  }
}