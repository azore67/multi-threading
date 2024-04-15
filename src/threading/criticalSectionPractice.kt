package threading

internal class CriticalSection{
    val lock = Any()

    var counter = 0
    fun increment() {
        synchronized(lock){
            counter +=1

        }

    }
}

fun main() {
    val x = CriticalSection()
    val thread1 = Thread{
        for (i in 1..1000000)
            x.increment()
    }
    val thread2 = Thread{
        for (i in 1..1000000)
            x.increment()
    }
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()
    println("${x.counter}")
}