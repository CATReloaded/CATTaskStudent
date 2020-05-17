package cat.reloaded.tasks.repositories.remote

import cat.reloaded.tasks.datasource.AuthenticationSource
import cat.reloaded.tasks.datasource.Result
import cat.reloaded.tasks.models.requests.SignUpRequest
import cat.reloaded.tasks.models.responses.SignUpResponse
import cat.reloaded.tasks.repositories.AuthenticationRepository

internal class AuthenticationRepositoryRemote(private val authenticationSource: AuthenticationSource) :
    AuthenticationRepository {
    override suspend fun signUp(request: SignUpRequest): Result<SignUpResponse> {
        try {
            val result = authenticationSource.signUp(signUpRequest = request)
            result.message?.let {
                return Result.Success(result)
            }
            return Result.Error(Exception("Error"))
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }
}