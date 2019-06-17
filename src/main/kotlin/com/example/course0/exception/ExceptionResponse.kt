package com.example.course0.exception

import java.time.LocalDate

data class ExceptionResponse(var timeStamp: LocalDate, var message: String?, var details: String?)