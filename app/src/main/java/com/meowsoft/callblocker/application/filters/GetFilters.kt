package com.meowsoft.callblocker.application.filters

import com.meowsoft.callblocker.application.FlowableUseCaseWithoutParam
import com.meowsoft.callblocker.domain.Filter

interface GetFilters : FlowableUseCaseWithoutParam<List<Filter>>