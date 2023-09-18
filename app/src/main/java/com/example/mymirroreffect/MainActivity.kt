package com.example.mymirroreffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.example.mirror.Mirror
import com.example.mymirroreffect.ui.theme.MyMirrorEffectTheme
import com.google.accompanist.coil.rememberCoilPainter

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMirrorEffectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {


                    // images are taken from Pixabay website: "https://pixabay.com/"
                    val imageUrls = listOf(
                        "https://cdn.pixabay.com/photo/2023/06/07/14/21/mountain-8047293_1280.jpg",
                        "https://cdn.pixabay.com/photo/2023/07/22/10/50/ship-8143169_1280.jpg",
                        "https://cdn.pixabay.com/photo/2018/04/12/15/51/nature-3313832_1280.jpg",
                        "https://cdn.pixabay.com/photo/2016/10/09/05/49/autumn-1725205_1280.jpg",
                        "https://cdn.pixabay.com/photo/2013/11/28/10/36/road-220058_1280.jpg",
                    )

                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize(),
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "Mirror Efect")
                                }
                            )
                        }
                    ) { paddingValue ->

                        LazyRow(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(paddingValue)
                                .padding(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            items(imageUrls) { url ->

                                Mirror(
                                    opacity = 0.89f,
                                    content = {
                                        Image(
                                            painter = rememberCoilPainter(
                                                request = ImageRequest.Builder(LocalContext.current)
                                                    .crossfade(durationMillis = 1000)
                                                    .data(url)
                                                    .placeholder(R.drawable.ic_placeholder)
                                                    .error(R.drawable.ic_placeholder)
                                                    .build()
                                            ),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .fillParentMaxWidth()
                                                .height(300.dp)
                                                .clip(RoundedCornerShape(14.dp)),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
