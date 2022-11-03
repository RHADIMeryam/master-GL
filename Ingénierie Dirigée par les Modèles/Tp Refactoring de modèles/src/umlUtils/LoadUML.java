package umlUtils;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;
//importer automatiquement
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;

public class LoadUML {

	public static void main(String[] args) {

		// Instruction récupérant le modèle sous forme d'arbre à partir de la classe
		// racine "Model"
		Model umlP = chargerModele("model/InputMove.uml");
		String nomModele = umlP.getName();
		System.out.println("Ton modèle se nomme: \"" + nomModele + "\"");
		// Modifier le nom du modèle UML
		// umlP.setName("nouveauNom");
		System.out.println("\"" + nomModele + "\" Changé ! Le modèle se nomme: \"" + umlP.getName() + "\"");
		// Sauvegarder le modèle avec son nouveau nom
		// sauverModele("model/changerNom.uml", umlP);
		// recuperer le package de notre modele UML
		Package p = (Package) umlP.getPackagedElement("p2");
		Package pCible = (Package) umlP.getPackagedElement("p1");
		Class a = findClassInPackage("A", p);
		// changerClassDePackageAUnAutre(a, pCible);
		remplaceAttPublicParPrive(a, "age");
		sauverModele("model/Attr.uml", umlP);
		Class b = findClassInPackage("B", p);
		moveMethode(b, a, "afficherAb");
		sauverModele("model/heritage.uml", umlP);
	}

	public static void sauverModele(String uri, EObject root) {
		Resource resource = null;
		try {
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			resource = (new ResourceSetImpl()).createResource(uriUri);
			resource.getContents().add(root);
			resource.save(null);
		} catch (Exception e) {
			System.err.println("ERREUR sauvegarde du modèle : " + e);
			e.printStackTrace();
		}
	}

	public static Model chargerModele(String uri) {
		Resource resource = null;
		EPackage pack = UMLPackage.eINSTANCE;
		try {
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());
			resource = (new ResourceSetImpl()).createResource(uriUri);
			XMLResource.XMLMap xmlMap = new XMLMapImpl();
			xmlMap.setNoNamespacePackage(pack);
			java.util.Map options = new java.util.HashMap();
			options.put(XMLResource.OPTION_XML_MAP, xmlMap);
			resource.load(options);
		} catch (Exception e) {
			System.err.println("ERREUR chargement du modèle : " + e);
			e.printStackTrace();
		}
		return (Model) resource.getContents().get(0);
	}

	public static void changerClassDePackageAUnAutre(Class classeUml, Package packageCible) {
		/*
		 * Ecrire une methode de reusinage qui permet de deplacer une classe UML d’un
		 * package UML a un autre : cette methode prend en param`etre une classe UML, et
		 * un package UML cible, et d´eplace la classe dans le package.
		 */
		classeUml.setPackage(packageCible);

	}

	public static Class findClassInPackage(String name, Package p) {
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
				// si il trouve pas la classe, il recherche dans le package qui est à
				// l'interieur
				result = findPackageInPackage(name, pdp);
				if (result != null) {
					return result;
				}
			}
		}
		return result;
	}

	public static void remplaceAttPublicParPrive(Class className, String nomAttribut) {

		// on retourne la liste de tous les attr d'une classe
		for (Property p : className.getAllAttributes()) {
			// cherche attributs concerné

			if (p.getName().equals(nomAttribut)) {
				// verifier qu'il est public
				if (p.getVisibility() == VisibilityKind.PUBLIC_LITERAL) {
					// Le modifier

					p.setVisibility(VisibilityKind.PRIVATE_LITERAL);
					// createOwnedOperation : nom de la méthode, nom des liste des param , list des
					// param
					EList<String> nomArg = new BasicEList<String>();
					EList<Type> typeArg = new BasicEList<Type>();
					nomArg.add(p.getName());
					typeArg.add(p.getType());
					className.createOwnedOperation("get" + p.getName(), null, null).createReturnResult(nomAttribut,
							p.getType());
					className.createOwnedOperation("set" + p.getName(), nomArg, typeArg);

				}

			}

		}

	}

	public static void moveMethode(Class classeOrigine, Class superClassCible, String nomMethode) {

		// verifier que la méthode existe bien dans la classe origine
		for (Operation o : classeOrigine.getAllOperations()) {
			// classeOrigine.getGeneralization(superClassCible).isSubstitutable()
			if (classeOrigine.allParents().contains(superClassCible)) {
				if (!classeOrigine.getOperations().contains(nomMethode)) {
					if (o.getName().equals(nomMethode)) {
						o.setClass_(superClassCible);
						System.out.println("Le refactoring est effectué avec succés, vérifier votre modèle !!");

					} else {
						System.out.println("Il n'existe pas de méthode " + nomMethode + " dans votre classe "
								+ classeOrigine + "!!");

					}
				} else {
					System.out.println("Une méthode avec le nom " + nomMethode + " existe deja dans la classe mère "
							+ superClassCible);
				}
			} else {
				System.out.println("La classe  " + classeOrigine + "n'est pas une classe fille de la classe " + superClassCible );
			}
		}

	}

}
