package cat.reloaded.tasks.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<VA : ViewAction> : ViewModel() {
    abstract fun processAction(viewAction: VA)
}