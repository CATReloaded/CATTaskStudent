package cat.reloaded.tasks.datasource.remote

import cat.reloaded.tasks.datasource.AuthenticationSource
import cat.reloaded.tasks.models.requests.SignUpRequest
import cat.reloaded.tasks.models.responses.SignUpResponse
import cat.reloaded.tasks.service.ApiService

class AuthenticationDateSourceRemote(private val apiService: ApiService) : AuthenticationSource {
    override suspend fun signUp(signUpRequest: SignUpRequest): SignUpResponse {
        return apiService.signUp(signUpRequest)
    }
}