package com.plazafyi.errors

open class PlazaException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
