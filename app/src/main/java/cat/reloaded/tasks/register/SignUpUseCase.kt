package cat.reloaded.tasks.register

import cat.reloaded.tasks.datasource.Result
import cat.reloaded.tasks.models.requests.SignUpRequest
import cat.reloaded.tasks.repositories.AuthenticationRepository

class SignUpUseCase(private val repo: AuthenticationRepository) {
    suspend operator fun invoke(signUpRequest: SignUpRequest): SignUpViewState {
        return when (val result = repo.signUp(signUpRequest)) {
            is Result.Success -> {
                SignUpViewState(signUpResponse = result.data)
            }
            is Result.Error -> {
                SignUpViewState(error = result.error)
            }
        }
    }
}