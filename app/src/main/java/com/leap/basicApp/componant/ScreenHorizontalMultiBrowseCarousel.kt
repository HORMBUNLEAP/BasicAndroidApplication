package com.leap.basicApp.componant

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.carousel.HorizontalMultiBrowseCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leap.basicApp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.carousel.CarouselDefaults
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHorizontalMultiBrowseCarousel() {
    data class ItemModel(
        val id : Int,
        val title: String,
        val description: String,
        @DrawableRes val image: Int,

    )
    val list: List<ItemModel> = listOf(
        ItemModel(
            id = 1,
            title = "Wallpaper",
            description = "4k Display",
            image = R.drawable.img_1,
        ),
        ItemModel(
            id = 2,
            title = "Wallpaper 2",
            description = "4k Display",
            image = R.drawable.img_2,
        ),
        ItemModel(
            id = 3,
            title = "Wallpaper 3",
            description = "4k Display",
            image = R.drawable.img_3,
        ),
        ItemModel(
            id = 4,
            title = "Wallpaper 4",
            description = "4k Display",
            image = R.drawable.img_4,
        ),
        ItemModel(
            id = 5,
            title = "Wallpaper 5",
            description = "4k Display",
            image = R.drawable.img_5,
        ),
        ItemModel(
            id = 6,
            title = "Wallpaper 6",
            description = "4k Display",
            image = R.drawable.img_6,
        )
    )

    val  carouselState = rememberCarouselState(
        initialItem = 0,
        itemCount = {list.size},
    )
    val  carouselStateUncentain = rememberCarouselState(
        initialItem = 0,
        itemCount = {list.size},
    )
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        text = "HorizontalMultiBrowseCarousel"
                    )

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    navigationIconContentColor = colorResource(R.color.purple_700)
                )
            )
        },

    ) {padding->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            HorizontalMultiBrowseCarousel(
                state = carouselState,
                preferredItemWidth = 186.dp,
                itemSpacing = 16.dp,
                flingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(
                    state = carouselState,
                    snapAnimationSpec = spring()
                ),
                contentPadding = PaddingValues(10.dp)

            ) {index ->
                val card = list[index]
                Box(
                    modifier = Modifier
                         .wrapContentSize(),

                ) {
                    Image(
                        modifier = Modifier
                            .height(205.dp)
                            .fillMaxSize(),
                        painter = painterResource(card.image),
                        contentDescription =card.description
                    )
                }
            }
            HorizontalUncontainedCarousel (
                state = carouselStateUncentain,
                itemWidth = 245.dp,
                itemSpacing = 16.dp,
                flingBehavior = CarouselDefaults.singleAdvanceFlingBehavior(
                    state = carouselStateUncentain,
                    snapAnimationSpec = spring()
                ),
                contentPadding = PaddingValues(10.dp)

            ) {index ->
                val card = list[index]
                Box(
                    modifier = Modifier
                        .wrapContentSize(),

                    ) {
                    Image(
                        modifier = Modifier
                            .height(205.dp)
                            .fillMaxSize(),
                        painter = painterResource(card.image),
                        contentDescription =card.description
                    )
                }
            }

        }

    }
}
@Preview(showBackground = false)
@Composable
fun ScreenHorizontalMultiBrowseCarouselPerview(){
    ScreenHorizontalMultiBrowseCarousel()

}