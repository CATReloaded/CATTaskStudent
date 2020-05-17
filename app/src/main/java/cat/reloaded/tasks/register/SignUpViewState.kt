package cat.reloaded.tasks.register

import cat.reloaded.tasks.base.BaseViewState
import cat.reloaded.tasks.models.responses.SignUpResponse

data class SignUpViewState(
    private val loading: Boolean = false,
    private val error: Throwable? = null,
    private val signUpResponse: SignUpResponse? = null
) : BaseViewState()