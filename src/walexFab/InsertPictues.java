package walexFab;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.*;

public class InsertPictues extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	JPanel panel;
	JButton btn,btn1;
	JLabel label;
	JTextField amount,nameclothe,type;
	 String d;
	 
	void  InsertPictures(){

		this.setTitle("Add Pictures");
		this.setLayout(null);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		
     panel=new JPanel();	 
	 panel.setSize(600,300);
	 panel.setLayout( null);
	panel.setBackground(Color.blue);
	btn=new JButton("Choose File");
	btn.setBounds(20,30,150,30);
	btn.addActionListener(this);
	btn1=new JButton("Upload");
	btn1.setBounds(20,70,150,30);
	btn1.addActionListener(this);
	label=new JLabel();
	label.setBounds(200, 30, 100,100 );
	
	amount=new JTextField();
	amount.setToolTipText("Amount");
	amount.setBounds(330, 30, 100, 30);
	
	nameclothe=new JTextField();
	nameclothe.setBounds(330, 80, 100, 30);
	nameclothe.setToolTipText("Cloth name");
	
	type=new JTextField();
	type.setBounds(330,125,100,30);
	type.setToolTipText("category ");
	
	this.add(panel);
	panel.add(btn);
	panel.add(btn1);
	panel.add(label);
	panel.add(amount);
	panel.add(nameclothe);
	panel.add(type);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	 }
	public static void main(String[] args) {
	   InsertPictues insp=new InsertPictues();
	   insp.InsertPictures();

	}
	@SuppressWarnings("resource")
	@Override
	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btn) {
        FileDialog fg=new FileDialog(this,"Open",FileDialog.LOAD);
        fg.show();
        if(fg.getFile()!=null){
             d=(fg.getDirectory()+fg.getFile());
           Toolkit toolkit= Toolkit.getDefaultToolkit();
           Image  image1=toolkit.getImage(d);
          Image  imgfit=image1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
          label.setIcon(new ImageIcon(imgfit));

        }}
	else if(e.getSource()==btn1) {
		try {
			
    	 Connection con=new DatabaseConnection().getConnection();
		 PreparedStatement pst=con.prepareStatement("insert into  walexfab_walex01 (price,NameClothes,img_url,category) values (?,?,?,?)");
		pst.setString(1, amount.getText());
		pst.setString(2,nameclothe.getText());
		pst.setString(3, String.valueOf(System.currentTimeMillis())+".png");
		pst.setString(4, type.getText());
		   
		pst.executeUpdate();
		
		}catch(Exception ae) {
			System.out.println(ae);
		}		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
public String rice() {

String name=null,na=".png";
FileOutputStream fos=null;
try {
String dir="HOT";
File directory=new File(dir);


if(!(directory.exists()& directory.isDirectory())) {
	
	directory.mkdir();
	new File(directory,dir).createNewFile();
}
long ls=System.currentTimeMillis();
	name =String.valueOf(ls).concat(na);	
	 File file=new File(directory,name);
 fos=new FileOutputStream(file);	
fos.write((int) new FileInputStream(d).transferTo(fos));
fos.close();

name=file.getAbsolutePath();
System.out.println("Succesful Pics Name is =  "+name);
fos.close();
}catch(Exception eaa) {
System.out.println(eaa);
}
return name;
}


}
