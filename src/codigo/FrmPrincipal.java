/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;


import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author Cristian
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }
    
    private void analizarLexico() throws IOException {
            int cont = 1;
         
            String expr = (String) txtResultado.getText();
            String contarPalabras[] = txtResultado.getText().split("\\n");
            ArrayList<String> aCaracteres = new ArrayList<>(Arrays.asList(contarPalabras));
            Lexer lexer = new Lexer(new StringReader(expr));
            String resultado = "TOKEN\t\t\tSIMBOLO\n";
            String error = "Simbolo\tLinea\tColumna\n";
            
            //System.out.println(aCaracteres);
            while (true) {
                Tokens token = lexer.yylex();
                if (token == null) {
                    //resultado += "FIN";
                    txtAnalizarLex.setText(resultado);
                    txtErrores.setText(error);
                    return;
                }
             

                switch (token) {
                    case Linea:
                        cont++;                       
                        break;
                    case For:
                        resultado += "Reservada For\t\t" + lexer.lexeme + "\n";
                        break;
                    case Switch:
                        resultado += "Reservada Switch\t" + lexer.lexeme + "\n";
                        break;
                    case Case:
                        resultado += "Reservada Case\t\t" + lexer.lexeme + "\n";
                        break;
                    case Break:
                        resultado += "Reservada Break\t\t" + lexer.lexeme + "\n";
                        break;  
                    case Default:
                        resultado += "Reservada Default\t" + lexer.lexeme + "\n";
                        break;    
                    case DosPuntos:
                        resultado += "Dos puntos\t\t" + lexer.lexeme + "\n";
                        break;    
                    case Do:
                        resultado += "Reservada Do\t\t" + lexer.lexeme + "\n";
                        break;
                    case Incremento:
                        resultado += "Incremento\t\t" + lexer.lexeme + "\n";
                        break;
                    case Decremento:
                        resultado += "Decremento\t\t" + lexer.lexeme + "\n";
                        break;
                    case Logicos:
                        resultado += "Operador Logico\t\t" + lexer.lexeme + "\n";
                        break;    
                    case Punto:
                        resultado += "Punto\t\t\t" + lexer.lexeme + "\n";
                        break;
                    case Imprimir:
                        resultado += "Imprimir en consola\t" + lexer.lexeme + "\n";
                        break;        
                    case Menor:
                        resultado += "Menor que\t\t" + lexer.lexeme + "\n";
                        break;
                    case Mayor:
                        resultado += "Mayor que\t\t" + lexer.lexeme + "\n";
                        break;
                    case Comparacion:
                        resultado += "Comparacion\t\t" + lexer.lexeme + "\n";
                        break;
                    case MenorIgual:
                        resultado += "Menor o Igual\t\t" + lexer.lexeme + "\n";
                        break;
                    case MayorIgual:
                        resultado += "Mayor o Igual\t\t" + lexer.lexeme + "\n";
                        break;
                    case Distinto:
                        resultado += "Distinto de\t\t" + lexer.lexeme + "\n";
                        break;    
                    case Int:
                        resultado += "Reservada int\t\t" + lexer.lexeme + "\n";
                        break;
                    case Cadena:
                        resultado += "Cadena de texto\t\t" + lexer.lexeme + "\n";
                        break;
                    case Coment:
                        resultado += "Comentarios\t\t" + lexer.lexeme + "\n";
                        break;    
                    case R_args:
                        resultado += "Reservada args\t\t" + lexer.lexeme + "\n";
                        break;    
                    case If:
                        resultado += "Reservada if\t\t" + lexer.lexeme + "\n";
                        break;
                    case Else:
                        resultado += "Reservada else\t\t" + lexer.lexeme + "\n";
                        break;
                    case While:
                        resultado += "Reservada while\t\t" + lexer.lexeme + "\n";
                        break;
                    case Igual:
                        resultado += "Igual\t\t\t" + lexer.lexeme + "\n";
                        break;
                    case Suma:
                        resultado += "Suma\t\t\t" + lexer.lexeme + "\n";
                        break;
                    case Resta:
                        resultado += "Resta\t\t\t" + lexer.lexeme + "\n";
                        break;
                    case Multiplicacion:
                        resultado += "Multiplicacion\t\t" + lexer.lexeme + "\n";
                        break;
                    case Division:
                        resultado += "Division\t\t" + lexer.lexeme + "\n";
                        break;
                    case Parentesis_a:
                        resultado += "Parentesis apertura\t" + lexer.lexeme + "\n";
                        break;
                    case Parentesis_c:
                        resultado += "Parentesis cierre\t" + lexer.lexeme + "\n";
                        break;
                    case Llave_a:
                        resultado += "Llave apertura\t\t" + lexer.lexeme + "\n";
                        break;
                    case Llave_c:
                        resultado += "Llave cierre\t\t" + lexer.lexeme + "\n";
                        break;
                    case Corchete_a:
                        resultado += "Corchete apertura\t" + lexer.lexeme + "\n";
                        break;
                    case Corchete_c:
                        resultado += "Corchete cierre\t\t" + lexer.lexeme + "\n";
                        break;    
                    case Main:
                        resultado += "Reservada main\t\t" + lexer.lexeme + "\n";
                        break;
                    case P_coma:
                        resultado += "Punto y coma\t\t" + lexer.lexeme + "\n";
                        break;
                    case Identificador:
                        resultado += "Identificador\t\t" + lexer.lexeme + "\n";
                        break;
                    case Numero:
                        resultado += "Numero\t\t" + lexer.lexeme + "\n";
                        break;
                    case Ternario:
                        resultado += "Ternario\t\t\t" + lexer.lexeme + "\n";
                        break;    
                    case ERROR:
                        String indicadorLinea = aCaracteres.get(cont-1);
                        char[] eCaracteres;                            
                        eCaracteres = indicadorLinea.toCharArray();
                        //error += "Simbolo no Definido\t"+ lexer.yytext() +"\n linea: "+ cont+"\n";                                               
                        for (int x = 0; x < eCaracteres.length; x++) {
                            if (eCaracteres[x] == lexer.yytext().charAt(0)) {
                            eCaracteres[x]='0';    
                            error += lexer.yytext()+"\t" +cont+"\t"+(x+1)+"\n" ;
                            break;
                          }
                        }
                        
                        
                        
                        break;
                    case Privado:
                        resultado += "Reservada Private\t" + lexer.lexeme + "\n";
                        break;
                    case Publico:
                        resultado += "Reservada Public\t" + lexer.lexeme + "\n";
                        break;
                    case Estatico:
                        resultado += "Reservada Static\t" + lexer.lexeme + "\n";
                        break;
                    case Clase:
                        resultado += "Reservada Class\t\t" + lexer.lexeme + "\n";
                        break;
                    case N_Clase:
                        resultado += "Clase\t\t\t" + lexer.lexeme + "\n";
                        break;    
                    case Paquete:
                        resultado += "Reservada Package\t" + lexer.lexeme + "\n";
                        break;
                    case Vacio:
                        resultado += "Reservada Void\t\t" + lexer.lexeme + "\n";
                        break;
                    case Importar:
                        resultado += "Reservada Import\t" + lexer.lexeme + "\n";                       
                        break;
                    case D_String:
                        resultado += "Reservada String\t" + lexer.lexeme + "\n";
                    break;                                     
                    default:
                        resultado += "   " + lexer.lexeme + "\n";
                }
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

        btnArchivo = new javax.swing.JButton();
        btnAnalizarLex = new javax.swing.JButton();
        btnLimpiarRes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtErrores = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnAnalizarSin = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtErroresSin = new javax.swing.JTextArea();
        btnLimpiarLex = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnArchivo.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnArchivo.setText("Cargar Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        btnAnalizarLex.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarRes.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnLimpiarRes.setText("Limpiar");
        btnLimpiarRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarResActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        jLabel1.setText("Analizador Léxico");

        txtResultado.setColumns(20);
        txtResultado.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        txtErrores.setColumns(20);
        txtErrores.setForeground(new java.awt.Color(255, 51, 51));
        txtErrores.setRows(5);
        jScrollPane3.setViewportView(txtErrores);

        jLabel2.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        jLabel2.setText("Analizador Sintáctico");

        btnAnalizarSin.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        btnLimpiarSin.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnLimpiarSin.setText("Limpiar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 13)); // NOI18N
        txtAnalizarSin.setRows(5);
        jScrollPane4.setViewportView(txtAnalizarSin);

        txtErroresSin.setColumns(20);
        txtErroresSin.setForeground(new java.awt.Color(255, 51, 51));
        txtErroresSin.setRows(5);
        jScrollPane5.setViewportView(txtErroresSin);

        btnLimpiarLex.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnAnalizarLex)
                                .addGap(186, 186, 186)
                                .addComponent(btnLimpiarLex))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane5)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAnalizarSin)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
                                    .addComponent(btnLimpiarSin)
                                    .addGap(70, 70, 70)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(btnArchivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiarRes)
                                .addGap(191, 191, 191)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnLimpiarRes))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarLex)
                    .addComponent(btnLimpiarLex)
                    .addComponent(btnAnalizarSin)
                    .addComponent(btnLimpiarSin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarResActionPerformed
        txtResultado.setText("");
    }//GEN-LAST:event_btnLimpiarResActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalizarSin.setText("Análisis Realizado Correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis.\nLinea: " + (sym.right + 1) + "\nColumna: " + (sym.left +1) + "\nTexto: " + sym.value + "\n");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        txtAnalizarSin.setText("");
        txtErroresSin.setText("");
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        txtAnalizarLex.setText("");
        txtErrores.setText("");
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            new FrmPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarRes;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtErrores;
    private javax.swing.JTextArea txtErroresSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
