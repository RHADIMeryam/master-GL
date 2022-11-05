
import java.awt.GridLayout;

import javax.swing.JPanel;


public class Plateau extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;
        public int nb;
	private static final int TAILLE=12;
        private Corsaire corsaire;
	private Case caseActive;
        private Case piratecase; 
        private Case flibcase; 
        public boolean partiegagne = true;
         private States state;
         private int nbm=0;
         private int nba=0;
         private int flib=0;
         private int triso=0;
         private int pelle=0;
         private int mosqu=0;
         private int arm=0;
              

	private boolean tourNoir=true;
        // creation du plateau 
	public Plateau(int taille){
		tourNoir=!false;
		setLayout(new GridLayout(TAILLE, TAILLE));
		for(int i=0; i<TAILLE; i++){
			for(int j=0; j<TAILLE; j++){
					ajouterCase(Couleur.NOIR);	
			}
		}
               ;
		init();
                
	}
        
	private void ajouterCase(Couleur couleur){
		Case case1 = new Case(couleur);
		case1.addMouseListener(new ListenerCase(case1, this));
		add(case1);
	}

	private Corsaire creerCorsaire(Couleur couleur){
	        corsaire = new Corsaire(couleur);
		corsaire.addMouseListener(new ListenerCorsaire(corsaire, this));
		return corsaire;
	}
        	private Boucanier creerPirate(Couleur couleur){
		Boucanier boucanier = new Boucanier(couleur);
		return boucanier;
	}
                private Pirate creerPirate(Couleur couleur,String s){
		Pirate boucanier = new Pirate(couleur,s);
		return boucanier;
	}
                private Flibustier creerFlibustier(Couleur couleur){
		Flibustier flibustier = new Flibustier(couleur);
		return flibustier;
                }
	

	private void init(){
                        
                        boolean tt=true;
                        
			getCase(72).add(creerCorsaire(Couleur.NOIR));
                        
                       
                         while(tt)
                        {
                            pelle= (int) (Math.random() * TAILLE*TAILLE);
                            this.nb = (int) (Math.random() * TAILLE*TAILLE);
                            this.flib = (int) (Math.random() * TAILLE*TAILLE);
                            triso = (int) (Math.random() * TAILLE*TAILLE);
                            arm=(int) (Math.random() * TAILLE*TAILLE);
                            mosqu= (int) (Math.random() * TAILLE*TAILLE);
                            if(nb!=72  && pelle!=72 && triso !=72 && arm!=72 && mosqu!=72 && this.flib!=72)
                            {
                            tt=false;
                            }        
                        }
                        
                        getCase(nb).add(creerPirate(Couleur.VERT));
                        getCase(nb).getComponent(0).setVisible(true);
                        getCase(flib).add(creerFlibustier(Couleur.VERT));
			piratecase = getCase(nb);
                        flibcase = getCase(flib);
                        getCase(pelle).setPelle(true);
                        getCase(pelle).add(creerPirate(Couleur.VERT,"spade.png"));
                        getCase(arm).setArmure(true);
                        getCase(arm).add(creerPirate(Couleur.VERT,"armure.png"));
                        getCase(mosqu).setMousquet(true);
                         getCase(mosqu).add(creerPirate(Couleur.VERT,"arme.png"));
                        getCase(triso).setTrisor(true);
                        getCase(triso).add(creerPirate(Couleur.VERT,"treasure.png"));
                       
                        
                         state = new States();
                         state.setPointsdevie(String.valueOf(corsaire.getVie()));
                         state.setVisible(true);
                         state.setAyantpelle("NON");
                         state.setArmure("0");
                         state.setMosquet("0");
                         state.setNom("Joueur 1");
	
	}

	public Case getCase(int i, int j){
		return (Case) getComponent(j+i*TAILLE);
	}

	public Case getCase(int i){
		return (Case) getComponent(i);
	}

	public void afficherPossibilites(Corsaire p){
		if((p.getCouleur().equals(Couleur.NOIR) && tourNoir)){
			int i=0;
			int j=0;
			for(int k=0; k<TAILLE*TAILLE; k++){
				getCase(k).setSelectionnee(false);
				if(getCase(k).getComponentCount()!=0 && getCase(k).getComponent(0).equals(p)){
					caseActive=getCase(k);
					i=k/TAILLE;
					j=k%TAILLE;

				}
                                
                                
			}
			selectionnerCases(i, j, p.getCouleur());
		}
	}

	public void selectionnerCases(int i, int j, Couleur couleur){
                
		//Corsaire corsaire = (Corsaire)(getCase(i, j).getComponent(0));               
			if(i-1>=0 && j-1>=0 ){
				getCase(i-1, j-1).setSelectionnee(true);
			}
                        if(i+1<12 && j+1<12 ){
                                getCase(i+1, j+1).setSelectionnee(true);
                        }
                        if(i+1<12 && j-1>=0 ){
                                getCase(i+1, j-1).setSelectionnee(true);
                        }
                        if(i-1>=0 && j+1<12 ){
                                getCase(i-1, j+1).setSelectionnee(true);
                        }
                        if(i-1>=0 ){
                                getCase(i-1, j).setSelectionnee(true);
                        }
                        if(i+1<12 ){
                                getCase(i+1, j).setSelectionnee(true);
                        }
                        if(j+1<12 ){
                                getCase(i,j+1).setSelectionnee(true);
                        }
                        if(j-1>=0 ){
                                getCase(i, j-1).setSelectionnee(true);
                        }
                
              
            
            
        }

	public void deplacer(Case case1){
                int a;
                int b;
                
                 /*    
                     
                            //  getCase(triso).removeAll();
                              // getCase(triso).
                              //getCase(triso).repaint();
                           case1.add(caseActive.getComponent(1));
                              for(int k=0; k<TAILLE*TAILLE; k++){
                                getCase(k).setSelectionnee(false);
                                   }
                             
                            getCase(triso).remove(1);
                             getCase(triso).repaint();                      
                            case1.repaint();
                 */
                            
                       
                        
                        if(getCase(triso).getComponentCount() == 0)
                        {
                            getCase(triso).add(creerPirate(Couleur.VERT,"treasure.png"));
                            getCase(triso).getComponent(0).setVisible(true);
                            getCase(triso).repaint();
                            System.out.println("hhhh");
                        }
                       
                        if(case1 == getCase(triso))
                        {
                            getCase(triso).removeAll();
                       
                           case1.add(caseActive.getComponent(0));
                              for(int k=0; k<TAILLE*TAILLE; k++){
                                getCase(k).setSelectionnee(false);
                                   }
                            
                             caseActive.removeAll();
                             caseActive.repaint();
                            caseActive=null;
                            case1.repaint();
                           
                           }
                        else
                        {
                        case1.add(caseActive.getComponent(0));
                              for(int k=0; k<TAILLE*TAILLE; k++){
                                getCase(k).setSelectionnee(false);
                                   }
                            
                             caseActive.removeAll();
                             caseActive.repaint();
                            caseActive=null;
                            case1.repaint();
                        
                        }
                       
                       
                       
                if(piratecase.getComponentCount()!=0)
                {
                if(case1 !=piratecase && case1 != flibcase){
                b = Flibustier.seDeplacer(getLigne(flibcase),getColonne(flibcase));
                a=Boucanier.seDeplacer(getLigne(piratecase),getColonne(piratecase));
                if( piratecase != null && flibcase != null)
                {
             while(a==b || this.pelle==a || b==this.pelle|| a==this.triso || b==this.triso || a == this.mosqu || b==this.mosqu || a== this.arm || b==this.arm )
                {
                   b = Flibustier.seDeplacer(getLigne(flibcase),getColonne(flibcase));
                   a=Boucanier.seDeplacer(getLigne(piratecase),getColonne(piratecase));   
                }}
                 if(piratecase != null)
                 {
                getCase(a).add(piratecase.getComponent(0));
                piratecase.removeAll();
                piratecase.repaint();
                piratecase=getCase(a);
                getCase(a).repaint();
                 }
                 if(flibcase != null)
                 {
                getCase(b).add(flibcase.getComponent(0));
                flibcase.removeAll();
                flibcase.repaint();
                flibcase=getCase(b);
                getCase(b).repaint();
                 }
                }
                
                else
                {
                      
                    if(corsaire.isAyantMosquet() ==0 && corsaire.getAyantArmure() ==0 )
                    {
                    case1.remove(1);
                    case1.repaint();
                    FinPartie fin = new FinPartie("VOUS AVEZ PERDU");
                    fin.setVisible((true));
                    partiegagne = false;
              
                    }
                    else
                    {
                        case1.remove(0);
                        case1.repaint();
                 
                    }
           
                }
                
                
                }
                if(case1.isPelle())
                {
                    corsaire.setAyantPelle(true);
                    state.setAyantpelle("OUI");
                    case1.remove(0);
                        
                }
                 if(case1.isPelle())
                {
                    case1.setPelle(false);
                    corsaire.setAyantPelle(true);
                     
                }
               if(case1.isMousquet())
                {
                    case1.setMousquet(false);
                    corsaire.setAyantMosquet();
                    nbm++;
                    state.setMosquet(String.valueOf(nbm));
                     case1.remove(0);
                }
               if(case1.isArmure())
                {
                    case1.setArmure(false);
                    corsaire.setVie(corsaire.getVie()+50);
                    nba++;
                    System.out.println(nba);
                     state.setArmure(String.valueOf(nba));
                      case1.remove(0);
                         
                }
               
               if(piratecase == case1)
               {
                   if(corsaire.isAyantMosquet() ==0 && corsaire.getAyantArmure() ==0 )
                    {
                    case1.remove(1);
                    case1.repaint();
                    
                    }
                    else
                    {
                        case1.remove(0);
                        case1.repaint();
                        FinPartie fin = new FinPartie("VOUS AVEZ PERDU");
                    fin.setVisible((true));
                    this.setVisible(false);
                   partiegagne = false;
                 
                    }
               }
               if(flibcase == case1)
               {
                   if(corsaire.isAyantMosquet() ==0 && corsaire.getAyantArmure() ==0 )
                    {
                    case1.remove(1);
                    case1.repaint();
                
                    }
                    else
                    {
                        case1.remove(0);
                        case1.repaint();
                     FinPartie fin = new FinPartie("VOUS AVEZ PERDU");
                    fin.setVisible((true));
                    this.setVisible(false);
                    partiegagne = false;
                    }
               }
                 if(corsaire.getAyantPelle())
               {
                   if(case1.isTrisor())
                   {
                    FinPartie fin = new FinPartie("VOUS AVEZ GAGNÉ");
                         fin.setVisible((true));
                         this.setVisible(false);
                         partiegagne = false;
                         
                   }
               }
               
               
                
                 
                

                
        
        }
	private int getLigne(Case case1){
		int res=0;
		for(int i=0; i<TAILLE*TAILLE; i++){
			if(getCase(i).equals(case1)){
				res=i/TAILLE;
			}
		}
		return res;
	}

	private int getColonne(Case case1){
		int res=0;
		for(int i=0; i<TAILLE*TAILLE; i++){
			if(getCase(i).equals(case1)){
				res=i%TAILLE;
			}
		}
		return res;
	}
	
      
	


}