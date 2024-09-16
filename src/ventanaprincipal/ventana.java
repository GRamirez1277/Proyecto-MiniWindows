package ventanaprincipal;

import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import opcionesescritorio.ConsolaDeComandos;
import opcionesescritorio.CrearUsuario;
import opcionesescritorio.MusicPlayer;
import opcionesescritorio.Reloj;
import opcionesescritorio.SimpleTextEditor;
import opcionesescritorio.VisorDeCarpetas;
import opcionesescritorio.Visual;
import usuarios.UserManagement;
//import opcionesescritorio.VisorDeImagenes;

public class ventana extends javax.swing.JFrame {

    private javax.swing.ImageIcon redimensionarIcono(String ruta, int ancho, int alto) {
        javax.swing.ImageIcon icono = new javax.swing.ImageIcon(getClass().getResource(ruta));
        java.awt.Image img = icono.getImage();
        java.awt.Image imgRedimensionado = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
        return new javax.swing.ImageIcon(imgRedimensionado);
    }

    public ventana() {
        initComponents();
        jLabelFecha = new javax.swing.JLabel();
        jLabelHora = new javax.swing.JLabel();

        jPanel2.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));  // Añadir jLabelFecha
        jPanel2.add(jLabelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));  // Añadir jLabelHora

        // Inicia el reloj
        new Reloj(jLabelFecha, jLabelHora).start();

    }
    // private VisorDeImagenes visorDeImagenes = null;  // Variable de instancia para la ventana del visor de imágenes
    private ConsolaDeComandos consola = null;  // Variable de instancia para la ventana de la consola
    private VisorDeCarpetas visorDeCarpetas = null;  // Variable de instancia para la ventana del visor de carpetas reproductormc
    private MusicPlayer reproductorMusica = null;  // Variable de instancia para la ventana del reproductor de música
    private SimpleTextEditor editor = null;  // Variable de instancia para el editor de texto
    private Visual visual = null;  // Variable de instancia para Visual
    private Process proceso;  // Variable global para almacenar el proceso
    private javax.swing.JLabel jLabelFecha;  // JLabel para la fecha
    private javax.swing.JLabel jLabelHora;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn5 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setToolTipText("");
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jButton3.setText("Pantalla completa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(334, 334, 334))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(41, 41, 41)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanaprincipal/componetesJframe/icocarpeta.png"))); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanaprincipal/componetesJframe/word.png"))); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanaprincipal/componetesJframe/instagram.png"))); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanaprincipal/componetesJframe/galeria.png"))); // NOI18N
        btn3.setInheritsPopupMenu(true);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanaprincipal/componetesJframe/terminal.png"))); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventanaprincipal/componetesJframe/musica.png"))); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar Session");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Crear Cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(360, 360, 360))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        //shell
        if (consola == null) {
            consola = new ConsolaDeComandos();  // Si no existe, la creamos
        }

        // Si la ventana está visible, la ocultamos; si no, la mostramos
        if (consola.isVisible()) {
            consola.setVisible(false);  // Ocultar la ventana
        } else {
            consola.setVisible(true);   // Mostrar la ventana
        }

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        //visor de imagenes
        if (visual == null) {
            visual = new Visual();
        }
        visual.setVisible(!visual.isVisible());

    }//GEN-LAST:event_btn3ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        //reproductor musica
        // Verificar si la instancia de MusicPlayer ya existe
        if (reproductorMusica == null) {
            // Si no existe, la creamos
            reproductorMusica = new MusicPlayer();
        }

        // Alternar la visibilidad de la ventana del MusicPlayer
        reproductorMusica.setVisible(!reproductorMusica.isVisible());
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // navegador de carpertas
        // Verificar si ya existe una instancia de VisorDeCarpetas
        if (visorDeCarpetas == null) {
            // Si no existe, la creamos con la ruta inicial
            visorDeCarpetas = new VisorDeCarpetas();
        }

        // Si la ventana está visible, la ocultamos; si no, la mostramos
        if (visorDeCarpetas.isVisible()) {
            visorDeCarpetas.setVisible(false);  // Ocultar la ventana
        } else {
            visorDeCarpetas.setVisible(true);   // Mostrar la ventana
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (editor == null) {
            // Si no existe, la creamos
            editor = new SimpleTextEditor();
        }
        // Alternar la visibilidad de la ventana del SimpleTextEditor
        if (editor.isVisible()) {
            editor.setVisible(false);  // Ocultar la ventana si ya está visible
        } else {
            editor.setVisible(true);   // Mostrar la ventana si no está visible
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // cerrar session
        this.dispose();

        // Mostrar la ventana de login
        new VentanaLogin().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // crear cuentas
      UserManagement userManager = new UserManagement();
    
    // Crear cuentas de ejemplo
    // Aquí puedes añadir usuarios predeterminados si es necesario
    userManager.registerUser("admin", "password");

    // Crear el panel CrearUsuario y pasar la instancia de UserManagement
    CrearUsuario crearUsuario = new CrearUsuario(this, userManager);
    
    // Configurar la ventana para que se muestre
    javax.swing.JFrame frame = new javax.swing.JFrame("Crear Usuario");
    frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setContentPane(crearUsuario);
    frame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        try {
            // Ruta completa del archivo .jar
            String rutaCompleta = "C:/Users/user/Documents/NetBeansProjects/Mini_Windows/src/ventanaprincipal/app/dist/Proyecto-Windows.jar";

            // Comando para ejecutar el archivo .jar
            String comando = "java -jar \"" + rutaCompleta + "\"";

            if (proceso == null || !proceso.isAlive()) {
                // Si no hay un proceso en ejecución, ejecutamos el archivo
                proceso = Runtime.getRuntime().exec(comando);
                System.out.println("Ejecutable abierto desde: " + rutaCompleta);
            } else {
                // Si ya hay un proceso en ejecución, lo cerramos
                proceso.destroy();
                System.out.println("Proceso cerrado.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
    java.awt.GraphicsDevice gd = ge.getDefaultScreenDevice();

    if (gd.isFullScreenSupported()) {
        // Verificar si la ventana ya está en pantalla completa
        if (gd.getFullScreenWindow() == this) {
            // Restaurar a modo ventana si ya está en pantalla completa
            gd.setFullScreenWindow(null); // Salir de pantalla completa
            this.dispose(); // Liberar recursos de la ventana actual

            // Configurar la ventana nuevamente en modo normal
            this.setUndecorated(false); // Volver a mostrar los bordes de la ventana
            this.setVisible(true); // Mostrar la ventana restaurada
            this.setExtendedState(javax.swing.JFrame.NORMAL); // Estado normal
        } else {
            // Pasar a pantalla completa
            this.dispose(); // Liberar la ventana actual antes de cambiar a pantalla completa
            this.setUndecorated(true); // Hacer la ventana sin bordes

            // Hacer que la ventana sea de pantalla completa
            gd.setFullScreenWindow(this);
            this.setVisible(true); // Mostrar la ventana en pantalla completa

            // Maximizar la ventana para llenar toda la pantalla
            this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

            // Revalidar y repintar los componentes para ajustarlos al nuevo tamaño
            this.revalidate();
            this.repaint();
        }
    } else {
        System.out.println("Pantalla completa no soportada.");
    }


    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
