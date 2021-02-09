package uploadData;

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DBCONNECT.DatabaseCon;




public class UploadFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JPanel panel;
	JButton btn,btn1;
	JLabel label;
	JTextField field,identity,categor;
	 String d;

	
	void InsertPicturesExample() {

		this.setTitle("Add Pictures");
		this.setLayout(null);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		
     panel=new JPanel();	 
	 panel.setSize(600,300);
	 panel.setLayout( null);
	panel.setBackground(Color.blue);
	btn=new JButton("upload");
	btn.setBounds(20,30,150,30);
	btn.addActionListener(this);
	btn1=new JButton("send");
	btn1.setBounds(20,70,150,30);
	btn1.addActionListener(this);
	label=new JLabel();
	label.setBounds(200, 30, 100,100 );
	field=new JTextField();
	field.setBounds(330, 30, 100, 50);
	identity=new JTextField();
	identity.setBounds(330, 90, 100, 30);
	categor=new JTextField();
	categor.setBounds(330, 140, 100, 30);
	
	this.add(panel);
	panel.add(btn);
	panel.add(btn1);
	panel.add(label);
	panel.add(field);
	panel.add(identity);
	panel.add(categor);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	}

	public static void main(String[] args) {
		UploadFrame bb=new UploadFrame();
		bb.InsertPicturesExample();
	}

	@SuppressWarnings("resource")
	@Override
	
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==btn) {
        FileDialog fg=new FileDialog(this,"Open",FileDialog.LOAD);
        fg.show();
        if(fg.getFile()!=null){                               
          	
        	/*Sequin
        	 * velvet lace
        	silk
        	organza
        	brocade*/
             d=(fg.getDirectory()+fg.getFile());
           Toolkit toolkit= Toolkit.getDefaultToolkit();
           Image  image1=toolkit.getImage(d);
          Image  imgfit=image1.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
          label.setIcon(new ImageIcon(imgfit));

        }}
	else if(e.getSource()==btn1) {
		try {
		
			FileInputStream inp=new FileInputStream(d);
	
		 Connection con=new DatabaseCon().getConnection();
		 PreparedStatement pst=con.prepareStatement("insert into  walex_uploads (write_up,price,Pictures,cats) values (?,?,?,?)");
		pst.setString(1,field.getText());
		pst.setString(2, identity.getText());
		pst.setBinaryStream(3, inp);
		pst.setString(4,categor.getText());
		 pst.executeUpdate();
	
		}catch(Exception ae) {
			System.out.println(ae);
		}		}
	}

/*	public String rice() {

		String name=null,
				na=".png";
		FileOutputStream fos=null;
		try {
			String dir="walex_uploads";
			File directory=new File(dir);
			
			
			if(!(directory.exists()& directory.isDirectory())) {
				
				directory.mkdir();
			
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
	}*/
}
