package View;

import controller.Listener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class DashboardAdmin extends javax.swing.JFrame {

    Listener listener;
    
    public DashboardAdmin() {
        initComponents();
        
//        this.Alamat.setVisible(false);
//        this.DaftarIdForm.setVisible(false);
//        this.DaftarKodeAgensi1.setVisible(false);
//        this.DashboardLabel.setVisible(false);
//        this.Deskripsi.setVisible(false);
//        this.Harga.setVisible(false);
//        this.InputKodeAgensi.setVisible(false);
//        this.InputWaktuTersedia1.setVisible(false);
//        this.JumlahKamar.setVisible(false);
//        this.JumlahLantai.setVisible(false);
//        this.JumlahParkir.setVisible(false);
//        this.JumlahToilet.setVisible(false);
//        this.ListIdForm.setVisible(false);
//        this.ListKodeAgensi1.setVisible(false);
//        this.LuasBangunan.setVisible(false);
//        this.LuasTanah.setVisible(false);
//        this.MasukanIdFormPengajuan.setVisible(false);
//        this.NamaRumah.setVisible(false);
//        this.TableDataRumah.setVisible(false);
//        this.TextFieldInputIdForm.setVisible(false);
//        this.TextFieldInputKode.setVisible(false);
//        this.TextFieldInputWaktu1.setVisible(false);
//        this.SubmitDeleteAll.setVisible(false);
//        this.SubmitDeleteID.setVisible(false);
//        this.SubmitInputIdForm1.setVisible(false);
//        this.SubmitInputKode.setVisible(false);
//        this.SubmitInputKode2.setVisible(false);
        
    }

    public JLabel getLabelKeterangan() {
        return LabelKeterangan;
    }

    public JTable getTableForm() {
        return TableForm;
    }

    public JTable getTableWaktu() {
        return TableWaktu;
    }

    public JScrollPane getjScrollPane6() {
        return jScrollPane6;
    }

    public JScrollPane getjScrollPane7() {
        return jScrollPane7;
    }

    public JLabel getLabelNamaAgensi() {
        return LabelNamaAgensi;
    }

    public JLabel getInputNamaAgensi() {
        return InputNamaAgensi;
    }

    public JTextField getTextFieldInputNamaAgensi() {
        return TextFieldInputNamaAgensi;
    }

    
    public JLabel getCodeAgensi() {
        return CodeAgensi;
    }

    public JButton getKonfirmasiTable() {
        return KonfirmasiTable;
    }

    public JTable getTableUntukKonfirmasi() {
        return TableUntukKonfirmasi;
    }

    public JScrollPane getjScrollPane4() {
        return jScrollPane4;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public JLabel getAlamat() {
        return Alamat;
    }

    public JLabel getDaftarIdForm() {
        return DaftarIdForm;
    }

    public JLabel getDaftarKodeAgensi1() {
        return DaftarKodeAgensi1;
    }

    public JLabel getDashboardLabel() {
        return DashboardLabel;
    }

    public JLabel getDeskripsi() {
        return Deskripsi;
    }

    public JLabel getHarga() {
        return Harga;
    }

    public JLabel getInputKodeAgensi() {
        return InputKodeAgensi;
    }

    public JLabel getInputWaktuTersedia1() {
        return InputWaktuTersedia1;
    }

    public JLabel getJumlahKamar() {
        return JumlahKamar;
    }

    public JLabel getJumlahLantai() {
        return JumlahLantai;
    }

    public JLabel getJumlahParkir() {
        return JumlahParkir;
    }

    public JLabel getJumlahToilet() {
        return JumlahToilet;
    }

    public JToggleButton getKonfirmasiForm() {
        return KonfirmasiForm;
    }

    public JToggleButton getLihatDataRumah() {
        return LihatDataRumah;
    }

    public JToggleButton getLihatKodeAgensi() {
        return LihatKodeAgensi;
    }

    public JList<String> getListIdForm() {
        return ListIdForm;
    }

    public JList<String> getListKodeAgensi1() {
        return ListKodeAgensi1;
    }

    public JButton getLogout() {
        return Logout;
    }

    public JLabel getLuasBangunan() {
        return LuasBangunan;
    }

    public JLabel getLuasTanah() {
        return LuasTanah;
    }

    public JLabel getMasukanIdFormPengajuan() {
        return MasukanIdFormPengajuan;
    }

    public JToggleButton getMenambahWaktuForm() {
        return MenambahWaktuForm;
    }

    public JToggleButton getMenyuntingWaktuForm() {
        return MenyuntingWaktuForm;
    }

    public JLabel getNamaRumah() {
        return NamaRumah;
    }

    public JButton getSubmitDeleteAll() {
        return KonfirmasiTable;
    }

    public JButton getSubmitDeleteID() {
        return SubmitDeleteID;
    }

    public JButton getSubmitInputIdForm1() {
        return SubmitInputIdForm1;
    }

    public JButton getSubmitInputKode() {
        return SubmitInputKode;
    }

    public JButton getSubmitInputKode2() {
        return SubmitInputKode2;
    }

    public JTable getTableDataRumah() {
        return TableDataRumah;
    }

    public JToggleButton getTambahKodeAgensi() {
        return TambahKodeAgensi;
    }

    public JTextField getTextFieldInputIdForm() {
        return TextFieldInputIdForm;
    }

    public JTextField getTextFieldInputKode() {
        return TextFieldInputKode;
    }

    public JTextField getTextFieldInputWaktu1() {
        return TextFieldInputWaktu1;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public JList<String> getListWaktu() {
        return ListWaktu;
    }

    public JScrollPane getjScrollPane5() {
        return jScrollPane5;
    }

    public JLabel getLabelKodeAgensi() {
        return LabelKodeAgensi;
    }

    public JLabel getLabelWaktuDipilih() {
        return LabelWaktuDipilih;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        LabelKeterangan = new javax.swing.JLabel();
        InputNamaAgensi = new javax.swing.JLabel();
        TextFieldInputNamaAgensi = new javax.swing.JTextField();
        LabelKodeAgensi = new javax.swing.JLabel();
        LabelNamaAgensi = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        DaftarIdForm = new javax.swing.JLabel();
        InputKodeAgensi = new javax.swing.JLabel();
        TextFieldInputKode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListIdForm = new javax.swing.JList<>();
        SubmitInputKode = new javax.swing.JButton();
        MasukanIdFormPengajuan = new javax.swing.JLabel();
        TextFieldInputIdForm = new javax.swing.JTextField();
        SubmitDeleteID = new javax.swing.JButton();
        InputWaktuTersedia1 = new javax.swing.JLabel();
        TextFieldInputWaktu1 = new javax.swing.JTextField();
        SubmitInputKode2 = new javax.swing.JButton();
        DaftarKodeAgensi1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListKodeAgensi1 = new javax.swing.JList<>();
        SubmitInputIdForm1 = new javax.swing.JButton();
        KonfirmasiTable = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableDataRumah = new javax.swing.JTable();
        Alamat = new javax.swing.JLabel();
        NamaRumah = new javax.swing.JLabel();
        Deskripsi = new javax.swing.JLabel();
        Harga = new javax.swing.JLabel();
        JumlahKamar = new javax.swing.JLabel();
        LuasBangunan = new javax.swing.JLabel();
        LuasTanah = new javax.swing.JLabel();
        JumlahParkir = new javax.swing.JLabel();
        JumlahLantai = new javax.swing.JLabel();
        JumlahToilet = new javax.swing.JLabel();
        LabelWaktuDipilih = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableUntukKonfirmasi = new javax.swing.JTable();
        CodeAgensi = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListWaktu = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableWaktu = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableForm = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        LihatDataRumah = new javax.swing.JToggleButton();
        TambahKodeAgensi = new javax.swing.JToggleButton();
        LihatKodeAgensi = new javax.swing.JToggleButton();
        MenambahWaktuForm = new javax.swing.JToggleButton();
        MenyuntingWaktuForm = new javax.swing.JToggleButton();
        KonfirmasiForm = new javax.swing.JToggleButton();
        DashboardLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelKeterangan.setText("HH;MM;SS");
        jPanel1.add(LabelKeterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        InputNamaAgensi.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        InputNamaAgensi.setForeground(new java.awt.Color(204, 102, 0));
        InputNamaAgensi.setText("Input Nama Agensi Baru :");
        jPanel1.add(InputNamaAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 180, -1));

        TextFieldInputNamaAgensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldInputNamaAgensiActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldInputNamaAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 98, -1));

        LabelKodeAgensi.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        LabelKodeAgensi.setForeground(new java.awt.Color(204, 102, 0));
        LabelKodeAgensi.setText("Kode Agensi :");
        jPanel1.add(LabelKodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 300, -1));

        LabelNamaAgensi.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        LabelNamaAgensi.setForeground(new java.awt.Color(204, 102, 0));
        LabelNamaAgensi.setText("Nama Agensi :");
        jPanel1.add(LabelNamaAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 310, -1));

        Logout.setBackground(new java.awt.Color(204, 102, 0));
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        jPanel1.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        DaftarIdForm.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        DaftarIdForm.setForeground(new java.awt.Color(204, 102, 0));
        DaftarIdForm.setText("ID Form :");
        jPanel1.add(DaftarIdForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 186, -1));

        InputKodeAgensi.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        InputKodeAgensi.setForeground(new java.awt.Color(204, 102, 0));
        InputKodeAgensi.setText("Input Kode Agensi Baru :");
        jPanel1.add(InputKodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 180, -1));

        TextFieldInputKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldInputKodeActionPerformed(evt);
            }
        });
        jPanel1.add(TextFieldInputKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 98, -1));

        ListIdForm.setForeground(new java.awt.Color(204, 102, 0));
        ListIdForm.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ID 1", "ID 2", "ID 3", "ID 4", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListIdForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListIdFormMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ListIdForm);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 143, -1));

        SubmitInputKode.setBackground(new java.awt.Color(204, 102, 0));
        SubmitInputKode.setForeground(new java.awt.Color(255, 255, 255));
        SubmitInputKode.setText("Submit");
        SubmitInputKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitInputKodeActionPerformed(evt);
            }
        });
        jPanel1.add(SubmitInputKode, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        MasukanIdFormPengajuan.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        MasukanIdFormPengajuan.setForeground(new java.awt.Color(204, 102, 0));
        MasukanIdFormPengajuan.setText("Input ID Form Pengajuan :");
        jPanel1.add(MasukanIdFormPengajuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 232, -1));

        TextFieldInputIdForm.setEditable(false);
        jPanel1.add(TextFieldInputIdForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 98, -1));

        SubmitDeleteID.setBackground(new java.awt.Color(204, 102, 0));
        SubmitDeleteID.setForeground(new java.awt.Color(255, 255, 255));
        SubmitDeleteID.setText("Delete ID");
        SubmitDeleteID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitDeleteIDMouseClicked(evt);
            }
        });
        SubmitDeleteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitDeleteIDActionPerformed(evt);
            }
        });
        jPanel1.add(SubmitDeleteID, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, -1, -1));

        InputWaktuTersedia1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        InputWaktuTersedia1.setForeground(new java.awt.Color(204, 102, 0));
        InputWaktuTersedia1.setText("Input Waktu Tersedia(Tanggal) :");
        jPanel1.add(InputWaktuTersedia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 232, -1));
        jPanel1.add(TextFieldInputWaktu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 98, -1));

        SubmitInputKode2.setBackground(new java.awt.Color(204, 102, 0));
        SubmitInputKode2.setForeground(new java.awt.Color(255, 255, 255));
        SubmitInputKode2.setText("Submit");
        SubmitInputKode2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitInputKode2ActionPerformed(evt);
            }
        });
        jPanel1.add(SubmitInputKode2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        DaftarKodeAgensi1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        DaftarKodeAgensi1.setForeground(new java.awt.Color(204, 102, 0));
        DaftarKodeAgensi1.setText("Daftar Kode Agensi :");
        jPanel1.add(DaftarKodeAgensi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 186, -1));

        ListKodeAgensi1.setForeground(new java.awt.Color(204, 102, 0));
        ListKodeAgensi1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Kode 1", "Kode 2", "Kode 3", "Kode 4", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListKodeAgensi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListKodeAgensi1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListKodeAgensi1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 143, -1));

        SubmitInputIdForm1.setBackground(new java.awt.Color(204, 102, 0));
        SubmitInputIdForm1.setForeground(new java.awt.Color(255, 255, 255));
        SubmitInputIdForm1.setText("Submit");
        SubmitInputIdForm1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitInputIdForm1ActionPerformed(evt);
            }
        });
        jPanel1.add(SubmitInputIdForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, -1, -1));

        KonfirmasiTable.setBackground(new java.awt.Color(204, 102, 0));
        KonfirmasiTable.setForeground(new java.awt.Color(255, 255, 255));
        KonfirmasiTable.setText("Konfirmasi");
        KonfirmasiTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KonfirmasiTableActionPerformed(evt);
            }
        });
        jPanel1.add(KonfirmasiTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 790, -1, -1));

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });

        TableDataRumah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Rumah", "Alamat", "Harga"
            }
        ));
        TableDataRumah.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        TableDataRumah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDataRumahMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableDataRumah);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 570, 220));

        Alamat.setText("Alamat :");
        jPanel1.add(Alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, 20));

        NamaRumah.setText("Nama Rumah :");
        jPanel1.add(NamaRumah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, 20));

        Deskripsi.setText("Deskripsi :");
        jPanel1.add(Deskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, -1, 20));

        Harga.setText("Harga : ");
        jPanel1.add(Harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, -1, 20));

        JumlahKamar.setText("Jumlah Kamar :");
        jPanel1.add(JumlahKamar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, -1, 20));

        LuasBangunan.setText("Luas Bangunan :");
        jPanel1.add(LuasBangunan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, -1, 20));

        LuasTanah.setText("Luas Tanah :");
        jPanel1.add(LuasTanah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, -1, 20));

        JumlahParkir.setText("Jumlah Parkir :");
        jPanel1.add(JumlahParkir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 730, -1, 20));

        JumlahLantai.setText("Jumlah Lantai :");
        jPanel1.add(JumlahLantai, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 760, -1, 20));

        JumlahToilet.setText("Jumlah Toilet :");
        jPanel1.add(JumlahToilet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 790, -1, 20));

        LabelWaktuDipilih.setText("Waktu yang Dipilih :");
        jPanel1.add(LabelWaktuDipilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        jScrollPane4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane4MouseClicked(evt);
            }
        });

        TableUntukKonfirmasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama Rumah", "Alamat", "Harga"
            }
        ));
        TableUntukKonfirmasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableUntukKonfirmasiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TableUntukKonfirmasi);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 570, 210));

        CodeAgensi.setText("Code Agensi :");
        jPanel1.add(CodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, 20));

        ListWaktu.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(ListWaktu);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 140, -1));

        TableWaktu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        TableWaktu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableWaktuMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TableWaktu);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 570, 200));

        TableForm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        TableForm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableFormMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TableForm);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 570, 260));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1040, 830));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LihatDataRumah.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(LihatDataRumah);
        LihatDataRumah.setForeground(new java.awt.Color(255, 255, 255));
        LihatDataRumah.setText("LihatDataRumah");
        LihatDataRumah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatDataRumahActionPerformed(evt);
            }
        });
        jPanel2.add(LihatDataRumah, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 80, 160, -1));

        TambahKodeAgensi.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(TambahKodeAgensi);
        TambahKodeAgensi.setForeground(new java.awt.Color(255, 255, 255));
        TambahKodeAgensi.setText("TambahKodeAgensi");
        TambahKodeAgensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahKodeAgensiActionPerformed(evt);
            }
        });
        jPanel2.add(TambahKodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 136, 160, -1));

        LihatKodeAgensi.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(LihatKodeAgensi);
        LihatKodeAgensi.setForeground(new java.awt.Color(255, 255, 255));
        LihatKodeAgensi.setText("MenambahWaktuForm");
        LihatKodeAgensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LihatKodeAgensiActionPerformed(evt);
            }
        });
        jPanel2.add(LihatKodeAgensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 245, 160, -1));

        MenambahWaktuForm.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(MenambahWaktuForm);
        MenambahWaktuForm.setForeground(new java.awt.Color(255, 255, 255));
        MenambahWaktuForm.setText("MenyuntingWaktuForm");
        MenambahWaktuForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenambahWaktuFormActionPerformed(evt);
            }
        });
        jPanel2.add(MenambahWaktuForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 300, 160, -1));

        MenyuntingWaktuForm.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(MenyuntingWaktuForm);
        MenyuntingWaktuForm.setForeground(new java.awt.Color(255, 255, 255));
        MenyuntingWaktuForm.setText("KonfirmasiForm");
        MenyuntingWaktuForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenyuntingWaktuFormActionPerformed(evt);
            }
        });
        jPanel2.add(MenyuntingWaktuForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 355, 160, -1));

        KonfirmasiForm.setBackground(new java.awt.Color(204, 102, 0));
        buttonGroup1.add(KonfirmasiForm);
        KonfirmasiForm.setForeground(new java.awt.Color(255, 255, 255));
        KonfirmasiForm.setText("LihatKodeAgensi");
        KonfirmasiForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KonfirmasiFormActionPerformed(evt);
            }
        });
        jPanel2.add(KonfirmasiForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 190, 160, -1));

        DashboardLabel.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        DashboardLabel.setForeground(new java.awt.Color(204, 102, 0));
        DashboardLabel.setText("Dashboard Admin");
        jPanel2.add(DashboardLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 22, 217, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LihatDataRumahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatDataRumahActionPerformed
        listener.pilihanAdmin();
        listener.isiTabel();
    }//GEN-LAST:event_LihatDataRumahActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        listener.LogOut();
    }//GEN-LAST:event_LogoutActionPerformed

    private void TambahKodeAgensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahKodeAgensiActionPerformed
        listener.pilihanAdmin();
    }//GEN-LAST:event_TambahKodeAgensiActionPerformed

    private void KonfirmasiFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KonfirmasiFormActionPerformed
        listener.pilihanAdmin();
        listener.isiListKodeAgen();
    }//GEN-LAST:event_KonfirmasiFormActionPerformed

    private void LihatKodeAgensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LihatKodeAgensiActionPerformed
        listener.pilihanAdmin();
        listener.isiListForm();
        listener.isiTabel();
    }//GEN-LAST:event_LihatKodeAgensiActionPerformed

    private void MenambahWaktuFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenambahWaktuFormActionPerformed
        listener.pilihanAdmin();
        listener.isiListForm();
        listener.isiListKodeAgen();
        listener.isiTabel();
    }//GEN-LAST:event_MenambahWaktuFormActionPerformed

    private void MenyuntingWaktuFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenyuntingWaktuFormActionPerformed
        listener.pilihanAdmin();
        listener.isiListForm();
        listener.isiTabel();
    }//GEN-LAST:event_MenyuntingWaktuFormActionPerformed

    private void TableDataRumahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDataRumahMouseClicked
        listener.isiField(TableDataRumah.getSelectedRow());
    }//GEN-LAST:event_TableDataRumahMouseClicked

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        listener.isiField(TableDataRumah.getSelectedRow());
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void SubmitInputKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitInputKodeActionPerformed
        listener.submitKodeAgen();
    }//GEN-LAST:event_SubmitInputKodeActionPerformed

    private void KonfirmasiTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KonfirmasiTableActionPerformed
        listener.KonfirmasiRumah(TableUntukKonfirmasi.getSelectedRow());
    }//GEN-LAST:event_KonfirmasiTableActionPerformed

    private void TableUntukKonfirmasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableUntukKonfirmasiMouseClicked
        listener.isiFieldKonfirmasi(TableUntukKonfirmasi.getSelectedRow());
    }//GEN-LAST:event_TableUntukKonfirmasiMouseClicked

    private void jScrollPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane4MouseClicked
        listener.isiFieldKonfirmasi(TableUntukKonfirmasi.getSelectedRow());
    }//GEN-LAST:event_jScrollPane4MouseClicked

    private void SubmitDeleteIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitDeleteIDMouseClicked
        
    }//GEN-LAST:event_SubmitDeleteIDMouseClicked

    private void TextFieldInputKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldInputKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInputKodeActionPerformed

    private void SubmitDeleteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitDeleteIDActionPerformed
        listener.Delete();
    }//GEN-LAST:event_SubmitDeleteIDActionPerformed

    private void SubmitInputIdForm1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitInputIdForm1ActionPerformed
        listener.updateForm();
        listener.isiTabel();
    }//GEN-LAST:event_SubmitInputIdForm1ActionPerformed

    private void ListIdFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListIdFormMouseClicked
        listener.isiField(ListIdForm.getSelectedIndex());
    }//GEN-LAST:event_ListIdFormMouseClicked

    private void ListKodeAgensi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListKodeAgensi1MouseClicked
        listener.isiField(ListKodeAgensi1.getSelectedIndex());
    }//GEN-LAST:event_ListKodeAgensi1MouseClicked

    private void TextFieldInputNamaAgensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldInputNamaAgensiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldInputNamaAgensiActionPerformed

    private void TableWaktuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableWaktuMouseClicked
        listener.isiField(TableWaktu.getSelectedRow());
    }//GEN-LAST:event_TableWaktuMouseClicked

    private void TableFormMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableFormMouseClicked
        listener.isiField(TableForm.getSelectedRow());
    }//GEN-LAST:event_TableFormMouseClicked

    private void SubmitInputKode2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitInputKode2ActionPerformed
        listener.inputWaktu();
    }//GEN-LAST:event_SubmitInputKode2ActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel CodeAgensi;
    private javax.swing.JLabel DaftarIdForm;
    private javax.swing.JLabel DaftarKodeAgensi1;
    private javax.swing.JLabel DashboardLabel;
    private javax.swing.JLabel Deskripsi;
    private javax.swing.JLabel Harga;
    private javax.swing.JLabel InputKodeAgensi;
    private javax.swing.JLabel InputNamaAgensi;
    private javax.swing.JLabel InputWaktuTersedia1;
    private javax.swing.JLabel JumlahKamar;
    private javax.swing.JLabel JumlahLantai;
    private javax.swing.JLabel JumlahParkir;
    private javax.swing.JLabel JumlahToilet;
    private javax.swing.JToggleButton KonfirmasiForm;
    private javax.swing.JButton KonfirmasiTable;
    private javax.swing.JLabel LabelKeterangan;
    private javax.swing.JLabel LabelKodeAgensi;
    private javax.swing.JLabel LabelNamaAgensi;
    private javax.swing.JLabel LabelWaktuDipilih;
    private javax.swing.JToggleButton LihatDataRumah;
    private javax.swing.JToggleButton LihatKodeAgensi;
    private javax.swing.JList<String> ListIdForm;
    private javax.swing.JList<String> ListKodeAgensi1;
    private javax.swing.JList<String> ListWaktu;
    private javax.swing.JButton Logout;
    private javax.swing.JLabel LuasBangunan;
    private javax.swing.JLabel LuasTanah;
    private javax.swing.JLabel MasukanIdFormPengajuan;
    private javax.swing.JToggleButton MenambahWaktuForm;
    private javax.swing.JToggleButton MenyuntingWaktuForm;
    private javax.swing.JLabel NamaRumah;
    private javax.swing.JButton SubmitDeleteID;
    private javax.swing.JButton SubmitInputIdForm1;
    private javax.swing.JButton SubmitInputKode;
    private javax.swing.JButton SubmitInputKode2;
    private javax.swing.JTable TableDataRumah;
    private javax.swing.JTable TableForm;
    private javax.swing.JTable TableUntukKonfirmasi;
    private javax.swing.JTable TableWaktu;
    private javax.swing.JToggleButton TambahKodeAgensi;
    private javax.swing.JTextField TextFieldInputIdForm;
    private javax.swing.JTextField TextFieldInputKode;
    private javax.swing.JTextField TextFieldInputNamaAgensi;
    private javax.swing.JTextField TextFieldInputWaktu1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
