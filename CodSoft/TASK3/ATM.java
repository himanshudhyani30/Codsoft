import java.lang.String;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bankaccount{
    private int balance;
    public bankaccount(int initialbalance){
        this.balance = initialbalance;
    }
    public int getbalance(){
        return balance;
    }
    public void deposit(int amount){
        balance= balance + amount;
    }
    public boolean withdraw(int amount){
        if(amount <=balance){
            balance= balance-amount;
            return true;
        }
        else{
            return false;
        }
    }
}
class AtmMachine{
    private bankaccount account;
    public AtmMachine(bankaccount account){
        this.account = account;
    }
    public void deposit(int amount){
        account.deposit(amount);
    }
    public boolean withdraw(int amount){
        return account.withdraw(amount);
    }
    public int checkbalance(){
        return account.getbalance();
    }
}
class AtmGui extends JFrame{
    private AtmMachine atm;
    private JTextField amountf;
    private JTextArea result;
    public AtmGui(AtmMachine atm){
        this.atm = atm;
        setTitle("ATM MACHINE");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4,2));

        JLabel amountl=new JLabel("  ENTER AMOUNT");
        amountf=new JTextField();
        JButton dButton=new JButton("DEPOSIT AMOUNT");
        JButton wButton=new JButton("WITHDRAWL AMOUNT");
        JButton bButton=new JButton("CHECK BALANCE");

        result = new JTextArea();
        result.setEditable(false);

        p.add(amountl);
        p.add(amountf);
        p.add(dButton);
        p.add(wButton);
        p.add(bButton);
        p.add(result);

        dButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                performTransaction("DEPOSIT");
            }
        });
        wButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                performTransaction("WITHDRAW");
            }
        });
        bButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                display();
            }
        });

        add(p);
    }

    private void performTransaction(String transactionType){
        try{
            int amount= Integer.parseInt(amountf.getText());
            if(transactionType.equals("DEPOSIT")){
                atm.deposit(amount);
                showMessage("Deposit Successfull.\nNew Balance= "+ atm.checkbalance());
            }else if(transactionType.equals("WITHDRAW")){
                if(atm.withdraw(amount)){
                    showMessage("Withdrawal Successful.\nNew Balance= "+atm.checkbalance());
                }
                else{
                    showMessage("Insufficient Balance");
                }
            }
        }
        catch(NumberFormatException ex){
            showMessage("Invalid amount");
        }
    }

    private void display(){
        int balance= atm.checkbalance();
        showMessage("Current Balance= "+ balance);
    }
    private void showMessage(String message){
        result.setText(message);
    }
}
public class ATM{
    public static void main(String[] args){
        bankaccount account = new bankaccount(1000);
        AtmMachine atm= new AtmMachine(account);
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new AtmGui(atm).setVisible(true);
            }
        });
    }
}