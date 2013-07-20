/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesapp.modules.admin.importer;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import org.iesapp.framework.pluggable.TopModuleWindow;
import org.iesapp.framework.util.CoreCfg;
import org.iesapp.framework.util.HtmlLog;

/**
 *
 * @author Josep
 */
public class NeseModule extends TopModuleWindow {
    private boolean terminate=true;
    private File lastDir;
    /**
     * Creates new form NeseModule
     */
    public NeseModule() {
        lastDir = new File(CoreCfg.contextRoot);
        initComponents();
        
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
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        htmlLog1 = new org.iesapp.framework.util.HtmlLog();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Importa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Fes un update dels medicaments si l'alumne ja existeix");

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Esborra totes les dades de NESE abans de començar");

        jLabel1.setText("Path del fitxer EXCEL");

        jTextField1.setToolTipText("Tria el fitxer");

        jButton2.setText("···");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Simulació (no escriu a la base de dades)");

        jLabel5.setText("Column. Expedient");

        jTextField2.setText("8");
        jTextField2.setToolTipText("#columna començant de 0");

        jLabel6.setText("Column. NESE (Categoria)");

        jTextField3.setText("9");
        jTextField3.setToolTipText("#columna començant de 0");

        jTextField4.setText("7");
        jTextField4.setToolTipText("#columna començant de 0");

        jLabel7.setText("Column. Grup");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(71, 71, 71)
                                .addComponent(jCheckBox3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(3, 3, 3))
        );

        jScrollPane1.setViewportView(htmlLog1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Log", jPanel3);

        jButton3.setText("Obrir una plantilla d'importació");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addContainerGap(458, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estructura EXCEL", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentContainer());
        getContentContainer().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jTabbedPane1))
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
            Desktop.getDesktop().open(new File("reports/templates/nese-import.xls"));
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables



    
     class LongTask extends Thread
     {
         @Override
         public void run()
         {
            //Esborra la taula de medicaments alumnes si s'ha triat
             if(jCheckBox2.isSelected() && !jCheckBox3.isSelected())
             {
                 String SQL1="UPDATE `"+CoreCfg.core_mysqlDBPrefix+"`.xes_alumne SET anee=''";
                 int nup = coreCfg.getMysql().executeUpdate(SQL1);
             }
             jButton1.setEnabled(false);
             
            try
            {
             int colComment =(int) Double.parseDouble( jTextField3.getText());
             int colGrup =(int) Double.parseDouble( jTextField4.getText());
             int colExpd =(int) Double.parseDouble( jTextField2.getText());
 
            //Fa un parse del fitxer excel
           
                 WorkbookSettings ws = new WorkbookSettings();
                 ws.setLocale(new Locale("ca", "ES"));
                 //ws.setEncoding("UTF8");
                 ws.setEncoding("ISO-8859-1");

                  String path = jTextField1.getText();
                 Workbook workbook = Workbook.getWorkbook(new File(path),ws);
                 Sheet s = workbook.getSheet(0);

                 int nRows = s.getRows();
                 htmlLog1.append("* Dimensions:: "+s.getColumns()+" x " + nRows, HtmlLog.COMMENTTYPE);

                 float tpc = 100/(1f*nRows);
                 for(int row=0; row<nRows; row++) //
                 {
                     //jProgressBar1.setValue((int) (row*tpc));
                     //Determina si es una fila bona o dolenta
                      boolean isValidRow = false;
                      Cell[] cellsRow = s.getRow(row);
                      
                      if(cellsRow.length>4 && cellsRow[colGrup]!=null)
                      {
                        CellType type = cellsRow[colGrup].getType();
                        if(type.equals(CellType.LABEL))
                        {
                            LabelCell dc = (LabelCell) cellsRow[colGrup];
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
                         String estudis =  getAsString(s, 6, row);
                         String grup =  getAsString(s, 7, row);
                         String expd =  getAsString(s, colExpd, row);
                         String comment =  getAsString(s, colComment, row);
                         
//          
                         int ncasos = 1;
                         
                           
                         if(!expd.isEmpty() && ncasos==1)
                         {
                             htmlLog1.append("S'ha trobat expd="+expd+" per a "+llinatge1+" "+llinatge2+", "+nom1+" : "+estudis+" "+grup, HtmlLog.COMMENTTYPE);
                             htmlLog1.append(">>>>>> Tipus NESE -> "+comment, HtmlLog.SUMMARYTYPE);
                             if(!jCheckBox3.isSelected())
                             {
                                 String SQL1 = "UPDATE `"+CoreCfg.core_mysqlDBPrefix+"`.xes_alumne SET anee=? WHERE exp2="+expd;
                                 int nup = coreCfg.getMysql().preparedUpdate(SQL1, new Object[]{comment});
                                 if(nup>0)
                                 {
                                      htmlLog1.append(" DB UPDATE OK.");
                                 }
                                 else
                                 {
                                      htmlLog1.append(" DB UPDATE FAILED", HtmlLog.ERRORTYPE);
                                 }
                             }
                           
                         }
                         else
                         {
                              htmlLog1.append("ERROR: no es troba # expedient de "+llinatge1+" "+llinatge2+", "+nom1, HtmlLog.ERRORTYPE);
                         }
                      }
                 
             }
             workbook.close();
             //jProgressBar1.setValue(100);
             jButton1.setEnabled(true);
             
             
        } catch (IOException ex) {
            Logger.getLogger(NeseModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(NeseModule.class.getName()).log(Level.SEVERE, null, ex);
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
        else if(type.equals(CellType.NUMBER))
        {
            retValue=((int) ((NumberCell) aCell).getValue()) + "";
        }
        return retValue;
    }
      
     }
        


}