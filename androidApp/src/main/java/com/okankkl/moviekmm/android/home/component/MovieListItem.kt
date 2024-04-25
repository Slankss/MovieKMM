package com.okankkl.moviekmm.android.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.okankkl.moviekmm.android.R
import com.okankkl.moviekmm.domain.model.Movie

@Composable
fun MovieListItem(
    modifier : Modifier = Modifier,
    movie : Movie,
    onMovieClick : (Movie) -> Unit
){

    Card(
        modifier = modifier
            .height(220.dp),
        shape = RoundedCornerShape(7.dp)
    ){
        Column(
        ){
            Box(
                modifier = modifier.weight(1f),
                contentAlignment = Alignment.Center
            ){
                AsyncImage(
                    model = movie.imageUrl,
                    contentDescription = movie.title,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp))
                )
                Surface(
                    color = Color.Black.copy(alpha = 0.6f),
                    modifier = modifier.size(50.dp),
                    shape = CircleShape
                ){
                    Image(
                        painter = painterResource(id = R.drawable.play_button),
                        contentDescription = "Play button",
                        modifier = modifier.padding(12.dp).align(Alignment.Center)
                    )
                }
            }
            Column(
                modifier = modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = movie.releaseDate,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Thin,
                )
            }

        }
    }

}