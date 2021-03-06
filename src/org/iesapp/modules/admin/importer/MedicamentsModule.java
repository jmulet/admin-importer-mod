/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesapp.modules.admin.importer;

import com.l2fprod.common.swing.StatusBar;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.iesapp.framework.pluggable.StatusBarZone;
import org.iesapp.framework.pluggable.TopModuleWindow;
import org.iesapp.framework.util.CoreCfg;
import org.iesapp.framework.util.HtmlLog;

/**
 *
 * @author Josep
 */
public class MedicamentsModule extends TopModuleWindow {
    private DefaultTableModel modelTable1;
    private  HashMap<Integer, Integer> map;
    private boolean terminate=true;
    private File lastDir;
    /**
     * Creates new form MedicamentsModule
     */
    public MedicamentsModule() {
        this.moduleDescription = "Importador de medicaments pel sistema de fitxes";
        this.moduleDisplayName = "Importador de medicaments";
        this.moduleName = "medicalImporter";
        
        lastDir = new File(CoreCfg.contextRoot);
        initComponents();  
    }
    
    @Override
    public void postInitialize(){
        DefaultListModel modelList1 = new DefaultListModel();
        map = new HashMap<Integer,Integer>();
        //Crea una llista amb totes els ids
        String SQL1="SELECT * FROM `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments";
        ResultSet rs1 = coreCfg.getMysql().getResultSet(SQL1);
        int pos = 5;
        try {
            while(rs1!=null && rs1.next())
            {
                int id = rs1.getInt("id");
                String med = rs1.getString("descripcio");
                modelList1.addElement("id="+id+" --> "+med);
                map.put(id,pos);
                pos +=1;
            }
            if(rs1!=null) {
                rs1.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicamentsModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jList1.setModel(modelList1);
        
        //Taula d'equivalencies
        for(int ky: map.keySet())
        {
            modelTable1.addRow(new Object[]{ky,map.get(ky)});
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        htmlLog1 = new org.iesapp.framework.util.HtmlLog();
        jPanel6 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Importa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Fes un update dels medicaments si l'alumne ja existeix");

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Esborra totes les dades de medicaments abans de començar");

        jLabel1.setText("Path del fitxer EXCEL");

        jTextField1.setEditable(false);
        jTextField1.setToolTipText("Tria el fitxer");

        jButton2.setText("···");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Simulació (no escriu a la base de dades)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(71, 71, 71)
                                .addComponent(jCheckBox3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, 21))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jLabel3.setText("Ids de medicaments actuals");

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        modelTable1 = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Id. Medicament", "Columna Excel"
            }
        );
        jTable1.setModel(modelTable1);
        jScrollPane3.setViewportView(jTable1);

        jLabel2.setText("Taula d'equivalències");

        jLabel5.setText("Column. Observacions");

        jTextField2.setText("9");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(htmlLog1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Log", jPanel4);

        jButton3.setText("Obrir una plantilla d'importació");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estructura EXCEL", jPanel6);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentContainer());
        getContentContainer().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String path = jTextField1.getText();
        if(!new java.io.File(path).exists())
        {
            JOptionPane.showMessageDialog(this, "No es pot trobar el fitxer\n"+jTextField1.getText(), "Atenció", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        new LongTask().start();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        JFileChooser fd = new JFileChooser();
        fd.setCurrentDirectory(lastDir);
        fd.setFileFilter(new FileFilter(){

            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getAbsolutePath().endsWith(".xls");
            }

            @Override
            public String getDescription() {
                return "Excel file (*.xls)";
            }

            
        });
        fd.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fd.setMultiSelectionEnabled(false);
        int showOpenDialog = fd.showOpenDialog(this);
        if(showOpenDialog == JFileChooser.APPROVE_OPTION)
        {
            jTextField1.setText(fd.getSelectedFile().getAbsolutePath());
            lastDir = fd.getSelectedFile().getParentFile();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            Desktop.getDesktop().open(new File("reports/templates/medical-import.xls"));
        } catch (IOException ex) {
            Logger.getLogger(NeseModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.iesapp.framework.util.HtmlLog htmlLog1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables


      /**
     * @return the terminate
     */
    public boolean isTerminate() {
        return terminate;
    }

    /**
     * @param terminate the terminate to set
     */
    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }

  
     class LongTask extends Thread
     {
         @Override
         public void run()
         {
            //Esborra la taula de medicaments alumnes si s'ha triat
             if(jCheckBox2.isSelected() &&  !jCheckBox3.isSelected())
             {
                 String SQL1="TRUNCATE `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments_alumnes";
                 int nup = coreCfg.getMysql().executeUpdate(SQL1);
                 SQL1="TRUNCATE `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments_observ";
                 nup = coreCfg.getMysql().executeUpdate(SQL1);
             }
             jButton1.setEnabled(false);
             
            try
            {
             int colComment =(int) Double.parseDouble( jTextField2.getText());
        
             int nAlumnOK =0;
             int nAlumnERR =0;
      
                
            //Torna a carregar la taula d'equivalencies si l'usuari la canviada
            for(int i=0; i<jTable1.getRowCount(); i++)
            {
                int id= ((Number) jTable1.getValueAt(i, 0)).intValue();
                int col= ((Number) jTable1.getValueAt(i, 1)).intValue();
                map.put(id,col);
            }
            
            //Fa un parse del fitxer excel
           
                 WorkbookSettings ws = new WorkbookSettings();
                 ws.setLocale(new Locale("ca", "ES"));
                 //ws.setEncoding("UTF8");
                 ws.setEncoding("ISO-8859-1");

                  String path = jTextField1.getText();
                 Workbook workbook = Workbook.getWorkbook(new File(path),ws);
                 Sheet s = workbook.getSheet(0);

                 int nRows = s.getRows();
                 htmlLog1.append("* Dimensions:: "+s.getColumns()+" x " + nRows, HtmlLog.SUMMARYTYPE);

                 float tpc = 100/(1f*nRows);
                 for(int row=0; row<nRows; row++) //
                 {
                     jProgressBar1.setValue((int) (row*tpc));
                     //Determina si es una fila bona o dolenta
                      boolean isValidRow = false;
                      Cell[] cellsRow = s.getRow(row);
                      
                      if(cellsRow.length>4 && cellsRow[4]!=null)
                      {
                        CellType type = cellsRow[4].getType();
                        if(type.equals(CellType.LABEL))
                        {
                            LabelCell dc = (LabelCell) cellsRow[4];
                            String valor = dc.getString();
                            if(valor.length()==1) {
                                isValidRow=true;
                            }    //La columna Grup té longitud 1
                        }
                      }
                      
                      if(isValidRow)
                      { 
                         String llinatge1 =  getAsString(s, 0, row);
                         String llinatge2 =   getAsString(s, 1, row);
                         String nom1 =   getAsString(s, 2, row);
                         String estudis =  getAsString(s, 3, row);
                         String grup =  getAsString(s, 4, row);
                         
                         //Cerca a la base de dades l'expedient associat a cada alumne
                         String SQL1 = "SELECT exp2 FROM `"+CoreCfg.core_mysqlDBPrefix+"`.xes_alumne where llinatge1='"+llinatge1+"' and "
                                 + " llinatge2='"+llinatge2+"' and nom1='"+nom1+"'";
                         ResultSet rs1 = coreCfg.getMysql().getResultSet(SQL1);
                         int ncasos=0;
                         int expd = -1;
                         try {
                             while(rs1!=null && rs1.next())
                             {
                                 ncasos +=1;
                                 expd = rs1.getInt(1);
                             }
                             if(rs1!=null) {
                                rs1.close();
                            }
                         } catch (SQLException ex) {
                             Logger.getLogger(MedicamentsModule.class.getName()).log(Level.SEVERE, null, ex);
                         }
                           
                         if(expd>0 && ncasos==1)
                         {
                             htmlLog1.append("S'ha trobat expd="+expd+" per a "+llinatge1+" "+llinatge2+", "+nom1+" : "+estudis+" "+grup, HtmlLog.COMMENTTYPE);
                             nAlumnOK +=1;
                             
                             ArrayList<Integer> allowedPills = new ArrayList<Integer>();
                             String observacions="";
                             //Determina els medicaments que pot pendre
                             for(int ky: map.keySet())
                             {
                                 int id = ky;
                                 int col = map.get(ky);
                                 String med = getAsString(s, col, row);
                                 if(!med.isEmpty())
                                 {
                                     htmlLog1.append(".     idMedicament="+id+" Sí.", HtmlLog.SUMMARYTYPE);
                                     allowedPills.add(id);
                                 }                               
                             }
                               
                             //Determina el seu comentari
                               String comment = getAsString(s,colComment,row);
                                 if(!comment.isEmpty())
                                 {
                                     htmlLog1.append(".     Observacions="+comment, HtmlLog.SUMMARYTYPE);
                                     observacions += comment;
                                 }
                                String comment2 =getAsString(s,colComment-1,row);
                                 if(!comment2.isEmpty())
                                 {
                                     htmlLog1.append(".     Observacions=CAP MEDICAMENT!", HtmlLog.SUMMARYTYPE);
                                     observacions += " . CAP MEDICAMENT ";
                                 }
                             
                                 //Puja la informacio a les bases de dades
                                 if(!jCheckBox3.isSelected())
                                 {
                                 //Determina si hi ha informacio sobre aquest alumne
                                 int nevents = 0;
                                 SQL1 = "SELECT COUNT(id) FROM `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments_alumnes WHERE exp2="+expd;
                                 rs1 = coreCfg.getMysql().getResultSet(SQL1);
                                 try {
                                 while(rs1!=null && rs1.next())
                                 {  
                                     nevents = rs1.getInt(1);
                                }
                                if(rs1!=null) {
                                        rs1.close();
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(MedicamentsModule.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                 
                                if(nevents==0)
                                {
                                    for(int k=0; k<allowedPills.size(); k++)
                                    {
                                         SQL1 = "INSERT INTO `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments_alumnes (exp2,idMedicament) VALUES ('"+expd+"','"+allowedPills.get(k)+"')";
                                         int nup = coreCfg.getMysql().executeUpdate(SQL1);
                                         if(nup==0) {
                                            htmlLog1.append("ERROR: update failed!", HtmlLog.ERRORTYPE);
                                        }
                                    }
                                }
                                else if(nevents>0 && jCheckBox1.isSelected())
                                {
                                     SQL1 = "DELETE FROM `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments_alumnes WHERE exp2="+expd;
                                     int nup = coreCfg.getMysql().executeUpdate(SQL1);
                                     if(nup==0) {
                                        htmlLog1.append("ERROR: update failed!", HtmlLog.ERRORTYPE);
                                    }
                                     
                                       for(int k=0; k<allowedPills.size(); k++)
                                       {
                                         SQL1 = "INSERT INTO `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments_alumnes (exp2,idMedicament) VALUES ('"+expd+"','"+allowedPills.get(k)+"')";
                                         nup = coreCfg.getMysql().executeUpdate(SQL1);
                                         if(nup==0) {
                                               htmlLog1.append("ERROR: update failed!", HtmlLog.ERRORTYPE);
                                           }
                                       }
                                }
                             
                              
                             //Si té algun comentari, el puja a la taula de comentaris u observacions de medicaments
                             if(!observacions.isEmpty())   
                             {
                                  SQL1 = "DELETE FROM `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments_observ WHERE exp2="+expd;
                                  int nup = coreCfg.getMysql().executeUpdate(SQL1);
                                  if(nup==0) {
                                     htmlLog1.append("ERROR: update failed!", HtmlLog.ERRORTYPE);
                                 }
                                  SQL1 = "INSERT INTO `"+CoreCfg.core_mysqlDBPrefix+"`.sig_medicaments_observ (exp2,observacions) VALUES ('"+expd+"', ?)";
                                  nup = coreCfg.getMysql().preparedUpdate(SQL1, new Object[]{observacions}); if(nup==0) {
                                     htmlLog1.append("ERROR: update failed!", HtmlLog.ERRORTYPE);
                                 }                                      
                             }
                             }
                                
                         }
                         else
                         {
                              htmlLog1.append("ERROR: no es troba # expedient de "+llinatge1+" "+llinatge2+", "+nom1, HtmlLog.ERRORTYPE);
                              nAlumnERR +=1;
                         }
                      }
                 
             }

                   htmlLog1.append(" ");  
                   htmlLog1.append("-Alumnes OK:"+nAlumnOK,  HtmlLog.ERRORTYPE);
                   htmlLog1.append("-Alumnes ERRORS:"+nAlumnERR, HtmlLog.ERRORTYPE);
                 workbook.close();
             jProgressBar1.setValue(100);
             jButton1.setEnabled(true);
             
             
        } catch (IOException ex) {
            Logger.getLogger(MedicamentsModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(MedicamentsModule.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
         
          private String getAsString(Sheet s, int col, int row) {
        String retValue="";
        Cell aCell = s.getCell(col,row);
        CellType type = aCell.getType();
        if(type.equals(CellType.LABEL))
        {
            retValue=(((LabelCell) aCell).getString()).trim();
        }
       
        return retValue;
    }
      
   }

    @Override
    public void setMenus(JMenuBar jMenuBar1, JToolBar jToolbar1, StatusBar jStatusBar1) {
      ((StatusBarZone) jStatusBar1.getZone("third")).addComponent(jProgressBar1);
    }

 
    
}
