package dev.alimansour.aopdemo.service

import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class TrafficFortuneServiceImpl : TrafficFortuneService {
    override fun getFortune(): String {
        runCatching {
            TimeUnit.SECONDS.sleep(5)
        }.onFailure { t ->
            if (t is InterruptedException) {
                throw RuntimeException(t)
            }
        }

        return "Expected heavy traffic this morning"
    }

    override fun getFortune(tripWire: Boolean): String {
        if (tripWire) {
            throw RuntimeException("Major accident! Highway is closed!")
        }

        return getFortune()
    }


}
