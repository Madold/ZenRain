package com.markusw.onboarding.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.markusw.onboarding.R

@Composable
fun OnBoardingScreen(
    mainNavController: NavController,
    modifier: Modifier = Modifier
) {

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
                    .fillMaxSize()
                ,
                contentScale = ContentScale.Crop
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
internal fun OnBoardingScreenPreview(modifier: Modifier = Modifier) {
    OnBoardingScreen(
        mainNavController = rememberNavController()
    )
}