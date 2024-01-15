package com.example.funfacts.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfacts.data.UserDataUiEvents
import com.example.funfacts.data.UserInputScreenState


class UserInputViewModel : ViewModel() {
    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {

                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
            }
        }
    }

    fun isValidState(): Boolean {
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
    }
}