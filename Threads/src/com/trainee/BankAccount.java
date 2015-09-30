package com.trainee;

public class BankAccount {
	
	private  double balance = 1000;

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public synchronized double deposit(double amt){
		
		balance = balance+amt;
		System.out.println("Amount Deposited : "+balance);
		notify();
		return 0;
		
		}
	public synchronized double withdraw(double amt){
		
		if(balance < amt)
		{
			System.out.println("Insufficient Balance - Will wait for Transfer");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		balance = balance-amt;
		System.out.println("Got the Money - Amount Withdrawn "+ amt);
		return 0;
		
		}

}
