import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Compose for Desktop",
        state = rememberWindowState(width = 500.dp, height = 500.dp)
    ) {
        val count = remember { mutableStateOf(0) }
        var text by remember { mutableStateOf("I'm Ready") }
        // Define a color for the button background
        val buttonBackgroundColor = if (count.value == 0) Color.Blue else Color.Red
        MaterialTheme {
            Column(Modifier.fillMaxSize(), Arrangement.spacedBy(100.dp)) {
                Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        count.value++
                        text = "Here we go for the ${count.value} times"
                    },
                        colors = ButtonDefaults.buttonColors(buttonBackgroundColor)
                ) {
                    Text(if (count.value == 0) "Hello World" else "Clicked ${count.value}!")
                }
                Button(modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = {
                        text = "I'm Ready"
                        count.value = 0
                    }) {
                    Text("Reset")
                }
                Text(text, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    }
}