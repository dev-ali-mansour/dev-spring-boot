package dev.alimansour.aopdemo.service

interface TrafficFortuneService {
    fun getFortune(): String
    fun getFortune(tripWire: Boolean): String
}
