package com.example.fitnessapp.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.WelcomeButtonStyle
import com.example.fitnessapp.ui.theme.WelcomeSubtitleStyle
import com.example.fitnessapp.ui.theme.WelcomeTitleStyle

@Composable
fun WelcomeScreen(
    onLogin: () -> Unit = {}, 
    onRegister: () -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_screen_background),
            contentDescription = stringResource(R.string.welcome_background_description),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(R.color.welcome_overlay).copy(alpha = 0.5f))
        )

        Column(
            Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                painter = painterResource(id = R.drawable.dumbbell_logo),
                contentDescription = stringResource(
                    R.string.logo_description
                ),
                modifier = Modifier.size(135.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = stringResource(R.string.welcome_title),
                style = WelcomeTitleStyle,
                color = colorResource(R.color.welcome_text)
            )

            Spacer(Modifier.height(5.dp))

            Text(
                text = stringResource(R.string.welcome_subtitle),
                style = WelcomeSubtitleStyle,
                color = colorResource(R.color.welcome_text)
            )

            Spacer(Modifier.height(50.dp))

            Button(
                onLogin, Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.welcome_button),
                    contentColor = colorResource(R.color.welcome_text)
                )
            )
            {
                Text(text = stringResource(R.string.login_button),
                    style = WelcomeButtonStyle
                )
            }

            Spacer(Modifier.height(12.dp))

            OutlinedButton(
                onRegister, Modifier.fillMaxWidth().height(52.dp),
                shape = RoundedCornerShape(14.dp)
            )
            {
                Text(text = stringResource(R.string.register_button),
                    style = WelcomeButtonStyle,
                    color = colorResource(R.color.welcome_text)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    FitnessAppTheme {
        WelcomeScreen()
    }
}

