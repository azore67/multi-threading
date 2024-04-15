package threading.ProducerConsumerPattern

import java.util.Objects

class SharedData{
    var num: Int=0
    var isDataProduced: Boolean = false
    @Synchronized
        fun put(num:Int){
            while (isDataProduced == true) {
                (this as Object).wait()
            }
            this.num=num
            println("PUT: $num")
            isDataProduced = true
            (this as Object).notify()
        }
    @Synchronized
    fun get() {
        while (isDataProduced == false) {
            (this as Object).wait()
        }
        println("GET: $num")
        isDataProduced = false
        (this as Object).notify()


    }
}
class Producer(val sd:SharedData): Runnable {
    override fun run() {
        var i = 0
        while (true) {
            i ++
            sd.put(i)
            try{Thread.sleep(100)}
            catch(e:Exception){

            }

        }
    }
}
class Consumer(val sd: SharedData) : Runnable {
    override fun run() {
        sd.get()
        try{Thread.sleep(100)}
        catch(e:Exception){

        }

    }
}
fun main() {
    val sd1 = SharedData()
    Thread(Producer(sd1),"producerThread").start()
    Thread(Consumer(sd1),"consumerThread").start()
}