package cat.reloaded.tasks.datasource

interface AuthenticationSource {
    suspend fun signUp()
}