package com.markusw.onboarding.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.markusw.core.presentation.composables.Button
import com.markusw.core.presentation.theme.ZenRainTheme
import com.markusw.core.presentation.theme.spacing
import com.markusw.onboarding.R
import kotlinx.coroutines.delay

@Composable
fun OnBoardingScreen(
    mainNavController: NavController,
    modifier: Modifier = Modifier
) {

    var isTitleVisible by rememberSaveable {
        mutableStateOf(false)
    }
    var isDescriptionVisible by rememberSaveable {
        mutableStateOf(false)
    }
    var isButtonVisible by rememberSaveable {
        mutableStateOf(false)
    }


    LaunchedEffect(key1 = Unit) {
        delay(300)
        isTitleVisible = true
        delay(1200)
        isDescriptionVisible = true
        delay(1200)
        isButtonVisible = true
    }

    Scaffold(
        modifier = modifier,
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding),
        ) {

            Image(
                painter = painterResource(id = R.drawable.landscape_1),
                contentDescription = stringResource(id = R.string.onboarding_image_description),
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.spacing.medium),
                verticalArrangement = Arrangement.Bottom
            ) {
                AnimatedVisibility(
                    visible = isTitleVisible,
                    enter = slideInVertically(initialOffsetY = { it }) + fadeIn()
                ) {
                    Text(
                        text = "Relaxing Sounds",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                AnimatedVisibility(
                    visible = isDescriptionVisible,
                    enter = slideInVertically(initialOffsetY = { it }) + fadeIn()
                ) {
                    Text(
                        text = "Get access to our full library of relaxing sounds to help you sleep better :)",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White,
                    )
                }

                Spacer(modifier = Modifier.height(64.dp))

                AnimatedVisibility(
                    visible = isButtonVisible,
                    enter = slideInVertically(initialOffsetY = { it }) + fadeIn()
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = { }) {
                            Text(
                                text = "Start",
                                style = MaterialTheme.typography.titleSmall.copy(fontSize = 18.sp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))


            }

        }
    }

}

@Preview(showBackground = true)
@Composable
internal fun OnBoardingScreenPreview(modifier: Modifier = Modifier) {
    ZenRainTheme(
        darkTheme = false,
        dynamicColor = false
    ) {
        Surface {
            OnBoardingScreen(
                mainNavController = rememberNavController()
            )
        }
    }
}