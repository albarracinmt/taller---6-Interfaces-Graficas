package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelDetallesRestaurante extends JPanel
{
    private JLabel labNombre;
    private JLabel labCalificacion;
    private JCheckBox chkVisitado;

    public PanelDetallesRestaurante()
    {
        labNombre = new JLabel();
        labCalificacion = new JLabel();
        chkVisitado = new JCheckBox();

        setLayout(new GridLayout(3, 1));

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Nombre: "));
        p1.add(labNombre);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("Calificación: "));
        p2.add(labCalificacion);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(new JLabel("Visitado: "));
        p3.add(chkVisitado);

        add(p1);
        add(p2);
        add(p3);
    }

    private void actualizarRestaurante(String nombre, int calificacion, boolean visitado)
    {
        labNombre.setText(nombre);
        labCalificacion.setIcon(buscarIconoCalificacion(calificacion));
        chkVisitado.setSelected(visitado);
    }

    public void actualizarRestaurante(Restaurante r)
    {
        this.actualizarRestaurante(r.getNombre(), r.getCalificacion(), r.isVisitado());
    }

    private ImageIcon buscarIconoCalificacion(int calificacion)
    {
        String imagen = "./imagenes/stars" + calificacion + ".png";
        return new ImageIcon(imagen);
    }
}
