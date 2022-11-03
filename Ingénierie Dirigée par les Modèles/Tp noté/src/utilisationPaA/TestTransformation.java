package utilisationPaA;

import org.eclipse.uml2.uml.Model;

import paa.PaAModel;

public class TestTransformation {
	
	public static void main(String[] args) {
		
	   UtilisationpaA test= new UtilisationpaA();
		PaAModel paaModel = FileUtils.chargerModelePaA("model/PaAModel.xmi");
		
       Model modelGenerer=test.createModelUml(paaModel);

		FileUtils.sauverModeleUML("model/"+modelGenerer.getName()+".uml", modelGenerer);
		
		
	}
	
	
	
	

}
