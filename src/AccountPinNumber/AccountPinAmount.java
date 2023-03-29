/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountPinNumber;
import AccountPinNumber.AccountPinAmount;
/**
 *
 * @author Hlsmith1
 */
public class AccountPinAmount implements Comparable<AccountPinAmount> {
    static int permanentCounter = 0;
    private String accountNumber;
    private String pin;
    private Double amount;
    
    

    public AccountPinAmount(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        ++permanentCounter;
        this.amount = 0.00;
    }

    public AccountPinAmount(String accountNumber, String pin, Double amount) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.amount = amount;
        ++permanentCounter;
    }


    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public Double getAmount() {
        return amount;
    }

    public void changeAmount(Double change){
        this.amount += change;
    }
    
    /*Get Max amount*/
    
        
    @Override
    public String toString() {
        return "AccountPinAmount{" + "accountNumber=" + 
                accountNumber + ", pin=" + 
                pin + ", amount=" + amount + '}';
    }

    @Override
    public int compareTo(AccountPinAmount o) {
        return this.amount.compareTo(o.getAmount());
    }

    
}

