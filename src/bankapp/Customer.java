
package bankapp;


import java.io.Serializable;


public class Customer  implements Serializable{
    private final String name;
    private final String surname;
    private final String id;
    private final Account account;

    Customer(String name, String surname, String id, Account account) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.account = account;
    }
    
    @Override
    public String toString(){
        return "\nCustomer Information\n" +
                "First Name: " + getName() + "\n" + 
                "Last Name: " + getSurname() +  "\n" + 
                "ID: " + getId() +  "\n" + 
                account;
    }
    //test
    public String basicInfo(){
        return " Account Number: " + account.getAccountNumber() + " - Name: " + getName() + " " + getSurname();
    }
    
    Account getAccount(){
        return account;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    
}

