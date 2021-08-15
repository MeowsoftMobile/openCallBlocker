package com.meowsoft.callblocker.application.blocked

import com.meowsoft.callblocker.application.FlowableUseCaseWithoutParam
import com.meowsoft.callblocker.domain.CallLog

interface GetBlockedCalls : FlowableUseCaseWithoutParam<List<CallLog>>