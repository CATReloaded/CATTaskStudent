package cat.reloaded.tasks.datasource

import cat.reloaded.tasks.models.requests.SignUpRequest
import cat.reloaded.tasks.models.responses.SignUpResponse

interface AuthenticationSource {
    suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse
}