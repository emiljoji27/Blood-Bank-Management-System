
package Project;

import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;  
  
public class Homepage extends Canvas{ 
    
    public Homepage()
    {
         initComponents();
    }
      
    @Override
    public void paint(Graphics g) 
    {  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("D:\\DBMS PROJECT\\Project\\src\\Project\\homepage_icon.png");  
        g.drawImage(i, 100,100,this);  
    }  
    
    public static void main(String[] args)
    {  
        Homepage m=new Homepage();
    }  
    
    private void initComponents() 
     {
        JFrame f=new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton signup=new JButton("Sign Up");
        JButton signin=new JButton("Sign In");
        JButton get_blood=new JButton("GET BLOOD");
        signup.setBounds(300,10,100,100);
        signup.setSize(100,30);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Registration.main(null);
            }
            });
        signin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Login.main(null);
            }
            });
        signin.setBounds(200,10,100,100);
        signin.setSize(100,30);
        get_blood.setBounds(50,320,100,100);
        get_blood.setSize(300,30);
        get_blood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Request.main(null);
            }
            });
        
        
        f.add(signup);
        f.add(signin);
        f.add(get_blood);
        f.add(this);  
        f.setSize(400,400);  
        f.setVisible(true);
    }
} 