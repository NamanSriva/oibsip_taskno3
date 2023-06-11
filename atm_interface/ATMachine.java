package atm_interface;
import java.util.*;


// CREATING AN ATM CLASS

class ATM{
    String name;
    String userName;
    String password;
    int accountno;
    float Balance;
    int transaction=0;
    String transactionHistory="";



    // REGISTER FUNCTION

    public void register(){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n Enter your name : ");
        this.name=sc.nextLine();
        System.out.println("\n Enter your Username : ");
        this.userName=sc.nextLine();
        System.out.println("\n Enter your Password : ");
        this.password=sc.nextLine();
        System.out.println("\n Enter your Account Number : ");
        this.accountno=sc.nextInt();
        System.out.println("\n Your registration is completed !! You can now login : ");
        
        
    }



    //LOGIN FUNCTION
   
    public boolean login(){
        boolean isLogin=false;
        Scanner sc= new Scanner(System.in);
        while(!isLogin){
        System.out.println("Enter your Username : ");
        String Username=sc.nextLine();
        if(Username.equals(userName)){
            while(!isLogin){
                System.out.println("\n Enter your password");
                String Password=sc.nextLine();
                if(Password.equals(password)){
                    System.out.println("\n Login Successful !!");
                    isLogin=true;
                }
                else {
                    System.out.println("\n ERROR !! Enter Correct PIN ");
                }
            }
        }
        else{
            System.out.println("\n Username not found ! Register yourself ");
        }
      }
      return isLogin;
        
    }

   

    //WITHDRAW MONEY FUNCTION


    public void withdrawMoney(){

        System.out.println("Enter amount to withdraw : ");
        Scanner sc =new Scanner(System.in);
        float amount=sc.nextFloat();
        if(amount> Balance){
            System.out.println("Insufficient Balance");
        }
        else {
            transaction++;
            Balance= Balance - amount;
            System.out.println("Money withdrawn successfully !!");
            String str=amount+"Rs Withdrawed\n";
            transactionHistory=transactionHistory.concat(str);
        }
       
    }



    // DEPOSIT MONEY FUNCTION


    public void depositMoney(){
        System.out.println("Enter amount to deposit : ");
        Scanner sc=new Scanner(System.in);
        float amount=sc.nextFloat();
        transaction++;

        Balance= Balance +amount;
        System.out.println("Money deposited successfully !!");
        String str=amount+"Rs Deposited\n";
        transactionHistory=transactionHistory.concat(str);
    }


    // TRANSFER MONEY FUNCTION

    public void transferMoney(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter recipient's name : ");
        String recipient=sc.nextLine();
        System.out.println("Enter amount to transfer : ");
        float amount=sc.nextFloat();
        
        
        if(amount> Balance){
            System.out.println("Insufficient Balance");
        }
        else {

            transaction++;
            Balance= Balance - amount;
            System.out.println("Money transferred successfully to "+ recipient);
            String str=amount+("Rs transferred successfully to "+ recipient+ "\n");
            transactionHistory=transactionHistory.concat(str);
        }
       
    }


    // CHECK BALANCE FUNCTION

    public void checkBalance(){
        System.out.println("Your A/C balance is : " + Balance);

    }



    // TRANSACTION HISTORY FUNCTION

    public void transactionHistory(){
        if(transaction==0){
            System.out.println("No transactions done yet. ");
        }
        else {
            System.out.println("\n"+ transactionHistory);
        }
    }


 }



 // MAIN FUNCTION


public class ATMachine {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("\n**********WELCOME TO ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice - ");
		int choice = sc.nextInt();
		
		if ( choice == 1 ) {
			ATM b = new ATM();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice - ");
				int ch = sc.nextInt();
				if ( ch == 1 ) {
					if (b.login()) {
						System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = sc.nextInt();
							switch(c) {
								case 1:
								b.withdrawMoney();
								break;
								case 2:
								b.depositMoney();
								break;
								case 3:
								b.transferMoney();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transactionHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
    }

    
}
