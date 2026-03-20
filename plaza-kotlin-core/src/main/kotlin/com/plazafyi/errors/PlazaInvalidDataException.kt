package com.plazafyi.errors

class PlazaInvalidDataException(message: String? = null, cause: Throwable? = null) :
    PlazaException(message, cause)
