package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;

@SuppressWarnings("serial")
public class VentanaAgregarRestaurante extends JFrame
{
    private PanelEditarRestaurante panelDetalles;
    private PanelBotonesAgregar panelBotones;
    private PanelMapaAgregar panelMapa;
    private VentanaPrincipal ventanaPrincipal;

    public VentanaAgregarRestaurante(VentanaPrincipal principal)
    {
        this.ventanaPrincipal = principal;
        setLayout(new BorderLayout());

        panelMapa = new PanelMapaAgregar();
        add(panelMapa, BorderLayout.CENTER);

        JPanel pSur = new JPanel(new BorderLayout());
        panelDetalles = new PanelEditarRestaurante();
        panelBotones = new PanelBotonesAgregar(this);
        pSur.add(panelDetalles, BorderLayout.CENTER);
        pSur.add(panelBotones, BorderLayout.SOUTH);

        add(pSur, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public void agregarRestaurante()
    {
        String nombre = panelDetalles.getNombre();
        int calificacion = panelDetalles.getCalificacion();
        boolean visitado = panelDetalles.getVisitado();
        int x = panelMapa.getXSeleccionado();
        int y = panelMapa.getYSeleccionado();

        ventanaPrincipal.agregarRestaurante(nombre, calificacion, x, y, visitado);
        dispose();
    }

    public void cerrarVentana()
    {
        dispose();
    }
}
