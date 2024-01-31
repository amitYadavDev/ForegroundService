package amitapps.media.service

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import amitapps.media.service.ui.theme.ServiceTheme
import android.content.Intent
import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.core.app.ActivityCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(Manifest.permission.POST_NOTIFICATION),
//                0
//            )
//        }
        setContent {
            ServiceTheme {
                // A surface container using the 'background' color from the theme
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Button(onClick = {
                        Intent(applicationContext, ForegroundService::class.java).also {
                            it.action = ForegroundService.Actions.START.toString()
                            startService(it)
                        }
                    }) {
                            Text(text = "Start service")
                    }
                    Button(onClick = {
                        Intent(applicationContext, ForegroundService::class.java).also {
                            it.action = ForegroundService.Actions.STOP.toString()
                            startService(it)
                        }
                    }) {
                        Text(text = "Stop service")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ServiceTheme {
        Greeting("Android")
    }
}