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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.FitnessAppTheme
import com.example.fitnessapp.ui.theme.LoginTitleStyle
import com.example.fitnessapp.ui.theme.LoginSubtitleStyle
import com.example.fitnessapp.ui.theme.LoginButtonStyle

@Composable
fun LoginScreen(
    onBack: () -> Unit = {},
    onLoginSuccess: () -> Unit = {},
    onRegister: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize().background(colorResource(R.color.login_background)),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.login_card)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    TextButton(onClick = onBack) {
                        Text(
                            text = stringResource(R.string.login_back),
                            color = colorResource(R.color.login_button)
                        )
                    }
                }

                Image(
                    painter = painterResource(R.drawable.dumbbell_logo),
                    contentDescription = stringResource(
                        R.string.logo_description
                    ),
                    modifier = Modifier.size(80.dp)
                )

                Text(
                    text = stringResource(R.string.login_title),
                    style = LoginTitleStyle,
                    color = colorResource(R.color.login_text)
                )

                Text(
                    text = stringResource(R.string.login_subtitle),
                    style = LoginSubtitleStyle,
                    color = colorResource(R.color.login_secondary_text)
                )

                Spacer(Modifier.height(8.dp))

                OutlinedTextField(value = email, onValueChange = { email = it },
                    label = {
                        Text(stringResource(R.string.login_email))
                    },
                    modifier = Modifier.fillMaxWidth(), singleLine = true, shape = RoundedCornerShape(14.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )

                OutlinedTextField(
                    value = password, onValueChange = { password = it },
                    label = {
                        Text(stringResource(R.string.login_password))
                    },
                    modifier = Modifier.fillMaxWidth(), singleLine = true,
                    shape = RoundedCornerShape(14.dp), visualTransformation = PasswordVisualTransformation()
                )

                Spacer(Modifier.height(4.dp))

                Button(
                    onClick = onLoginSuccess, modifier = Modifier.fillMaxWidth().height(52.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.login_button)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.login_button),
                        style = LoginButtonStyle
                    )
                }

                TextButton(onClick = onRegister) {
                    Text(
                        text = stringResource(R.string.login_no_account),
                        color = colorResource(R.color.login_secondary_text)
                    )

                    Text(
                        text = " " + stringResource(R.string.login_register),
                        color = colorResource(R.color.login_button)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    FitnessAppTheme {
        LoginScreen()
    }
}