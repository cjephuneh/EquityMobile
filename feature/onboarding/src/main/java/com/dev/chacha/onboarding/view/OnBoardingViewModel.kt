//package com.dev.chacha.onboarding.view
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.dev.chacha.onboarding.DataStoreRepository
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//@HiltViewModel
//class OnBoardingViewModel(
//    private val repository: DataStoreRepository
//) : ViewModel() {
//
//    fun saveOnBoardingState(completed: Boolean) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.saveOnBoardingState(completed = completed)
//        }
//    }
//
//}
