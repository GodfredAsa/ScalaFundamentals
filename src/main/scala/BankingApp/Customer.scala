package BankingApp

class Customer(val name: String, val address: String, val accountType: String, val mobile: String,var balance: Double){

  override def toString: String = s"" +
    s"{Name: $name, Address: $address, " +
    s"Account Type: $accountType, " +
    s"Mobile No: $mobile, " +
    s"Current Balance: $balance}"


  def deposit( amount: Double): Unit = {
   if(amount<=0)
     println("Deposit Unsuccessful")
   else {
    this.balance = this.balance + amount
     println("Deposit Successful")
   }

  }

  def withdrawal(amount: Double): Unit = {
    if(amount> this.balance)
      println("Withdrawal Unsuccessful")
    else {
      println("Withdrawal Successful")
      this.balance -= amount
    }



  }


}
