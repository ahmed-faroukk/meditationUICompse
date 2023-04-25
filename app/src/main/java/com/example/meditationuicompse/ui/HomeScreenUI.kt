package com.example.meditationuicompse.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationuicompse.BottomMenuContent
import com.example.meditationuicompse.Features
import com.example.meditationuicompse.R
import com.example.meditationuicompse.ui.theme.*

@Composable
fun HomeScreen() {
    val feature1 = Features("sleep meditation", R.drawable.ic_headphone, BlueViolet2)
    val feature2 = Features("Tips for sleeping", R.drawable.ic_videocam, LightGreen2)
    val feature3 = Features("Night island ", R.drawable.ic_headphone, OrangeYellow2)
    val feature4 = Features("Calming sounds", R.drawable.ic_headphone, Beige2)
    val feature5 = Features("sleep meditation", R.drawable.ic_headphone, BlueViolet2)
    val feature6 = Features("Tips for sleeping", R.drawable.ic_videocam, LightGreen2)
    val feature7 = Features("Night island ", R.drawable.ic_headphone, OrangeYellow2)
    val feature8 = Features("Calming sounds", R.drawable.ic_headphone, Beige2)
    val featureList = listOf(feature1,
        feature2,
        feature3,
        feature4,
        feature5,
        feature6,
        feature7,
        feature8)
    val menuItem1 = BottomMenuContent("Home", R.drawable.ic_home)
    val menuItem2 = BottomMenuContent("Meditate", R.drawable.ic_bubble)
    val menuItem3 = BottomMenuContent("Sleep", R.drawable.ic_moon)
    val menuItem4 = BottomMenuContent("Music", R.drawable.ic_music)
    val menuItem5 = BottomMenuContent("Profile", R.drawable.ic_profile)
    val bottomMenu = listOf(menuItem1 , menuItem2 ,menuItem3 ,menuItem4,menuItem5)
    Box(Modifier
        .fillMaxSize()
        .background(DeepBlue).padding(25.dp)
    ) {

        Column {
            GreetingSection(name = "Ahmed ")
            chipSection(Chips = listOf("Sweet sleep", "Insomnia", "Depression", "silent Mood"))
            currentMeditation()
            FeaturesSection(feature = featureList )
            BottomMenu(items = bottomMenu , modifier = Modifier.padding(top = 15.dp) )


        }

    }
}

@Composable
fun GreetingSection(name: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        Column {
            Text(text = "Good Morning, $name",
                style = MaterialTheme.typography.h5, color = Color.White)
            Text(text = "we wish you have a good day",
                style = MaterialTheme.typography.body1,
                color = Color.Gray)
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search",
            tint = Color.White,
            modifier = Modifier.size(25.dp)
        )
    }
}

// recyclerview
@Composable
fun chipSection(Chips: List<String>) {

    var selectedChapIndex by remember {
        mutableStateOf(Chips[0])
    }
    LazyRow(
        Modifier.padding(top = 25.dp)
    ) {
        items(items = Chips) {

            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clickable {
                        selectedChapIndex = it
                    }
                    .background(
                        if (selectedChapIndex == it)
                            DarkerButtonBlue
                        else ButtonBlue, shape = RoundedCornerShape(10.dp)
                    )
                    .padding(20.dp)


            )
            {
                Text(text = it, color = Color.White)
            }
            Spacer(modifier = Modifier.width(15.dp))
        }
    }
}

@Composable
fun currentMeditation(
    color: Color = LightRed,
) {
    Row(
        Modifier
            .padding(top = 35.dp)
            .fillMaxWidth()
            .background(color, shape = RoundedCornerShape(10.dp))
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column {
            Text(text = "Daily Thought", style = MaterialTheme.typography.h5, color = Color.White)
            Row {
                Text(text = "Meditation",
                    style = MaterialTheme.typography.body1,
                    color = Color.White)
                Text(text = ". 3-10 MIN",
                    style = MaterialTheme.typography.body1,
                    color = Color.White)
            }
        }
        Box(
            Modifier
                .background(DeepBlue, shape = CircleShape)
                .padding(10.dp)

        ) {
            val pauseId = painterResource(id = R.drawable.ic_baseline_pause_24)
            val startId = painterResource(id = R.drawable.ic_play)
            var isPlaying by remember {
                mutableStateOf(true)
            }


            Icon(painter = if (isPlaying) pauseId else startId,
                contentDescription = "play music btn",
                tint = TextWhite,
                modifier = Modifier
                    .size(16.dp)
                    .clickable {
                        isPlaying = !isPlaying
                    }
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeaturesSection(feature: List<Features>) {
    Column(Modifier.padding(top = 10.dp).height(355.dp)) {
        Text(text = "Featured", style = MaterialTheme.typography.h5, color = Color.White , fontWeight = FontWeight.Bold , modifier = Modifier.padding(bottom = 10.dp))
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
        ) {
            items(feature) {
                Box(Modifier
                    .padding( end = 8.dp , bottom = 8.dp)
                    .background(it.background, shape = RoundedCornerShape(10.dp))
                    .size(170.dp)
                    .padding(18.dp)) {
                    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
                        Text(text = it.title,
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {
                                // handle the click
                            })


                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            Icon(painter = painterResource(id = it.iconId),
                                contentDescription = "",
                                tint = Color.White, modifier = Modifier.size(25.dp))

                            Button(onClick = {
                                /*TODO*/
                            },
                                Modifier
                                    .clip(RoundedCornerShape(9.dp))
                                    .size(width = 60.dp, height = 35.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = DeepBlue)) {
                                Text(text = "start",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold)
                            }


                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomMenu(
    items : List<BottomMenuContent>,
    modifier:Modifier = Modifier,
    activeHighlightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color = AquaBlue,
    initialSelectedItemIndex : Int = 0
){
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(modifier = modifier
        .background(DeepBlue).fillMaxWidth()
        , horizontalArrangement = Arrangement.SpaceAround ,
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(item = item, isSelected = index == selectedItemIndex
            ,activeHighlightColor = activeHighlightColor ,
            activeTextColor = activeTextColor ,
            inactiveTextColor = inactiveTextColor) {
                selectedItemIndex = index
            }

        }

    }



}
@Composable
fun BottomMenuItem(
    item : BottomMenuContent,
    isSelected : Boolean,
    activeHighlightColor : Color = ButtonBlue,
    activeTextColor : Color = Color.White,
    inactiveTextColor : Color = AquaBlue,
    onItemClick : () -> Unit
){
    var tint by remember {
        mutableStateOf(inactiveTextColor)
    }
    var boxBackground by remember {
        mutableStateOf(Color.Transparent)
    }
    if (isSelected) {
        tint = activeTextColor
        boxBackground = activeHighlightColor

    }else{
        tint = inactiveTextColor
        boxBackground = Color.Transparent
    }

    Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally ) {
        Box(Modifier.background(boxBackground , shape = RoundedCornerShape(12.dp))
            .size(35.dp).padding(5.dp).clickable {
                onItemClick()
            }) {
                Icon(painter = painterResource(id = item.icon),
                    contentDescription = item.title , tint = tint  )
        }
        Text(text = item.title, color = tint,
            fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }

}