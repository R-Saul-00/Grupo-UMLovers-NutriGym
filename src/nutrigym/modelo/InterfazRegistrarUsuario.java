package nutrigym.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//Compilar interfaz simulada aqui
public class InterfazRegistrarUsuario extends JFrame {
    private static final long serialVersionUID = 1L;

    private final static String FECHA_ACTUAL = "26/07/2025";

    private JTextField campoTextoCorreoElectronico;
    private JPasswordField campoContrasenia;
    private JTextField campoTextoNombreUsuario;
    private JTextField campoTextoNombrePublico;
    private JTextField campoTextoFechaNacimiento;
    private JTextField campoTextoPeso;
    private JTextField campoTextoAltura;
    private JComboBox<String> desplegableGenero;
    private JComboBox<String> desplegablePais;
    private JLabel etiquetaMensajes;
    private JButton botonRegistrar;
    private JButton botonCancelar;
    private JPanel panelDatosUsuario;

    private SimulaBDUsuarios baseDatosUsuarios;
    private ListaGenero listaGeneros;
    private ListaPais listaPaises;

    //para evitar el error "The value of the lambda parameter e is not used"
    @SuppressWarnings("unused")
	public InterfazRegistrarUsuario() {
        setTitle("Registro NutriGym");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 650);
        setLocationRelativeTo(null);

        baseDatosUsuarios = new SimulaBDUsuarios();
        listaGeneros = new ListaGenero();
        listaPaises = new ListaPais();

        JPanel panelContenedorPrincipal = new JPanel(new GridBagLayout());
        panelContenedorPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelContenedorPrincipal.setBackground(new Color(230, 240, 250));

        GridBagConstraints restriccionesLayout = new GridBagConstraints();
        restriccionesLayout.insets = new Insets(5, 5, 5, 5);
        restriccionesLayout.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetaTitulo = new JLabel("BIENVENIDO AL REGISTRO DE NUTRIGYM");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 0;
        restriccionesLayout.gridwidth = 2;
        panelContenedorPrincipal.add(etiquetaTitulo, restriccionesLayout);

        JLabel etiquetaSubtitulo = new JLabel("INGRESE SUS DATOS PARA EL REGISTRO");
        etiquetaSubtitulo.setFont(new Font("Arial", Font.PLAIN, 14));
        etiquetaSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        restriccionesLayout.gridy = 1;
        panelContenedorPrincipal.add(etiquetaSubtitulo, restriccionesLayout);

        restriccionesLayout.gridwidth = 1;

        int filaActual = 2;

        agregarCampoFormulario(panelContenedorPrincipal, restriccionesLayout, filaActual++, "Correo Electrónico:", campoTextoCorreoElectronico = new JTextField(20));
        agregarCampoFormulario(panelContenedorPrincipal, restriccionesLayout, filaActual++, "Contraseña:", campoContrasenia = new JPasswordField(20));
        agregarCampoFormulario(panelContenedorPrincipal, restriccionesLayout, filaActual++, "Nombre de Usuario:", campoTextoNombreUsuario = new JTextField(20));
        agregarCampoFormulario(panelContenedorPrincipal, restriccionesLayout, filaActual++, "Nombre Público:", campoTextoNombrePublico = new JTextField(20));
        agregarCampoFormulario(panelContenedorPrincipal, restriccionesLayout, filaActual++, "Fecha Nacimiento (DD/MM/AAAA):", campoTextoFechaNacimiento = new JTextField(10));
        agregarCampoFormulario(panelContenedorPrincipal, restriccionesLayout, filaActual++, "Peso en kg (ej. 70.5):", campoTextoPeso = new JTextField(10));
        agregarCampoFormulario(panelContenedorPrincipal, restriccionesLayout, filaActual++, "Altura en metros (ej. 1.75):", campoTextoAltura = new JTextField(10));

        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = filaActual;
        restriccionesLayout.anchor = GridBagConstraints.WEST;
        panelContenedorPrincipal.add(new JLabel("Sexo:"), restriccionesLayout);
        restriccionesLayout.gridx = 1;
        restriccionesLayout.anchor = GridBagConstraints.EAST;
        desplegableGenero = new JComboBox<>(listaGeneros.getGenero().toArray(new String[0]));
        panelContenedorPrincipal.add(desplegableGenero, restriccionesLayout);
        filaActual++;

        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = filaActual;
        restriccionesLayout.anchor = GridBagConstraints.WEST;
        panelContenedorPrincipal.add(new JLabel("Región/País:"), restriccionesLayout);
        restriccionesLayout.gridx = 1;
        restriccionesLayout.anchor = GridBagConstraints.EAST;
        desplegablePais = new JComboBox<>(listaPaises.getPais().toArray(new String[0]));
        panelContenedorPrincipal.add(desplegablePais, restriccionesLayout);
        filaActual++;

        etiquetaMensajes = new JLabel("");
        etiquetaMensajes.setForeground(Color.RED);
        etiquetaMensajes.setHorizontalAlignment(SwingConstants.CENTER);
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = filaActual++;
        restriccionesLayout.gridwidth = 2;
        panelContenedorPrincipal.add(etiquetaMensajes, restriccionesLayout);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        botonRegistrar = new JButton("Registrar");
        botonRegistrar.setBackground(new Color(60, 179, 113));
        botonRegistrar.setForeground(Color.WHITE);
        botonRegistrar.setFocusPainted(false);
        botonRegistrar.addActionListener(this::accionRegistrarUsuario);

        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBackground(new Color(220, 20, 60));
        botonCancelar.setForeground(Color.WHITE);
        botonCancelar.setFocusPainted(false);
        botonCancelar.addActionListener(e -> {
            mostrarMensaje("Registro cancelado.", Color.RED);
            JOptionPane.showMessageDialog(this, "Registro cancelado. Saliendo...", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        });

        panelBotones.add(botonRegistrar);
        panelBotones.add(botonCancelar);

        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = filaActual++;
        restriccionesLayout.gridwidth = 2;
        panelContenedorPrincipal.add(panelBotones, restriccionesLayout);

        panelDatosUsuario = new JPanel();
        panelDatosUsuario.setLayout(new BoxLayout(panelDatosUsuario, BoxLayout.Y_AXIS));
        panelDatosUsuario.setBorder(BorderFactory.createTitledBorder("Datos Registrados"));
        panelDatosUsuario.setVisible(false);
        
        restriccionesLayout.gridy = filaActual;
        panelContenedorPrincipal.add(panelDatosUsuario, restriccionesLayout);

        add(panelContenedorPrincipal);
    }

    private void agregarCampoFormulario(JPanel panelContenedor, GridBagConstraints restricciones, int fila, String textoEtiqueta, JTextField campoTexto) {
        restricciones.gridx = 0;
        restricciones.gridy = fila;
        restricciones.anchor = GridBagConstraints.WEST;
        panelContenedor.add(new JLabel(textoEtiqueta), restricciones);
        
        restricciones.gridx = 1;
        restricciones.anchor = GridBagConstraints.EAST;
        restricciones.weightx = 1.0;
        panelContenedor.add(campoTexto, restricciones);
        restricciones.weightx = 0;
    }

    private void accionRegistrarUsuario(ActionEvent evento) {
        mostrarMensaje("", Color.BLACK);
        panelDatosUsuario.setVisible(false);

        String correoElectronico = campoTextoCorreoElectronico.getText().trim();
        String contrasenia = new String(campoContrasenia.getPassword()).trim();
        String nombreUsuario = campoTextoNombreUsuario.getText().trim();
        String nombrePublico = campoTextoNombrePublico.getText().trim();
        String fechaNacimiento = campoTextoFechaNacimiento.getText().trim();
        String textoPeso = campoTextoPeso.getText().trim();
        String textoAltura = campoTextoAltura.getText().trim();
        String generoSeleccionado = (String) desplegableGenero.getSelectedItem();
        String paisSeleccionado = (String) desplegablePais.getSelectedItem();

        if (correoElectronico.isEmpty() || contrasenia.isEmpty() || nombreUsuario.isEmpty() ||
            nombrePublico.isEmpty() || fechaNacimiento.isEmpty() || textoPeso.isEmpty() || textoAltura.isEmpty()) {
            mostrarMensaje("Todos los campos son obligatorios.", Color.RED);
            return;
        }
        
        if (baseDatosUsuarios.existeCuentaPorNombreCorreo(correoElectronico)) {
            mostrarMensaje("Este correo electrónico ya está registrado.", Color.RED);
            return;
        }

        if (baseDatosUsuarios.existeCuentaPorNombreCorreo(nombreUsuario)) {
            mostrarMensaje("Este nombre de usuario ya existe o es un correo ya registrado.", Color.RED);
            return;
        }
        
        int edad = verificarEdadFormato(fechaNacimiento);
        if (edad <= 15) {
            mostrarMensaje("Fecha de nacimiento incorrecta o edad no válida. Debe ser mayor de 15 años.", Color.RED);
            return;
        }

        float peso;
        try {
            peso = Float.parseFloat(textoPeso);
            if (peso <= 0) {
                 mostrarMensaje("El peso debe ser un número positivo.", Color.RED);
                 return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("Formato de peso inválido. Use números (ej. 70.5).", Color.RED);
            return;
        }

        float altura;
        try {
            altura = Float.parseFloat(textoAltura);
            if (altura <= 0) {
                mostrarMensaje("La altura debe ser un número positivo.", Color.RED);
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("Formato de altura inválido. Use números (ej. 1.75).", Color.RED);
            return;
        }

        if (!listaGeneros.generoDisponible(generoSeleccionado)) {
            mostrarMensaje("Sexo no válido. Por favor, seleccione uno de la lista.", Color.RED);
            return;
        }

        if (!listaPaises.paisDisponible(paisSeleccionado)) {
            mostrarMensaje("Región/país no válido. Por favor, seleccione uno de la lista.", Color.RED);
            return;
        }

        Usuario nuevoUsuario = new Usuario(        
                correoElectronico, 
                nombreUsuario,      
                contrasenia, 
                nombrePublico,
                fechaNacimiento,
                peso,
                altura,
                generoSeleccionado,
                paisSeleccionado
        );
        
        mostrarMensaje("¡REGISTRO EXITOSO! Bienvenido/a, " + nuevoUsuario.getNombrePublico() + "!", new Color(34, 139, 34));

        panelDatosUsuario.removeAll();
        panelDatosUsuario.add(new JLabel("<html><br><b>Tus datos registrados son:</b></html>"));
        panelDatosUsuario.add(new JLabel("  Correo electrónico: " + nuevoUsuario.getCorreoElectronico()));
        panelDatosUsuario.add(new JLabel("  Usuario: " + nuevoUsuario.getUsuario()));
        panelDatosUsuario.add(new JLabel("  Nombre público: " + nuevoUsuario.getNombrePublico()));
        panelDatosUsuario.add(new JLabel("  Fecha de nacimiento: " + nuevoUsuario.getFechaNacimiento()));
        panelDatosUsuario.add(new JLabel("  Edad: " + nuevoUsuario.calcularEdadAFecha(FECHA_ACTUAL) + " años"));
        panelDatosUsuario.add(new JLabel("  Peso: " + nuevoUsuario.getPeso() + " kg"));
        panelDatosUsuario.add(new JLabel("  Altura: " + nuevoUsuario.getAltura() + " m"));
        panelDatosUsuario.add(new JLabel("  Sexo: " + nuevoUsuario.getSexo()));
        panelDatosUsuario.add(new JLabel("  Región: " + nuevoUsuario.getRegion()));
        panelDatosUsuario.setVisible(true);
        panelDatosUsuario.revalidate();
        panelDatosUsuario.repaint();
    }

    private void mostrarMensaje(String mensaje, Color color) {
        etiquetaMensajes.setText(mensaje);
        etiquetaMensajes.setForeground(color);
    }

    public static int verificarEdadFormato(String fechaNacimiento) {
        try {
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNacimientoParseada = LocalDate.parse(fechaNacimiento, formatoFecha);
            LocalDate fechaActualParseada = LocalDate.parse(FECHA_ACTUAL, formatoFecha);

            int edad = fechaActualParseada.getYear() - fechaNacimientoParseada.getYear();

            if (fechaActualParseada.getMonthValue() < fechaNacimientoParseada.getMonthValue()) {
                edad--;
            } else if (fechaActualParseada.getMonthValue() == fechaNacimientoParseada.getMonthValue()) {
                if (fechaActualParseada.getDayOfMonth() < fechaNacimientoParseada.getDayOfMonth()) {
                    edad--;
                }
            }
            return edad;
        } catch (DateTimeParseException | StringIndexOutOfBoundsException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazRegistrarUsuario ventanaRegistro = new InterfazRegistrarUsuario();
            ventanaRegistro.setVisible(true);
        });
    }
}