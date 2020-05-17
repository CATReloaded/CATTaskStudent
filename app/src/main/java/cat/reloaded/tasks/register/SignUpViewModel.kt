package cat.reloaded.tasks.register

import androidx.lifecycle.MutableLiveData
import cat.reloaded.tasks.base.BaseViewModel
import cat.reloaded.tasks.models.requests.SignUpRequest
import kotlinx.coroutines.launch

internal class SignUpViewModel(private val signUpUseCase: SignUpUseCase) :
    BaseViewModel<SignUpViewAction>() {

    private val _viewState = MutableLiveData<SignUpViewState>()

    override fun processAction(viewAction: SignUpViewAction) {
        signUp(viewAction.signUpRequest)
    }

    private fun signUp(signUpRequest: SignUpRequest) = launch {
        postState(signUpUseCase(signUpRequest))
    }

    private fun postState(viewState: SignUpViewState) {
        _viewState.postValue(viewState)
    }
}