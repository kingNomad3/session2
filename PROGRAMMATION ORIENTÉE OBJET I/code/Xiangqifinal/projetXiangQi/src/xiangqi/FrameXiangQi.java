package xiangqi;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

public class FrameXiangQi extends JFrame {

	private JPanel contentPane;
	JPanel panelConteneur;
	JLabel labelImage, labelCouleur;
	JLabel grille[][]; //90 JLabels transparents s'apparentant aux intersections
	JPanel panelNoirs, panelRouges, panelControle;
	JButton boutonDebuter, boutonRecommencer;
	Ecouteur ec;
	Echiquier echiquier; //échiquier faisant le lien avec la logique du jeu
	private Piece pieceSelectionnee;
	private boolean jouer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameXiangQi frame = new FrameXiangQi();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *constructeur
	 */
	public FrameXiangQi() {

		echiquier = new Echiquier(); //création de l'échiquier et des 90 JLabels
		grille = new JLabel[10][9];


		setTitle("XiangQi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 789);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);



		panelConteneur= new JPanel();
		panelConteneur.setBackground(new Color(255, 228, 196));
		panelConteneur.setBounds(26, 105, 675, 653);
		panelConteneur.setLayout(new GridLayout(10, 9, 0, 0));
		panelConteneur.setOpaque(false);
		contentPane.add(panelConteneur);

		labelImage= new JLabel("");
		labelImage.setBounds(30, 115, 690, 627);
		contentPane.add(labelImage);
		labelImage.setIcon(( new ImageIcon( "fond2.png")));



		panelNoirs = new JPanel();
		panelNoirs.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		panelNoirs.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelNoirs.setBounds(772, 77, 68, 751);
		contentPane.add(panelNoirs);

		panelRouges = new JPanel();
		panelRouges.setBackground(new Color(255, 102, 102));
		panelRouges.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelRouges.setBounds(850, 77, 68, 751);
		contentPane.add(panelRouges);

		panelControle = new JPanel();
		panelControle.setBackground(new Color(255, 228, 196));
		panelControle.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelControle.setBounds(0, 11, 918, 58);
		contentPane.add(panelControle);
		panelControle.setLayout(null);

		boutonRecommencer = new JButton("Recommencer");
		boutonRecommencer.setBounds(744, 22, 152, 23);
		boutonRecommencer.setBackground(new Color(255,239,213));
		boutonRecommencer.setContentAreaFilled(false);
		boutonRecommencer.setOpaque(true);
		panelControle.add(boutonRecommencer);
		boutonRecommencer.setFont(new Font("Tahoma", Font.BOLD, 15));

		boutonDebuter = new JButton("Débuter");
		boutonDebuter.setBackground(new Color(255, 239, 213));
		boutonDebuter.setBounds(610, 22, 119, 23);
		boutonDebuter.setContentAreaFilled(false);
		boutonDebuter.setOpaque(true);
		panelControle.add(boutonDebuter);
		boutonDebuter.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelCouleur = new JLabel("");
		labelCouleur.setBackground(new Color(255, 239, 213));
		labelCouleur.setOpaque(true);
		labelCouleur.setBounds(53, 11, 475, 41);

		panelControle.add(labelCouleur);
		labelCouleur.setFont(new Font("Tahoma", Font.BOLD, 20));



		//gestion des événements
		ec = new Ecouteur();
		for ( int i = 0 ; i < 10 ; i ++ )
			for ( int j = 0 ; j < 9 ; j ++ )
			{
				grille[i][j] = new JLabel();
				grille[i][j].addMouseListener( ec );
				panelConteneur.add( grille[i][j]);
				grille[i][j].setHorizontalAlignment(SwingConstants.CENTER);
			}
		boutonDebuter.addMouseListener(ec);
		boutonRecommencer.addMouseListener(ec);




	}

	private class Ecouteur extends MouseAdapter
	{
		int ligneClic, colonneClic; // dernière ligne et dernière colonne cliquée

		Piece pieceTampon, pieceEnlevee; // pièce que je suis en train de déplacer
		ImageIcon iconeTampon; // équivalent de pieceTampon pour l'aspect graphique
		Position depart, arrivee;
		String couleurControle = "noir" ; //valeur rouge ou noir ;





		  public void reset(){
		      echiquier = new Echiquier ();
		      echiquier.debuter();
		      // rafraichir l'interface graphique
		      panelRouges.removeAll();
		      panelNoirs.removeAll();
		      for ( int i = 0; i < 10 ; i++ ) {
		          for ( int j = 0; j <9 ; j ++) {
		              grille[i][j].setIcon (null);
		          }
		      }
				//icones
				grille[0][0].setIcon(new ImageIcon ( "icones/charNoir.png"));
				grille[0][1].setIcon( new ImageIcon ( "icones/cavalierNoir.png"));
				grille[0][2].setIcon( new ImageIcon( "icones/elephantNoir.png"));
				grille[0][3].setIcon( new ImageIcon ( "icones/mandarinNoir.png"));
				grille[0][4].setIcon( new ImageIcon("icones/roiNoir.png"));
				grille[0][5].setIcon(new ImageIcon("icones/mandarinNoir.png"));
				grille[0][6].setIcon( new ImageIcon( "icones/elephantNoir.png"));
				grille[0][7].setIcon( new ImageIcon ( "icones/cavalierNoir.png"));
				grille[0][8].setIcon(new ImageIcon ( "icones/charNoir.png"));
				grille[2][1].setIcon( new ImageIcon( "icones/bombardeNoir.png"));
				grille[2][7].setIcon(new ImageIcon("icones/bombardeNoir.png"));
				grille[3][0].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][2].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][4].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][6].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][8].setIcon(new ImageIcon("icones/pionNoir.png"));

				grille[9][0].setIcon(new ImageIcon ( "icones/charRouge.png"));
				grille[9][1].setIcon( new ImageIcon ( "icones/cavalierRouge.png"));
				grille[9][2].setIcon( new ImageIcon( "icones/elephantRouge.png"));
				grille[9][3].setIcon( new ImageIcon ( "icones/mandarinRouge.png"));
				grille[9][4].setIcon( new ImageIcon("icones/roiRouge.png"));
				grille[9][5].setIcon(new ImageIcon("icones/mandarinRouge.png"));
				grille[9][6].setIcon( new ImageIcon( "icones/elephantRouge.png"));
				grille[9][7].setIcon( new ImageIcon ( "icones/cavalierRouge.png"));
				grille[9][8].setIcon(new ImageIcon ( "icones/charRouge.png"));
				grille[7][1].setIcon( new ImageIcon( "icones/bombardeRouge.png"));
				grille[7][7].setIcon(new ImageIcon("icones/bombardeRouge.png"));
				grille[6][0].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][2].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][4].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][6].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][8].setIcon(new ImageIcon("icones/pionRouge.png"));


		     repaint();
		      panelRouges.updateUI();
		      panelNoirs.updateUI();


		  }



		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub


			if ( e.getSource() == boutonDebuter)
			{
				echiquier.debuter();
				grille[0][0].setIcon(new ImageIcon ( "icones/charNoir.png"));
				grille[0][1].setIcon( new ImageIcon ( "icones/cavalierNoir.png"));
				grille[0][2].setIcon( new ImageIcon( "icones/elephantNoir.png"));
				grille[0][3].setIcon( new ImageIcon ( "icones/mandarinNoir.png"));
				grille[0][4].setIcon( new ImageIcon("icones/roiNoir.png"));
				grille[0][5].setIcon(new ImageIcon("icones/mandarinNoir.png"));
				grille[0][6].setIcon( new ImageIcon( "icones/elephantNoir.png"));
				grille[0][7].setIcon( new ImageIcon ( "icones/cavalierNoir.png"));
				grille[0][8].setIcon(new ImageIcon ( "icones/charNoir.png"));
				grille[2][1].setIcon( new ImageIcon( "icones/bombardeNoir.png"));
				grille[2][7].setIcon(new ImageIcon("icones/bombardeNoir.png"));
				grille[3][0].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][2].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][4].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][6].setIcon(new ImageIcon("icones/pionNoir.png"));
				grille[3][8].setIcon(new ImageIcon("icones/pionNoir.png"));

				grille[9][0].setIcon(new ImageIcon ( "icones/charRouge.png"));
				grille[9][1].setIcon( new ImageIcon ( "icones/cavalierRouge.png"));
				grille[9][2].setIcon( new ImageIcon( "icones/elephantRouge.png"));
				grille[9][3].setIcon( new ImageIcon ( "icones/mandarinRouge.png"));
				grille[9][4].setIcon( new ImageIcon("icones/roiRouge.png"));
				grille[9][5].setIcon(new ImageIcon("icones/mandarinRouge.png"));
				grille[9][6].setIcon( new ImageIcon( "icones/elephantRouge.png"));
				grille[9][7].setIcon( new ImageIcon ( "icones/cavalierRouge.png"));
				grille[9][8].setIcon(new ImageIcon ( "icones/charRouge.png"));
				grille[7][1].setIcon( new ImageIcon( "icones/bombardeRouge.png"));
				grille[7][7].setIcon(new ImageIcon("icones/bombardeRouge.png"));
				grille[6][0].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][2].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][4].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][6].setIcon(new ImageIcon("icones/pionRouge.png"));
				grille[6][8].setIcon(new ImageIcon("icones/pionRouge.png"));

				labelCouleur.setText("C'est aux " + "noir" + "s à jouer");
			}
			else if ( e.getSource() == boutonRecommencer)
			{
				reset();
				labelCouleur.setText("C'est aux " + "noir" + "s à jouer");
			}
			else // il s'agit d'un label / intersection
			{
			    //trouver lequel
			    for ( int i = 0; i < 10 ; i++ )
			      {
			      for ( int j = 0; j<9; j++ )
			        {
			        if (e.getSource() == grille[i][j])
			          {
			          ligneClic = i;
			          colonneClic = j;
			          }
			        }
			      }


				// 1er cas : clique sur une case occupee , tampon vide : cas Depart
																				//la couleur dans estOccupe()
				if (echiquier.getIntersection(ligneClic, colonneClic).estOccupee() && pieceTampon == null) {
					depart = new Position(ligneClic, colonneClic);
					pieceTampon = echiquier.getIntersection(ligneClic, colonneClic).getPiece();
					iconeTampon = (ImageIcon) grille[ligneClic][colonneClic].getIcon();
					grille[ligneClic][colonneClic].setIcon(null);

				}

				// 2ème cas : clique sur une case vide, tampon plein : cas d'arrivée
				else if (!echiquier.getIntersection(ligneClic, colonneClic).estOccupee() && pieceTampon != null) {
					arrivee = new Position(ligneClic, colonneClic);

					// Vérifier si le déplacement est valide
					if (pieceTampon.estValide(depart, arrivee)) {
						// Vérifier si la case d'arrivée est vide ou s'il y a une pièce à capturer
						if (!echiquier.getIntersection(ligneClic, colonneClic).estOccupee() ||
								echiquier.getIntersection(ligneClic, colonneClic).getPiece().getCouleur().equals("noir")) {

							// Vérifier si la case d'arrivée est la même que la case de départ
							if (ligneClic == depart.getLigne() && colonneClic == depart.getColonne()) {
								// Mettre à jour la position de départ avec la nouvelle position
								depart.setLigne(ligneClic);
								depart.setColonne(colonneClic);

								// Déplacer la pièce vers la nouvelle position
								echiquier.cheminPossible(depart, arrivee);

								// Mettre à jour l'interface graphique
								grille[depart.getLigne()][depart.getColonne()].setIcon(null); // Effacer l'icône de la cellule précédente
								grille[ligneClic][colonneClic].setIcon(iconeTampon); // Définir l'icône sur la nouvelle cellule

								// Mettre à jour la position de la pièce
								echiquier.getIntersection(depart.getLigne(), depart.getColonne()).setPiece(null);
								echiquier.getIntersection(arrivee.getLigne(), arrivee.getColonne()).setPiece(pieceTampon);

								// Réinitialiser les variables temporaires
								iconeTampon = null;


								// Mettre à jour la couleur de contrôle
								String couleurTampon = pieceTampon.getCouleur();
								if (couleurTampon.equals("noir")) {
									couleurControle = "rouge";
								} else {
									couleurControle = "noir";
								}

								labelCouleur.setText("C'est aux " + couleurControle + "s à jouer");

								// Réinitialiser la pièce tampon
								pieceTampon = null;

								return;
							}

							// Mettre à jour la position de départ avec la nouvelle position
							depart.setLigne(ligneClic);
							depart.setColonne(colonneClic);

							// Déplacer la pièce vers la nouvelle position
							echiquier.cheminPossible(depart, arrivee);

							// Mettre à jour l'interface graphique
							grille[depart.getLigne()][depart.getColonne()].setIcon(null); // Effacer l'icône de la cellule précédente
							grille[ligneClic][colonneClic].setIcon(iconeTampon); // Définir l'icône sur la nouvelle cellule

							// Mettre à jour la position de la pièce
							echiquier.getIntersection(depart.getLigne(), depart.getColonne()).setPiece(null);
							echiquier.getIntersection(arrivee.getLigne(), arrivee.getColonne()).setPiece(pieceTampon);

							// Réinitialiser les variables temporaires
							iconeTampon = null;

							// Mettre à jour la couleur de contrôle
							String couleurTampon = pieceTampon.getCouleur();
							if (couleurTampon.equals("noir")) {
								couleurControle = "rouge";
							} else {
								couleurControle = "noir";
							}

							labelCouleur.setText("C'est aux " + couleurControle + "s à jouer");

							// Réinitialiser la pièce tampon
							pieceTampon = null;

						}
					}
				}


				// 3ème cas : clique sur une case occupée et tampon plein : cas d'arrivée / capture
				else if (echiquier.getIntersection(ligneClic, colonneClic).estOccupee() && pieceTampon != null) {
					arrivee = new Position(ligneClic, colonneClic);

					// Vérifier si le déplacement est valide
					if (pieceTampon.estValide(depart, arrivee)) {
						// Vérifier si la case d'arrivée contient une pièce à capturer
						if (echiquier.getIntersection(ligneClic, colonneClic).getPiece().getCouleur() != pieceTampon.getCouleur()) {
							// Déplacer la pièce vers la nouvelle position
							echiquier.cheminPossible(depart, arrivee);
							pieceTampon = null;

							// Récupérer l'icône de la pièce capturée
							Icon iconeCapture = grille[depart.getLigne()][depart.getColonne()].getIcon();

							// Mettre à jour l'interface graphique
							grille[ligneClic][colonneClic].setIcon(iconeTampon); // Définir l'icône sur la nouvelle cellule
							grille[depart.getLigne()][depart.getColonne()].setIcon(iconeCapture); // Effacer l'icône de la cellule précédente

							// Supprimer la pièce capturée de l'échiquier
							Intersection captureIntersection = echiquier.getIntersection(depart.getLigne(), depart.getColonne());
							captureIntersection.setPiece(null);

							// Mettre à jour les variables temporaires
							Position capturePosition = new Position(depart.getLigne(), depart.getColonne());
							Piece pieceCapturee = captureIntersection.getPiece();
							String couleurPieceCapturee = pieceCapturee.getCouleur();
							int rowN = 0;
							int rowR = 0;

							// Ajouter la pièce capturée au panel correspondant
							if (couleurPieceCapturee.equals("noir")) {
								JLabel labelCapture = new JLabel(iconeCapture);
								panelNoirs.setLayout(new GridLayout(rowN, 0));
								panelNoirs.add(labelCapture);
								panelNoirs.revalidate();
								rowN++;
							} else if (couleurPieceCapturee.equals("rouge")) {
								JLabel labelCapture = new JLabel(iconeCapture);
								panelRouges.setLayout(new GridLayout(rowR, 0));
								panelRouges.add(labelCapture);
								panelRouges.revalidate();
								rowR++;
							}

							// Mettre à jour la couleur de contrôle
							String couleurTampon = pieceCapturee.getCouleur();
							if (couleurTampon.equals("noir")) {
								couleurControle = "rouge";
							} else {
								couleurControle = "noir";
							}

							labelCouleur.setText("C'est aux " + couleurControle + "s à jouer");
						} else {
							// Déplacement invalide, réinitialiser les variables temporaires et afficher un message d'erreur si nécessaire
							depart = null;
							pieceTampon = null;
							iconeTampon = null;

						}


					}
				}




			}
	}



}
	}

			     
			            
			       
			            



			
		
		
	

