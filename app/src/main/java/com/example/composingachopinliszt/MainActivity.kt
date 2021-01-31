package com.example.composingachopinliszt

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composingachopinliszt.ui.theme.ComposingAChopinLisztTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var shoppingList = listOf("Apple", "Milk", "Butter", "Grapes", "Onions","Bread", "Cereal", "Celery", "Beans", "Meat", "Ice cream")
        setContent {
            MyApp {
                MyScreenContent(shoppingList)
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposingAChopinLisztTheme {
        Surface(color = colorResource(R.color.pink)) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(myItems: List<String>) {
    ChopinLiszt(myItems)
}

@Composable
fun ChopinLiszt(names: List<String>) {
    LazyColumn() {
        items(items = names) { name ->
            var isSelected by remember { mutableStateOf(false) }
            val backgroundColor = if (isSelected) colorResource(R.color.baby_blue) else Color.Transparent
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = backgroundColor)
                    .clickable(onClick = { isSelected = !isSelected })
            ) {
                ImageItem()
                TextItem(name = name)
            }
            Divider(color = colorResource(R.color.teal_200))
        }
    }
}

@Composable
fun TextItem(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .padding(24.dp)
    )
}

@Composable
fun ImageItem() {
    Image(
        vectorResource(id = R.drawable.ic_android_black_24dp)
    )
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    var shoppingList = listOf("Apple", "Milk", "Butter", "Grapes", "Onions")
    MyApp {
        MyScreenContent(shoppingList)
    }
}