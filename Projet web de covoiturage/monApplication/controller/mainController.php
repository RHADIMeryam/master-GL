<?php

class mainController
{

	public static function helloWorld($request,$context)
	{
		return context::SUCCESS;
	}
	public static function test($request,$context)
	{
		echo voyageTable::getPlaceDisponibleVoyage(10);
		return context::SUCCESS;
	}
	public static function logout($request, $context){
		$context->setSessionAttribute('user_id',NULL);
		header('location: monApplication.php');
	}
	public static function login($request,$context)
	{
		if(key_exists("identifiant",$request) &&key_exists("password",$request)){
			$context->identifiant =  $request['identifiant'];
			$context->password =  $request['password'];
			$user = utilisateurTable::getUserByLoginAndPass($context->identifiant, $context->password);
			if($user){
				$context->setSessionAttribute('user_id',$user->id);
				header('location: monApplication.php?action=rechercheVoyage');
			}
			else{
				$context->errorMSG = "Nom d'utilisateur ou mots de passe incorrect";
				return context::ERROR;
			}
		}
		return context::SUCCESS;
	}
	public static function nouveauVoyage($request,$context)
	{
		if($context->getSessionAttribute("user_id")!=NULL) 
    {$context->user = utilisateurTable::getUserById($context->getSessionAttribute("user_id"));}
		else return context::ERROR;
		$context->villes = trajetTable::getVilles();
		return context::SUCCESS;
	}

	public static function nouveauVoyagePost($request, $context){
		$context->success = "false";
		if($context->getSessionAttribute("user_id")!=NULL) 
    {
    $context->user = utilisateurTable::getUserById($context->getSessionAttribute("user_id"));
    }
   
		if(key_exists("depart",$request)&&key_exists("tarifparkm",$request)&&key_exists("arrivee",$request)&&key_exists("heuredepart",$request)&&key_exists("nbplace",$request)&&key_exists("contraintes",$request))
    {

			$context->tarifparkm = $request['tarifparkm'];
			$context->depart = $request['depart'];
			$context->arrivee = $request['arrivee'];
			$context->heuredepart = $request['heuredepart'];
			$context->nbplace = $request['nbplace'];
			$context->contraintes = $request['contraintes'];

      $context->voyage=voyageTable::nouveauVoyage($context->depart,$context->arrivee,$context->heuredepart,$context->nbplace,$context->tarifparkm,$context->contraintes,$context->user);
        
			}
      return context::SUCCESS;
	}
	public static function reservation($request,$context)
	{
		if($context->getSessionAttribute("user_id")!=NULL) $context->user = utilisateurTable::getUserById($context->getSessionAttribute("user_id"));
		else return context::ERROR;
		if(key_exists("voyages",$request) &&key_exists("nbvoyageur",$request)){
			$result = reservationTable::nouvelleReservation($context->user, $request['voyages'], $request['nbvoyageur']);
			if($result==0) return context::ERROR;
		}
		return context::SUCCESS;
	}
	public static function mesvoyages($request,$context)
	{
		if($context->getSessionAttribute("user_id")!=NULL) $context->user = utilisateurTable::getUserById($context->getSessionAttribute("user_id"));
		else return context::ERROR;
		$voyagesData = array();
		$voyages = voyageTable::getVoyagesByUser($context->user->id);
		foreach($voyages as $voyage){
			array_push($voyagesData, new voyageData($voyage));
		}
		$context->voyagesData = $voyagesData;
		return context::SUCCESS;
	}
	public static function mesreservations($request,$context)
	{
		if($context->getSessionAttribute("user_id")!=NULL) $context->user = utilisateurTable::getUserById($context->getSessionAttribute("user_id"));
		else return context::ERROR;
		$voyagesData = array();
		$reservations = reservationTable::getReservationsByUser($context->user->id);
		foreach($reservations as $reservation){
			array_push($voyagesData, new voyageData($reservation->voyage));
		}
		$context->voyagesData = $voyagesData;
		return context::SUCCESS;
	}
	public static function register($request,$context)
	{
		if(key_exists("nom",$request) &&key_exists("prenom",$request) &&key_exists("identifiant",$request) &&key_exists("password",$request)){
			$context->nom = $request['nom'];
			$context->prenom =  $request['prenom'];
			$context->identifiant =  $request['identifiant'];
			$context->password =  $request['password'];
			if(utilisateurTable::getUserByLogin($request['identifiant'])){
				$context->errorMSG = "Cet identifiant est deja prit.";
				return context::ERROR;
			}
			else{
				$user = utilisateurTable::ajouterUtilisateur($context->nom, $context->prenom, $context->identifiant, $context->password);
				$context->success = true;
			}
		}
		return context::SUCCESS;
	}

	public static function rechercheVoyage($request,$context){
		if($context->getSessionAttribute("user_id")!=NULL) $context->user = utilisateurTable::getUserById($context->getSessionAttribute("user_id"));
		if(key_exists("depart",$request) && key_exists("arrivee",$request)){
			$trajet = trajetTable::getTrajet($request['depart'], $request['arrivee']);
			$context->voyages = voyageTable::getVoyagesByTrajet($trajet->id);
		}
		$context->villes = trajetTable::getVilles();
		return context::SUCCESS;
	}
	public static function ajaxRechercheVoyage($request,$context){
		if(key_exists("depart",$request) && key_exists("arrivee",$request)){
			$trajet = trajetTable::getTrajet($request['depart'], $request['arrivee']);
			$context->voyages = voyageTable::getVoyagesByTrajet($trajet->id);
			return context::SUCCESS;
		}
		return context::ERROR;
	}
 public static function rechercheVoyageCorrespendance($request,$context){
		$context->reservation ="";
		if(!$context->getSessionAttribute("user_id")!=NULL) $context->reservation ="disabled";
		$context->titre = "Recherché un Voyage";
		if(key_exists("depart",$request) && key_exists("arrivee",$request) && key_exists("nbvoyageur",$request)){
			$context->nbvoyageur = $request['nbvoyageur'];
			$context->trajet = trajetTable::getTrajet($request['depart'], $request['arrivee']);
			$correspendances = voyageTable::getVoyagesByTrajet2($context->trajet, $request['nbvoyageur']);
			$correspendancesData = array();
			foreach($correspendances as $correspendance){
				$cor = new correspendance($correspendance);
				array_push($correspendancesData, $cor);
			}
			$context->correspendancesData = $correspendancesData;
		}
		return context::SUCCESS;
	}

	
}