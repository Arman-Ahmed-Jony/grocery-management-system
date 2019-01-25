
import com.jtattoo.plaf.*;

import java.util.Date;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
public class Admin_panel extends javax.swing.JFrame {
Connection conn=null;       //initializing Connection Variable
ResultSet rs=null;          //initializing ResultSet Variable  
PreparedStatement pst=null; //initializing PreparedStatement Variable

    public Admin_panel() {  //construictor that initiate components, connection from localhost, employee table populatoin & Date
        initComponents();
        conn=javaconnect.connDB();
        Update_table();
        currentdate();
    }
private void Update_table(){            //populating table of employee information
try{
String sql="SELECT emp_id as 'ID',emp_name as 'Name', emp_address as 'Address',emp_bdate as 'Birthdate',emp_contact as 'Contact', emp_join_date as 'Joining Date', emp_img as 'Image',emp_gender as 'Gender',emp_email as 'Email' FROM `emp_info`";
pst=conn.prepareStatement(sql);
rs=pst.executeQuery();
emp_table.setModel(DbUtils.resultSetToTableModel(rs));
}catch(Exception e){
JOptionPane.showMessageDialog(null, e);
}




}
/*
Bunch of codes bellow is under examination. it will be used for scalling images in the desktop pane of any resulation of pictures
*/
private java.awt.Image sclImg(java.awt.Image img,int w,int h){
    BufferedImage obj=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
    Graphics2D obj2=obj.createGraphics();
    obj2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR );
    obj2.drawImage(img,0,0,w,h,null);
    obj2.dispose();
    
    
    return obj;
    }


public void currentdate(){          //THSI METHOOD DISPLAYS A DIGITAL CLOCK IN TOP OF THE SOFTWARE
Thread clock=new Thread(){

    public void run(){
    
    for(;;){
        try {
    Calendar cal=new GregorianCalendar();
int month=cal.get(Calendar.MONTH);
int day=cal.get(Calendar.DAY_OF_MONTH);
int year=cal.get(Calendar.YEAR);
Date.setText("Date  "+day+"/"+(month+1)+"/"+year);
int sec=cal.get(Calendar.SECOND);
int min=cal.get(Calendar.MINUTE);
int hour=cal.get(Calendar.HOUR);
time.setText("Time  "+hour+":"+min+":"+sec);
    
        
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Admin_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }

    }
};
clock.start();


}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Date = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        emp_dlt = new javax.swing.JButton();
        Add_emp = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        update_emp = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        emp_contact = new javax.swing.JTextField();
        emp_join_date = new com.toedter.calendar.JDateChooser();
        emp_email = new javax.swing.JTextField();
        emp_id = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        maleradio = new javax.swing.JRadioButton();
        femaleradio = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        emp_bdate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        emp_address = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emp_name = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        attach = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        img_show = new javax.swing.JLabel();
        img_path = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        emp_table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu_POS = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Menu_logout = new javax.swing.JMenuItem();
        Menu_exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AJ soft[Employee Information]");
        setIconImage(new ImageIcon("logo2.png").getImage() );
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setPreferredSize(new java.awt.Dimension(1281, 882));

        Date.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        Date.setForeground(new java.awt.Color(102, 102, 255));
        Date.setText("date");

        time.setFont(new java.awt.Font("Old English Text MT", 0, 24)); // NOI18N
        time.setForeground(new java.awt.Color(102, 102, 255));
        time.setText("time");

        emp_dlt.setFont(new java.awt.Font("Matura MT Script Capitals", 2, 36)); // NOI18N
        emp_dlt.setForeground(new java.awt.Color(153, 153, 153));
        emp_dlt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete_male.png"))); // NOI18N
        emp_dlt.setText("Delete");
        emp_dlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_dltActionPerformed(evt);
            }
        });

        Add_emp.setFont(new java.awt.Font("Matura MT Script Capitals", 2, 36)); // NOI18N
        Add_emp.setForeground(new java.awt.Color(153, 153, 153));
        Add_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Add-Male-User.png"))); // NOI18N
        Add_emp.setText("Add");
        Add_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_empActionPerformed(evt);
            }
        });

        clear_btn.setFont(new java.awt.Font("Matura MT Script Capitals", 2, 36)); // NOI18N
        clear_btn.setForeground(new java.awt.Color(153, 153, 153));
        clear_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.Fchkl.cache.cleaner.png"))); // NOI18N
        clear_btn.setText("Clean");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });

        update_emp.setFont(new java.awt.Font("Matura MT Script Capitals", 2, 36)); // NOI18N
        update_emp.setForeground(new java.awt.Color(153, 153, 153));
        update_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Edit-Male-User-icon.png"))); // NOI18N
        update_emp.setText("Update");
        update_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_empActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Matura MT Script Capitals", 2, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/report-3-xxl (1).png"))); // NOI18N
        jButton1.setText("Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(update_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emp_dlt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clear_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Add_emp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Add_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emp_dlt)
                .addGap(18, 18, 18)
                .addComponent(update_emp)
                .addGap(18, 18, 18)
                .addComponent(clear_btn)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Information", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Vivaldi", 0, 24))); // NOI18N

        jLabel4.setText("Gender");

        emp_join_date.setDateFormatString("yyyy-MM-dd");
        emp_join_date.setIcon(null);

        emp_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_idActionPerformed(evt);
            }
        });

        buttonGroup1.add(maleradio);
        maleradio.setText("Male");
        maleradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleradioActionPerformed(evt);
            }
        });

        buttonGroup1.add(femaleradio);
        femaleradio.setText("Female");
        femaleradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleradioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(maleradio)
                .addGap(18, 18, 18)
                .addComponent(femaleradio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maleradio)
                    .addComponent(femaleradio))
                .addContainerGap())
        );

        jLabel2.setText("Name");

        jLabel1.setText("ID");

        emp_bdate.setDateFormatString("yyyy-MM-dd");
        emp_bdate.setIcon(null);

        jLabel5.setText("Image");

        jLabel6.setText("Birth Date");

        emp_address.setColumns(20);
        emp_address.setRows(5);
        jScrollPane2.setViewportView(emp_address);

        jLabel7.setText("Address");

        jLabel9.setText("Joining Date");

        jLabel8.setText("Contact No.");

        jLabel3.setText("Email");

        attach.setText("Attach");
        attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachActionPerformed(evt);
            }
        });

        img_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img_showMouseClicked(evt);
            }
        });

        jDesktopPane1.setLayer(img_show, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img_show, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(img_show, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(emp_name)
                            .addComponent(emp_contact)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emp_email)
                            .addComponent(emp_id)
                            .addComponent(emp_bdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(img_path, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(attach))
                            .addComponent(emp_join_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(emp_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(emp_bdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(emp_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(emp_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(attach)
                            .addComponent(img_path, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(emp_join_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee List", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Vivaldi", 0, 24))); // NOI18N

        jScrollPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane4MouseClicked(evt);
            }
        });

        emp_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        emp_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emp_tableMouseClicked(evt);
            }
        });
        emp_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emp_tableKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(emp_table);

        jScrollPane3.setViewportView(jScrollPane4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date)
                    .addComponent(time))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(7, 7, 7))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(208, 208, 208))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("File");

        Menu_POS.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Menu_POS.setText("Go to POS");
        Menu_POS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_POSActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_POS);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Go to Stock");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Add User");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        Menu_logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        Menu_logout.setText("Log Out");
        Menu_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_logoutActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_logout);

        Menu_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        Menu_exit.setText("Exit");
        Menu_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_exitActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("help");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Software Manual");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("About Coders");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1291, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maleradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleradioActionPerformed
       
       
        gender="Male";
      
        
    }//GEN-LAST:event_maleradioActionPerformed

    private void emp_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emp_tableMouseClicked

        
        int row=emp_table.getSelectedRow();
        String Table_click=(emp_table.getModel().getValueAt(row, 0).toString());
        
        try{
        String sql="select emp_img from emp_info where emp_id='"+Table_click+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        if(rs.next()){
            String imgdata=rs.getString("emp_img");
            format=new ImageIcon("src/img/"+imgdata);
            img_show.setIcon(format);
        }
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
        String sql="SELECT * FROM `emp_info` where emp_id='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();

        if(rs.next()){
        
        String add1=rs.getString("emp_id");
        emp_id.setText(add1);
        String add2=rs.getString("emp_name");
        emp_name.setText(add2);
        Date add3=rs.getDate("emp_bdate");
        emp_bdate.setDate(add3);
        String add4=rs.getString("emp_address");
        emp_address.setText(add4);
        String add5=rs.getString("emp_contact");
        emp_contact.setText(add5);
        Date add6=rs.getDate("emp_join_date");
        emp_join_date.setDate(add6);
        String add7=rs.getString("emp_email");
        emp_email.setText(add7);
        String add8=rs.getString("emp_img");
        
        img_path.setText(add8);
        String add9=rs.getString("emp_gender");
        
        if(add9.equals("Male")){
        maleradio.setSelected(true);
        gender="Male";
        femaleradio.setSelected(false);
        
        }
        else{
        maleradio.setSelected(false);
        
        femaleradio.setSelected(true);
        gender="Female";
        }

        }
        
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        
        }

    }//GEN-LAST:event_emp_tableMouseClicked
    
    
    private void Add_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_empActionPerformed
        // TODO add your handling code here:
        
        String idpattern="^[0-9]$";
        String namepattern="^[a-zA-Z]$";
        String emailpattern="^[a-zA-Z0-9]{1,20}@[a-zA-Z]{1,10}.[a-z]{2,3}$";

        Pattern p1=Pattern.compile(idpattern);
        Pattern p2=Pattern.compile(namepattern);
        Pattern p3=Pattern.compile(emailpattern);
        Matcher reg1=p1.matcher(emp_id.getText());
        Matcher reg2=p2.matcher(emp_name.getText());
        Matcher reg3=p3.matcher(emp_email.getText());

        
        
        if(!reg1.matches()&!reg2.matches()&!reg3.matches()){    //&!(emp_bdate.getDate().after(emp_join_date.getDate()))
        JOptionPane.showMessageDialog(null, "info is not in formate");
        }

        else{
        try{
        String sql="insert into emp_info(emp_id,emp_name,emp_address,emp_contact,emp_email,emp_gender,emp_img,emp_bdate,emp_join_date)values(?,?,?,?,?,?,?,?,?)";
        pst=conn.prepareStatement(sql);
        pst.setString(1, emp_id.getText());
        pst.setString(2, emp_name.getText());
        pst.setString(3, emp_address.getText());
        pst.setString(4, emp_contact.getText());
        pst.setString(5, emp_email.getText());
        pst.setString(6, gender);
        pst.setString(7, img_path.getText());
        pst.setString(8, ((JTextField)emp_bdate.getDateEditor().getUiComponent()).getText());
        pst.setString(9, ((JTextField)emp_join_date.getDateEditor().getUiComponent()).getText());
        if(emp_join_date.getDate().after(emp_bdate.getDate())){
        pst.execute();
        JOptionPane.showMessageDialog(null, "Employee added");
        }
        else{
        JOptionPane.showMessageDialog(null, "Sorry Boss!!! :( ");
        
        }
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
        }
        Update_table();
        }
    }//GEN-LAST:event_Add_empActionPerformed

    private void update_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_empActionPerformed
        // TODO add your handling code here:
        try{
            String val_id=emp_id.getText();
            String val_name=emp_name.getText();
            String val_address=emp_address.getText();
            String val_contact=emp_contact.getText();
            String val_email=emp_email.getText();
            String val_img=img_path.getText();
            String val_gender=gender;
            String val_bdate=((JTextField)emp_bdate.getDateEditor().getUiComponent()).getText();
            String val_join_date=((JTextField)emp_join_date.getDateEditor().getUiComponent()).getText();
        
            String sql="update `emp_info` set emp_id='"+val_id+"',emp_name='"+val_name+"',emp_address='"+val_address+"',emp_contact='"+val_contact+"',emp_email='"+val_email+"',emp_gender='"+val_gender+"',emp_bdate='"+val_bdate+"',emp_img='"+val_img+"',emp_join_date='"+val_join_date+"' where emp_id='"+val_id+"'";
                    if(emp_join_date.getDate().after(emp_bdate.getDate()))//comparing date
                    {

            pst=conn.prepareStatement(sql);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Employee info is updated");
                    }
                    else{
                    JOptionPane.showMessageDialog(null, "something wrong in Birthdate and joining date....");
                    }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
        }
        Update_table();
    }//GEN-LAST:event_update_empActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        emp_id.setText("");
            emp_name.setText("");
            emp_address.setText("");
            emp_contact.setText("");
            emp_email.setText("");
            
            img_path.setText("");
            img_show.setIcon(null);
            emp_bdate.setDate(null);
            emp_join_date.setDate(null);
buttonGroup1.clearSelection();
        
    }//GEN-LAST:event_clear_btnActionPerformed

    private void emp_dltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_dltActionPerformed
        // TODO add your handling code here:
        int option=JOptionPane.showConfirmDialog(null, "Do you really want to delete the information?","Delete",JOptionPane.YES_NO_OPTION);
        if(option==0){
        String Sql="delete from emp_info where emp_id=?";
        
        try{
        pst=conn.prepareStatement(Sql);
        pst.setString(1, emp_id.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Employee info has deleted");
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
        Update_table();
        }
    }//GEN-LAST:event_emp_dltActionPerformed

    private void femaleradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleradioActionPerformed
        
        gender="Female";
    }//GEN-LAST:event_femaleradioActionPerformed

    private void attachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachActionPerformed
        
        try {
        JFileChooser chooser=new JFileChooser();
        
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
        String file_name=f.getName();
        
        img_path.setText(file_name);
        
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
        }
        
        
    }//GEN-LAST:event_attachActionPerformed

    private void jScrollPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane4MouseClicked

    }//GEN-LAST:event_jScrollPane4MouseClicked

    private void Menu_POSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_POSActionPerformed
     
              
        emp_test pos=new emp_test();
                this.setVisible(false);
                pos.setVisible(true);
        
        
        
    }//GEN-LAST:event_Menu_POSActionPerformed

    private void Menu_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_logoutActionPerformed
        
        Login_panel log=new Login_panel();
                this.setVisible(false);
                log.setVisible(true);
    }//GEN-LAST:event_Menu_logoutActionPerformed

    private void Menu_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_exitActionPerformed
        
        
        System.exit(0);
    }//GEN-LAST:event_Menu_exitActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        About_Coders log=new About_Coders();
                log.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // TODO add your handling code here:
        
        
        
            
        
        
        Calendar cal=new GregorianCalendar();
        int mounth =cal.get(Calendar.MONTH);
        int year =cal.get(Calendar.YEAR);
        int day =cal.get(Calendar.DAY_OF_MONTH);
        
        
        String strmonth=String.valueOf(mounth+1);
        String stryear=String.valueOf(year);
        String strday=String.valueOf(day);
        
        try{
            String sql="SELECT * FROM `emp_info` where emp_id='"+emp_id.getText()+"' ";
        
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();

        if(rs.next()){
        
            String value_id="\t\t"+rs.getString("emp_id");
        String value_name=rs.getString("emp_name");
        String value_gender=rs.getString("emp_gender");
        String value_bd=rs.getString("emp_bdate");
        String value_email=rs.getString("emp_email");
        String value_address=rs.getString("emp_address");
        String value_cont=rs.getString("emp_contact");
        
        String value_j_date=rs.getString("emp_join_date");
        
        
            
        
        Document doc=new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("src/reports/raport_id_"+emp_id.getText()+".pdf"));
        doc.open();
        
        Image img=Image.getInstance("src/img/"+img_path.getText());
        Image title=Image.getInstance("icons/logo-retina.png");
        doc.add(new Paragraph("                                                                                            "+strday+"/"+strmonth+"/"+stryear,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.BOLD,BaseColor.BLUE)));
        doc.add(title);
        doc.add(new Paragraph("Employee Information",FontFactory.getFont(FontFactory.TIMES_ROMAN,24,Font.BOLD,BaseColor.BLACK)));
        doc.add(img);

        String val="";
        if(maleradio.isSelected()){
        val="Male";
        }
        else 
        {
            val="Female";
        }
        
        
        
        doc.add(new Paragraph("Name\t\t:"+value_name,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.NORMAL,BaseColor.BLACK)));
        doc.add(new Paragraph("ID\t\t: "+value_id,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.NORMAL,BaseColor.BLACK)));
        doc.add(new Paragraph("Gender\t\t: "+value_gender,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.NORMAL,BaseColor.BLACK)));
        doc.add(new Paragraph("Contact\t\t: "+value_cont,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.NORMAL,BaseColor.BLACK)));
        doc.add(new Paragraph("Email\t\t: "+value_email,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.NORMAL,BaseColor.BLACK)));
        doc.add(new Paragraph("Address\t\t: "+value_address,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.NORMAL,BaseColor.BLACK)));
        doc.add(new Paragraph("Birth date\t\t: "+value_bd,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.NORMAL,BaseColor.BLACK)));
        doc.add(new Paragraph("Joining Date\t\t: "+value_j_date,FontFactory.getFont(FontFactory.TIMES_ITALIC,18,Font.NORMAL,BaseColor.BLACK)));
        
        
        
        doc.close();
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"src\\reports\\raport_id_"+emp_id.getText()+".pdf");
        JOptionPane.showMessageDialog(null,"PDF is generated");
        }
        
        
        
                

        }
        catch(Exception  E){
        JOptionPane.showMessageDialog(null,E);
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emp_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_tableKeyReleased
        // TODO add your handling code here:
        if((evt.getKeyCode()==java.awt.event.KeyEvent.VK_DOWN)||(evt.getKeyCode()==java.awt.event.KeyEvent.VK_UP)){
        int row=emp_table.getSelectedRow();
        String Table_click=(emp_table.getModel().getValueAt(row, 0).toString());
        
        try{
        String sql="select emp_img from emp_info where emp_id='"+Table_click+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        if(rs.next()){
            String imgdata=rs.getString("emp_img");
            format=new ImageIcon("src/img/"+imgdata);
            img_show.setIcon(format);
        }
        }catch(Exception e){
        
        
        e.printStackTrace();
        }
        
        
        
        try{

        String sql="SELECT * FROM `emp_info` where emp_id='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();

        if(rs.next()){
        
        String add1=rs.getString("emp_id");
        emp_id.setText(add1);
        String add2=rs.getString("emp_name");
        emp_name.setText(add2);
        Date add3=rs.getDate("emp_bdate");
        emp_bdate.setDate(add3);
        String add4=rs.getString("emp_address");
        emp_address.setText(add4);
        String add5=rs.getString("emp_contact");
        emp_contact.setText(add5);
        Date add6=rs.getDate("emp_join_date");
        emp_join_date.setDate(add6);
        String add7=rs.getString("emp_email");
        emp_email.setText(add7);
        String add8=rs.getString("emp_img");
        
        img_path.setText(add8);
        String add9=rs.getString("emp_gender");
        
        if(add9.equals("Male")){
        maleradio.setSelected(true);
        gender="Male";
        femaleradio.setSelected(false);
        
        }
        else if(add9.equals("Female")){
        maleradio.setSelected(false);
        
        femaleradio.setSelected(true);
        gender="Female";
        }
        else{
        buttonGroup1.clearSelection();
        }
        }
        }catch(Exception E){
        JOptionPane.showMessageDialog(null, E);
        
        }
        }
    }//GEN-LAST:event_emp_tableKeyReleased

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        try{
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"manual.pdf");
        
        }catch(Exception E){
        
        JOptionPane.showMessageDialog(null, E);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
                Add_User pos=new Add_User();
                pos.setVisible(true);        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
         stock pos=new stock();
                
                pos.setVisible(true);
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void img_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img_showMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_img_showMouseClicked

    private void emp_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_idActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                /*if ("com.jtattoo.plaf.mint".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }*/
                UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
                
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_emp;
    private javax.swing.JLabel Date;
    private javax.swing.JMenuItem Menu_POS;
    private javax.swing.JMenuItem Menu_exit;
    private javax.swing.JMenuItem Menu_logout;
    private javax.swing.JButton attach;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clear_btn;
    private javax.swing.JTextArea emp_address;
    private com.toedter.calendar.JDateChooser emp_bdate;
    private javax.swing.JTextField emp_contact;
    private javax.swing.JButton emp_dlt;
    private javax.swing.JTextField emp_email;
    private javax.swing.JTextField emp_id;
    private com.toedter.calendar.JDateChooser emp_join_date;
    private javax.swing.JTextField emp_name;
    private javax.swing.JTable emp_table;
    private javax.swing.JRadioButton femaleradio;
    private javax.swing.JTextField img_path;
    private javax.swing.JLabel img_show;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JRadioButton maleradio;
    private javax.swing.JLabel time;
    private javax.swing.JButton update_emp;
    // End of variables declaration//GEN-END:variables
private String gender=null;
private ImageIcon format=null;
}