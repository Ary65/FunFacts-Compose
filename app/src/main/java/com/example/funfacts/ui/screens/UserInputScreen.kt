package com.example.funfacts.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.funfacts.R
import com.example.funfacts.data.UserDataUiEvents
import com.example.funfacts.ui.AnimalCard
import com.example.funfacts.ui.ButtonComponent
import com.example.funfacts.ui.TextComponent
import com.example.funfacts.ui.TextFieldComponent
import com.example.funfacts.ui.TopBar
import com.example.funfacts.ui.UserInputViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface(modifier = Modifier.fillMaxSize()) {
//        val keyboardController = LocalSoftwareKeyboardController.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
//                .clickable {
//                    keyboardController?.hide()
//                }
        ) {
            TopBar(value = "Hi There! 😊")

            TextComponent(
                textValue = "Let's learn about you",
                textSize = 24.sp
            )
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This App will prepare a details page based on input provided by you",
                textSize = 18.sp
            )
            Spacer(modifier = Modifier.size(30.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(
                onTextChanged = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.UserNameEntered(it)
                    )
                }
            )
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like?", textSize = 18.sp)

            Row {
                AnimalCard(
                    image = R.drawable.catr, animalSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    },
                    selected = userInputViewModel.uiState.value.animalSelected == "Cat"
                )

                AnimalCard(
                    image = R.drawable.dogr, animalSelected = {
                        userInputViewModel.onEvent(
                            UserDataUiEvents.AnimalSelected(it)
                        )
                    },
                    selected = userInputViewModel.uiState.value.animalSelected == "Dog"
                )

            }
            Spacer(modifier = Modifier.weight(1f))
            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    ggoToDetailsScreen = {
                        println("======Cming here")
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputPreview() {
    UserInputScreen(UserInputViewModel())
    TextComponent(
        textValue = "Let's learn about you",
        textSize = 24.sp
    )
}