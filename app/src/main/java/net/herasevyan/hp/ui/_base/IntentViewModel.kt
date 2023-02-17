package net.herasevyan.hp.ui._base

import androidx.lifecycle.ViewModel

abstract class IntentViewModel : ViewModel() {

    init {
        handleIntent()
    }

    protected abstract fun handleIntent()
}