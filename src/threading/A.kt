package threading

import java.lang.Thread.sleep

class A : Thread() {
    override fun run(){
        for (i in 1..5)
            println("atharva")
           sleep(2000)

    }

}

class B : Thread(){
    override fun run(){
        for (i in 1..5)
            //sleep(100)
            println("Akash")
    }
}
class C: Runnable {
    override fun run() {
        for (i in 1..5)
            //sleep(200)
            println("C")
    }
}

//singleton claSS
object ThreadLearning{
    @JvmStatic
    fun main(args: Array<String>) {
        val a = A()
        val b = B()
        val c = C()
        val thread = Thread(c)
        a.start()
        b.start()
        thread.start()
        println("${a.name}, ${a.priority}")
        println("${b.name}, ${b.priority}")
        println("${thread.name}, ${thread.priority}")

        a.priority=Thread.MAX_PRIORITY//1-10\
        a.name= "callThread"
        println("${a.name}, ${a.priority}")
        println("${b.name}, ${b.priority}")
        println("${thread.name}, ${thread.priority}")
//        a.name=
        println(a.isAlive)
        a.join()
        println(a.isAlive)
        println("i am from main thread")
    }
}