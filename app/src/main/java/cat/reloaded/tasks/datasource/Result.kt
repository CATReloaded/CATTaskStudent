package cat.reloaded.tasks.datasource

sealed class Result<T> {
    class Success<T>(val data: T) : Result<T>()
    class Error(val error: Throwable) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[error=$error]"
        }
    }
}