package com.picpay.desafio.android.util

import com.picpay.desafio.android.domain.exception.Failure
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import org.junit.internal.runners.statements.Fail
import retrofit2.Call
import retrofit2.Response
import retrofit2.await

/**
 *
 * Function to transform safeawait into flow
 *
 */
fun <T> Deferred<Response<T>>.safeAwait(
    default: T? = null,
): Flow<T> =
    flow {
        val response = this@safeAwait.await()
        when (response.isSuccessful) {
            true -> emit((response.body() ?: (default ?: throw NullPointerException())))
            false -> throw  when (response.code()) {
                in 400..499 -> Failure.ClientError
                in 500..599 -> Failure.ServerError
                else -> Failure.GenericError
            }
        }
    }


inline fun <T, R> networkBoundResource(
    crossinline fetch: suspend () -> R,
    crossinline saveFetchResult: suspend (R) -> Unit,
    crossinline query: () -> Flow<T>,
    crossinline shouldFetch: (T) -> Boolean = { true }
) = flow {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}

