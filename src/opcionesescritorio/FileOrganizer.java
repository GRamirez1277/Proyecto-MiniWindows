package opcionesescritorio;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

public class FileOrganizer extends JFrame {
    private JTree arbol;
    private DefaultTreeModel modeloTree;
    private DefaultMutableTreeNode raiz;
    private JScrollPane scroll;
    
    public FileOrganizer() {
        // Configurar ventana principal
        setTitle("Navegador y Organizador de Archivos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear árbol y modelo
        arbol = new JTree();
        
        // Crear bordes y aplicarlos al árbol
        LineBorder lineBorde = new LineBorder(Color.BLACK);
        TitledBorder titleBorder = new TitledBorder("Navegador de Archivos");
        CompoundBorder border = BorderFactory.createCompoundBorder(lineBorde, titleBorder);
        arbol.setBorder(border);
        
        // Definir el archivo raíz
        File fileRaiz = new File(System.getProperty("../src/Z/Abraham"));  // Usar el directorio actual
        raiz = new DefaultMutableTreeNode(fileRaiz.getName());
        modeloTree = new DefaultTreeModel(raiz);
        arbol.setModel(modeloTree);
        
        // Crear panel de desplazamiento para el árbol
        scroll = new JScrollPane();
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(50, 50, 400, 400);  // Cambié las coordenadas para que se ajusten dentro de la ventana
        scroll.setViewportView(arbol);
        
        // Crear panel principal
        JPanel panelEscritorio = new JPanel(null);  // Usa layout null para coordenadas absolutas
        panelEscritorio.add(scroll);
        
        // Lógica para cargar el árbol
        agregarNodosJTree(fileRaiz);
        
        // Añadir panel al JFrame
        add(panelEscritorio);
    }
    
    // Método para agregar nodos al JTree
    private void agregarNodosJTree(File root) {
        DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) modeloTree.getRoot();
        agregarNodos(root, rootNode);
        modeloTree.reload();
    }

    private void agregarNodos(File file, DefaultMutableTreeNode node) {
        if (file.isDirectory()) {
            File[] archivos = file.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    DefaultMutableTreeNode nuevoNodo = new DefaultMutableTreeNode(archivo.getName());
                    node.add(nuevoNodo);
                    if (archivo.isDirectory()) {
                        agregarNodos(archivo, nuevoNodo);
                    }
                }
            }
        }
    }


}
