package org.apache.dts;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Class BTreeRenderer
 * @author BR18024
 */
public class BTreeRenderer extends JFrame
{
    public final static int APP_WIDTH       =   1140;
    public final static int APP_HEIGHT      =   650;
    public final static int HEIGHT_STEP     =   80;
    public final static int NODE_HEIGHT     =   30;
    public final static int NODE_DIST       =   16;
    public final static int TREE_HEIGHT     =   32;

    private final BTreeTest mTreeTest;
    private final StringBuilder mBuf;
    private final Object []mObjLists;
    //private mxGraph mGraph;
    // private mxGraphComponent mGraphComponent;
    private final JTextField mText;
    //private final JButton mAddBt, mRemoveBt;
    //private final JButton mAddMoreBt, mRemoveMoreBt;
    private final JButton  mSearchKeyBt;
    private final JButton mListBt,mCola, mEncolar ;
    private final JTextArea mOutputConsole;
    private final JTextField id,nombre,cantMaletas;
    private final JLabel label;

    public BTreeRenderer() {
        super("Pasajeros");
        mTreeTest = new BTreeTest();
        mBuf = new StringBuilder();
        mObjLists = new Object[TREE_HEIGHT];
        mSearchKeyBt = new JButton("Buscar");
        //mClearBt = new JButton("Limpiar");
        mListBt = new JButton("Listar");
        mCola = new JButton("Terminar de Encolar");
        mEncolar = new JButton("Encolar");
        
        mText = new JTextField("");
        mOutputConsole = new JTextArea(30, 30);
        id = new JTextField("");
        nombre = new JTextField("");
        cantMaletas = new JTextField("");
        label = new JLabel("Id: ");
        id.setEditable(false);
        nombre.setEditable(false);
        cantMaletas.setEditable(false);
        mOutputConsole.setEditable(false);
        
        mText.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    searchButtonPressed();
                }
            }
        });

        mSearchKeyBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                searchButtonPressed();
                cantMaletas.setEditable(true);
            }
        });

        mListBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                listButtonPressed();
            }
        });
        mCola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                dejarDEncolar();
            }
        });
        mEncolar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
               EnColar();
               
            }
        });
        
       /*mClearBt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                clearButtonPressed();
            }
        });*/


        generateTestData();
    }


    private Integer getInputValue() {
        String strInput = mText.getText().trim();
        int nVal;

        try {
            nVal = Integer.parseInt(strInput);
        }
        catch (Exception ex) {
            return null;
        }

        mText.setFocusable(true);
        return nVal;
    }

//metodo para Buscar
    public void searchButtonPressed() {
        Integer in = getInputValue();
        if (in == null) {
            return;
        }

        mText.setText("");
        searchKey(in);
    }


    public void addButtonPressed() {
        Integer in = getInputValue();
        if (in == null) {
            return;
        }

        mText.setText("");
        addKey(in);
        render();
    }


    public void removeButtonPressed() {
        Integer in = getInputValue();
        if (in == null) {
            return;
        }

        mText.setText("");
        deleteKey(in);
        render();
    }


    public void addMoreButtonPressed() {
        Integer in = getInputValue();
        if (in == null) {
            return;
        }

        addKey(in);
        in += 1;
        mText.setText(in + "");
        render();
    }


    public void removeMoreButtonPressed() {
        Integer in = getInputValue();
        if (in == null) {
            return;
        }

        deleteKey(in);
        in -= 1;
        mText.setText(in + "");
        render();
    }

//metodo para Limpiar
    public void clearButtonPressed() {
        mTreeTest.getBTree().clear();
        mOutputConsole.setText("");
        render();
    }



    private BTIteratorIF mIter = null;
    
    //metodo para Listar
    public void listButtonPressed() {
        if (mIter == null) {
            mIter = new BTIteratorImpl();
        }

        mOutputConsole.setText("");
        mTreeTest.listItems(mIter);
    }
    //Metodo para validar si esta vacia
    public boolean ColaVacia(){
        return c.inicio==null ;
    }
    //metodo para dejar de encolar y despachar a los usuarios
    public void dejarDEncolar(){
        if(c.inicio == null){
            JOptionPane.showMessageDialog(null, "No hay nungun pasajero en la cola de revisión");
        }else{
            this.setVisible(false);
            DesEncolar e = new DesEncolar();
            e.setVisible(true);
        }
        
    }
    public static Cola c = new Cola();
    
    //Metodo para desencolar
    public String DesencolarNombre(){
        String nom = c.inicio.nombre;
        c.inicio=c.inicio.siguiente;
        return nom;
    }
    //retorna el numero de pasaporte
    public String DesencolarPasaporte(){
        String pasaporte = Integer.toString(c.inicio.numPasaporte);
        return pasaporte;
    }
    //Metodo para encolar Usuarios
    public void EnColar(){
        //Validar que el JTextField de la cantidad no este vacio antes de encolar al viajero
        if(cantMaletas.getText().length() == 0)
            //Mensaje de error 
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad de maletas");
        else{
            //Crear variablas para convertir los valores de los JTextField
            int pas = Integer.parseInt(id.getText());
            int cant = Integer.parseInt(cantMaletas.getText());    
            //Insertar datos en la Cola
            c.Insertar(pas,cant,nombre.getText());
            //Limpiar los TextField
            id.setText("");
            nombre.setText("");
            cantMaletas.setText("");
            cantMaletas.setEditable(false);
        }
       
    }
    
    
    public void render() {
        //mGraph = new mxGraph();
        //Object parent = mGraph.getDefaultParent();
        List<Object> pObjList = new ArrayList<Object>();
        List<Object> cObjList = new ArrayList<Object>();
        List<Object> tempObjList;

        for (int i = 0; i < TREE_HEIGHT; ++i) {
            mObjLists[i] = null;
        }
        JComboBox combo = new JComboBox();
        Box hBox = Box.createHorizontalBox();
        hBox.add(new JLabel("   Numero Pasaporte:  "));
        hBox.add(mText);
        hBox.add(mSearchKeyBt);
        hBox.add(mListBt);
        //hBox.add(mSaveBt);
        //hBox.add(mClearBt);
        
        Box hBox2 = Box.createHorizontalBox();
        hBox2.add(new JLabel("      Id:             "));
        hBox2.add(id);
        
        Box hBox3 = Box.createHorizontalBox();
        hBox3.add(new JLabel("      Nombre: "));
        
        hBox3.add(nombre);
        
        Box hBox4 = Box.createHorizontalBox();
        hBox4.add(new JLabel("      Cantidad de Maletas"));
        hBox4.add(cantMaletas);
        hBox4.add(mEncolar);
        
        Box hBox5 = Box.createHorizontalBox();
        hBox5.add(new JLabel("_"));
        
        Box hBox6 = Box.createHorizontalBox();
        hBox6.add(mCola);
        Box hBox7 = Box.createHorizontalBox();
        hBox7.add(new JLabel("________________________________________________________________________________________________________________________________________________________________________________________________________________________"));
        //mxGraphComponent graphComponent = new mxGraphComponent(mGraph);
        getContentPane().removeAll();
        /*getContentPane().add(hBox, BorderLayout.BEFORE_FIRST_LINE);
        getContentPane().add(hBox2, BorderLayout.CENTER);
        getContentPane().add(hBox3,BorderLayout.CENTER);*/
        
        //getContentPane().add(graphComponent, BorderLayout.CENTER);
        //getContentPane().add(new JScrollPane(mOutputConsole), BorderLayout.SOUTH);
        //getContentPane().add(hBox2, BorderLayout.SOUTH);
        // addClickHandler(graphComponent);
        //revalidate();
        
        //getContentPane().add(Box2, BorderLayout.NORTH);
        
        Container frame = getContentPane();
        getContentPane().setLayout(new BoxLayout(frame,BoxLayout.Y_AXIS));
        frame.add(hBox);
        frame.add(hBox2);
        frame.add(hBox3);
        frame.add(hBox4);
        frame.add(hBox5);
        frame.add(hBox6);
        frame.add(hBox7);
        frame.add(mOutputConsole);
        
        
    }


    /*public void addClickHandler(mxGraphComponent graphComponent) {
        // mxGraphComponent graphComponent = new mxGraphComponent(mGraph);
        getContentPane().add(graphComponent);
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                
                Object cell = graphComponent.getCellAt(e.getX(), e.getY());
                if (cell != null) {
                    println("cell=" + mGraph.getLabel(cell));
                }
            }
        });
    }*/


    public static void centreWindow(JFrame frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }


    private void generateGraphObject(BTNode<Integer, String> treeNode, int nLevel) throws BTException {
        if ((treeNode == null) ||
            (treeNode.mCurrentKeyNum == 0)) {
            return;
        }

        int currentKeyNum = treeNode.mCurrentKeyNum;
        BTKeyValue<Integer, String> keyVal;

        List<KeyData> keyList = (List<KeyData>)mObjLists[nLevel];
        if (keyList == null) {
            keyList = new ArrayList<KeyData>();
            mObjLists[nLevel] = keyList;
        }

        mBuf.setLength(0);
        // Render the keys in the node
        for (int i = 0; i < currentKeyNum; ++i) {
            if (i > 0) {
                mBuf.append(" | ");
            }

            keyVal = treeNode.mKeys[i];
            mBuf.append(keyVal.mKey);
        }

        keyList.add(new KeyData(mBuf.toString(), currentKeyNum));

        if (treeNode.mIsLeaf) {
            return;
        }

        ++nLevel;
        for (int i = 0; i < currentKeyNum + 1; ++i) {
            generateGraphObject(treeNode.mChildren[i], nLevel);
        }
    }


    public void println(String strText) {
        mOutputConsole.append("\n");
        mOutputConsole.append(strText);
        mOutputConsole.append("\n\n");
    }

    //Metodo para buscar
    public void searchKey(Integer key) {
        println("Id buscado= " + key);
        String strVal = mTreeTest.getBTree().search(key);
        if (strVal != null) {
            //mOutputConsole.setText("Datos encontrados aaaaa");
            //label.setText("ID: ");
            id.setText(""+key);
            nombre.setText(""+strVal);
            //println("Id = " + key + " | Empleado = " + strVal);
            //mOutputConsole.append("---------------------------");
        }
        else {
            println("No se encontro un empleado con id = " + key);
        }
    }


    public void deleteKey(Integer key) {
        String strVal = mTreeTest.getBTree().delete(key);
        println("Delete key = " + key + " | value = " + strVal);
    }


    public void addKey(Integer key) {
        String usuario = "root";
        String clave ="1234";
        String url ="jdbc:mysql://localhost:3306/arbol?serverTimezone=UTC";
        Connection con;
        Statement stmt;
        ResultSet rs;
        ArrayList<String> nuevos = new ArrayList<String>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BTreeRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con= DriverManager.getConnection(url, usuario,clave);
            stmt= con.createStatement();
            rs= stmt.executeQuery("SELECT nombre FROM personasc");
            
            while (rs.next()) { 
                nuevos.add(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BTreeRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(nuevos.size());
        println("Se añadio el usuario con id = " + key);
        mTreeTest.getBTree().insert(key, nuevos.get(index));
    }


    public final void generateTestData() {
        String usuario = "root";
        String clave ="1234";
        String url ="jdbc:mysql://localhost:3306/arbol?serverTimezone=UTC";
        Connection con;
        Statement stmt;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BTreeRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con= DriverManager.getConnection(url, usuario,clave);
            stmt= con.createStatement();
            rs= stmt.executeQuery("SELECT nombre FROM personasg");
            ArrayList<String> empleado = new ArrayList<String>();
            while (rs.next()) { 
                empleado.add(rs.getString("nombre"));
            }
            String[] empleados = new String[empleado.size()];
            empleados = empleado.toArray(empleados);
            for (int i = 1; i < 43; ++i) {
            mTreeTest.add(i, empleados[i]);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BTreeRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        /*try {
            mTreeTest.delete(24);
            mTreeTest.delete(23);
            mTreeTest.delete(27);
        }
        catch (BTException btex) {
            btex.printStackTrace();
        }*/
    }



    /**
     * Main Entry
     * @param args 
     */
    public static void main(String[] args) {
        BTreeRenderer frame = new BTreeRenderer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(APP_WIDTH, APP_HEIGHT);
        centreWindow(frame);
        frame.render();
        frame.setVisible(true);
    }


    /**
     * Inner class: KeyData
     */
    class KeyData {
        String mKeys = null;
        int mKeyNum = 0;

        KeyData(String keys, int keyNum) {
            mKeys = keys;
            mKeyNum = keyNum;
        }
    }


    /**
     * Inner class to implement BTree iterator
     */
    class BTIteratorImpl<K extends Comparable, V> implements BTIteratorIF<K, V> {
        private StringBuilder mBuf = new StringBuilder();

        @Override
        public boolean item(K key, V value) {
            mBuf.setLength(0);
            mBuf.append(key)
                .append("  |  Empleado = ")
                .append(value);
            println(mBuf.toString());
            /*
            if (key.compareTo(30) == 0) {
                return false;
            }
            */
            return true;
        }
    }
}
