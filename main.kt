/**
  Author: Aldrin Caballero
  Date: September 9, 2023
*/

// Dummy account information 
var PIN: Int = 1234
val fullname: String = "Aldrin Caballero"
val gender: Char = 'M'
var currentBalance: Int = 4500

var attempts = 4;


fun main() {
  println("\n---------- ATM MACHINE ----------")
  while(attempts != 0) {
    print("\nEnter your 4-digit PIN: ")
    if(loginAttempt(readLine()!!.trimIndent().toInt())) {
      mainProgram()
      attempts = 0;
      break
    } else {
      val msg = if(attempts != 0) "Incorrect PIN, Please try again.\nYou have $attempts login remaining!" else "Incorrect PIN, Please contact the administrator.\nYou have $attempts login remaining!"
      println("\n\n$msg")
    }
  }
  
  println("Thank you for using the program...")
  println("Best regards: Aldrin Caballero")
}

fun loginAttempt(userPin: Int): Boolean {
  attempts--
  return (userPin == PIN)
}

fun mainProgram() {
  println("\nLogged in successfully!")
  val identity: String = if(gender == 'M') "Mr." else "Mrs."
  val menuDisplay: String = """
   --------------------------- ATM --------------------------- 
        Welcome To Your Bank Account $identity $fullname   

   ----------------------------------------------------------- 
    MAIN MENU
    (1) Balance Inquiry
    (2) Withdrawal
    (3) Deposit
    (4) Change PIN
    (5) Return Card
    (6) Logout and Exit
   ----------------------------------------------------------- """.trimIndent()
  
  
  while(true) {
    println("\n\n$menuDisplay")
  	print("\nChoose a number in `Main Menu` to proceed: ")
  	val inputNumber: Int = readLine()!!.toInt()
      
      when(inputNumber) {
  		1 -> {
              println("\nYour Current Balance is: PHP$currentBalance")
              print("Do you want to continue? (Y/N): ")
              readLine()!!.lowercase().trimIndent() == "n" && break
      	}
      	2 -> {
              var amount: Int
              while(true) {
                  print("Please enter the amount to withdraw: ")
              	amount = readLine()!!.trimIndent().toInt()
              	if(amount > currentBalance) {
              		println("\nInsufficient balance, \nPlease enter a lower amount!")
                      continue
              	} else {
                  	currentBalance -= amount
                  	println("\nWithdrawal successfully!")
                      println("""
                      Amount withdrawn: $amount
                      Current balance: $currentBalance
                      """.trimIndent())
                      break
                  }
              }
      		
              print("\nDo you want to continue? (Y/N): ")
              (readLine()!!.lowercase().trimIndent() == "n") && break
      	}
     	 3 -> {
          	var amount: Int
              while(true) {
                  print("Please enter the amount to deposit: ")
              	amount = readLine()!!.trimIndent().toInt()
              	if(amount <= 0) {
              		println("\nPlease enter a valid amount!")
                      continue
              	} else {
                  	currentBalance += amount
                  	println("\nDeposit successfully!")
                      println("""
                      Amount deposit: $amount
                      Current balance: $currentBalance
                      """.trimIndent())
                      break
                  }
              }
      		
              print("\nDo you want to continue? (Y/N): ")
              (readLine()!!.lowercase().trimIndent() == "n") && break
      		
     	 }
     	 4 -> {
          	while(true) {
                  print("\nEnter your 4-digit PIN: ")
              	if(readLine()!!.trimIndent().toInt() != PIN) {
              		println("\nIncorrect PIN, Please try again")
                      continue
              	} else {
                  	while(true) {
                      	var newPIN: String
                      	print("\nEnter your New 4-digit PIN: ")
                          newPIN = readLine()!!.trimIndent()
                          if(newPIN.length != 4) {
                         	println("Only accept 4-digit number, please try again!")
                             continue 
                          } else {
                          	PIN = newPIN.toInt()
                              println("PIN changed successfully!")
                              break 
                          }
                      }
                      break
                  }
              }
      		
              print("\nDo you want to continue? (Y/N): ")
              (readLine()!!.lowercase().trimIndent() == "n") && break
    	  	
     	 }
     	 5 -> {
          	println("\nReturning card...")
              println("Card returned successfully!")
              break
     	 	
      	}
      	6 -> {
          	print("\nAre you sure you want to logout? (Y/N): ")
              if(readLine()!!.lowercase().trimIndent() == "y") {
              	println("\nThank you for confirming..")
              	println("Logout successfully!")
                  break
              } else {
              	println("\nThank you for confirming..")
              }
      	}
      	else -> {
     	 	println("Invalid input, Please try again!")
      	}
  	}
  }
  
}
