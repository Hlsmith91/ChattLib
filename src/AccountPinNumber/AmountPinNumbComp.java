/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountPinNumber;
import AccountPinNumber.AccountPinAmount;
import java.util.Comparator;

/**
 *
 * @author Heather
 */
public class AmountPinNumbComp implements Comparator<AccountPinAmount> {

    @Override
    public int compare(AccountPinAmount t, AccountPinAmount t1) {
        return Double.compare(t.getAmount(), t1.getAmount());
    }
    
    

    
}
