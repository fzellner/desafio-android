package com.picpay.desafio.android.domain.exception

open class Failure : Throwable() {
    object NetworkException : Throwable()
    object ServerError : Throwable()
    object ClientError : Throwable()
    object GenericError : Throwable()
}