import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class ClaseDeAdrese 
{

	private JFrame clasa;
	private JTextField txtAdresaip;
	private JTextField textFieldIpBinar;
	private JTextField textFieldPRetea;
	private JTextField textFieldPGazda;
	private JTextField textFieldClasa;
	private JTextField textFieldTip;
	private JTextField textFieldRetea;
	private JTextField textFieldBroadcast;
	private JTextField textFieldNrMaxGazde;
	private JTextField textFieldNrBitiGazda;
	private JTextField textFieldGazda2014Zec;
	private JTextField textFieldGazda2014Bin;
	private JTextField textFieldAdrRetZec;
	private JTextField textFieldMascaZec;
	private JTextField textFieldAdrRetBin;
	private JTextField textFieldMascaBin;
	private JTextField textFieldNrminBiti17Sub;
	private JTextField textFieldNrMaxBiti31G;
	private JTextField textFieldAdrUltSubRZec;
	private JTextField textFieldAdrUltSubRBin;
	private JTextField textFieldBroadSubZec;
	private JTextField textFieldBroadSubBin;
	private JTextField textFieldGazda19Zec;
	private JTextField textFieldGazda19Bin;
	ClasaA c=new ClasaA();
	IpAdress ipAdress=new IpAdress();
	private JPanel panel3;
	private JPanel panel2;
	private JLabel label_1;
	private JTextField textFieldNrSubreteleIntr;
	private JTextField textFieldNrgazdeSub;
	private JButton btnGenerate;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try 
				{
					
					ClaseDeAdrese  window = new ClaseDeAdrese ();
					window.clasa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClaseDeAdrese() 
	{
		clasa = new JFrame();
		clasa.setForeground(Color.BLACK);
		clasa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		clasa.setTitle("Detectare");
		clasa.setBounds(100, 0, 1024, 768);
		clasa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clasa.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel panel1 = new JPanel();
		clasa.getContentPane().add(panel1, "name_9812363596888");
		panel1.setLayout(null);
		panel1.setVisible(true);
		
		panel2 = new JPanel();
		clasa.getContentPane().add(panel2, "name_8257845336977");
		panel2.setLayout(null);
		panel2.setVisible(false);
		
		panel3 = new JPanel();
		clasa.getContentPane().add(panel3, "name_8294251279418");
		panel3.setLayout(null);
		panel3.setVisible(false);
		
		JLabel lblAdresaIp = new JLabel("Adresa IP");
		lblAdresaIp.setForeground(Color.BLACK);
		lblAdresaIp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblAdresaIp.setBounds(236, 138, 197, 34);
		panel1.add(lblAdresaIp);
		
		txtAdresaip = new JTextField();
		txtAdresaip.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtAdresaip.setBounds(145, 196, 341, 34);
		panel1.add(txtAdresaip);
		txtAdresaip.setColumns(10);
		
		JLabel lblAdresaipBinar = new JLabel("AdresaIp Binar");
		lblAdresaipBinar.setForeground(Color.BLACK);
		lblAdresaipBinar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAdresaipBinar.setBounds(548, 174, 222, 29);
		panel2.add(lblAdresaipBinar);
		
		JLabel lblAdresaipDeRetea = new JLabel("AdresaIp de retea ");
		lblAdresaipDeRetea.setForeground(Color.BLACK);
		lblAdresaipDeRetea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAdresaipDeRetea.setBounds(438, 131, 190, 26);
		panel3.add(lblAdresaipDeRetea);
		
		textFieldIpBinar = new JTextField();
		textFieldIpBinar.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldIpBinar.setBounds(436, 198, 395, 29);
		panel2.add(textFieldIpBinar);
		textFieldIpBinar.setColumns(10);
		
		JLabel lblParteRetea = new JLabel("Parte Retea");
		lblParteRetea.setForeground(Color.BLACK);
		lblParteRetea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblParteRetea.setBounds(407, 238, 160, 29);
		panel2.add(lblParteRetea);
		
		JLabel lblParteGazda = new JLabel("Parte gazda");
		lblParteGazda.setForeground(Color.BLACK);
		lblParteGazda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblParteGazda.setBounds(748, 238, 160, 29);
		panel2.add(lblParteGazda);
		
		textFieldPRetea = new JTextField();
		textFieldPRetea.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldPRetea.setBounds(334, 259, 284, 34);
		panel2.add(textFieldPRetea);
		textFieldPRetea.setColumns(10);
		
		textFieldPGazda = new JTextField();
		textFieldPGazda.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldPGazda.setBounds(657, 259, 305, 34);
		panel2.add(textFieldPGazda);
		textFieldPGazda.setColumns(10);
		
		JLabel lblClasa = new JLabel("Clasa");
		lblClasa.setForeground(Color.BLACK);
		lblClasa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblClasa.setBounds(577, 21, 93, 29);
		panel2.add(lblClasa);
		
		JLabel lblTip = new JLabel("Tipul");
		lblTip.setForeground(Color.BLACK);
		lblTip.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblTip.setBounds(577, 99, 74, 29);
		panel2.add(lblTip);
		
		textFieldClasa = new JTextField();
		textFieldClasa.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldClasa.setBounds(525, 44, 186, 29);
		panel2.add(textFieldClasa);
		textFieldClasa.setColumns(10);
		
		textFieldTip = new JTextField();
		textFieldTip.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldTip.setBounds(525, 124, 186, 29);
		panel2.add(textFieldTip);
		textFieldTip.setColumns(10);
		
		JLabel lblRetea = new JLabel("Retea");
		lblRetea.setForeground(Color.BLACK);
		lblRetea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblRetea.setBounds(513, 304, 124, 34);
		panel2.add(lblRetea);
		
		textFieldRetea = new JTextField();
		textFieldRetea.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldRetea.setBounds(334, 331, 198, 34);
		panel2.add(textFieldRetea);
		textFieldRetea.setColumns(10);
		
		JLabel lblBroadcast = new JLabel("Broadcast");
		lblBroadcast.setForeground(Color.BLACK);
		lblBroadcast.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblBroadcast.setBounds(513, 382, 151, 34);
		panel2.add(lblBroadcast);
		
		textFieldBroadcast = new JTextField();
		textFieldBroadcast.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldBroadcast.setBounds(334, 408, 198, 31);
		panel2.add(textFieldBroadcast);
		textFieldBroadcast.setColumns(10);
		
		JLabel lblNumarMaximGazde = new JLabel("Numar maxim gazde");
		lblNumarMaximGazde.setForeground(Color.BLACK);
		lblNumarMaximGazde.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNumarMaximGazde.setBounds(559, 519, 198, 27);
		panel2.add(lblNumarMaximGazde);
		
		textFieldNrMaxGazde = new JTextField();
		textFieldNrMaxGazde.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNrMaxGazde.setBounds(531, 541, 212, 31);
		panel2.add(textFieldNrMaxGazde);
		textFieldNrMaxGazde.setColumns(10);
		
		textFieldNrBitiGazda = new JTextField();
		textFieldNrBitiGazda.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNrBitiGazda.setBounds(531, 477, 216, 31);
		panel2.add(textFieldNrBitiGazda);
		textFieldNrBitiGazda.setColumns(10);
		
		JLabel lblNumarBitiGazda = new JLabel("Numar biti gazda");
		lblNumarBitiGazda.setForeground(Color.BLACK);
		lblNumarBitiGazda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNumarBitiGazda.setBounds(559, 450, 205, 27);
		panel2.add(lblNumarBitiGazda);
		
		JLabel lblGazda = new JLabel("Gazda 2014");
		lblGazda.setForeground(Color.BLACK);
		lblGazda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblGazda.setBounds(577, 583, 162, 31);
		panel2.add(lblGazda);
		
		textFieldGazda2014Zec = new JTextField();
		textFieldGazda2014Zec.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGazda2014Zec.setBounds(436, 612, 182, 27);
		panel2.add(textFieldGazda2014Zec);
		textFieldGazda2014Zec.setColumns(10);
		
		textFieldGazda2014Bin = new JTextField();
		textFieldGazda2014Bin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGazda2014Bin.setBounds(628, 610, 370, 31);
		panel2.add(textFieldGazda2014Bin);
		textFieldGazda2014Bin.setColumns(10);
		
		textFieldAdrRetZec = new JTextField();
		textFieldAdrRetZec.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAdrRetZec.setBounds(318, 164, 160, 26);
		panel3.add(textFieldAdrRetZec);
		textFieldAdrRetZec.setColumns(10);
		
		JLabel lblMascaRetea = new JLabel("Masca retea");
		lblMascaRetea.setForeground(Color.BLACK);
		lblMascaRetea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblMascaRetea.setBounds(438, 186, 190, 26);
		panel3.add(lblMascaRetea);
		
		textFieldMascaZec = new JTextField();
		textFieldMascaZec.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldMascaZec.setBounds(318, 211, 160, 26);
		panel3.add(textFieldMascaZec);
		textFieldMascaZec.setColumns(10);
		
		textFieldAdrRetBin = new JTextField();
		textFieldAdrRetBin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAdrRetBin.setBounds(491, 164, 447, 26);
		panel3.add(textFieldAdrRetBin);
		textFieldAdrRetBin.setColumns(10);
		
		textFieldMascaBin = new JTextField();
		textFieldMascaBin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldMascaBin.setBounds(488, 211, 450, 26);
		panel3.add(textFieldMascaBin);
		textFieldMascaBin.setColumns(10);
		
		JLabel lblNumarMinimBiti = new JLabel("Numar minim biti cu care trebuie sa se imprumute pentru a forma m subretele");
		lblNumarMinimBiti.setForeground(Color.BLACK);
		lblNumarMinimBiti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNumarMinimBiti.setBounds(318, 291, 679, 26);
		panel3.add(lblNumarMinimBiti);
		
		textFieldNrminBiti17Sub = new JTextField();
		textFieldNrminBiti17Sub.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNrminBiti17Sub.setBounds(318, 317, 160, 33);
		panel3.add(textFieldNrminBiti17Sub);
		textFieldNrminBiti17Sub.setColumns(10);
		
		JLabel lblNumarMaximBiti = new JLabel("Numar maxim biti cu care trebuie sa se imprumute pentru a se poate pune  p  gazde");
		lblNumarMaximBiti.setForeground(Color.BLACK);
		lblNumarMaximBiti.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNumarMaximBiti.setBounds(318, 387, 680, 26);
		panel3.add(lblNumarMaximBiti);
		
		textFieldNrMaxBiti31G = new JTextField();
		textFieldNrMaxBiti31G.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNrMaxBiti31G.setBounds(318, 410, 160, 33);
		panel3.add(textFieldNrMaxBiti31G);
		textFieldNrMaxBiti31G.setColumns(10);
		
		JLabel lblAdresaIpA = new JLabel("Adresa IP a ultimei subretele");
		lblAdresaIpA.setForeground(Color.BLACK);
		lblAdresaIpA.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAdresaIpA.setBounds(318, 541, 294, 33);
		panel3.add(lblAdresaIpA);
		
		textFieldAdrUltSubRZec = new JTextField();
		textFieldAdrUltSubRZec.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAdrUltSubRZec.setBounds(318, 568, 160, 26);
		panel3.add(textFieldAdrUltSubRZec);
		textFieldAdrUltSubRZec.setColumns(10);
		
		textFieldAdrUltSubRBin = new JTextField();
		textFieldAdrUltSubRBin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldAdrUltSubRBin.setBounds(491, 568, 447, 26);
		panel3.add(textFieldAdrUltSubRBin);
		textFieldAdrUltSubRBin.setColumns(10);
		
		JLabel lblBroadcastSubretea = new JLabel("Broadcast subretea");
		lblBroadcastSubretea.setForeground(Color.BLACK);
		lblBroadcastSubretea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblBroadcastSubretea.setBounds(318, 605, 246, 26);
		panel3.add(lblBroadcastSubretea);
		
		textFieldBroadSubZec = new JTextField();
		textFieldBroadSubZec.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldBroadSubZec.setBounds(318, 627, 160, 26);
		panel3.add(textFieldBroadSubZec);
		textFieldBroadSubZec.setColumns(10);
		
		textFieldBroadSubBin = new JTextField();
		textFieldBroadSubBin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldBroadSubBin.setBounds(491, 627, 447, 26);
		panel3.add(textFieldBroadSubBin);
		textFieldBroadSubBin.setColumns(10);
		
		JLabel lblAdresaCeleiDe = new JLabel("Adresa celei de a 19-a gazde din ultima subretea ");
		lblAdresaCeleiDe.setForeground(Color.BLACK);
		lblAdresaCeleiDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAdresaCeleiDe.setBounds(318, 664, 419, 26);
		panel3.add(lblAdresaCeleiDe);
		
		textFieldGazda19Zec = new JTextField();
		textFieldGazda19Zec.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGazda19Zec.setBounds(318, 689, 160, 26);
		panel3.add(textFieldGazda19Zec);
		textFieldGazda19Zec.setColumns(10);
		
		textFieldGazda19Bin = new JTextField();
		textFieldGazda19Bin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldGazda19Bin.setBounds(491, 689, 447, 26);
		panel3.add(textFieldGazda19Bin);
		textFieldGazda19Bin.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				panel3.setVisible(false);
				panel2.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(38, 680, 137, 39);
		panel3.add(btnNewButton);
		
		JLabel lblIntroducetiNumarulDe = new JLabel("Introduceti m = numarul de  subretele : ");
		lblIntroducetiNumarulDe.setForeground(Color.BLACK);
		lblIntroducetiNumarulDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIntroducetiNumarulDe.setBounds(318, 263, 329, 31);
		panel3.add(lblIntroducetiNumarulDe);
		
		textFieldNrSubreteleIntr = new JTextField();
		textFieldNrSubreteleIntr.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNrSubreteleIntr.setBounds(657, 263, 147, 31);
		panel3.add(textFieldNrSubreteleIntr);
		textFieldNrSubreteleIntr.setColumns(10);
		
		JLabel lblIntroducetiPnumarulDe = new JLabel("Introduceti p=numarul de gazde: ");
		lblIntroducetiPnumarulDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIntroducetiPnumarulDe.setForeground(Color.BLACK);
		lblIntroducetiPnumarulDe.setBounds(318, 361, 310, 26);
		panel3.add(lblIntroducetiPnumarulDe);
		
		textFieldNrgazdeSub = new JTextField();
		textFieldNrgazdeSub.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNrgazdeSub.setBounds(657, 358, 147, 33);
		panel3.add(textFieldNrgazdeSub);
		textFieldNrgazdeSub.setColumns(10);
		
		btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String nrSubretele=textFieldNrSubreteleIntr.getText();
				String nrGazde=textFieldNrgazdeSub.getText();
				if(nrSubretele.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Introduceti numarul de subretele");
				}
				else if(nrGazde.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Introduceti numarul de gazde");
				}
				else
				{
					if(isNumber(nrSubretele))
					{
						int nrsub=Integer.parseInt(nrSubretele);
						if(c.numarMaximBitiImprumutati(ipAdress,nrsub)!=0)
							textFieldNrminBiti17Sub.setText(c.numarMaximBitiImprumutati(ipAdress,nrsub)+"");
						else
							textFieldNrminBiti17Sub.setText("Nu se pot imprumuta biti");
						if(isNumber(nrGazde))
						{
							int nrgaz=Integer.parseInt(nrGazde);
							if(c.numarMinimBitiImprumutatiGazde(ipAdress,nrgaz,nrsub)!=0)
								textFieldNrMaxBiti31G.setText("k="+c.numarMinimBitiImprumutatiGazde(ipAdress,nrgaz,nrsub));
							else
								textFieldNrMaxBiti31G.setText("Nu se pot imprumuta biti");
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Reintroduceti numarul de gazde");
						}
						String s=c.adresaUltimeiSubretele(ipAdress, c.numarMaximBitiImprumutati(ipAdress,nrsub));
						String s1=c.binarytoDecimal(s);
						String s2=c.adresaPrimeiSubretele(ipAdress, c.numarMaximBitiImprumutati(ipAdress,nrsub));
						String s3=c.adresaBroadcastUltimeiSubretele(ipAdress, c.numarMaximBitiImprumutati(ipAdress,nrsub));
						String s4=c.ultDom(s3);
						String s5=c.prDom(s);
						textFieldAdrUltSubRBin.setText(s);
						textFieldAdrUltSubRZec.setText(s1);
						textField_1.setText(c.binarytoDecimal(s4));
						textField_3.setText(s4);
						textField.setText(c.binarytoDecimal(s5));
						textField_2.setText(s5);
						textFieldBroadSubBin.setText(s3);
						textFieldBroadSubZec.setText(c.binarytoDecimal(s3));
						textFieldGazda19Zec.setText(ipAdress.getGazda19UltSubretea().get(0));
						textFieldGazda19Bin.setText(ipAdress.getGazda19UltSubretea().get(1));
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Reintroduceti numarul de subretele");
					}
				}
				
			}
		});
		btnGenerate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGenerate.setForeground(Color.BLACK);
		btnGenerate.setBounds(814, 424, 147, 44);
		panel3.add(btnGenerate);
		
		JLabel lblDomeniulAdreselorGazdelor = new JLabel("Domeniul adreselor gazdelor");
		lblDomeniulAdreselorGazdelor.setForeground(Color.BLACK);
		lblDomeniulAdreselorGazdelor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblDomeniulAdreselorGazdelor.setBounds(318, 454, 450, 26);
		panel3.add(lblDomeniulAdreselorGazdelor);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(318, 479, 160, 26);
		panel3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBounds(318, 510, 160, 26);
		panel3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setBounds(491, 479, 447, 26);
		panel3.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setBounds(491, 510, 447, 26);
		panel3.add(textField_3);
		textField_3.setColumns(10);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\animation java\\retele\\Untitled-3.png"));
		label_1.setBounds(0, 0, 1008, 730);
		panel3.add(label_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_5.setBounds(559, 331, 421, 34);
		panel2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_4.setBounds(559, 408, 421, 31);
		panel2.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnOk = new JButton("Next");
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				List<Integer> s=new ArrayList<>();
				String ip=txtAdresaip.getText();
				if (c.isIPv4Address(ip)==false)
				{
					JOptionPane.showMessageDialog(null, "Reintroduceti adresa IP");
				}
				else
				{
					s=c.adrIp(ip);
					ipAdress.setIp(s);
					c.setIpBinar1(ipAdress);
					c.determinClass(ipAdress);
					c.setGazda2014(ipAdress);
					c.setMascaReteaSiAdresaRetelei(ipAdress);
					
					textFieldClasa.setText(ipAdress.getClasaTip().get(0));
					textFieldTip.setText(ipAdress.getClasaTip().get(1));
					textFieldIpBinar.setText(ipAdress.getIpBinar().get(0)+"."+ipAdress.getIpBinar().get(1)+"."+ipAdress.getIpBinar().get(2)+"."+ipAdress.getIpBinar().get(3));
					textFieldPRetea.setText(ipAdress.getReteaGazda().get(0));
					textFieldPGazda.setText(ipAdress.getReteaGazda().get(1));
					textFieldRetea.setText(ipAdress.getReteaBroadcast().get(0));
					textField_5.setText(ipAdress.getReteaBroadcast().get(1));
					textFieldBroadcast.setText(ipAdress.getReteaBroadcast().get(2));
					textField_4.setText(ipAdress.getReteaBroadcast().get(3));
					textFieldNrMaxGazde.setText(ipAdress.getNrMaximGazde()+"");
					textFieldNrBitiGazda.setText(ipAdress.getNrBitiGazda()+"");
					textFieldGazda2014Zec.setText(ipAdress.getGazda2014().get(0));
					textFieldGazda2014Bin.setText(ipAdress.getGazda2014().get(1));
					
					panel1.setVisible(false);
					panel2.setVisible(true);
				}
			}
		});
		btnOk.setBounds(236, 274, 141, 40);
		panel1.add(btnOk);
		
		JLabel labelBackground1 = new JLabel("");
		labelBackground1.setIcon(new ImageIcon("D:\\animation java\\retele\\Untitled-1.png"));
		labelBackground1.setBounds(0, 0, 1008, 730);
		panel1.add(labelBackground1);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panel2.setVisible(false);
				panel3.setVisible(true);
				textFieldAdrRetZec.setText(ipAdress.getAdresaRetelei().get(4));
				textFieldAdrRetBin.setText(ipAdress.getAdresaRetelei().get(0)+"."+ipAdress.getAdresaRetelei().get(1)+"."+ipAdress.getAdresaRetelei().get(2)+"."+ipAdress.getAdresaRetelei().get(3));
				textFieldMascaZec.setText(ipAdress.getMascaRetea().get(4));
				textFieldMascaBin.setText(ipAdress.getMascaRetea().get(0)+"."+ipAdress.getMascaRetea().get(1)+"."+ipAdress.getMascaRetea().get(2)+"."+ipAdress.getMascaRetea().get(3));
			}
		});
		btnNext.setForeground(Color.BLACK);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNext.setBounds(835, 670, 163, 49);
		panel2.add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panel1.setVisible(true);
				panel2.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBack.setBounds(53, 673, 160, 42);
		panel2.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\animation java\\retele\\Untitled-2.png"));
		label.setBounds(0, 0, 1008, 730);
		panel2.add(label);
	}
	
	public boolean isNumber(String s)
	{
		char[] chars = s.toCharArray();
		if(chars[0]=='0')
		{
			return false;
		}
		 for (char c : chars) 
		 {
			    if(!Character.isDigit(c)) 
		        {
		            return false;
		        }
		 }
		 return true;
	}
}

