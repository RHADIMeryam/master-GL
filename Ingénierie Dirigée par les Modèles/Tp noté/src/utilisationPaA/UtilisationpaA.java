package utilisationPaA;

import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;

import paa.Entity;
import paa.Field;
import paa.FieldDependantQuery;
import paa.PaAModel;
import paa.Query;
import paa.Repository;

public class UtilisationpaA {

	private static UMLFactory factory = UMLFactory.eINSTANCE;
	private static PrimitiveType uml_int = factory.createPrimitiveType();
	private static PrimitiveType uml_string = factory.createPrimitiveType();
	private static PrimitiveType uml_float = factory.createPrimitiveType();
	static {
		uml_int.setName("int");
		uml_string.setName("string");
		uml_float.setName("float");
	}

	/*
	 * Question 3.1
	 * 
	 * cette methode construit et retourne un model UML qui contient les 3 types
	 * primitifs
	 */

	public Model getModelUml() {
		Model modelCreer;
		modelCreer = factory.createModel();
		modelCreer.setName("generatedModel");
		modelCreer.getPackagedElements().add(uml_int);
		modelCreer.getPackagedElements().add(uml_string);
		modelCreer.getPackagedElements().add(uml_float);
		System.out.println("Le model uml " + modelCreer.getName() + "  est bien cree");
		return modelCreer;
	}

	// Question 3.2
	// cette methode cree une proprieté UML et la retourne
	public Property createPropertyUml(Field field) {

		Property p = factory.createProperty();
		p.setName(field.getName());
		p.setVisibility(VisibilityKind.PRIVATE_LITERAL);
		switch (field.getType()) {
		case STRING: {
			p.setType(uml_string);
			break;
		}

		case INT: {
			p.setType(uml_int);
			break;
		}
		case FLOAT: {
			p.setType(uml_float);
			break;
		}
		default: {
			System.out.println("Le type choisi n'existe pas");
			p.setType(null);
		}

		}
		System.out.println("property " + p.getName() + " est bien cree");
		return p;
	}

	// Question 3.3
	// Cette classe cree une classe uml et la retourne
	public Class createClasseUml(Entity entity) {

		Class classeEntity = factory.createClass();
		classeEntity.setName(entity.getName());
		for (Field field : entity.getFields()) {
			Property p = createPropertyUml(field);
			classeEntity.getOwnedAttributes().add(p);
		}
		classeEntity.createOwnedComment().setBody("@Entity");
		System.out.println("Class " + classeEntity.getName() + " est bien cree");
		return classeEntity;
	}

	// Question 3.4
	// Cette methode cree une operation uml et la retourne
	public Operation createOperationUml(FieldDependantQuery query) {

		Operation operation = factory.createOperation();
		operation.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		operation.setName(query.getType().getName() + query.getField().getName());
		switch (query.getField().getType()) {
		case STRING: {
			operation.createOwnedParameter(query.getField().getName(), uml_string);
			break;
		}

		case INT: {
			operation.createOwnedParameter(query.getField().getName(), uml_int);
			break;
		}
		case FLOAT: {
			operation.createOwnedParameter(query.getField().getName(), uml_float);
			break;
		}
		default: {
			System.out.println("Le type choisi n'existe pas");

		}

		}
		System.out.println("Operation " + operation.getName() + " est bien cree");
		return operation;
	}

	// Question 3.5
	// cette methode cree une interface pour chaque repository
	public Interface createInterfaceUML(Repository repository) {

		Interface interfaceCreer = factory.createInterface();
		interfaceCreer.setName(repository.getTypeEntity().getName() + "Repository");
		for (Query q : repository.getQueries()) {
			Operation o = createOperationUml((FieldDependantQuery) q);
			interfaceCreer.getOwnedOperations().add(o);
		}
		interfaceCreer.createOwnedComment().setBody("@Repository");
		System.out.println("Interface " + interfaceCreer.getName() + " est bien cree");
		return interfaceCreer;
	}

	// Question 3.6
	// cette methode retourne notre model paAmodel
	public Model createModelUml(PaAModel paa) {
		Model modelGenerer = getModelUml();
		for (Entity entity : paa.getEntities()) {

			Class c = createClasseUml(entity);

			if (entity.getSuperEntity() != null) {
				Class c2 = createClasseUml(entity.getSuperEntity());

				modelGenerer.getPackagedElements().add(c2);

				c.createGeneralization(c2);
				modelGenerer.getPackagedElements().add(c);

			}
		}

		for (Repository rep : paa.getRepositories()) {

			Interface inter = createInterfaceUML(rep);
			modelGenerer.getPackagedElements().add(inter);

		}
		System.out.println("Model " + modelGenerer.getName() + " est bien cree");
		return modelGenerer;
	}
}
