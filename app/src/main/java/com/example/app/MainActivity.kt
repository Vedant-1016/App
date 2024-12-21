package com.example.app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Red) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_sam),
                        from = "Vedant"
                    )

                }


            }
        }
    }
}


@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.birthdaybackground)
    Box(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            alpha = 0.8F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp) //Isme jo padding hai woh poore dono text ko group karke diya hai
        )
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 48.sp,  // Reduced font size
            lineHeight = 52.sp,
            textAlign = TextAlign.Center,
            color = Color.Black  // Added for better visibility
        )
        Text(
            text = from,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.SansSerif,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp) // Yeh wala individual from text ka padding hai
                .align(alignment = Alignment.CenterHorizontally),
            color = Color.Black  // Added for better visibility
        )
    }
}

@Preview
@Composable
fun birthdaygreeting() {
    AppTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_sam),
            from = stringResource(R.string.signature_text)
        )
    }
}
