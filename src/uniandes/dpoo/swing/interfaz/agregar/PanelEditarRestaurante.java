package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    private JTextField txtNombre;
    private JComboBox<String> cbbCalificacion;
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante()
    {
        txtNombre = new JTextField(15);
        cbbCalificacion = new JComboBox<>(new String[]{"1", "2", "3", "4", "5"});
        cbbVisitado = new JComboBox<>(new String[]{"No", "Si"});

        setLayout(new GridLayout(3, 1));

        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new JLabel("Nombre: "));
        p1.add(txtNombre);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(new JLabel("Calificación: "));
        p2.add(cbbCalificacion);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(new JLabel("Visitado: "));
        p3.add(cbbVisitado);

        add(p1);
        add(p2);
        add(p3);
    }

    public boolean getVisitado()
    {
        String valor = (String) cbbVisitado.getSelectedItem();
        return "Si".equals(valor);
    }

    public int getCalificacion()
    {
        String calif = (String) cbbCalificacion.getSelectedItem();
        return Integer.parseInt(calif);
    }

    public String getNombre()
    {
        return txtNombre.getText();
    }
}