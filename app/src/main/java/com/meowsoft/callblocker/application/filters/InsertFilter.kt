package com.meowsoft.callblocker.application.filters

import com.meowsoft.callblocker.application.CompletableUseCaseWithParam
import com.meowsoft.callblocker.application.FlowableUseCaseWithParam
import com.meowsoft.callblocker.application.FlowableUseCaseWithoutParam
import com.meowsoft.callblocker.domain.Filter

interface InsertFilter : CompletableUseCaseWithParam<Filter>