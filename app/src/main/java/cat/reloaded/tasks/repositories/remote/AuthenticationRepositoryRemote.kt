package cat.reloaded.tasks.repositories.remote

import cat.reloaded.tasks.models.requests.SignUpRequest
import cat.reloaded.tasks.models.responses.SignUpResponse
import cat.reloaded.tasks.repositories.AuthenticationRepository

class AuthenticationRepositoryRemote : AuthenticationRepository {
    override suspend fun signUp(request: SignUpRequest): SignUpResponse {
        return SignUpResponse("success")
    }
}