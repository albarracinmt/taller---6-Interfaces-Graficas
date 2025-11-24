package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    private JLabel labMapa;
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar()
    {
        setLayout(new BorderLayout());
        labMapa = new JLabel(new ImageIcon("./imagenes/mapa.png"));
        labMapa.setBorder(new LineBorder(Color.DARK_GRAY));
        add(labMapa, BorderLayout.CENTER);
    }

    public PanelMapaVisualizar(List<Restaurante> restaurantes)
    {
        this();
        this.restaurantes = restaurantes;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        if (restaurantes != null)
        {
            for (Restaurante r : restaurantes)
            {
                g2d.drawString(r.getNombre(), r.getX(), r.getY());
            }
        }
    }

    public void actualizarMapa(List<Restaurante> nuevosRestaurantes)
    {
        if (restaurantes != null)
        {
            restaurantes.clear();
            restaurantes.addAll(nuevosRestaurantes);
        }
        else
        {
            restaurantes = nuevosRestaurantes;
        }
        repaint();
    }
}
