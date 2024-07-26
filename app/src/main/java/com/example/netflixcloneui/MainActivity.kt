package com.example.netflixcloneui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixcloneui.ui.theme.NetflixCloneUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
      Column(modifier = Modifier
          .fillMaxSize()
          .background(Color.Black)
          .verticalScroll(rememberScrollState())) {
          TopAppSection()
          ContentChooser()
          FeaturedMovie()
          AddMovieList(movieName = "Watch it Again")
          AddMovieList(movieName = "Drama Movies")
          AddMovieList(movieName = "Action Movies")
          AddMovieList(movieName = "Romantic Movies")
      }
        }
    }
    @Composable
    fun TopAppSection(){
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .height(60.dp)
                .padding(top = 6.dp)
                , horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment= Alignment.CenterVertically
          
        ) {
            Image(painter = painterResource(id = R.drawable.netflix), contentDescription = "netflix logo")
            Row {
            Image(painter = painterResource(id = R.drawable.ic_search_icon), contentDescription = "search logo")
            Image(painter = painterResource(id = R.drawable.user), contentDescription = "user logo", modifier = Modifier.padding(start=15.dp,end=6.dp))
            }
        }
    }
    @Composable
    fun ContentChooser(){
Row(
    modifier= Modifier
        .fillMaxWidth()
        .height(40.dp)
        .background(Color.Black)
        .padding(top = 12.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
) {
    Text(text = "TV Shows",color=Color.LightGray, fontSize = 20.sp, modifier = Modifier.padding(start=10.dp))
    Text(text="Movies",color=Color.LightGray, fontSize = 20.sp)

Row{
    Text(text = "Categories",color=Color.LightGray, fontSize = 20.sp)
    Image(painter = painterResource(id = R.drawable.icon_drop), contentDescription ="drop icon",modifier=Modifier.padding(end=7.dp) )
}
}
    }
    @Composable
    fun FeaturedMovie() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Image(
                painter = painterResource(id = R.drawable.movie1),
                contentDescription = "image 1",
                modifier = Modifier.height(280.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 80.dp, end = 80.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Adventure", fontSize = 15.sp, color = Color.White)
                Text(text = "Thriller", fontSize = 15.sp, color = Color.White)
                Text(text = "Drama", fontSize = 15.sp, color = Color.White)
                Text(text = "Indian", fontSize = 15.sp, color = Color.White)
            }
            Row(
                modifier = Modifier
                    .padding(top = 25.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(start = 60.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_plus_icon),
                        contentDescription = "plus"
                    )
                    Text(text = "My List", color = Color.White, fontSize = 14.sp)
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(text = "Play", color = Color.Black, fontSize = 20.sp)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(end = 60.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_info_icon),
                        contentDescription = "info"
                    )
                    Text(text = "Info", color = Color.White, fontSize = 14.sp)
                }
            }
        }
    }
    @Composable
    fun AddMovieList(
        movieName:String
    ){
   val movieList=getRandomMovie()
        Column (
            modifier= Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(top = 20.dp)
        ){
            Text(text = movieName,color=Color.LightGray, fontSize = 24.sp,
                fontWeight = FontWeight.Bold,modifier=Modifier.padding(start=10.dp))
            LazyRow {
                itemsIndexed(movieList){index, item ->
                    MovieItemUI(ImageRes = item.ImageRes)
                }
            }
        }
    }
        @Composable
        fun MovieItemUI(
            ImageRes:Int
        ){
 Image(painter = painterResource(id = ImageRes), contentDescription = "movie 1",
    modifier= Modifier
        .height(220.dp)
        .width(120.dp))

    }
    fun getRandomMovie():List<movieItem>{
        val movieList= mutableListOf<movieItem>()
        movieList.add(movieItem(R.drawable.godfather))
        movieList.add(movieItem(R.drawable.movie2))
        movieList.add(movieItem(R.drawable.movie3))
        movieList.add(movieItem(R.drawable.movie4))
        movieList.add(movieItem(R.drawable.movie5))
        movieList.add(movieItem(R.drawable.batman))
        movieList.add(movieItem(R.drawable.pushpa))
        movieList.add(movieItem(R.drawable.sharukh))
        movieList.add(movieItem(R.drawable.anna))
        movieList.shuffle()
        return movieList
    }
}
data class movieItem(
    val ImageRes:Int
)
