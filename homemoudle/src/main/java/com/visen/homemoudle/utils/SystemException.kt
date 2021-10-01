package com.visen.homemoudle.utils

/**
 * Created by Jackson Fu on 15/7/7.
 */
class SystemException : RuntimeException {
    constructor() {}
    constructor(detailMessage: String?) : super(detailMessage) {}
    constructor(detailMessage: String?, throwable: Throwable?) : super(detailMessage, throwable) {}
    constructor(throwable: Throwable?) : super(throwable) {}
}