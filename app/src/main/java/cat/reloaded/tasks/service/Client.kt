package cat.reloaded.tasks.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Client {
    private val baseUrl = "http://rhat0o.pythonanywhere.com/"
    private var retrofitClient: Retrofit? = null
    private var service: ApiService? = null
    private fun getInstance() = retrofitClient?.let { it } ?: kotlin.run {
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .build().also { retrofitClient = it }
    }

    fun getCatService() = service?.let { it } ?: kotlin.run {
        getInstance().create(ApiService::class.java).also { service = it }
    }
}