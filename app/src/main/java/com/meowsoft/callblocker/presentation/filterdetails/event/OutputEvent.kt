package com.meowsoft.callblocker.presentation.filterdetails.event

sealed class OutputEvent{
    object FilterCreatedEvent : OutputEvent()
}

typealias FilterCreatedEvent = OutputEvent.FilterCreatedEvent
