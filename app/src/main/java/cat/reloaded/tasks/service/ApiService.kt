package cat.reloaded.tasks.service

import cat.reloaded.tasks.models.requests.SignUpRequest
import cat.reloaded.tasks.models.responses.SignUpResponse
import retrofit2.http.POST

interface ApiService {
    @POST("/api/signup/")
    suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse
}

