package sistemahojacostos;

//Autor: Roberto Colón
import AppPackage.AnimationClass;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmHoja extends javax.swing.JFrame {

    ArrayList<String> columnas = new ArrayList<>();
    DefaultComboBoxModel modeloUnidad = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloUnidades = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloTipo = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloTipos = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloInsumo = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloInsumos = new DefaultComboBoxModel();
    DefaultComboBoxModel modeloLp = new DefaultComboBoxModel();

    DefaultTableModel modeloInsumosxHoja = new DefaultTableModel();

    AnimationClass a1 = new AnimationClass();
    AnimationClass a2 = new AnimationClass();

    ResultSet rstUnidad = null;
    ResultSet rstTipo = null;
    ResultSet rstHoja = null;
    ResultSet rstInsumo = null;
    ResultSet rstInsumosxHoja = null;
    Unidades unidad = new Unidades();
    Tipos tipo = new Tipos();
    Hojas hoja = new Hojas();
    Insumos insumo = new Insumos();
    InsumosxHoja insumosxHoja = new InsumosxHoja();
    FrmMensajes mandar = new FrmMensajes();
    int columnasDeTabla, columna;
    boolean cargarUnidades = false;
    int xx, xy, bandera = 0, bandera2 = 0, bandera3 = 0, bandera4 = 0, existe = 0;

    public frmHoja() {
        this.setLocationRelativeTo(this);
        this.setIconImage(new ImageIcon(getClass().getResource("/iconos/imageTodo.png")).getImage());
        initComponents();
        lblTotal.setVisible(false);

    }

    public void llenarCmbUnidades() {

        try {
            rstUnidad = unidad.llenarUnidades();
            while (rstUnidad.next()) {
                modeloUnidad.addElement(rstUnidad.getString(2));
                modeloUnidades.addElement(rstUnidad.getString(1));
            }
            cmbUnidad.setModel(modeloUnidad);
            lblUnidad.setText(String.valueOf(modeloUnidades.getElementAt(0)));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
        txtDescripcion.requestFocus();
    }

    public void limUnidad() {
        cmbUnidad.setModel(modeloLp);
        modeloUnidad.removeAllElements();
        modeloUnidades.removeAllElements();
        txtDescripcion.requestFocus();
        lblUnidad.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInsumosxHoja = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        txtCodigoHoja = new javax.swing.JTextField();
        lblHoja = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCacLim = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        cmbUnidad = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        lblTipos = new javax.swing.JLabel();
        lblInformacion = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        lblInsumos = new javax.swing.JLabel();
        cmbInsumo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnAgregarUnidad = new javax.swing.JButton();
        lblTipo = new javax.swing.JLabel();
        lblUnidad = new javax.swing.JLabel();
        lblInsumo = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        editarInsumo = new javax.swing.JButton();
        eliminarInsumo = new javax.swing.JButton();
        lblCancelar = new javax.swing.JLabel();
        btnNuevoInsumo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblSumaPrecios = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hoja de costos");
        setLocation(new java.awt.Point(150, 100));
        setMaximumSize(new java.awt.Dimension(900, 600));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInsumosxHoja.setBackground(new java.awt.Color(101, 138, 191));
        tblInsumosxHoja.setForeground(new java.awt.Color(255, 255, 255));
        tblInsumosxHoja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblInsumosxHoja.setGridColor(new java.awt.Color(251, 202, 57));
        tblInsumosxHoja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblInsumosxHojaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblInsumosxHoja);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 810, 150));

        btnNuevo.setBackground(new java.awt.Color(237, 239, 251));
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NueHoja.png"))); // NOI18N
        btnNuevo.setBorder(null);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 50));

        txtCodigoHoja.setEditable(false);
        txtCodigoHoja.setBackground(new java.awt.Color(237, 239, 251));
        txtCodigoHoja.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        getContentPane().add(txtCodigoHoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 50, 30));

        lblHoja.setBackground(new java.awt.Color(255, 255, 255));
        lblHoja.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblHoja.setForeground(new java.awt.Color(0, 0, 0));
        lblHoja.setText("N° de hoja");
        getContentPane().add(lblHoja, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 25));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Descripción :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 120, 30));

        btnCacLim.setBackground(new java.awt.Color(237, 239, 251));
        btnCacLim.setForeground(new java.awt.Color(0, 0, 0));
        btnCacLim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png"))); // NOI18N
        btnCacLim.setBorder(null);
        btnCacLim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCacLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCacLimActionPerformed(evt);
            }
        });
        getContentPane().add(btnCacLim, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 50));

        txtDescripcion.setEditable(false);
        txtDescripcion.setBackground(new java.awt.Color(229, 229, 229));
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 440, 30));

        cmbUnidad.setBackground(new java.awt.Color(229, 229, 229));
        cmbUnidad.setForeground(new java.awt.Color(0, 0, 0));
        cmbUnidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbUnidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUnidadItemStateChanged(evt);
            }
        });
        cmbUnidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbUnidadFocusGained(evt);
            }
        });
        cmbUnidad.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                cmbUnidadCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        cmbUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnidadActionPerformed(evt);
            }
        });
        getContentPane().add(cmbUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 280, 30));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Untitled (7).png"))); // NOI18N
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnGuardarFocusLost(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 100, 50));

        lblTipos.setBackground(new java.awt.Color(255, 255, 255));
        lblTipos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTipos.setForeground(new java.awt.Color(0, 0, 0));
        lblTipos.setText("Tipo de insumo :");
        getContentPane().add(lblTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 30));

        lblInformacion.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblInformacion.setForeground(new java.awt.Color(0, 0, 0));
        lblInformacion.setText("Detalle de la hoja de costos");
        getContentPane().add(lblInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 230, 20));

        cmbTipo.setBackground(new java.awt.Color(229, 229, 229));
        cmbTipo.setForeground(new java.awt.Color(0, 0, 0));
        cmbTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });
        cmbTipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbTipoFocusGained(evt);
            }
        });
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 280, 30));

        lblInsumos.setBackground(new java.awt.Color(255, 255, 255));
        lblInsumos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblInsumos.setForeground(new java.awt.Color(0, 0, 0));
        lblInsumos.setText("Insumos :");
        lblInsumos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInsumosMouseClicked(evt);
            }
        });
        getContentPane().add(lblInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 90, 30));

        cmbInsumo.setBackground(new java.awt.Color(229, 229, 229));
        cmbInsumo.setForeground(new java.awt.Color(0, 0, 0));
        cmbInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbInsumo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbInsumoItemStateChanged(evt);
            }
        });
        getContentPane().add(cmbInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 240, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cantidad :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 90, 20));

        txtCantidad.setEditable(false);
        txtCantidad.setBackground(new java.awt.Color(229, 229, 229));
        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));
        txtCantidad.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 130, 30));

        btnAgregar.setBackground(new java.awt.Color(237, 239, 251));
        btnAgregar.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AgreInsu.png"))); // NOI18N
        btnAgregar.setBorder(null);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, 50));

        btnAgregarUnidad.setBackground(new java.awt.Color(237, 239, 251));
        btnAgregarUnidad.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NueMedida.png"))); // NOI18N
        btnAgregarUnidad.setBorder(null);
        btnAgregarUnidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUnidadActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 60, 100, 50));

        lblTipo.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 30, 30));

        lblUnidad.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 40, 30));

        lblInsumo.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 230, 50, 30));

        txtBuscar.setBackground(new java.awt.Color(229, 229, 229));
        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 50, 30));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/1491254410-searchfinddetailzoom_82949.png"))); // NOI18N
        jLabel4.setText("Buscar Hoja");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/4115230-cancel-close-cross-delete_114048.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(865, 10, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 900, 20));

        editarInsumo.setBackground(new java.awt.Color(229, 229, 229));
        editarInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/notes_edit_modify_icon_143729.png"))); // NOI18N
        editarInsumo.setBorder(null);
        editarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarInsumoActionPerformed(evt);
            }
        });
        getContentPane().add(editarInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 422, 40, 40));

        eliminarInsumo.setBackground(new java.awt.Color(229, 229, 229));
        eliminarInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/biggarbagebin_121980.png"))); // NOI18N
        eliminarInsumo.setBorder(null);
        eliminarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarInsumoActionPerformed(evt);
            }
        });
        getContentPane().add(eliminarInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 362, 40, 40));

        lblCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(lblCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 470, 40, 30));

        btnNuevoInsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AgregarNueInsumo.png"))); // NOI18N
        btnNuevoInsumo.setBorder(null);
        btnNuevoInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoInsumoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Unidad de medida :");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, -1, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/window_minimize_icon_138009.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 30, -1));

        lblTotal.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setText("Total :");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, -1, -1));

        lblSumaPrecios.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblSumaPrecios.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(lblSumaPrecios, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 80, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ImageBackground.png"))); // NOI18N
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel3MouseDragged(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void Columnas() {
        columnas.clear();
        columnas.add("Numero de hoja");
        columnas.add("Numero de insumo");
        columnas.add("Descripcion");
        columnas.add("Precio Unitario");
        columnas.add("Cantidad");
        columnas.add("SubTotal");
    }

    private void bloquearHoja() {
        txtDescripcion.setEditable(false);
        cmbUnidad.setEnabled(false);
        lblUnidad.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnNuevo.setEnabled(true);
        btnAgregarUnidad.setEnabled(false);
        btnCacLim.setEnabled(false);
    }

    private void desbloquearHoja() {
        txtDescripcion.setEditable(true);
        cmbUnidad.setEnabled(true);
        lblUnidad.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnNuevo.setEnabled(false);
        btnAgregarUnidad.setEnabled(true);
        btnCacLim.setEnabled(true);
    }

    private void bloquearDetalle() {
        cmbTipo.setEnabled(false);
        lblTipo.setEnabled(false);
        cmbInsumo.setEnabled(false);
        lblInsumo.setEnabled(false);
        txtCantidad.setEditable(false);
        btnAgregar.setEnabled(false);
        btnNuevoInsumo.setEnabled(false);
        eliminarInsumo.setEnabled(false);
        editarInsumo.setEnabled(false);
    }

    private void desbloquearDetalle() {
        cmbTipo.setEnabled(true);
        lblTipo.setEnabled(true);
        cmbInsumo.setEnabled(true);
        lblInsumo.setEnabled(true);
        txtCantidad.setEditable(true);
        btnAgregar.setEnabled(true);
        btnNuevoInsumo.setEnabled(true);
        eliminarInsumo.setEnabled(true);
        editarInsumo.setEnabled(true);
    }

    private void cmbUnidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUnidadItemStateChanged
        int posicion = cmbUnidad.getSelectedIndex();
        lblUnidad.setText(String.valueOf(modeloUnidades.getElementAt(posicion)));
    }//GEN-LAST:event_cmbUnidadItemStateChanged

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        int posicion = cmbTipo.getSelectedIndex();
        lblTipo.setText(String.valueOf(modeloTipos.getElementAt(posicion)));

        //Llenando el cmbUnidades mediante un modelo
        modeloInsumo.removeAllElements();
        modeloInsumos.removeAllElements();
        try {
            rstInsumo = insumo.llenarInsumos(Integer.parseInt(lblTipo.getText()));
            while (rstInsumo.next()) {
                modeloInsumo.addElement(rstInsumo.getString(2));
                modeloInsumos.addElement(rstInsumo.getString(1));
            }
            cmbInsumo.setModel(modeloInsumo);
            lblInsumo.setText(String.valueOf(modeloInsumos.getElementAt(0)));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }

    }//GEN-LAST:event_cmbTipoItemStateChanged

    public void limpiarCmbs() {
        modeloLp.removeAllElements();
        lblInsumo.setText("");
        lblTipo.setText("");
        cmbTipo.setModel(modeloLp);
        cmbInsumo.setModel(modeloLp);
        modeloInsumo.removeAllElements();
        modeloInsumos.removeAllElements();
        modeloTipo.removeAllElements();
        modeloTipos.removeAllElements();
    }

    public void llenarDetalleHoja() {
        limpiarCmbs();
        try {
            rstTipo = tipo.llenarTipos();
            while (rstTipo.next()) {
                modeloTipo.addElement(rstTipo.getString(2));
                modeloTipos.addElement(rstTipo.getString(1));
            }
            cmbTipo.setModel(modeloTipo);
            lblTipo.setText(String.valueOf(modeloTipos.getElementAt(0)));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
        bloquearHoja();
        desbloquearDetalle();
        cmbTipo.requestFocus();
    }


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        regresarBtns();
        if (bandera == 0) {
            if (!txtDescripcion.getText().equals("")) {
                hoja.insertar(Integer.parseInt(txtCodigoHoja.getText()), txtDescripcion.getText(), lblUnidad.getText());
                mandar.setVisible(true);
                mandar.queMensaje(5);
                mandar.mandarMensaje();
                bandera4 = 1;
                bandera3 = 0;
                llenarDetalleHoja();
            } else {
                mandar.setVisible(true);
                mandar.queMensaje(6);
                mandar.mandarMensaje();
                txtDescripcion.requestFocus();
            }
        } else if (bandera == 1) {
            if (!txtDescripcion.getText().equals("")) {
                hoja.modificar(Integer.parseInt(txtCodigoHoja.getText()), txtDescripcion.getText(), lblUnidad.getText());
                mandar.setVisible(true);
                mandar.queMensaje(7);
                mandar.mandarMensaje();
                bandera4 = 1;
                bandera3 = 0;
                llenarDetalleHoja();
            } else {
                mandar.setVisible(true);
                mandar.queMensaje(6);
                mandar.mandarMensaje();
                txtDescripcion.requestFocus();
            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    public void buscarId() {
        int cantidad, mayor = 0;
        rstHoja = hoja.contarRegistros();
        try {
            while (rstHoja.next()) {
                cantidad = rstHoja.getInt(1);
                if (cantidad != 0) {
                    rstHoja = null;
                    rstHoja = hoja.mayorRegistro();
                    while (rstHoja.next()) {
                        mayor = rstHoja.getInt(1);

                    }
                    if (txtCodigoHoja.getText().equals(String.valueOf(mayor))) {
                        txtCodigoHoja.setText("");
                        limpiarCampos();
                    } else {
                        rstHoja = hoja.buscarTodo();
                        while (rstHoja.next()) {
                            if (txtCodigoHoja.getText().equals(rstHoja.getString("codigoHoja"))) {
                                txtCodigoHoja.setText("");
                                limpiarCampos();
                            } else {
                                txtCodigoHoja.setText("");
                                limpiarCampos();
                            }
                        }
                    }
                    {

                    }
                } else {

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "AVISO DEL SISTEMA", 0);
        }

    }

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        regresarBtns();
        if (bandera == 0) {
            buscarId();
            if (!txtCodigoHoja.getText().equals("")) {
                mandar.setVisible(true);
                mandar.queMensaje(4);
                mandar.mandarMensaje();
            } else {
                bandera3 = 1;
                txtBuscar.setText("");
                limUnidad();
                llenarCmbUnidades();
                int cantidad, mayor = 0;
                rstHoja = hoja.contarRegistros();
                try {
                    while (rstHoja.next()) {
                        cantidad = rstHoja.getInt(1);
                        if (cantidad != 0) {
                            rstHoja = null;
                            rstHoja = hoja.mayorRegistro();
                            while (rstHoja.next()) {
                                mayor = rstHoja.getInt(1) + 1;
                            }
                            txtCodigoHoja.setText(String.valueOf(mayor));
                        } else {
                            txtCodigoHoja.setText("1");
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "AVISO DEL SISTEMA", 0);
                }
                desbloquearHoja();
                txtDescripcion.requestFocus();
            }

        } else if (bandera == 1) {
            btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NueHoja.png")));
            btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Untitled (7).png")));
            btnCacLim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png")));

            tblInsumosxHoja.removeAll();
            buscarId();
            if (!txtCodigoHoja.getText().equals("")) {
                mandar.setVisible(true);
                mandar.queMensaje(4);
                mandar.mandarMensaje();
            } else {
                bandera3 = 1;
                txtBuscar.setText("");
                limUnidad();
                llenarCmbUnidades();
                int cantidad, mayor = 0;
                rstHoja = hoja.contarRegistros();
                try {
                    while (rstHoja.next()) {
                        cantidad = rstHoja.getInt(1);
                        if (cantidad != 0) {
                            rstHoja = null;
                            rstHoja = hoja.mayorRegistro();
                            while (rstHoja.next()) {
                                mayor = rstHoja.getInt(1) + 1;
                            }
                            txtCodigoHoja.setText(String.valueOf(mayor));
                        } else {
                            txtCodigoHoja.setText("1");
                        }
                    }
                    bandera = 0;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "AVISO DEL SISTEMA", 0);
                }
                desbloquearHoja();
                txtDescripcion.requestFocus();
            }
        }


    }//GEN-LAST:event_btnNuevoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (txtCodigoHoja.getText().equals("")) {
            bloquearHoja();
            bloquearDetalle();
        } else {
            //desbloquearDetalle();
        }
    }//GEN-LAST:event_formWindowActivated

    private void cmbTipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbTipoFocusGained
        //Llenando el cmbUnidades mediante un modelo
        modeloInsumo.removeAllElements();
        modeloInsumos.removeAllElements();
        try {
            rstInsumo = insumo.llenarInsumos(Integer.parseInt(lblTipo.getText()));
            while (rstInsumo.next()) {
                modeloInsumo.addElement(rstInsumo.getString(2));
                modeloInsumos.addElement(rstInsumo.getString(1));
            }
            cmbInsumo.setModel(modeloInsumo);
            lblInsumo.setText(String.valueOf(modeloInsumos.getElementAt(0)));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
        }
    }//GEN-LAST:event_cmbTipoFocusGained
    public String buscarInsumo(String codigo) {
        String salida = "";
        rstInsumo = insumo.llenarInsumos2(codigo);
        try {
            while (rstInsumo.next()) {
                salida = rstInsumo.getString("precioUnitario");
            }
        } catch (SQLException ex) {

        }

        return salida;
    }

    public Double total() {//metodo para calcular el total de la hoja
        Double total = 0.0;
        rstInsumosxHoja = insumosxHoja.llenarInsumos2(txtCodigoHoja.getText());
        try {
            while (rstInsumosxHoja.next()) {
                total += (Double.parseDouble(rstInsumosxHoja.getString("cantidad"))) * Double.parseDouble(buscarInsumo(rstInsumosxHoja.getString("codigo")));
            }
        } catch (SQLException ex) {

        }
        return Double.parseDouble(String.format("%.2f", total));
    }

    public void llenarTabla() {
        Columnas();
        modeloInsumosxHoja = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tblInsumosxHoja.setModel(modeloInsumosxHoja);

        //segunda parte: mostrar
        rstInsumosxHoja = null;
        int codigoHoja;
        codigoHoja = Integer.parseInt(txtCodigoHoja.getText());
        rstInsumosxHoja = insumosxHoja.llenarTabla(codigoHoja);

        try {
            ResultSetMetaData rstInsumosxHojaMD = rstInsumosxHoja.getMetaData();
            columnasDeTabla = rstInsumosxHojaMD.getColumnCount();

            //para llenar la tablas
            for (columna = 0; columna < columnasDeTabla; columna++) {
                modeloInsumosxHoja.addColumn(columnas.get(columna));
            }

            while (rstInsumosxHoja.next()) {
                Object[] fila = new Object[columna];
                for (int campo = 0; campo < columnasDeTabla; campo++) {
                    fila[campo] = rstInsumosxHoja.getObject(campo + 1);

                }
                modeloInsumosxHoja.addRow(fila);
            }
            lblTotal.setVisible(true);
            lblSumaPrecios.setText("$ " + total().toString());

            //finaliza llenado de tabla
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void cmbInsumoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbInsumoItemStateChanged
        int posicion = cmbInsumo.getSelectedIndex();
        lblInsumo.setText(String.valueOf(modeloInsumos.getElementAt(posicion)));
    }//GEN-LAST:event_cmbInsumoItemStateChanged

    public void nu() {
        cmbTipo.setSelectedIndex(0);
        cmbInsumo.setSelectedIndex(0);
        txtCantidad.setText("");
        cmbTipo.requestFocus();
    }

    public void repetidos() {
        String codH = "", codIn = "";
        rstInsumosxHoja = insumosxHoja.buscar2(txtCodigoHoja.getText(), lblInsumo.getText());
        try {
            while (rstInsumosxHoja.next()) {
                codH = rstInsumosxHoja.getString("codigoHoja");
                codIn = rstInsumosxHoja.getString("codigo");
            }

            if (codH.equals(txtCodigoHoja.getText()) && codIn.equals(lblInsumo.getText())) {
                existe = 1;
            } else {
                existe = 0;
            }
        } catch (SQLException ex) {

        }

    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (bandera2 == 0) {
            if (!txtCantidad.getText().equals("")) {
                repetidos();
                if (existe == 0) {
                    insumosxHoja.insertar(Integer.parseInt(txtCodigoHoja.getText()), Integer.parseInt(lblInsumo.getText()), Double.parseDouble(txtCantidad.getText()));
                    nu();
                } else if (existe == 1) {
                    mandar.setVisible(true);
                    mandar.queMensaje(8);
                    mandar.mandarMensaje();
                    txtCantidad.setText("");
                }

            } else {
                mandar.setVisible(true);
                mandar.queMensaje(9);
                mandar.mandarMensaje();
                txtCantidad.requestFocus();
            }
            llenarTabla();
        } else if (bandera2 == 1) {
            if (!txtCantidad.getText().equals("")) {

                insumosxHoja.modificar(txtCantidad.getText(), txtCodigoHoja.getText(), lblInsumo.getText());
                nu();
                bandera2 = 0;
                btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AgreInsu.png"))); // NOI18N
                txtCantidad.setText("");
                cmbTipo.setSelectedIndex(0);
                cmbInsumo.setSelectedIndex(0);
                desbloquearDetalle();
                txtCantidad.requestFocus();

            } else {
                mandar.setVisible(true);
                mandar.queMensaje(9);
                mandar.mandarMensaje();
                txtCantidad.requestFocus();
            }
            llenarTabla();
        }


    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cmbUnidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbUnidadFocusGained
        if (cargarUnidades == true) {
            //Llenando el cmbUnidades mediante un modelo
            modeloUnidad.removeAllElements();
            modeloUnidades.removeAllElements();
            try {
                rstUnidad = unidad.llenarUnidades();
                while (rstUnidad.next()) {
                    modeloUnidad.addElement(rstUnidad.getString(2));
                    modeloUnidades.addElement(rstUnidad.getString(1));
                }
                cmbUnidad.setModel(modeloUnidad);
                lblUnidad.setText(String.valueOf(modeloUnidades.getElementAt(0)));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Error", 0);
            }
            cargarUnidades = false;

        }

    }//GEN-LAST:event_cmbUnidadFocusGained

    public void limpiarCampos() {
        txtCodigoHoja.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
        lblUnidad.setText("");
        txtBuscar.setText("");
        lblTipo.setText("");
        lblInsumo.setText("");
        bloquearHoja();
        bloquearDetalle();
        modeloInsumosxHoja.setRowCount(0);
        modeloUnidad.removeAllElements();
        //btnNuevo.setEnabled(true);
    }

    public String buscarUnidad(String unidadd) {
        String salida = "";
        rstUnidad = unidad.buscar(unidadd);
        try {
            while (rstUnidad.next()) {
                salida = rstUnidad.getString("descripcion");
            }
        } catch (SQLException ex) {

        }
        return salida;
    }

    private void btnCacLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCacLimActionPerformed
        regresarBtns();
        if (bandera == 0) {
            limpiarCampos();
            modeloUnidad.removeAllElements();
            lblUnidad.setText("");
            bandera3 = 0;
        } else if (bandera == 1) {
            if (txtCodigoHoja.getText().isEmpty()) {
                mandar.setVisible(true);
                mandar.queMensaje(3);
                mandar.mandarMensaje();
            } else {
                insumosxHoja.eliminar(txtCodigoHoja.getText());
                hoja.eliminar(txtCodigoHoja.getText());
                JOptionPane.showMessageDialog(null, "Borrado");
                btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Untitled (7).png")));
                btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NueHoja.png"))); // NOI18N
                btnCacLim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png"))); // NOI18N
                limpiarCampos();
                modeloUnidad.removeAllElements();
                lblCancelar.setIcon(null);
                lblUnidad.setText("");
                bandera3 = 0;
                lblTotal.setVisible(false);
                lblSumaPrecios.setText("");
            }

        }


    }//GEN-LAST:event_btnCacLimActionPerformed

    private void btnAgregarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUnidadActionPerformed
        regresarBtns();
        frmUnidad abrir = new frmUnidad();
        abrir.setVisible(true);
        cargarUnidades = true;
        //this.setVisible(false); POR SI QUEREMOS OCULTAR EL FORMULARIO PRINCIPAL
    }//GEN-LAST:event_btnAgregarUnidadActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        regresarBtns();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_jLabel3MouseDragged

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscar();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    public void buscar() {
        if (txtBuscar.getText().isEmpty()) {
            mandar.setVisible(true);
            mandar.queMensaje(2);
            mandar.mandarMensaje();
        } else {
            int cuantos = 0;
            String cod = "", desp = "", unid = "";
            rstHoja = hoja.Consulta(txtBuscar.getText());
            try {
                while (rstHoja.next()) {
                    cod = rstHoja.getString("codigoHoja");
                    desp = rstHoja.getString("descripcion");
                    unid = buscarUnidad(rstHoja.getString("unidad"));
                    cuantos++;
                }
                if (cuantos != 0) {
                    llenarCmbUnidades();
                    desbloquearHoja();
                    desbloquearDetalle();
                    txtCodigoHoja.setText(cod);
                    txtDescripcion.setText(desp);
                    cmbUnidad.setSelectedItem(unid);
                    btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ActHoja.png")));
                    btnCacLim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/EliHoja.png")));
                    lblCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/android-system-back_icon-icons.com_50490.png")));
                    btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AgreInsu.png")));
                    txtCantidad.setText("");
                    lblCancelar.setEnabled(true);
                    lblTotal.setVisible(true);
                    bandera = 1;
                    llenarDetalleHoja();
                    llenarTabla();
                    desbloquearHoja();
                    bandera3 = 1;
                    bandera4 = 1;
                    txtBuscar.setText("");
                } else {
                    mandar.setVisible(true);
                    mandar.queMensaje(1);
                    mandar.mandarMensaje();
                    txtBuscar.setText("");
                }
            } catch (SQLException ex) {

            }
        }

    }
    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnGuardarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnGuardarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarFocusLost

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void eliminarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarInsumoActionPerformed
        if (tblInsumosxHoja.getSelectedRow() == -1) {
            mandar.setVisible(true);
            mandar.queMensaje(10);
            mandar.mandarMensaje();
        } else {
            String cod = "";
            int fila = tblInsumosxHoja.getSelectedRow();
            cod = tblInsumosxHoja.getValueAt(fila, 1).toString();
            insumosxHoja.eliminarInsumo(txtCodigoHoja.getText(), cod);
            mandar.setVisible(true);
            mandar.queMensaje(11);
            mandar.mandarMensaje();
            llenarTabla();
        }


    }//GEN-LAST:event_eliminarInsumoActionPerformed

    private void lblCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelarMouseClicked
        lblCancelar.setIcon(null);
        limpiarCampos();
        limpiarCmbs();
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Untitled (7).png")));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/NueHoja.png")));
        btnCacLim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Cancelar.png")));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/AgreInsu.png")));
        lblCancelar.setEnabled(false);
        lblTotal.setVisible(false);
        lblSumaPrecios.setText("");
        bandera = 0;
        bandera3 = 0;
        bandera4 = 0;
        lblUnidad.setText("");
        txtCodigoHoja.requestFocus();
    }//GEN-LAST:event_lblCancelarMouseClicked

    private void editarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarInsumoActionPerformed
        if (tblInsumosxHoja.getSelectedRow() == -1) {
            mandar.setVisible(true);
            mandar.queMensaje(10);
            mandar.mandarMensaje();
        } else {
            btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ActInsumo.png"))); // NOI18N
            String cod = "";
            int fila = tblInsumosxHoja.getSelectedRow();
            cod = tblInsumosxHoja.getValueAt(fila, 1).toString();
            rstInsumosxHoja = insumosxHoja.buscar2(txtCodigoHoja.getText(), cod);
            try {
                while (rstInsumosxHoja.next() || rstInsumo.next()) {
                    txtCantidad.setText(rstInsumosxHoja.getString("cantidad"));
                }
                cmbInsumo.setEnabled(false);
                cmbTipo.setEnabled(false);
                llenarCbmsParaEditar();
                bandera2 = 1;
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_editarInsumoActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        int posicion = btnAgregarUnidad.getX();
        if (bandera3 == 0) {

        } else {
            if (posicion == 950) {
                a1.jButtonXLeft(950, 750, 10, 5, btnAgregarUnidad);
            } else {
                a1.jButtonXRight(750, 950, 10, 5, btnAgregarUnidad);

            }
        }

    }//GEN-LAST:event_jLabel6MouseClicked

    private void lblInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInsumosMouseClicked
        int posicion = btnNuevoInsumo.getX();
        if (bandera4 == 0) {

        } else {
            if (posicion == 950) {
                a1.jButtonXLeft(950, 750, 10, 5, btnNuevoInsumo);
            } else {
                a1.jButtonXRight(750, 950, 10, 5, btnNuevoInsumo);

            }
        }
    }//GEN-LAST:event_lblInsumosMouseClicked

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        regresarBtns();
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.setState(frmHoja.ICONIFIED);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btnNuevoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoInsumoActionPerformed
        regresarBtns();
        frmInsumo abrir = new frmInsumo();
        abrir.setVisible(true);
    }//GEN-LAST:event_btnNuevoInsumoActionPerformed

    private void cmbUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUnidadActionPerformed

    private void cmbUnidadCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbUnidadCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUnidadCaretPositionChanged

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txtBuscar.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && evt.getKeyChar() != '.') {
            evt.consume();
        }
        if (evt.getKeyChar() == '.' && txtCantidad.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void tblInsumosxHojaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblInsumosxHojaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tblInsumosxHojaKeyTyped

    public void regresarBtns() {
        if (btnAgregarUnidad.getX() == 750 || btnNuevoInsumo.getX() == 750) {
            a1.jButtonXRight(750, 950, 10, 5, btnAgregarUnidad);
            a1.jButtonXRight(750, 950, 10, 5, btnNuevoInsumo);
        }
    }

    public void llenarCbmsParaEditar() {
        String cod = "", insum = "", tip = "", codT = "";
        int fila = tblInsumosxHoja.getSelectedRow();
        cod = tblInsumosxHoja.getValueAt(fila, 1).toString();
        rstInsumo = insumo.buscar(cod);
        try {
            while (rstInsumo.next()) {
                insum = rstInsumo.getString("descripcion");
                codT = rstInsumo.getString("tipo");
            }
            rstTipo = tipo.buscar(codT);
            while (rstTipo.next()) {
                tip = rstTipo.getString("descripcion");
            }

            cmbTipo.setSelectedItem(tip);
            cmbInsumo.setSelectedItem(insum);

        } catch (SQLException ex) {

        }

    }

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
            java.util.logging.Logger.getLogger(frmHoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHoja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarUnidad;
    private javax.swing.JButton btnCacLim;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnNuevoInsumo;
    private javax.swing.JComboBox cmbInsumo;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JComboBox cmbUnidad;
    private javax.swing.JButton editarInsumo;
    private javax.swing.JButton eliminarInsumo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCancelar;
    private javax.swing.JLabel lblHoja;
    private javax.swing.JLabel lblInformacion;
    private javax.swing.JLabel lblInsumo;
    private javax.swing.JLabel lblInsumos;
    private javax.swing.JLabel lblSumaPrecios;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTipos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JTable tblInsumosxHoja;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoHoja;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
