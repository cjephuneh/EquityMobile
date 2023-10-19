package com.dev.chacha.transaction.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TransactViewModel : ViewModel(){
    private val _shouldShowDialog = mutableStateOf(true)
    val shouldShowDialog: State<Boolean> = _shouldShowDialog

    fun setShowDialogState(value: Boolean) {
        _shouldShowDialog.value = value
    }

    private val _newTransactUiState = MutableStateFlow(NewTransactUiState())
    val newTransactUiState = _newTransactUiState.asStateFlow()

    var newProduct: SendMoneyItem? by mutableStateOf(null)
        private set

    var isAllSelected by mutableStateOf(false)
        private set


    var isRemittanceCategorySelected by mutableStateOf(false)
        private set

    init {
        loadProducts()
        loadCategories()
        selectDefaultCategory()
    }

    fun onEvent(event: TransactionListEvent) {
        when (event) {
            TransactionListEvent.OnLoadCategories -> {
                viewModelScope.launch { loadCategories() }
            }

            TransactionListEvent.OnLoadProducts -> {
                viewModelScope.launch { loadProducts() }
            }

            is TransactionListEvent.ProductLoaded -> {
                _newTransactUiState.update { state ->
                    state.copy(transactProducts = event.products)
                }
            }

            is TransactionListEvent.OnSelectedProduct -> {
                _newTransactUiState.update {
                    it.copy(selectedProduct = event.product)
                }
            }

        }
    }

    private fun loadProducts() {
        // Simulate loading products from a data source. Replace this with your actual data loading logic.
        val products = all +  sendMoneyList + payWithEquityList + buyAirtime + withdrawCashList + remittanceItemList
        _newTransactUiState.value = _newTransactUiState.value.copy(transactProducts = products)
    }

    private fun loadCategories() {
        _newTransactUiState.update { state ->
            state.copy(transactProductCategories = state.transactProducts.map { it.category }.toSet())
        }
    }

    fun selectCategory(category: String) {
        _newTransactUiState.update { state ->
            state.copy(selectedCategory = category)
        }
    }




    private fun selectDefaultCategory() {
        _newTransactUiState.update { state ->
            if (state.selectedCategory == null && state.categories.isNotEmpty()) {
                state.copy(selectedCategory = state.categories.first())
            } else {
                state
            }
        }
    }
}