package cat.reloaded.tasks.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Client {
    private val baseUrl = "http://rhat0o.pythonanywhere.com/"
    private var retrofitClient: Retrofit? = null
    fun getInstance(): Retrofit {
        return retrofitClient?.let { it } ?: kotlin.run {
            Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
                .baseUrl(baseUrl)
                .build().also { retrofitClient = it }
        }
    }
}