package view;

import controller.ProductController;
import exception.EmptyInputException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Product;


public class ProductView extends javax.swing.JFrame {
    private final ProductController productController = new ProductController();
    private boolean  isAddAction  = true; // fasle for update
    List<Product> products;
    public ProductView() {
        initComponents();
        setComponent(false);
        setDropDown();
        showProducts();
    }
    
    
    public void setComponent(boolean value){
           inputIdProduk.setEnabled(false);
           inputNamaProduk.setEnabled(value);
           inputStok.setEnabled(value);
           inputHarga.setEnabled(value);
           dropdownTipe.setEnabled(value);
           buttonCancel.setEnabled(value);
           buttonConfirm.setEnabled(value);
    }
    
    public void setEditDeleteButton(boolean value){
        buttonUpdate.setEnabled(value);
        buttonDelete.setEnabled(value);
    }
    
    public void clearText(){
           inputIdProduk.setText("");
           inputNamaProduk.setText("");
           inputStok.setText("");
           inputHarga.setText("");
           dropdownTipe.setSelectedIndex(0);
    }
    
    public void setDropDown(){
        dropdownTipe.addItem("Makanan");
        dropdownTipe.addItem("Minuman");
    }
    public TableProductView mapToTableProduct(String query){
        products = productController.read(query);
        TableProductView tableProductView = new TableProductView(products);
        return tableProductView;
    }
    public void showProducts(){
        productTable.setModel(mapToTableProduct(""));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        buttonCashier = new javax.swing.JButton();
        tableScrollPanel = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        buttonCreate = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonSearch = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        inputNamaProduk = new javax.swing.JTextField();
        labelNamaProduk = new javax.swing.JLabel();
        labelHargaProduk = new javax.swing.JLabel();
        inputHarga = new javax.swing.JTextField();
        inputStok = new javax.swing.JTextField();
        labelStok = new javax.swing.JLabel();
        dropdownTipe = new javax.swing.JComboBox<>();
        labelTipe = new javax.swing.JLabel();
        buttonConfirm = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelIdProduk = new javax.swing.JLabel();
        inputIdProduk = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 800));
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(1000, 800));

        header.setBackground(new java.awt.Color(241, 183, 119));
        header.setPreferredSize(new java.awt.Dimension(1000, 104));
        header.setRequestFocusEnabled(false);

        headerLabel.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(0, 0, 0));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("WARKOP PBO");

        buttonCashier.setText("Cashier");
        buttonCashier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCashierMouseClicked(evt);
            }
        });
        buttonCashier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCashierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCashier)
                .addGap(83, 83, 83))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(buttonCashier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        productTable.setModel(new javax.swing.table.DefaultTableModel(
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
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        tableScrollPanel.setViewportView(productTable);

        buttonCreate.setText("Create");
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateActionPerformed(evt);
            }
        });

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonSearch.setText("Search");
        buttonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchActionPerformed(evt);
            }
        });

        labelNamaProduk.setForeground(new java.awt.Color(0, 0, 0));
        labelNamaProduk.setText("Nama Produk");

        labelHargaProduk.setForeground(new java.awt.Color(0, 0, 0));
        labelHargaProduk.setText("Harga Produk");

        labelStok.setForeground(new java.awt.Color(0, 0, 0));
        labelStok.setText("Stok Produk");

        dropdownTipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "item1", "item 2" }));

        labelTipe.setForeground(new java.awt.Color(0, 0, 0));
        labelTipe.setText("Tipe");

        buttonConfirm.setText("Confirm");
        buttonConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonConfirmMouseClicked(evt);
            }
        });
        buttonConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonCancelMouseClicked(evt);
            }
        });
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        labelIdProduk.setForeground(new java.awt.Color(0, 0, 0));
        labelIdProduk.setText("Id Produk");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCreate)
                .addGap(49, 49, 49)
                .addComponent(buttonUpdate)
                .addGap(47, 47, 47)
                .addComponent(buttonDelete)
                .addGap(281, 281, 281)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSearch)
                .addGap(72, 72, 72))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(buttonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonConfirm)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(labelIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(inputIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundLayout.createSequentialGroup()
                            .addComponent(labelHargaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(inputHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(backgroundLayout.createSequentialGroup()
                            .addComponent(labelNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(inputNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelStok, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelTipe, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dropdownTipe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputStok, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCreate)
                    .addComponent(buttonUpdate)
                    .addComponent(buttonDelete)
                    .addComponent(buttonSearch)
                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputIdProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelIdProduk))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNamaProduk))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHargaProduk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropdownTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelStok))
                .addGap(34, 34, 34)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCancel)
                    .addComponent(buttonConfirm))
                .addGap(41, 41, 41)
                .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, 805, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
       isAddAction = Boolean.FALSE;
        setComponent(true);
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
       int getAnswer = JOptionPane.showConfirmDialog(
               rootPane, 
               "Apakah yakin ingin menghapus data ?",
               "Konfirmasi",
               JOptionPane.YES_NO_OPTION);
        
       if(getAnswer == 0){
             try {
                    productController.delete(String.valueOf(inputIdProduk.getText()));
                    clearText();
                    showProducts();
                    setComponent(false);
                    setEditDeleteButton(false);
                } catch (Exception e) {
                    System.out.println("Error : " + e.getMessage());
                }
       }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchActionPerformed
        setEditDeleteButton(false);
        setComponent(false);
        try{
            TableProductView modelProducts = mapToTableProduct(searchInput.getText());
            if(modelProducts.getRowCount() == 0){
                JOptionPane.showConfirmDialog(null, "Data tidak ditemukan", "Konfirmasi", JOptionPane.DEFAULT_OPTION);
            }else{
                productTable.setModel(modelProducts);
            }
            clearText();
        }catch(Exception e){
            System.out.println("Error : " +e.getMessage());
        }
 
    }//GEN-LAST:event_buttonSearchActionPerformed

    private void validateInput() throws EmptyInputException{
        boolean invalidName = inputNamaProduk.getText().isBlank() ;
        boolean invalidPrice = inputHarga.getText().isBlank();
        boolean invalidStock = inputStok.getText().isBlank(); 
        if(invalidName ||  invalidPrice || invalidStock){
             throw new EmptyInputException();
        }
    }
    
    private void buttonConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmActionPerformed
       try{
          validateInput();
        if(isAddAction){
           Product product = new Product();
           product.setName(inputNamaProduk.getText());
           product.setPrice(new BigDecimal( inputHarga.getText()));
           product.setStock(Integer.valueOf(inputStok.getText()));
           product.setType((String) dropdownTipe.getSelectedItem());
           productController.create(product);
       }else{
           Product product = new Product();
           product.setName(inputNamaProduk.getText());
           product.setPrice(new BigDecimal( inputHarga.getText()));
           product.setStock(Integer.valueOf(inputStok.getText()));
           product.setType((String) dropdownTipe.getSelectedItem());
           productController.update(Integer.valueOf( inputIdProduk.getText()), product);
       }
       clearText();
       showProducts();
        setComponent(false);
        setEditDeleteButton(false);
       }catch(EmptyInputException e){
            JOptionPane.showMessageDialog(this, e.message());
       }
    }//GEN-LAST:event_buttonConfirmActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        setComponent(false);
        clearText();
        setEditDeleteButton(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        setEditDeleteButton(true);
        setComponent(false);
        int clickedRow = productTable.getSelectedRow(); 
        TableModel tableModel =  productTable.getModel();
        inputIdProduk.setText(tableModel.getValueAt(clickedRow, 0).toString());
        inputNamaProduk.setText(tableModel.getValueAt(clickedRow, 1).toString());
        inputHarga.setText(tableModel.getValueAt(clickedRow, 3).toString());
        inputStok.setText(tableModel.getValueAt(clickedRow, 4).toString());
        
        String valueColumnType = tableModel.getValueAt(clickedRow, 2).toString();
        if(Objects.equals(valueColumnType,"Makanan")){
            dropdownTipe.setSelectedIndex(0);
        }else{
            dropdownTipe.setSelectedIndex(1);
        }
    }//GEN-LAST:event_productTableMouseClicked

    private void buttonCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCancelMouseClicked
 
    }//GEN-LAST:event_buttonCancelMouseClicked

    private void buttonConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConfirmMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonConfirmMouseClicked

    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed
        isAddAction = Boolean.TRUE;
        setComponent(true);
        clearText();
        searchInput.setText("");
    }//GEN-LAST:event_buttonCreateActionPerformed

    private void buttonCashierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonCashierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCashierMouseClicked

    private void buttonCashierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCashierActionPerformed
        CashierView cv = new CashierView();
        this.dispose();
        cv.setVisible(true); 
    }//GEN-LAST:event_buttonCashierActionPerformed

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
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonCashier;
    private javax.swing.JButton buttonConfirm;
    private javax.swing.JButton buttonCreate;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<String> dropdownTipe;
    private javax.swing.JPanel header;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JTextField inputHarga;
    private javax.swing.JTextField inputIdProduk;
    private javax.swing.JTextField inputNamaProduk;
    private javax.swing.JTextField inputStok;
    private javax.swing.JLabel labelHargaProduk;
    private javax.swing.JLabel labelIdProduk;
    private javax.swing.JLabel labelNamaProduk;
    private javax.swing.JLabel labelStok;
    private javax.swing.JLabel labelTipe;
    private javax.swing.JTable productTable;
    private javax.swing.JTextField searchInput;
    private javax.swing.JScrollPane tableScrollPanel;
    // End of variables declaration//GEN-END:variables
}
