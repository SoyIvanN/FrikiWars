import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class Friki extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static int num=generadorAdivinar();
	static int numFoto1=generadorAdivinar();
	static int numFoto2=generadorAdivinar();
	static int numFoto3=generadorAdivinar();
	final String RUTAIMAGENES="C:\\Users\\Profesor\\Documents\\Proyectos Java\\StarWars\\src\\img\\";
    private int tiradas = 0;
    private int aciertos = 0;
    JLabel lblAdivinar;
    JLabel lblFoto1;
    JLabel lblFoto2;
    JLabel lblFoto3;
    JButton btnAqui1;
    JButton btnAqui2;
    JButton btnAqui3;
    JButton btnVolverATirar;
    private JLabel lblPartidas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Friki frame = new Friki();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Friki() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 655);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon imgAdivinar;
		
		ImageIcon img=new ImageIcon(RUTAIMAGENES+"Fondo pantalla.jpg");
		JLabel lblFondo = new JLabel(img);
		lblFondo.setBounds(0, 0, 800, 615);
		contentPane.add(lblFondo);
		
		if(num==10) {
			imgAdivinar=new ImageIcon(RUTAIMAGENES+"10.jpg");
		}else {
			imgAdivinar=new ImageIcon(RUTAIMAGENES+"0"+num+".jpg");
		}
		lblAdivinar = new JLabel(imgAdivinar);
		lblAdivinar.setBounds(288, 14, 225, 225);
		contentPane.add(lblAdivinar);
		contentPane.setComponentZOrder(lblAdivinar, 0);
		
		ImageIcon cromo=new ImageIcon(RUTAIMAGENES+"traseraCromo.jpg");
		
		lblFoto1 = new JLabel(cromo);
		lblFoto1.setBounds(31, 295, 225, 225);
		contentPane.add(lblFoto1);
		contentPane.setComponentZOrder(lblFoto1, 0);
		
		lblFoto2 = new JLabel(cromo);
		lblFoto2.setBounds(287, 295, 225, 225);
		contentPane.add(lblFoto2);
		contentPane.setComponentZOrder(lblFoto2, 0);
		
		lblFoto3 = new JLabel(cromo);
		lblFoto3.setBounds(544, 295, 225, 225);
		contentPane.add(lblFoto3);
		contentPane.setComponentZOrder(lblFoto3, 0);
		
		btnAqui1 = new JButton("Aquí");
		btnAqui1.setBounds(31, 529, 225, 35);
		contentPane.add(btnAqui1);
		contentPane.setComponentZOrder(btnAqui1, 0);
		
		btnAqui2 = new JButton("Aqui");
		btnAqui2.setBounds(287, 529, 225, 35);
		contentPane.add(btnAqui2);
		contentPane.setComponentZOrder(btnAqui2, 0);
		
		btnAqui3 = new JButton("Aqui");
		btnAqui3.setBounds(544, 529, 225, 35);
		contentPane.add(btnAqui3);
		contentPane.setComponentZOrder(btnAqui3, 0);
		
		btnVolverATirar = new JButton("Volver a lanzar");
		btnVolverATirar.setBounds(31, 563, 738, 30);
		contentPane.add(btnVolverATirar);
		contentPane.setComponentZOrder(btnVolverATirar, 0);
		
		JLabel lblAciertos = new JLabel("Llevas "+aciertos+" aciertos");
		lblAciertos.setForeground(new Color(255, 255, 255));
		lblAciertos.setBounds(31, 254, 132, 30);
		contentPane.add(lblAciertos);
		contentPane.setComponentZOrder(lblAciertos, 0);
		
		lblPartidas = new JLabel("Estás en la partida "+(tiradas+1));
		lblPartidas.setForeground(new Color(255, 255, 255));
		lblPartidas.setBounds(646, 254, 123, 30);
		contentPane.add(lblPartidas);
		contentPane.setComponentZOrder(lblPartidas, 0);
			
		btnAqui1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobarAcierto(1);
                deshabilitarBotones();
                lblAciertos.setText("Llevas "+aciertos+" aciertos");
            }
        });
		btnAqui2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobarAcierto(2);
                deshabilitarBotones();
                lblAciertos.setText("Llevas "+aciertos+" aciertos");
            }
        });
		btnAqui3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobarAcierto(3);
                deshabilitarBotones();
                lblAciertos.setText("Llevas "+aciertos+" aciertos");
            }
        });
		btnVolverATirar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reset(lblFoto1,lblFoto2,lblFoto3);
                habilitarBotones();
                acc(lblAdivinar);
                lblPartidas.setText("Estás en la partida "+(tiradas+1));
                contentPane.repaint();
            }
        });
		
		contentPane.repaint();
	}
	
	private void comprobarAcierto(int posicion) {
		generadorEasy();
		boolean acierto=false;
		switch(posicion) {
		case 1:
			acierto=esAcierto(lblFoto1);
			break;
		case 2:
			acierto=esAcierto(lblFoto2);
			break;
		case 3:	
			acierto=esAcierto(lblFoto3);
			break;
		}
		if(acierto) {
			switch(posicion) {
			case 1:
				ImageIcon fote;
				if(num==10) {
					fote = new ImageIcon(RUTAIMAGENES + "10ok.jpg");
			    } else {
			        fote = new ImageIcon(RUTAIMAGENES + "0" + num + "ok.jpg");
			    }
			    lblFoto1.setIcon(fote);
			    aciertos++;
			    break;
			case 2:
				ImageIcon fete;
				if(num==10) {
					fete = new ImageIcon(RUTAIMAGENES + "10ok.jpg");
			    } else {
			        fete = new ImageIcon(RUTAIMAGENES + "0" + num + "ok.jpg");
			    }
			    lblFoto2.setIcon(fete);
			    aciertos++;
			    break;
			case 3:	
				ImageIcon frte;
				if(num==10) {
					frte = new ImageIcon(RUTAIMAGENES + "10ok.jpg");
			    } else {
			        frte = new ImageIcon(RUTAIMAGENES + "0" + num + "ok.jpg");
			    }
			    lblFoto3.setIcon(frte);
			    aciertos++;
			    break;
			}
		}else {
			switch(posicion) {
			case 1:
				ImageIcon fote;
				if(num==10) {
					fote = new ImageIcon(RUTAIMAGENES + "10bad.jpg");
			    } else {
			        fote = new ImageIcon(RUTAIMAGENES + "0" + numFoto3 + "bad.jpg");
			    }
			    lblFoto1.setIcon(fote);
			    break;
			case 2:
				ImageIcon fete;
				if(num==10) {
					fete = new ImageIcon(RUTAIMAGENES + "10bad.jpg");
			    } else {
			        fete = new ImageIcon(RUTAIMAGENES + "0" + numFoto3 + "bad.jpg");
			    }
			    lblFoto2.setIcon(fete);
			    break;
			case 3:	
				ImageIcon frte;
				if(num==10) {
					frte = new ImageIcon(RUTAIMAGENES + "10bad.jpg");
			    } else {
			        frte = new ImageIcon(RUTAIMAGENES + "0" + numFoto3 + "bad.jpg");
			    }
			    lblFoto3.setIcon(frte);
			    break;
			}
		}
		tiradas++;
		
		try {
			final String RUTA ="C:\\Users\\Profesor\\Documents\\Proyectos Java\\StarWars\\src\\";
			FileWriter writer= new FileWriter(RUTA+"datosFrikiWars.txt",true);
			writer.write("Cromo 0"+num+" - "+"Cromo 0"+numFoto1+" - "+"Cromo 0"+numFoto2+" - "+acierto+"\n");
			writer.close();
		} catch (Exception o) {
			o.printStackTrace();
		}
		if (tiradas==10) {
			deshabilitarBotones();
			btnVolverATirar.setEnabled(false);
			verMensaje("Has obtenido "+aciertos+"/10 aciertos.\n Felicidades!!");
			dispose();
		}
	}
	
	private boolean esAcierto(JLabel lblFoto) {
		ImageIcon adivinar=(ImageIcon) lblAdivinar.getIcon();
		 ImageIcon seleccion = (ImageIcon) lblFoto.getIcon();
		 return adivinar.getImage().equals(seleccion.getImage());
	}
	
	private static int generadorAdivinar() {
	    int nuevoNumero = (int) (Math.random() * (10 - 1)) + 1;
	    while (nuevoNumero == num || nuevoNumero == numFoto1 || nuevoNumero == numFoto2) {
	        nuevoNumero = (int) (Math.random() * (10 - 1)) + 1;
	    }
	    return nuevoNumero;
	}
	private void generadorEasy() {
		int num1= (int)(Math.random()*(3))+1;
		switch (num1) {
        case 1:
            asignarImagenAdivinar(lblFoto1);
            asignarImagenRandom(lblFoto2,lblFoto3);
            break;
        case 2:
            asignarImagenAdivinar(lblFoto2);
            asignarImagenRandom(lblFoto1,lblFoto3);
            break;
        case 3:
            asignarImagenAdivinar(lblFoto3);
            asignarImagenRandom(lblFoto1,lblFoto2);
            break;
    }
	}
	private void asignarImagenAdivinar(JLabel fto) {
	    ImageIcon imgAdivina;
	    if (num == 10) {
	        imgAdivina = new ImageIcon(RUTAIMAGENES + "10.jpg");
	    } else {
	        imgAdivina = new ImageIcon(RUTAIMAGENES + "0" + num + ".jpg");
	    }
	    fto.setIcon(imgAdivina);
	}
	private void asignarImagenRandom(JLabel fta, JLabel chope) {
	    ImageIcon imgAdivin1;
	    if (numFoto1 == 10) {
	        imgAdivin1 = new ImageIcon(RUTAIMAGENES + "10.jpg");
	    } else {
	        imgAdivin1 = new ImageIcon(RUTAIMAGENES + "0" + numFoto1 + ".jpg");
	    }
	    fta.setIcon(imgAdivin1);

	    ImageIcon imgAdivin2;
	    if (numFoto2 == 10) {
	        imgAdivin2 = new ImageIcon(RUTAIMAGENES + "10.jpg");
	    } else {
	        imgAdivin2 = new ImageIcon(RUTAIMAGENES + "0" + numFoto2 + ".jpg");
	    }
	    chope.setIcon(imgAdivin2);
	}
	 private void deshabilitarBotones() {
	        btnAqui1.setEnabled(false);
	        btnAqui2.setEnabled(false);
	        btnAqui3.setEnabled(false);
	        }
	    private void habilitarBotones() {
	        btnAqui1.setEnabled(true);
	        btnAqui2.setEnabled(true);
	        btnAqui3.setEnabled(true);
	    }
	    private void reset(JLabel foto1, JLabel foto2,JLabel foto3) {
	    	ImageIcon base=new ImageIcon(RUTAIMAGENES + "traseraCromo.jpg");
	    	foto1.setIcon(base);
	    	foto2.setIcon(base);
	    	foto3.setIcon(base);
	    }
	    private void acc(JLabel portada) {
	    	num = generadorAdivinar();
	    	numFoto1 = generadorAdivinar();
	    	numFoto2 = generadorAdivinar();
	    	numFoto3 = generadorAdivinar();
	    	ImageIcon imgAdivin1;
	 	    if (num == 10) {
	 	        imgAdivin1 = new ImageIcon(RUTAIMAGENES + "10.jpg");
	 	    } else {
	 	        imgAdivin1 = new ImageIcon(RUTAIMAGENES + "0" + num + ".jpg");
	 	    }
	 	    portada.setIcon(imgAdivin1);
	    }
	    private void verMensaje(String mensaje) {
			JOptionPane.showMessageDialog(null, mensaje);
		}
}

