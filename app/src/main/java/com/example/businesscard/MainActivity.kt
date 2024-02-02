package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image, contentDescription = null, Modifier.fillMaxWidth(0.3f)
        )
        Text(text = stringResource(R.string.full_name), fontSize = 50.sp, color = Color.White)
        Text(text = stringResource(R.string.title), fontSize = 25.sp, color = Green)
        Spacer(modifier = Modifier.padding(bottom = 200.dp))
        Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = stringResource(R.string.phone),
            textBlur = 5.dp,
            icon = Icons.Rounded.Phone
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = stringResource(R.string.website), icon = Icons.Rounded.Share
        )
        Divider(modifier = Modifier.fillMaxWidth(), color = Color(0xFF4F6C79))
        ContactRow(
            text = stringResource(R.string.email), icon = Icons.Rounded.Email
        )
    }
}

@Composable
fun ContactRow(
    text: String, icon: ImageVector, textBlur: Dp = 0.dp
) {
    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Green,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text, color = Color.White, modifier = Modifier
                .weight(3f)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}