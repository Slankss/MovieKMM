package com.okankkl.moviekmm.android.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.okankkl.moviekmm.android.R

@Composable
fun DetailScreen(
    modifier : Modifier = Modifier,
    state : DetailScreenState,
    navigateToHome : () -> Unit
){

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        state.movie?.let { movie ->
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
            ){
                item {
                    AsyncImage(
                        model = movie.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .fillMaxWidth()
                            .height(320.dp)
                    )
                }

                item {
                    Column(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ){
                        Text(
                            text = movie.title,
                            style = MaterialTheme.typography.headlineLarge.copy(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {},
                            modifier = modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Red
                            ),
                            elevation = ButtonDefaults.buttonElevation(defaultElevation = 1.dp)
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.play_button),
                                contentDescription = null,
                                tint = Color.White
                            )

                            Spacer(modifier = modifier.width(8.dp))

                            Text(text = "Start watching now",color = Color.White)
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Released in ${movie.releaseDate}".toUpperCase(),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = movie.description,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                textAlign = TextAlign.Justify
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
        if(state.loading) CircularProgressIndicator()
        if(state.error != null){
            Text(
                text = state.error!!,
                color = Color.White,
                fontSize = 18.sp
            )
        }

    }



}