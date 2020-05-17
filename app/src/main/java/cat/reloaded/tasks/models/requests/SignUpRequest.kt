package cat.reloaded.tasks.models.requests

data class SignUpRequest(
    val userName: String,
    val password: String,
    val email: String,
    val phoneNumber: String
)