package utilisationMaps;
import map.MapPackage;
import map.Pedestrian;
import map.PublicSpace;
import map.Road;
import map.Garden;
import map.Map;
import map.MapFactory;
import map.Street;
import map.impl.MapFactoryImpl;
import java.util.ArrayList;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

public class ManipulationsMaps {

	private static Map maMap;

	public static void main(String[] args) {

		// Je charge l'instance map.xmi du méta-modèle maps.ecore
		Resource resource = chargerModele("model/Map.xmi", MapPackage.eINSTANCE);
		if (resource == null) {
			System.err.println(" Erreur de chargement du modèle");
		}
		// Instruction récupérant le modèle sous forme d'arbre à partir de la classe
		// racine "Map"
		maMap = (Map) resource.getContents().get(0);
		System.out.println("Le nom de la classe :  " + maMap.getName()); // affichage du nom de la carte.
		// Test des résultats des noms de toutes les rues (Street) d’une map donn´ee.
		getStreet(maMap);
		getPedestrian(maMap);
		getCheminAdjARue("avenue de agriculture", maMap);
		EList<Road> roads = maMap.getRoads();
		sauverModele("model/createGarden.xmi", maMap);
		Garden d = creerJardin("jardine de oujda", getStreet(maMap), maMap);
		maMap.getSpaces().add(d);
		sauverModele("model/creer.xmi", maMap);

	}

	public static Resource chargerModele(String uri, EPackage pack) {
		Resource resource = null;
		try {
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
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
		return resource;
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

	public static EList<Road> getStreet(Map map) {
		System.out.println("les noms de toutes les rues  d’une map donnee : ");
		EList<Road> roads = map.getRoads();
		for (Road r : roads) {
			if (r instanceof Street) {
				System.out.println(" -" + r.getName());
				roads.add(r);
			}
		}
		return roads;

	}

	public static EList<Road> getPedestrian(Map map) {
		System.out.println("Les rues pietonnes dont la longueur depasse 1000m :");
		EList<Road> pendest = map.getRoads();
		for (Road r : pendest) {
			if (r instanceof Pedestrian && r.getLength() > 100) {
				System.out.println("- " + r.getName());
				pendest.add(r);
			}
		}
		return pendest;
	}

	public static EList<Road> getCheminAdjARue(String street, Map map) {
		System.out.println("Pour la rue : " + street + " les noms des rues ou chemins adjacents sont :");
		EList<Road> adjRue = map.getRoads();
		for (Road r : adjRue) {
			if (r.getName().equals(street)) {
				System.out.println(r.getBorder().toString());
			}
		}
		return adjRue;
	}

	public static Garden creerJardin(String nomJardin, EList<Road> rueBorder, Map map) {

		// MapFactory mapFactory=null;
		/*
		 * Garden d = MapFactory.eINSTANCE.createGarden(); //NewMapFactoryImpl map = new
		 * NewMapFactoryImpl(); d.setName(nomJardin); d.set
		 * System.out.println("Le jardin crée : " + d.getName() + " , border " +
		 * d.getBorderedBy()); return d;
		 */

		MapFactoryImpl mapFactoryImpl = new MapFactoryImpl();
		Garden g = MapFactory.eINSTANCE.createGarden();
		Garden garden = mapFactoryImpl.createGarden();
		garden.setName(nomJardin);
		garden.getBorderedBy().addAll(rueBorder);
		map.getSpaces().add(garden);
		System.out.println("Le jardin crée : " + garden.getName() + " , border " + garden.getBorderedBy());
		return garden;

	}
	public static ArrayList<String> getAdjacentRoads(String sName){
        ArrayList<String> sAdjacent = new ArrayList<String>();
        
        for (Road road : maMap.getRoads()) {
        	
            if(road instanceof Street && road.getName().equals(sName)) {
                for(Road meetRoad : road.getMeet()) {
                    sAdjacent.add(meetRoad.getName());
                }
                for(PublicSpace publicSpace : road.getBorder()) {
                    sAdjacent.add(publicSpace.getName());
                }
            }
        }
        return sAdjacent;
    }

}