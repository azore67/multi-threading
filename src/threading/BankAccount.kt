package threading

class BankAccount(var balance: Double) {
    private val lock = Any()

    fun deposit(amount: Double) {
        synchronized(lock) {
            balance += amount }
    }
    fun withdraw(amount: Double) {
        synchronized(lock) {
            if (balance >= amount) {
                balance -= amount

            }
            else {
                println("insufficient funds")
            }
        }
    }
    //fun getBalance(): Double{
        //synchronized(lock) {
           // return balance
        //}
    //}
}

fun main() {
    val account1 = BankAccount(100.0)
    val account2 = BankAccount(500.0)

    val thread1 = Thread {
       repeat(4){
           account1.deposit(100.0)
       }
    }
    val thread2 = Thread {
        repeat(3) {
//            account1.withdraw(200.0),"Customer 1")
        }
    }


    val customer2 = Thread ({account2.deposit(100.0)
        account1.withdraw(200.0)},"Customer 1")

    thread1.start()
    customer2.start()
    thread1.join()
    customer2.join()

    println("${account1.balance}")
    println("${account2.balance}")

}


















