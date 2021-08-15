package com.meowsoft.callblocker.application.filters

import com.meowsoft.callblocker.application.CompletableUseCaseWithParam
import com.meowsoft.callblocker.domain.Filter

interface InsertFilter : CompletableUseCaseWithParam<Filter>