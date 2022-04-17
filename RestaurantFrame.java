/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

/**
 *
 * @author RAMA
 */

import com.sun.org.apache.xpath.internal.operations.Variable;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import form.Encapsulation;


public class RestaurantFrame extends javax.swing.JFrame {
    //Variable table model
    private DefaultTableModel model;

    // Variable current id
    private int id = 0;

    // Varieble id yang dipilih
    private int selectedId = 0;

    /**
     * Creates new form CobaDesign
     */
    
    public RestaurantFrame() {
        initComponents();
         // Memanggil fungsi init table
        this.initTable();
        

    }
     private void initTable() {
        // Initialize Table
        model = new DefaultTableModel();
        tb_data.setModel(model);
        Encapsulation encap = new Encapsulation ();
        // Menambahkan kolom awal pada bagian atas
        model.addColumn("ID");
        model.addColumn(encap.getName());
        model.addColumn(encap.getTable());
        model.addColumn(encap.getAyamBakar());
        model.addColumn(encap.getIkanGoreng());
        model.addColumn(encap.getSushi());
        model.addColumn(encap.getTongseng());
        model.addColumn(encap.getEsTeh());
        model.addColumn(encap.getJusAlpukat());
        model.addColumn(encap.getThaiTea());
        model.addColumn(encap.getMatcha());
        model.addColumn(encap.getProgress());
        
        
        
        // Membuat tombol agar tidak terlihat saat pertama kali dijalankan
        btn_delete.setVisible(false); 
        cb_progress.setVisible(false);
    }                      

    private void resetForm() {
        // Mengembalikan id yang dipilih menjadi 0
        this.selectedId = 0;
        
        // Menghapus text field
   
        tf_name.setText("");
        tf_table.setText("");
        tf_ab.setText("");
        tf_ig.setText("");
        tf_ss.setText("");
        tf_ts.setText("");
        tf_et.setText("");
        tf_ja.setText("");
        tf_tt.setText("");
        tf_mt.setText("");
        tf_search.setText("");
        cb_progress.setSelectedIndex(0);
        
        // Menghilangkan tombol hapus kembali
        btn_delete.setVisible(false);
        cb_progress.setVisible(false);
    }

    // Fungsi untuk mengambil baris yang diklik
    private String getSelectedRow() {
         int selectedRowIndex = tb_data.getSelectedRow();
         Object selectedObject = (Object) tb_data.getModel().getValueAt(
            selectedRowIndex, 0
         );
         
         return String.valueOf(selectedObject);      
    }

    // Fungsi untuk menambahkan data ke model tabel
    private void store() {
        
        String name = tf_name.getText();
        String table = tf_table.getText();
        String AyamBakar =  tf_ab.getText();
        String IkanGoreng = tf_ig.getText();
        String Sushi = tf_ss.getText();
        String Tongseng =  tf_ts.getText();
        String EsTeh =  tf_et.getText();
        String JusAlpukat = tf_ja.getText();
        String ThaiTea =  tf_tt.getText();
        String Matcha =   tf_mt.getText();
        String Progress = cb_progress.getSelectedItem().toString();
                 
        this.id = this.id + 1;
        String id = String.valueOf(this.id);

        Object[] obj = new Object[]{
            id,
            name,
            table,
            AyamBakar,
            IkanGoreng,
            Sushi,
            Tongseng,
            EsTeh,
            JusAlpukat,
            ThaiTea,
            Matcha,
            Progress,
                
                } ;
        this.model.addRow(obj);
    }

    // Fungsi untuk mengubah data yang ada pada tabel
    private void update() {
        String row = this.getSelectedRow();
        
        String name = tf_name.getText();
        String table = tf_table.getText();
        String AyamBakar =  tf_ab.getText();
        String IkanGoreng = tf_ig.getText();
        String Sushi = tf_ss.getText();
        String Tongseng =  tf_ts.getText();
        String EsTeh =  tf_et.getText();
        String JusAlpukat = tf_ja.getText();
        String ThaiTea =  tf_tt.getText();
        String Matcha =   tf_mt.getText();
        String Progress = cb_progress.getSelectedItem().toString();
        
        for (int i = 0; model.getRowCount() > i; i++) {
            String id = (String) model.getValueAt(i, 0);
            
            if (id.equals(row)) {
                
                model.setValueAt(name, i, 1);
                model.setValueAt(table, i, 2);
                model.setValueAt(AyamBakar, i, 3);
                model.setValueAt(IkanGoreng, i, 4);
                model.setValueAt(Sushi, i, 5);
                model.setValueAt(Tongseng, i, 6);
                model.setValueAt(EsTeh, i, 7);
                model.setValueAt(JusAlpukat, i, 8);
                model.setValueAt(ThaiTea, i, 9);
                model.setValueAt(Matcha, i, 10);
                model.setValueAt(Progress, i, 11);
            }
        }
        

    }
     private String validateForm() {
        ArrayList<String> flag = new ArrayList<String>();
        String alert = "";
       
        

        String name = tf_name.getText();
        
        if(name.length() < 1) {
            flag.add("Nama tidak boleh kosong!");
        }
        
        if(!name.matches("[a-z A-Z]+")){
            flag.add("Nama hanya boleh berisi karakter saja!");
        }
        
        String table = tf_table.getText();
        
        if(table.length() < 1) {
            flag.add("Nomor meja tidak boleh kosong!");
        }
        
        if(!table.matches("[0-9]+")){
            flag.add("Nomor meja hanya boleh berisi angka saja!");
        }
        
        if (flag.size() > 0) {
            for (String msg : flag) {
                alert += (msg + "\n");
            }
        }
        
        return alert;
    }
     
     private void search(String _id) {
        
         
        String name = null;
        String table = null;
        String AyamBakar = null;
        String IkanGoreng = null;
        String Sushi = null;
        String Tongseng = null;
        String EsTeh = null;
        String JusAlpukat = null;
        String ThaiTea = null;
        String Matcha = null;
        String Progress = null;
        
        // Pencarian baris dan kolom pada model tabel
        for (int i = 0; model.getRowCount() > i; i++) {
            String id = (String) model.getValueAt(i, 0); //1
            
            if (id.equals(_id)) {
                this.selectedId = Integer.parseInt(id);
                
                name = (String) model.getValueAt(i, 1);
                table = (String) model.getValueAt(i, 2);
                AyamBakar = (String) model.getValueAt(i, 3);
                IkanGoreng= (String) model.getValueAt(i, 4);
                Sushi = (String) model.getValueAt(i, 5);
                Tongseng = (String) model.getValueAt(i, 6);
                EsTeh = (String) model.getValueAt(i, 7);
                JusAlpukat = (String) model.getValueAt(i, 8);
                ThaiTea = (String) model.getValueAt(i, 9);
                Matcha = (String) model.getValueAt(i, 10);
                Progress = (String) model.getValueAt(i, 11);
                
                // Tombol 
                btn_delete.setVisible(true);
                cb_progress.setVisible(true);
                break;
            }
            
        }
        
        if(name == null) {
            this.selectedId = 0;
        }
       
        
        tf_name.setText(name);
        tf_table.setText(table); 
        tf_ab.setText (AyamBakar);
        tf_ig.setText(IkanGoreng);
        tf_ss.setText(Sushi);
        tf_ts.setText(Tongseng);
        tf_et.setText(EsTeh);
        tf_ja.setText(JusAlpukat);
        tf_tt.setText(ThaiTea);
        tf_mt.setText(Matcha); 
        cb_progress.setSelectedItem(Progress);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_submit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        tf_mt = new javax.swing.JTextField();
        tf_et = new javax.swing.JTextField();
        tf_ja = new javax.swing.JTextField();
        tf_tt = new javax.swing.JTextField();
        tf_ig = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_data = new javax.swing.JTable();
        tf_ss = new javax.swing.JTextField();
        tf_ab = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_ts = new javax.swing.JTextField();
        tf_name = new javax.swing.JTextField();
        cb_progress = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_table = new javax.swing.JTextField();
        tf_search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 153));
        jPanel1.setForeground(new java.awt.Color(0, 153, 255));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Ikan Goreng");

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Matcha");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Es Teh");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Tongseng");

        btn_submit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_submit.setText("SUBMIT");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        tb_data.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_dataMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_data);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Nama Lengkap");

        cb_progress.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        cb_progress.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOTED", "On Progress", "Quality Check", "Done" }));
        cb_progress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_progressActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Nama Meja");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("ID");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Pesanan");

        btn_search.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_search.setText("SEARCH");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Ayam Bakar");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Jus Alpukat");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Thai Tea");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Sushi");

        btn_logout.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_logout.setText("LOGOUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Figure/rajil-removebg-preview (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_table)
                                .addComponent(tf_name, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel9))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tf_ss, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tf_ts, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tf_ab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tf_ig, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(btn_submit))
                                    .addGap(98, 98, 98)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(btn_delete)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_logout))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tf_et, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tf_ja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tf_tt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tf_mt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(145, 145, 145)))))
                            .addComponent(cb_progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(110, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tf_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_ab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tf_ig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tf_ss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tf_ts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(tf_ja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tf_et, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_tt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(tf_mt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(cb_progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_submit)
                    .addComponent(btn_logout))
                .addContainerGap(153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
         // TODO add your handling code here:
         String validation = this.validateForm();
        
        if(validation.length() > 0) {
            JOptionPane.showMessageDialog(null,  validation, "Validation Error!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        if (this.selectedId > 0) {
            this.update();
        } else {
            this.store();
        }
        
        this.resetForm();                       
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
         // TODO add your handling code here:
         int selectedRowIndex = tb_data.getSelectedRow();
        model.removeRow(selectedRowIndex);
        
        this.resetForm();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tb_dataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dataMousePressed
        // TODO add your handling code here:
        String row = this.getSelectedRow();
     
        String name = null;
        String table = null;
        String AyamBakar = null;
        String IkanGoreng = null;
        String Sushi = null;
        String Tongseng = null;
        String EsTeh = null;
        String JusAlpukat = null;
        String ThaiTea = null;
        String Matcha = null;
        String Progress = null;
                                                                
        

        // Pencarian baris dan kolom pada model tabel
        for (int i = 0; model.getRowCount() > i; i++) {
            String id = (String) model.getValueAt(i, 0);
            
            if (id.equals(row)) {
                this.selectedId = Integer.parseInt(id);
                
               
                name = (String) model.getValueAt(i, 1);
                table = (String) model.getValueAt(i, 2);
                AyamBakar = (String) model.getValueAt(i, 3);
                IkanGoreng= (String) model.getValueAt(i, 4);
                Sushi = (String) model.getValueAt(i, 5);
                Tongseng = (String) model.getValueAt(i, 6);
                EsTeh = (String) model.getValueAt(i, 7);
                JusAlpukat = (String) model.getValueAt(i, 8);
                ThaiTea = (String) model.getValueAt(i, 9);
                Matcha = (String) model.getValueAt(i, 10);
                Progress = (String) model.getValueAt(i, 11);
   
        
                // Tombol hapus ditampilkan
                btn_delete.setVisible(true);
                cb_progress.setVisible(true);
            }
            
        }
        tf_name.setText(name);
        tf_table.setText(table); 
        tf_ab.setText (AyamBakar);
        tf_ig.setText(IkanGoreng);
        tf_ss.setText(Sushi);
        tf_ts.setText(Tongseng);
        tf_et.setText(EsTeh);
        tf_ja.setText(JusAlpukat);
        tf_tt.setText(ThaiTea);
        tf_mt.setText(Matcha); 
        cb_progress.setSelectedItem(Progress);
                              
    }//GEN-LAST:event_tb_dataMousePressed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tempModel = new DefaultTableModel();
        tb_data.setModel(tempModel);
        
        // Menambahkan kolom awal pada bagian atas
         tempModel.addColumn("ID");
         tempModel.addColumn("Nama Customer");
         tempModel.addColumn("Nomor Meja");
         tempModel.addColumn("Ayam Bakar");
         tempModel.addColumn("Ikan Goreng");
         tempModel.addColumn("Sushi");
         tempModel.addColumn("Tongseng");
         tempModel.addColumn("Es Teh");
         tempModel.addColumn("Jus Alpukat");
         tempModel.addColumn("Thai Tea");
         tempModel.addColumn("Matcha");
         tempModel.addColumn("Progress");;
        
        String id = tf_search.getText();
        
        this.search(id);
        
        if (this.selectedId < 1) {
            JOptionPane.showMessageDialog(null, "We can't found any data", "Data not found", JOptionPane.INFORMATION_MESSAGE);
            this.resetForm();
            return;
        }
        
        Object[] obj = new Object[]{
            this.selectedId,
            tf_name.getText(),
            tf_table.getText(),
            tf_ab.getText() ,
        tf_ig.getText() ,
        tf_ss.getText() ,
        tf_ts.getText() ,
        tf_et.getText() ,
        tf_ja.getText() ,
        tf_tt.getText() ,
        tf_mt.getText() ,
        cb_progress.getSelectedItem().toString() ,
            
        };
        
        tempModel.addRow(obj);
    
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
         new Logout().show();
         this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void cb_progressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_progressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_progressActionPerformed

     
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RestaurantFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox<String> cb_progress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_data;
    private javax.swing.JTextField tf_ab;
    private javax.swing.JTextField tf_et;
    private javax.swing.JTextField tf_ig;
    private javax.swing.JTextField tf_ja;
    private javax.swing.JTextField tf_mt;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_ss;
    private javax.swing.JTextField tf_table;
    private javax.swing.JTextField tf_ts;
    private javax.swing.JTextField tf_tt;
    // End of variables declaration//GEN-END:variables
}
