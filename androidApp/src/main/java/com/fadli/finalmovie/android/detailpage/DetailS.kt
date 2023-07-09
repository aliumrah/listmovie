package com.fadli.finalmovie.android.detailpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fadli.finalmovie.android.Green1
import com.fadli.finalmovie.android.R
import com.fadli.finalmovie.domain.model.Movie

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    uiState: DetailScreenState
) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        uiState.movie?.let { movie ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colors.background)
            ) {
                AsyncImage(
                    model = movie.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )

                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(20.dp)
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )
                    Spacer(modifier = modifier.height(8.dp))

                    Button(
                        onClick = {},
                        modifier = modifier.fillMaxWidth().height(46.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Green1
                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.play_button),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Spacer(modifier = modifier.width(8.dp))

                        Text(text = "Start watching now", color = Color.Black,
                            fontFamily = FontFamily.Serif)
                    }

                    Spacer(modifier = modifier.height(30.dp))

                    Text(
                        text = "Released in ${movie.releaseDate}".uppercase(),
                        style = MaterialTheme.typography.overline,
                        color = Color.Black,
                        fontFamily = FontFamily.Serif
                    )

                    Spacer(modifier = modifier.height(12.dp))

                    Text(text = movie.description, style = MaterialTheme.typography.body2, color = Color.Black,
                        fontFamily = FontFamily.Serif)
                }
            }
        }

        if (uiState.loading){
            Row(
                modifier = modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(
                    color = Green1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposePreview(){
    DetailScreen(
    uiState = DetailScreenState(true, Movie(1,"Amak","blalbalba","https://postimg.cc/MvPFpH4d","2,1,223"), errorMessage = "is oka")
    )
}















