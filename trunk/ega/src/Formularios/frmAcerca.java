/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.util.ArrayList;
import Grafica.Grafica;
import Grafica.Enum.Tipo;
import java.util.ArrayList;
/*
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
* */
import java.util.*; //para el HashMap


/**
 *
 * @author Triton
 */
public class frmAcerca extends javax.swing.JInternalFrame {
    private Integer _intID;
    private ArrayList<javax.swing.JInternalFrame> _arrMySon = new ArrayList<javax.swing.JInternalFrame>();
    
    /**
     * Creates new form frmAcerca
     */
    public frmAcerca() {
        initComponents();
    }

    public void CloseAll(){
        for (javax.swing.JInternalFrame frm : this._arrMySon){
            switch (frm.getClass().toString().split("class Formularios.")[1]){
                case forms.Editor:
                    ((frmEditor)frm).CloseAll();
                    break;
                case forms.Acerca:
                    ((frmAcerca)frm).CloseAll();
                    break;
                case forms.DescripcionFuncion:
                    ((frmDescripcionFuncion)frm).CloseAll();
                    break;
                case forms.Grafica:
                    ((frmGrafica)frm).CloseAll();
                    break;
                case forms.Informe:
                    ((frmInforme)frm).CloseAll();
                    break;
                case forms.InformeConfiguracion:
                    ((frmInformeConfiguracion)frm).CloseAll();
                    break;
                case forms.Recursos:
                    ((frmRecursos)frm).CloseAll();
                    break;
                case forms.Solucion:
                    ((frmSolucion)frm).CloseAll();
                    break;
            }
        }
        this.setVisible(false);
        this.dispose();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAcercade1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setClosable(true);
        setResizable(true);
        setTitle("Acerca de ...                                                                                                                                                                  ");
        setAlignmentX(5.5F);
        setAlignmentY(5.5F);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(null);
        setMinimumSize(new java.awt.Dimension(600, 350));
        setPreferredSize(new java.awt.Dimension(600, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("EGA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, 56, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("V 1.0");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, 48, 28));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/system/res/Acerca.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 108, 302));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 7, 110, 304));

        txtAcercade1.setEditable(false);
        txtAcercade1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtAcercade1.setText("Easy Genetic Algorithms aplica técnicas de Inteligencia Artificial para resolver\nproblemas modelados en lenguaje JAVA, con el cual fue desarrollado.\n\nColaboradores:\n\n    Ing. Edmundo Rosci  -  Líder de Proyecto  -  spyest@hotmail.com \n    Ing. Leonardo Biagini  -  Programador Senior  -  leo.-biagi@hotmail.com\n    Ing. Nicolás Kivatinetz  -  Programador Senior  -  nico.kiva@gmail.com\n    Ing. Pablo Van Mechelen  -  Diseñador  -  pdvm2002@hotmail.com");
        txtAcercade1.setMargin(new java.awt.Insets(8, 8, 3, 3));
        jScrollPane3.setViewportView(txtAcercade1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 8, 462, 172));

        jScrollPane1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jEditorPane1.setEditable(false);
        jEditorPane1.setContentType("text/html"); // NOI18N
        jEditorPane1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jEditorPane1.setText("<html>\r\n  <head>\r</head>\r\n  <body>\r\r\n<FONT FACE=\"SansSerif\" SIZE=3 COLOR=black>\nCopyright (C) 2012 - EGA\n<p>\nEste programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de \nla Licencia Pública General de GNU según es publicada por la Free Software Foundation, \nbien de la versión 2 de dicha Licencia o bien (según su elección) de cualquier versión posterior.\n<p>\nEste programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, \nincluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN \nPROPÓSITO PARTICULAR. \n<p>\nVéase la Licencia Pública General de GNU para más detalles:\n</FONT>\n<FONT COLOR=blue>\n<a href=\"/philosophy/free-doc.es.html\">http://www.gnu.org/licenses/#GPL</a>\n</FONT>\n</p> \n \r  </body>\r\n</html>\r\n");
        jEditorPane1.setCaretPosition(0);
        jEditorPane1.setMargin(new java.awt.Insets(8, 8, 3, 3));
        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 186, 462, 124));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane txtAcercade1;
    // End of variables declaration//GEN-END:variables
}
