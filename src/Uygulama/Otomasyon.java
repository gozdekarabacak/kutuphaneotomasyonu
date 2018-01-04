package Uygulama;

import DBSQLite.DB;
import Verilerim.Kategori;
import Verilerim.Kitaplar;
import Uygulama.Login;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Otomasyon extends javax.swing.JFrame {

    public Otomasyon() {
        initComponents();
        setLocationRelativeTo(this);
        KategoriListele();
        KategoriComboYukle();
        KitapListele();
        lblKullanici.setText(Login.kullaniciAdi);
    }
    ArrayList<Kategori> ktgr = new ArrayList<>();
    ArrayList<Kitaplar> kitap = new ArrayList<>();

    private void KategoriListele() {
        ktgr.clear();
        DB db = new DB();
        try {
            String query = "SELECT * FROM kitapturleri";
            ResultSet rs = db.baglan().executeQuery(query);
            while (rs.next()) {
                Kategori kt = new Kategori();
                kt.setTur_id(Integer.valueOf(rs.getString("tur_id")));
                kt.setTur_adi(rs.getString("tur_adi"));
                kt.setStant_no(rs.getString("stant_no"));
                kt.setStant_adres(rs.getString("stant_adres"));
                kt.setEklenme_tarihi(rs.getString("eklenme_tarihi"));
                ktgr.add(kt);
            }
        } catch (Exception e) {
            System.err.println("Kategori alma Hatası..");
        } finally {
            db.kapat();
        }
        DefaultTableModel dtm = new DefaultTableModel();
        /*  TableModel md = tablaKategoriKontrol.getModel();*/
        dtm.addColumn("Id");
        dtm.addColumn("Tür Adı");
        dtm.addColumn("Stant No");
        dtm.addColumn("Stant Adres");
        dtm.addColumn("Tarih");

        for (Kategori kategori : ktgr) {
            //System.out.println(String.valueOf(kategori.getTur_id()) + kategori.getTur_adi() + kategori.getStant_no() + kategori.getStant_adres() + kategori.getEklenme_tarihi());

            dtm.addRow(new String[]{String.valueOf(kategori.getTur_id()), kategori.getTur_adi(), kategori.getStant_no(), kategori.getStant_adres(), kategori.getEklenme_tarihi()});
        }
        tablaKategoriKontrol.setModel(dtm);
    }

    private void KategoriComboYukle() {
        cmbKitapKontrolKitapTuru.removeAllItems();
        DefaultComboBoxModel cm = new DefaultComboBoxModel();
        DB db = new DB();
        try {
            String query = "SELECT * FROM kitapturleri";
            ResultSet rs = db.baglan().executeQuery(query);
            while (rs.next()) {
                cm.addElement(rs.getString("tur_adi"));
            }
            cmbKitapKontrolKitapTuru.setModel(cm);
        } catch (SQLException e) {
            System.err.println("Kategori alma Hatası..");
        } finally {
            db.kapat();
        }
    }

    private void KitapListele() {
        kitap.clear();
        tableKitapKontrol.removeAll();
        DB db = new DB();
        try {
            String query = "SELECT * FROM kitaplar";
            ResultSet rs = db.baglan().executeQuery(query);
            while (rs.next()) {
                System.out.println("data");
                Kitaplar kt = new Kitaplar();
                kt.setK_id(Integer.valueOf(rs.getString("k_id")));
                System.out.println("k_id");
                kt.setEklenme_tarihi(rs.getString("eklenme_tarihi"));
                System.out.println("eklenme_tarihi");
                kt.setKitap_adi(rs.getString("kitap_adi"));
                System.out.println("kitap_adi");
                kt.setKitap_dili(rs.getString("kitap_dili"));
                System.out.println("kitap_dili");
                kt.setKitap_kisa_aciklama(rs.getString("kitap_kisa_aciklama"));
                System.out.println("kitap_kisa_aciklama");
                kt.setKitap_turu(rs.getString("kitap_turu"));
                System.out.println("kitap_turu");
                kt.setRaf_no(rs.getString("raf_no"));
                System.out.println("raf_no");
                //kt.setTurid(Integer.valueOf(rs.getString("turid")));
                //System.out.println("turid");
                kt.setYayin_evi(rs.getString("yayin_evi"));
                System.out.println("yayin_evi");
                kt.setYazar_adi(rs.getString("yazar_adi"));
                System.out.println("yazar_adi");

                kitap.add(kt);
            }
        } catch (NumberFormatException | SQLException e) {
            System.err.println("Kitap listeleme Hatası..");
        } finally {
            db.kapat();
        }
        DefaultTableModel dtm = new DefaultTableModel();
        /*  TableModel md = tablaKategoriKontrol.getModel();*/

        dtm.addColumn("Id");
        dtm.addColumn("Türü");
        dtm.addColumn("Kitap Adı");
        dtm.addColumn("Açıklama");
        dtm.addColumn("Yazar");
        dtm.addColumn("Yayın Evi");
        dtm.addColumn("Raf No");
        dtm.addColumn("Tarih");

        for (Kitaplar ktp : kitap) {
            System.out.println(String.valueOf(ktp.getK_id()) + String.valueOf(ktp.getKitap_turu()) + ktp.getKitap_adi() + ktp.getKitap_kisa_aciklama() + ktp.getYazar_adi() + ktp.getYayin_evi() + ktp.getRaf_no() + ktp.getEklenme_tarihi());

            dtm.addRow(new String[]{String.valueOf(ktp.getK_id()), String.valueOf(ktp.getKitap_turu()), ktp.getKitap_adi(), ktp.getKitap_kisa_aciklama(), ktp.getYazar_adi(), ktp.getYayin_evi(), ktp.getRaf_no(), ktp.getEklenme_tarihi()});
        }
        tableKitapKontrol.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtKitapSorgulaAra = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKitapSorgula = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtKitapSorgulaKitapAdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKitapSorgulaKitapTuru = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtKitapSorgulaYazarAdi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtKitapSorgulaKitapDili = new javax.swing.JTextField();
        txtKitapSorgulaYayinEvi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtKitapSorgulaRafNo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtKitapSorgulaKisaAciklama = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtKitapKontrolKitapAdi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtKitapKontrolYazarAdi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtKitapKontrolKitapDili = new javax.swing.JTextField();
        txtKitapKontrolYayinEvi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtKitapKontrolRafNo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKitapKontrolKisaAciklama = new javax.swing.JTextArea();
        cmbKitapKontrolKitapTuru = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        btnKitapKontrolDüzenle = new javax.swing.JButton();
        btnKitapKontrolSil = new javax.swing.JButton();
        btnKitapKontrolTemizle = new javax.swing.JButton();
        btnKitapKontrolKitapEkle = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableKitapKontrol = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtKategoriKontrolKategoriAdi = new javax.swing.JTextField();
        txtKategoriKontrolStantAdres = new javax.swing.JTextField();
        btnKategoriKontrolEkle = new javax.swing.JButton();
        txtKategoriKontrolStantNo = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btnKategoriKontrolDüzenle = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaKategoriKontrol = new javax.swing.JTable();
        btnKategoriKontrolSil = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblKullanici = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.W_RESIZE_CURSOR));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ayarlar.png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/kapat.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setPreferredSize(new java.awt.Dimension(64, 64));
        jButton4.setSelected(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Kütüphane Otomasyonu");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtKitapSorgulaAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKitapSorgulaAraKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtKitapSorgulaAra)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtKitapSorgulaAra, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        tableKitapSorgula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kitap Türü", "Kitap Adı", "Kısa Açıklama", "Yazar Adı", "Yayın Evi", "Kitap Dili", "Raf Numarası"
            }
        ));
        tableKitapSorgula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKitapSorgulaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKitapSorgula);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Kitap Adı : ");

        txtKitapSorgulaKitapAdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKitapSorgulaKitapAdiActionPerformed(evt);
            }
        });

        jLabel3.setText("Kitap Türü : ");

        jLabel4.setText("Yazar Adı : ");

        jLabel5.setText("Kitap Dili : ");

        jLabel6.setText("Yayın Evi : ");

        jLabel7.setText("Raf No : ");

        jLabel8.setText("Kısa Açıklama : ");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25)
                        .addComponent(txtKitapSorgulaKitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKitapSorgulaYazarAdi)
                            .addComponent(txtKitapSorgulaKitapTuru)
                            .addComponent(txtKitapSorgulaKitapDili, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
                .addGap(64, 64, 64)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKitapSorgulaYayinEvi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKitapSorgulaKisaAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKitapSorgulaRafNo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKitapSorgulaKitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtKitapSorgulaYayinEvi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtKitapSorgulaKitapTuru, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtKitapSorgulaRafNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtKitapSorgulaYazarAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtKitapSorgulaKisaAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtKitapSorgulaKitapDili, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("<< ARAMA >>");
        jPanel6.getAccessibleContext().setAccessibleName("<< KİTAPLAR >>");
        jPanel5.getAccessibleContext().setAccessibleName("<< SEÇİLEN KİTAP >>");

        jTabbedPane2.addTab("<< Kitap Sorgula >>", jPanel2);

        jLabel9.setText("Kitap Adı : ");

        jLabel10.setText("Kitap Türü : ");

        jLabel11.setText("Yazar Adı : ");

        jLabel12.setText("Kitap Dili : ");

        jLabel13.setText("Yayın Evi : ");

        jLabel14.setText("Raf No : ");

        jLabel15.setText("Kısa Açıklama : ");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtKitapKontrolKisaAciklama.setColumns(20);
        txtKitapKontrolKisaAciklama.setRows(5);
        jScrollPane2.setViewportView(txtKitapKontrolKisaAciklama);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel9))
                        .addComponent(jLabel11)
                        .addComponent(jLabel12))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbKitapKontrolKitapTuru, 0, 246, Short.MAX_VALUE)
                    .addComponent(txtKitapKontrolYazarAdi)
                    .addComponent(txtKitapKontrolKitapDili)
                    .addComponent(txtKitapKontrolKitapAdi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addGap(46, 46, 46)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKitapKontrolYayinEvi)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(txtKitapKontrolRafNo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtKitapKontrolYayinEvi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKitapKontrolRafNo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbKitapKontrolKitapTuru, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKitapKontrolKitapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKitapKontrolYazarAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtKitapKontrolKitapDili, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnKitapKontrolDüzenle.setText("Düzenle");
        btnKitapKontrolDüzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKitapKontrolDüzenleActionPerformed(evt);
            }
        });

        btnKitapKontrolSil.setText("Sil");
        btnKitapKontrolSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKitapKontrolSilActionPerformed(evt);
            }
        });

        btnKitapKontrolTemizle.setText("Temizle");
        btnKitapKontrolTemizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKitapKontrolTemizleActionPerformed(evt);
            }
        });

        btnKitapKontrolKitapEkle.setText("Yeni Ekle");
        btnKitapKontrolKitapEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKitapKontrolKitapEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnKitapKontrolKitapEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKitapKontrolDüzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnKitapKontrolSil, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKitapKontrolTemizle, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKitapKontrolKitapEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKitapKontrolDüzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKitapKontrolSil, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKitapKontrolTemizle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableKitapKontrol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Türü", "Adı", "Açıklama", "Yazar", "Yayın Evi", "Raf No", "Tarih"
            }
        ));
        tableKitapKontrol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKitapKontrolMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableKitapKontrol);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("<< Kitap Kontrol >>", jPanel3);

        jLabel17.setText("Kategori Adı : ");

        jLabel18.setText("Stant No :");

        jLabel19.setText("Stant Adres :");

        btnKategoriKontrolEkle.setText("EKLE");
        btnKategoriKontrolEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriKontrolEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(63, 63, 63)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtKategoriKontrolStantAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKategoriKontrolStantNo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKategoriKontrolKategoriAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnKategoriKontrolEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKategoriKontrolKategoriAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKategoriKontrolStantAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKategoriKontrolEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKategoriKontrolStantNo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnKategoriKontrolDüzenle.setText("Düzenle");
        btnKategoriKontrolDüzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriKontrolDüzenleActionPerformed(evt);
            }
        });

        tablaKategoriKontrol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Tür Adı", "Stant No", "Stant Adres", "Tarih"
            }
        ));
        tablaKategoriKontrol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaKategoriKontrolMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaKategoriKontrol);

        btnKategoriKontrolSil.setText("Sil");
        btnKategoriKontrolSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriKontrolSilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKategoriKontrolDüzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnKategoriKontrolSil, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKategoriKontrolDüzenle)
                    .addComponent(btnKategoriKontrolSil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.getAccessibleContext().setAccessibleName("asd");

        jTabbedPane2.addTab("<< Kategori Kontrol >>", jPanel4);

        jLabel16.setText("Kullanıcı Adi : ");

        lblKullanici.setText("Guest6078");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKullanici, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKullanici, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtKitapSorgulaAraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKitapSorgulaAraKeyPressed
        kitap.clear();
        String oku = txtKitapSorgulaAra.getText().trim();
        String query = "SELECT * FROM kitaplar WHERE kitap_adi LIKE '" + oku + "%' ";
        DB db = new DB();
        try {
            ResultSet rs = db.baglan().executeQuery(query);
            while (rs.next()) {
                Kitaplar kit = new Kitaplar();
                kit.setKitap_turu((rs.getString("kitap_turu")));
                kit.setKitap_adi(rs.getString("kitap_adi"));
                kit.setKitap_kisa_aciklama(rs.getString("kitap_kisa_aciklama"));
                kit.setYazar_adi(rs.getString("yazar_adi"));
                kit.setYayin_evi(rs.getString("yayin_evi"));
                kit.setKitap_dili(rs.getString("kitap_dili"));
                kit.setRaf_no(rs.getString("raf_no"));
                kitap.add(kit);
            }
        } catch (NumberFormatException | SQLException e) {
            System.err.println("Arama Hatası");
        } finally {
            db.kapat();
        }
        Kitaplar kit = new Kitaplar();

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Kitap Türü");
        dtm.addColumn("Kitap Adı");
        dtm.addColumn("Kısa Açıklama");
        dtm.addColumn("Yazar Adı");
        dtm.addColumn("Yayın Evi");
        dtm.addColumn("Kitap Dili");
        dtm.addColumn("Raf Numarası");

        for (Kitaplar ktp : kitap) {
            dtm.addRow(new String[]{String.valueOf(ktp.getKitap_turu()), ktp.getKitap_adi(), ktp.getKitap_kisa_aciklama(), ktp.getYazar_adi(), ktp.getYayin_evi(), ktp.getKitap_dili(), ktp.getRaf_no()});

        }
        tableKitapSorgula.setModel(dtm);


    }//GEN-LAST:event_txtKitapSorgulaAraKeyPressed

    private void btnKategoriKontrolEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriKontrolEkleActionPerformed

        Calendar takvim = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd H:mm:ss");

        Kategori kt = new Kategori();
        kt.setTur_adi(txtKategoriKontrolKategoriAdi.getText());
        kt.setStant_adres(txtKategoriKontrolStantAdres.getText());
        kt.setStant_no(txtKategoriKontrolStantNo.getText());
        kt.setEklenme_tarihi(String.valueOf(sdf.format(takvim.getTime())));

        DB db = new DB();
        try {
            String query = "INSERT INTO kitapturleri VALUES(null,'" + kt.getTur_adi() + "','" + kt.getStant_no() + "','" + kt.getStant_adres() + "','" + kt.getEklenme_tarihi() + "')";
            int ekle = db.baglan().executeUpdate(query);//eğer -1 ifadesi dönerse işlem başarısız.
            if (ekle > 0) {
                JOptionPane.showMessageDialog(this, "Kategori Ekleme işlemi başarılııı....");
                KategoriListele();
                KategoriComboYukle();
            }
        } catch (Exception e) {
            System.err.println("Kategori ekleme işlemi başarısız");
        } finally {
            db.kapat();
        }

    }//GEN-LAST:event_btnKategoriKontrolEkleActionPerformed

    String kategoriId = "";
    private void tablaKategoriKontrolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaKategoriKontrolMouseClicked
        kategoriId = "" + tablaKategoriKontrol.getValueAt(tablaKategoriKontrol.getSelectedRow(), 0);
        System.out.println("Seçilen Kategori Id :  " + kategoriId);

    }//GEN-LAST:event_tablaKategoriKontrolMouseClicked

    private void btnKategoriKontrolSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriKontrolSilActionPerformed

        if (kategoriId.equals("")) {
            JOptionPane.showMessageDialog(this, "lütfen bir data seçiniz..");
        } else {
            DB db = new DB();
            try {
                String query = "DELETE FROM kitapturleri WHERE tur_id = '" + kategoriId + "'";
                int cntSil = db.baglan().executeUpdate(query);
                if (cntSil > 0) {

                    KategoriComboYukle();
                    KategoriListele();
                    kategoriId = "";
                }
            } catch (Exception e) {
                System.err.println("Kategori Silme Hatası -> " + e.getMessage());
            } finally {
                db.kapat();
            }
        }
    }//GEN-LAST:event_btnKategoriKontrolSilActionPerformed

    private void btnKategoriKontrolDüzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriKontrolDüzenleActionPerformed
        Calendar takvim = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd H:mm:ss");

        Kategori kt = new Kategori();
        kt.setTur_id(Integer.valueOf(kategoriId));
        kt.setTur_adi(String.valueOf(tablaKategoriKontrol.getValueAt(tablaKategoriKontrol.getSelectedRow(), 1)));
        kt.setStant_no(String.valueOf(tablaKategoriKontrol.getValueAt(tablaKategoriKontrol.getSelectedRow(), 2)));
        kt.setStant_adres(String.valueOf(tablaKategoriKontrol.getValueAt(tablaKategoriKontrol.getSelectedRow(), 3)));
        kt.setEklenme_tarihi(String.valueOf(sdf.format(takvim.getTime())));

        DB db = new DB();
        try {
            String query = "UPDATE kitapturleri SET tur_adi = '" + kt.getTur_adi() + "', stant_no = '" + kt.getStant_no() + "', stant_adres = '" + kt.getStant_adres() + "', eklenme_tarihi = '" + kt.getEklenme_tarihi() + "' WHERE tur_id = '" + kategoriId + "'";
            int cntUpdate = db.baglan().executeUpdate(query);
            if (cntUpdate > 0) {
                KategoriComboYukle();
                KategoriListele();
                JOptionPane.showMessageDialog(this, "Güncelleme Başarılı");
            } else {
                JOptionPane.showMessageDialog(this, "Güncelleme Hatası");
            }
        } catch (HeadlessException | SQLException e) {
            System.err.println("kodlama hatası");
        } finally {
            db.kapat();
        }
    }//GEN-LAST:event_btnKategoriKontrolDüzenleActionPerformed

    private void txtKitapSorgulaKitapAdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKitapSorgulaKitapAdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKitapSorgulaKitapAdiActionPerformed

    private void tableKitapSorgulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKitapSorgulaMouseClicked

        txtKitapSorgulaKitapTuru.setText("" + tableKitapSorgula.getValueAt(tableKitapSorgula.getSelectedRow(), 0));
        txtKitapSorgulaKitapAdi.setText("" + tableKitapSorgula.getValueAt(tableKitapSorgula.getSelectedRow(), 1));
        txtKitapSorgulaKisaAciklama.setText("" + tableKitapSorgula.getValueAt(tableKitapSorgula.getSelectedRow(), 2));
        txtKitapSorgulaYazarAdi.setText("" + tableKitapSorgula.getValueAt(tableKitapSorgula.getSelectedRow(), 3));
        txtKitapSorgulaYayinEvi.setText("" + tableKitapSorgula.getValueAt(tableKitapSorgula.getSelectedRow(), 4));
        txtKitapSorgulaKitapDili.setText("" + tableKitapSorgula.getValueAt(tableKitapSorgula.getSelectedRow(), 5));
        txtKitapSorgulaRafNo.setText("" + tableKitapSorgula.getValueAt(tableKitapSorgula.getSelectedRow(), 6));
    }//GEN-LAST:event_tableKitapSorgulaMouseClicked

    private void btnKitapKontrolKitapEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKitapKontrolKitapEkleActionPerformed

        Kitaplar kit = new Kitaplar();
        DB db = new DB();
        try {
            String query = "Select tur_id from kitapturleri where tur_adi LIKE '" + ("" + cmbKitapKontrolKitapTuru.getSelectedItem()) + "'";
            ResultSet rs = db.baglan().executeQuery(query);
            while (rs.next()) {
                kit.setKitap_turu((rs.getString("tur_id")));
            }
        } catch (NumberFormatException | SQLException e) {
            System.err.println("Tur id çekme hatası");
        } finally {
            db.kapat();
        }
        kit.setKitap_adi(txtKitapKontrolKitapAdi.getText());
        kit.setYazar_adi(txtKitapKontrolYazarAdi.getText());
        kit.setYayin_evi(txtKitapKontrolYayinEvi.getText());
        kit.setKitap_dili(txtKitapKontrolKitapDili.getText());
        kit.setRaf_no(txtKitapKontrolRafNo.getText());
        kit.setKitap_kisa_aciklama(txtKitapKontrolKisaAciklama.getText());
        Calendar takvim = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd H:mm:ss");
        kit.setEklenme_tarihi(String.valueOf(sdf.format(takvim.getTime())));
        DB db1 = new DB();
        try {
            String query = "INSERT INTO kitaplar VALUES(null,'" + kit.getKitap_turu() + "','" + kit.getKitap_adi() + "','" + kit.getKitap_kisa_aciklama() + "','" + kit.getYazar_adi() + "','" + kit.getYayin_evi() + "','" + kit.getKitap_dili() + "','" + kit.getRaf_no() + "','" + kit.getEklenme_tarihi() + "',null)";
            int ekle = db1.baglan().executeUpdate(query);
            if (ekle > 0) {
                KitapListele();
                JOptionPane.showMessageDialog(this, "Ekleme işlemi başarılııı....");
            } else {
                JOptionPane.showMessageDialog(this, "Ekleme işlemi hatalııııı....");
            }
        } catch (HeadlessException | SQLException e) {
            System.err.println("Bağlantı Hatası : " + e);
        } finally {
            db1.kapat();
        }

    }//GEN-LAST:event_btnKitapKontrolKitapEkleActionPerformed

    private void btnKitapKontrolTemizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKitapKontrolTemizleActionPerformed
        txtKitapKontrolKisaAciklama.setText("");
        txtKitapKontrolKitapAdi.setText("");
        txtKitapKontrolKitapDili.setText("");
        txtKitapKontrolRafNo.setText("");
        txtKitapKontrolYayinEvi.setText("");
        txtKitapKontrolYazarAdi.setText("");

    }//GEN-LAST:event_btnKitapKontrolTemizleActionPerformed

    String kitapSil = "", kitapDuzenle = "";
    private void tableKitapKontrolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKitapKontrolMouseClicked
        kitapSil = "" + tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 0);
        kitapDuzenle = "" + tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 0);
    }//GEN-LAST:event_tableKitapKontrolMouseClicked

    private void btnKitapKontrolSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKitapKontrolSilActionPerformed

        if (kitapSil.equals("")) {
            JOptionPane.showMessageDialog(this, "lütfen bir data seçiniz..");
        } else {
            DB db = new DB();
            try {
                String query = "delete from kitaplar where k_id = '" + kitapSil + "'";
                int sonuc = db.baglan().executeUpdate(query);
                if (sonuc > 0) {
                    db.kapat();
                    KitapListele();
                    kitapSil = "";
                }
            } catch (Exception e) {
                System.err.println("Silme Hatası.." + e);
            }
        }

    }//GEN-LAST:event_btnKitapKontrolSilActionPerformed

    private void btnKitapKontrolDüzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKitapKontrolDüzenleActionPerformed
        Calendar takvim = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd H:mm:ss");

        Kitaplar kit = new Kitaplar();

        kit.setK_id(Integer.valueOf(kitapDuzenle));
        //kit.setKitap_turu((Integer.valueOf(tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 1))));
        kit.setKitap_turu(String.valueOf(tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 1)));
        kit.setKitap_adi((String.valueOf(tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 2))));
        kit.setKitap_kisa_aciklama((String.valueOf(tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 3))));
        kit.setYazar_adi((String.valueOf(tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 4))));
        kit.setYayin_evi((String.valueOf(tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 5))));
        kit.setRaf_no((String.valueOf(tableKitapKontrol.getValueAt(tableKitapKontrol.getSelectedRow(), 6))));
        kit.setEklenme_tarihi(String.valueOf(sdf.format(takvim.getTime())));

        DB db = new DB();
        try {
            String query = "UPDATE kitaplar SET kitap_turu ='"+kit.getKitap_turu()+"', kitap_adi='"+kit.getKitap_adi()+"', kitap_kisa_aciklama ='"+kit.getKitap_kisa_aciklama()+"',yazar_adi='"+kit.getYazar_adi()+"',yayin_evi='"+kit.getYayin_evi()+"',kitap_dili='"+kit.getKitap_dili()+"',raf_no='"+kit.getRaf_no()+"', eklenme_tarihi = '"+kit.getEklenme_tarihi()+"' WHERE k_id = '"+ kitapDuzenle+"'";

            int cntUpdate = db.baglan().executeUpdate(query);
            if (cntUpdate > 0) {
                KitapListele();
                JOptionPane.showMessageDialog(this, "Güncelleme Başarılı");
            } else {
                JOptionPane.showMessageDialog(this, "Güncelleme Hatası");
            }
        } catch (HeadlessException | SQLException e) {
            System.err.println("kodlama hatası");
        } finally {
            db.kapat();
        }
        

    }//GEN-LAST:event_btnKitapKontrolDüzenleActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        UyeGuncelle gnc = new UyeGuncelle();
        gnc.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Otomasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Otomasyon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKategoriKontrolDüzenle;
    private javax.swing.JButton btnKategoriKontrolEkle;
    private javax.swing.JButton btnKategoriKontrolSil;
    private javax.swing.JButton btnKitapKontrolDüzenle;
    private javax.swing.JButton btnKitapKontrolKitapEkle;
    private javax.swing.JButton btnKitapKontrolSil;
    private javax.swing.JButton btnKitapKontrolTemizle;
    private javax.swing.JComboBox<String> cmbKitapKontrolKitapTuru;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblKullanici;
    private javax.swing.JTable tablaKategoriKontrol;
    private javax.swing.JTable tableKitapKontrol;
    private javax.swing.JTable tableKitapSorgula;
    private javax.swing.JTextField txtKategoriKontrolKategoriAdi;
    private javax.swing.JTextField txtKategoriKontrolStantAdres;
    private javax.swing.JTextField txtKategoriKontrolStantNo;
    private javax.swing.JTextArea txtKitapKontrolKisaAciklama;
    private javax.swing.JTextField txtKitapKontrolKitapAdi;
    private javax.swing.JTextField txtKitapKontrolKitapDili;
    private javax.swing.JTextField txtKitapKontrolRafNo;
    private javax.swing.JTextField txtKitapKontrolYayinEvi;
    private javax.swing.JTextField txtKitapKontrolYazarAdi;
    private javax.swing.JTextField txtKitapSorgulaAra;
    private javax.swing.JTextField txtKitapSorgulaKisaAciklama;
    private javax.swing.JTextField txtKitapSorgulaKitapAdi;
    private javax.swing.JTextField txtKitapSorgulaKitapDili;
    private javax.swing.JTextField txtKitapSorgulaKitapTuru;
    private javax.swing.JTextField txtKitapSorgulaRafNo;
    private javax.swing.JTextField txtKitapSorgulaYayinEvi;
    private javax.swing.JTextField txtKitapSorgulaYazarAdi;
    // End of variables declaration//GEN-END:variables

}
