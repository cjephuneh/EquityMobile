package com.dev.chacha.onboarding.onboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.chacha.onboarding.onboard.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {
    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveOnBoardingState(completed = completed)
        }
    }

    fun isOnBoardingCompleted(): Flow<Boolean> {
        return repository.readOnBoardingState()
    }

}
