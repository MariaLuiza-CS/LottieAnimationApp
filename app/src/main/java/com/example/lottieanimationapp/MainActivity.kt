package com.example.lottieanimationapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.lottieanimationapp.ui.theme.BackgroundButtonColor
import com.example.lottieanimationapp.ui.theme.BackgroundColor
import com.example.lottieanimationapp.ui.theme.BackgroundTextColor
import com.example.lottieanimationapp.ui.theme.LottieAnimationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        )
        setContent {
            LottieAnimationAppTheme {

                val composition =
                    rememberLottieComposition(
                        LottieCompositionSpec.RawRes(
                            R.raw.lottieanimation
                        )
                    )

                val progress by animateLottieCompositionAsState(
                    composition = composition.value,
                    iterations = LottieConstants.IterateForever
                )

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = BackgroundColor),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LottieAnimation(
                            modifier = Modifier.padding(horizontal = 30.dp, vertical = 16.dp),
                            composition = composition.value,
                            progress = { progress }
                        )
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 30.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = BackgroundButtonColor,
                                containerColor = BackgroundButtonColor
                            )
                        ) {
                            Text(
                                text = "Login",
                                color = BackgroundTextColor
                            )
                        }
                    }
                }

            }
        }
    }
}
