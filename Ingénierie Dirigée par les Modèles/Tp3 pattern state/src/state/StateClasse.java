package state;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.State;

//import org.eclipse.emf.common.util.EList;
//import org.eclipse.uml2.common.util.CacheAdapter;

public class StateClasse {

	static Model model;// ou on vas dessiner
	static UMLFactory factory = UMLFactory.eINSTANCE;

	
	public static void main(String[] args) {
  
		// recuperer notre modele
		model = LoadUml.chargerModele("model/modelState.uml");
		
		
		
		System.out.println("Ton modèle se nomme: \"" + model.getName() + "\"");
		Class cTest = findClassByName("A", model);
		// EList<StateMachine> state = getStateMachines(cTest, model);
		// Boolean bienForme = isStateMachineCorrect(state.get(0));
		// StateMachine sm = getNotreMachine(cTest, model);
		// getState(sm, bienForme);
		// getAllOperationTrigger(sm, bienForme);
		appliquerState(cTest, model);
		LoadUml.sauverModele("model/modelGenerer.uml", model);

	}

	// dois retourner le nom de la machine a etat, on a une seule dans notre cas
	// methode retourne la liste des etatA
	public static EList<StateMachine> getStateMachines(Class c, Model model) {

		EList<StateMachine> stateMachine = new BasicEList<StateMachine>();
		if (c != null) {
			System.out.print("Les etats  retourner :");
			for (Behavior b : c.getOwnedBehaviors()) {
				if (b instanceof StateMachine) {
					stateMachine.add((StateMachine) b);
					System.out.println(b.getName());
				}
			}
			return stateMachine;
		} else {
			System.out.println("La classe n'existe pas");
			return null;
		}
	}

	// retourne un seule machine a etat
	public static StateMachine getNotreMachine(Class c, Model model) {
		return getStateMachines(c, model).get(0);
	}

	public static Boolean isStateMachineCorrect(StateMachine state) {

		int r = state.getRegions().size();
		if (r == 1) {
			System.out.println("La machine a etat est correctement formee pour notre exercice");
			return true;
		} else {
			System.out.println("La machine a etat contient " + state.getRegions().size() + "donc il est mal formee");
			return false;
		}

	}

	public static EList<State> getState(StateMachine sm, Boolean bienForme) {

		EList<State> listeEtats = new BasicEList<State>();
		if (bienForme) {
			System.out.print("Les etats composant la machine sont : ");

			for (Vertex v : sm.getRegions().get(0).getSubvertices()) {
				if (v instanceof State) {
					listeEtats.add((State) v);
					System.out.print("- " + v.getName() + " ");
				}
			}
			return listeEtats;
		} else {
			System.out.println("verifier que votre machine est bien forme");
			return null;
		}

	}

	public static Vertex getStateInitiale(StateMachine sm, Boolean bienForme) {

		// EList<State> listeEtats = new BasicEList<State>();
		if (bienForme) {
			System.out.print("Les etats composant la machine sont : ");
			Boolean test;
			for (Vertex v : sm.getRegions().get(0).getSubvertices()) {
				test = v instanceof State;
				if (test == false) {
					// listeEtats.add((State) v);
					System.out.print("- " + v.getName() + " ");
					return v;

				}
			}
			// return listeEtats;

		} else {
			System.out.println("verifier que votre machine est bien forme");
			// return null;
		}
		return null;

	}

	public static EList<Operation> getAllOperationTrigger(StateMachine sm, Boolean b) {

		EList<Operation> operations = new BasicEList<Operation>();
		if (b) {
			System.out.println("La liste des opérations qui se trouve comme trigger sont: ");
			// on sait que regions on a qu'ine seule et transitions plusieurs
			for (Transition t : sm.getRegions().get(0).getTransitions()) {
				for (Trigger trg : t.getTriggers()) {
					Event e = trg.getEvent();
					if (e instanceof CallEvent) {
						Operation op = ((CallEvent) e).getOperation();
						operations.add(op);
						System.out.println("- " + op.getName());
					}
				}

			}
			return operations;
		} else {
			System.out.println("verifier que votre machine est bien forme");
			return null;
		}

	}

	public static void appliquerState(Class c, Model model) {

		if (c != null) {
			StateMachine sm = getNotreMachine(c, model);
			// createOwned 2eme param pour dire abstract ou pas
			Class etatA = model.createOwnedClass(sm.getName(), true);
			// model.getPackagedElements().add(etatA);
			Boolean bienForme = isStateMachineCorrect(sm);
			EList<State> states = getState(sm, bienForme);

			Vertex statesinitial = getStateInitiale(sm, bienForme);

			Class etatInitaile = model.createOwnedClass(statesinitial.getName(), false);
			// model.getPackagedElements().add(s);
			//association(c, etatA);
			EList<Operation> operations = getAllOperationTrigger(sm, bienForme);
			createComposition(c,etatA,model);
			for (Operation op : operations) {

				Operation o = EcoreUtil.copy(op);
				o.setIsAbstract(true);
				etatA.getOwnedOperations().add(o);
				for (State state : states) {
					Class s = model.createOwnedClass(state.getName(), false);
					s.createGeneralization(etatA);
					// model.getPackagedElements().add(s);
					Operation oper = EcoreUtil.copy(op);
					s.getOwnedOperations().add(oper);
				}

			}

		}

	}

	public static void createComposition(Class classA, Class abstractState, Model model) {
		Association composition = factory.createAssociation();
		classA.createAssociation(true, AggregationKind.NONE_LITERAL,"currentState", 0, 1, abstractState, false,
				AggregationKind.NONE_LITERAL, null, 0, 0);
	}

	public static void association(Class a, Class etatA) {

		Association association = factory.createAssociation();
		Property p1 = factory.createProperty();
		p1.setName("currentState");
		p1.setLower(0);
		p1.setUpper(1);
		p1.setType(etatA);
		association.getMemberEnds().add(p1);
		etatA.getOwnedAttributes().add(p1);

		Property p2 = factory.createProperty();
		p2.setName("contexte");
		p2.setLower(1);
		p2.setUpper(1);
		p2.setType(a);
		association.getMemberEnds().add(p2);
		a.getOwnedAttributes().add(p2);
		Package owner = (Package) etatA.getOwner();
		owner.getPackagedElements().add(association);

	}

	private static Class findClassByName(String name, Model uml) {
		if (!name.isBlank() && uml != null) {
			for (PackageableElement p : uml.getPackagedElements()) {
				if (p instanceof Package) {
					for (Element element : p.getOwnedElements()) {
						if (element instanceof Class && ((Class) element).getName().equals(name)) {
							return (Class) element;
						}
					}
				} else if (p instanceof Class) {
					System.out.println("class found : " + p.getName());
					return (Class) p;
				}
			}
		}
		return null;
	}

	public Class findClassInPackage(String name, Package p) {
		Class c = null;
		for (PackageableElement pd : p.getPackagedElements()) {
			if (pd instanceof Class) {
				Class pdc = (Class) pd;
				if (pdc.getName().equals(name)) {
					return pdc;
				}
			} else if (pd instanceof Package) {
				Package pdp = (Package) pd;
				c = findClassInPackage(name, pdp);
				if (c != null) {
					return c;
				}
			}
		}
		return c;
	}

	public Package findPackageInPackage(String name, Package p) {
		Package result = null;
		for (PackageableElement pd : p.getPackagedElements()) {
			if (pd instanceof Package) {
				Package pdp = (Package) pd;
				if (pdp.getName().equals(name)) {
					return pdp;
				}
				result = findPackageInPackage(name, pdp);
				if (result != null) {
					return result;
				}
			}
		}
		return result;
	}
}
