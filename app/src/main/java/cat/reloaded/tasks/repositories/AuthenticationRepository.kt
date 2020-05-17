package cat.reloaded.tasks.repositories

import cat.reloaded.tasks.models.requests.SignUpRequest
import cat.reloaded.tasks.models.responses.SignUpResponse

interface AuthenticationRepository {
    suspend fun signUp(request: SignUpRequest): SignUpResponse
}