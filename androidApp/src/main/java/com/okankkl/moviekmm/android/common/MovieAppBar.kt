package com.okankkl.moviekmm.android.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieAppBar(
    modifier : Modifier = Modifier,
    canNavigateBack : Boolean,
    currentScreen : Destination,
    onNavigateBack : () -> Unit
){

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.primary
    ){
        Row(
            modifier = modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            AnimatedVisibility(visible = canNavigateBack) {
                IconButton(onClick = onNavigateBack){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }

            }
            Spacer(modifier = modifier.width(10.dp))
            Text(
                text = currentScreen.title,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontSize = 20.sp
                ),
                modifier = modifier,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }


}