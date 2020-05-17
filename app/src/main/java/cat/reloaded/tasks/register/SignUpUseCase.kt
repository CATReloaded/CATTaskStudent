package cat.reloaded.tasks.register

import cat.reloaded.tasks.datasource.Result
import cat.reloaded.tasks.models.requests.SignUpRequest
import cat.reloaded.tasks.repositories.AuthenticationRepository

class SignUpUseCase(private val repo: AuthenticationRepository) {
    suspend operator fun invoke(signUpRequest: SignUpRequest) {
        when (val result = repo.signUp(signUpRequest)) {
            is Result.Success -> {
                // TODO return view state with the success
            }
            is Result.Error -> {
                // TODO return view state with the error
            }
        }
    }
}