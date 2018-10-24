import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

interface Loader{ public Image load(); }
class Test extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabelPhotos = new JLabel("Photos");
	private JComboBox<String> jComboBoxPhotos = new JComboBox<>();
	//private JButton jButtonTraiter = new JButton("Traiter");
	private  PanelPhoto panelPhoto = new PanelPhoto();
	private MesImages uneImage = new MesImages();
	private JCheckBox maCheckBox = new JCheckBox();
	private Frame father;
	Image m_Img1;
	 
	
	public Test() {
		JMenuBar menubar= new JMenuBar();
		setJMenuBar(menubar);
		JMenu menu1= new JMenu("Datei");
		menubar.add(menu1);
		JMenu menu2= new JMenu("Aktion");
		menubar.add(menu2);
		try {
//			FileDialog diag= new FileDialog(father);
//			diag.setVisible(true);
//			m_Img1 = getToolkit().getImage(diag.getDirectory()+diag.getFile());
//			MediaTracker mt= new MediaTracker(this); 
//			mt.addImage(m_Img1,0);
			
//			JFileChooser fc = new JFileChooser("C:\\Users\\AmadouOury\\Desktop\\Hs-Bremerhaven\\3e Semester\\Algorithmen und Daten\\images");
//			//fc.addChoosableFileFilter("JPEG und GIF IMAGE","jpg","gif");	
//			fc.setMultiSelectionEnabled(true);
//			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//			int returnVal = fc.showOpenDialog(getParent());
//			Object m_ImageManager;
			//m_ImageManager.file = fc.getSelectedFiles();
			
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(new BorderLayout());
			File f = new File("C:\\Users\\AmadouOury\\Desktop\\Hs-Bremerhaven\\3e Semester\\Algorithmen und Daten\\images");
		//	String nomPhoto = (String)jComboBoxPhotos.getSelectedItem();
			BufferedImage bi = ImageIO.read(new File("C:\\Users\\AmadouOury\\Desktop\\Hs-Bremerhaven\\3e Semester\\Algorithmen und Daten\\images\\img1.jpeg" ));
			panelPhoto.setBi(bi);
			String[] images = f.list();
			jComboBoxPhotos = new JComboBox<>(images);
			JPanel jPanelN = new JPanel();
			jPanelN.setLayout(new FlowLayout());
			
			/*final Shufle SHUF = new Shufle(this);
			add(BorderLayout.SOUTH,jPanelN);*/
			
			uneImage.setBi(bi);
			uneImage.add(maCheckBox, BorderLayout.NORTH);
			
		//	add(BorderLayout.CENTER,SHUF);
			
			jPanelN.add(uneImage, BorderLayout.WEST);
			jPanelN.add(jLabelPhotos);
			jPanelN.add(jComboBoxPhotos);
		//	jPanelN.add(jButtonTraiter);
			
			 
			this.add(jPanelN, BorderLayout.SOUTH);
			this.add(panelPhoto, BorderLayout.CENTER);
			this.setBounds(10,10,800,600);
			this.setVisible(true);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		jComboBoxPhotos.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String nomPhoto = (String)jComboBoxPhotos.getSelectedItem();
					BufferedImage bi = ImageIO.read(new File("C:\\Users\\AmadouOury\\Desktop\\Hs-Bremerhaven\\3e Semester\\Algorithmen und Daten\\images\\"+nomPhoto));
					panelPhoto.setBi(bi);
					panelPhoto.repaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	} 
 
public static void main(String [] args) { 
	new Test();
	 
}
}