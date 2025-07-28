package nutrigym.modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//Compilar interfaz simulada aqui
public class InterfazIniciarSesion extends JFrame {
    private static final long serialVersionUID = 1L;

    private final static String FECHA_ACTUAL = "26/07/2025";

    private JTextField campoTextoUsuarioCorreo;
    private JPasswordField campoContrasenia;
    private JLabel etiquetaMensajes;
    private JButton botonIniciarSesion;
    private JButton botonSalir;
    private JPanel panelDatosPerfil;

    private SimulaBDUsuarios baseDatosUsuarios;
    private Usuario usuarioActual;
    
    //para evitar el error "The value of the lambda parameter e is not used"
    @SuppressWarnings("unused")
    public InterfazIniciarSesion() {
        setTitle("Iniciar Sesión NutriGym");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 480);
        setLocationRelativeTo(null);

        baseDatosUsuarios = new SimulaBDUsuarios();

        JPanel panelContenedorPrincipal = new JPanel(new GridBagLayout());
        panelContenedorPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelContenedorPrincipal.setBackground(new Color(230, 240, 250));

        GridBagConstraints restriccionesLayout = new GridBagConstraints();
        restriccionesLayout.insets = new Insets(5, 5, 5, 5);
        restriccionesLayout.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetaTitulo = new JLabel("BIENVENIDO A NUTRIGYM");
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = 0;
        restriccionesLayout.gridwidth = 2;
        panelContenedorPrincipal.add(etiquetaTitulo, restriccionesLayout);

        JLabel etiquetaSubtitulo = new JLabel("INICIE SESIÓN");
        etiquetaSubtitulo.setFont(new Font("Arial", Font.PLAIN, 15));
        etiquetaSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
        restriccionesLayout.gridy = 1;
        panelContenedorPrincipal.add(etiquetaSubtitulo, restriccionesLayout);

        restriccionesLayout.gridwidth = 1;

        int filaActual = 2;

        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = filaActual;
        restriccionesLayout.anchor = GridBagConstraints.WEST;
        panelContenedorPrincipal.add(new JLabel("Usuario o Correo:"), restriccionesLayout);

        restriccionesLayout.gridx = 1;
        restriccionesLayout.anchor = GridBagConstraints.EAST;
        campoTextoUsuarioCorreo = new JTextField(20);
        panelContenedorPrincipal.add(campoTextoUsuarioCorreo, restriccionesLayout);
        filaActual++;

        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = filaActual;
        restriccionesLayout.anchor = GridBagConstraints.WEST;
        panelContenedorPrincipal.add(new JLabel("Contraseña:"), restriccionesLayout);

        restriccionesLayout.gridx = 1;
        restriccionesLayout.anchor = GridBagConstraints.EAST;
        campoContrasenia = new JPasswordField(20);
        panelContenedorPrincipal.add(campoContrasenia, restriccionesLayout);
        filaActual++;

        etiquetaMensajes = new JLabel("");
        etiquetaMensajes.setForeground(Color.RED);
        etiquetaMensajes.setHorizontalAlignment(SwingConstants.CENTER);
        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = filaActual++;
        restriccionesLayout.gridwidth = 2;
        panelContenedorPrincipal.add(etiquetaMensajes, restriccionesLayout);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.setBackground(new Color(60, 179, 113));
        botonIniciarSesion.setForeground(Color.WHITE);
        botonIniciarSesion.setFocusPainted(false);
        botonIniciarSesion.addActionListener(this::accionIniciarSesion);

        botonSalir = new JButton("Salir");
        botonSalir.setBackground(new Color(220, 20, 60));
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setFocusPainted(false);
        botonSalir.addActionListener(e -> System.exit(0));

        panelBotones.add(botonIniciarSesion);
        panelBotones.add(botonSalir);

        restriccionesLayout.gridx = 0;
        restriccionesLayout.gridy = filaActual++;
        restriccionesLayout.gridwidth = 2;
        panelContenedorPrincipal.add(panelBotones, restriccionesLayout);

        panelDatosPerfil = new JPanel();
        panelDatosPerfil.setLayout(new BoxLayout(panelDatosPerfil, BoxLayout.Y_AXIS));
        panelDatosPerfil.setBorder(BorderFactory.createTitledBorder("Tus Datos de Perfil"));
        panelDatosPerfil.setVisible(false);

        restriccionesLayout.gridy = filaActual;
        panelContenedorPrincipal.add(panelDatosPerfil, restriccionesLayout);

        add(panelContenedorPrincipal);
    }

    private void accionIniciarSesion(ActionEvent evento) {
        mostrarMensaje("", Color.BLACK);
        panelDatosPerfil.setVisible(false);

        String strUsuarioCorreoIngresado = campoTextoUsuarioCorreo.getText().trim();
        String strContraseniaIngresada = new String(campoContrasenia.getPassword()).trim();

        if (strUsuarioCorreoIngresado.isEmpty() || strContraseniaIngresada.isEmpty()) {
            mostrarMensaje("Por favor, ingrese usuario/correo y contraseña.", Color.RED);
            return;
        }

        usuarioActual = baseDatosUsuarios.buscarUsuarioPorNombreCorreo(strUsuarioCorreoIngresado);

        if (usuarioActual == null) {
            mostrarMensaje("Usuario no encontrado. Verifique su usuario o correo electrónico.", Color.RED);
            return;
        }

        if (usuarioActual.getContrasenia().equals(strContraseniaIngresada)) {
            mostrarMensaje("¡Inicio de sesión exitoso! Bienvenido/a, " + usuarioActual.getNombrePublico() + "!", new Color(34, 139, 34));
            mostrarPerfilUsuario();
        } else {
            mostrarMensaje("Contraseña incorrecta. Inténtelo de nuevo.", Color.RED);
        }
    }

    private void mostrarPerfilUsuario() {
        panelDatosPerfil.removeAll();

        panelDatosPerfil.add(new JLabel("<html><br><b>Información de Perfil:</b></html>"));
        panelDatosPerfil.add(new JLabel("  Correo electrónico: " + usuarioActual.getCorreoElectronico()));
        panelDatosPerfil.add(new JLabel("  Usuario: " + usuarioActual.getUsuario()));
        panelDatosPerfil.add(new JLabel("  Nombre público: " + usuarioActual.getNombrePublico()));
        
        int intEdad = usuarioActual.calcularEdadAFecha(FECHA_ACTUAL);
        panelDatosPerfil.add(new JLabel("  Edad: " + intEdad + " años"));
        
        panelDatosPerfil.add(new JLabel("  Peso: " + usuarioActual.getPeso() + " kg"));
        panelDatosPerfil.add(new JLabel("  Altura: " + usuarioActual.getAltura() + " m"));
        panelDatosPerfil.add(new JLabel("  Sexo: " + usuarioActual.getSexo()));
        panelDatosPerfil.add(new JLabel("  Región: " + usuarioActual.getRegion()));

        panelDatosPerfil.setVisible(true);
        panelDatosPerfil.revalidate();
        panelDatosPerfil.repaint();
    }
    private void mostrarMensaje(String strMensaje, Color color) {
        etiquetaMensajes.setText(strMensaje);
        etiquetaMensajes.setForeground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfazIniciarSesion ventanaLogin = new InterfazIniciarSesion();
            ventanaLogin.setVisible(true);
        });
    }
}