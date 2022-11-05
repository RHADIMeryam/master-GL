<div id="container">
<div id="page_maincontent">
<div class="col voyages" >
   <div class="card voyage rounded-lg">
      <div class="card-header text-center">
         <h3>Historique de vos voyages ajout&eacute dans CERI CAR</h3>
         <h4>Et si vous voulez ajouter autres voyages  <a href="monApplication.php?action=nouveauVoyage" class="btn btn-dark  "> Click </a> </h4>
      </div>
      <div class="card-body">
         <?php foreach($context->voyagesData as $voyageData) { ?>
         <div class="row">
            <div class="col-sm">
               <div class="card voyage rounded-lg">
                  <div class="card-body">
                     <div class="row" >
                        <div class="col">
                           <table cellpadding="5;" style="border-spacing:3;">
                              <tr>
                                 <td >
                                    <h3 style="color:blue;"> Ceri Car </h3>
                                    <img src="https://covoiturage-lasterrenas.com/img/logo.png" height="100px"
                                       width="100px"> 
                                    <h4> Avec Ceri Car, On roule ensemble ! </h4>
                                 </td>
                              </tr>
                           </table>
                        </div>
                        <div class="col">
                           <input type="hidden" name="voyages[]" value="<?php echo $correspendance->voyagesData[0]->voyage->id ?>">
                           <table cellpadding="5" style="">
                              <tr>
                                 <td> <b style="color:blue;">Conducteur(nom et prenom) </b>
                                    <?php echo $voyageData->voyage->conducteur->nom." ".$voyageData->voyage->conducteur->prenom?>
                                 </td>
                              </tr>
                              <tr>
                                 <td> <b style="color:blue"> Heure et ville de depart  </b>  &agrave <?php echo $voyageData->departFormat ?>  
                                    de <?php echo $voyageData->voyage->trajet->depart;?> 
                                 </td>
                              </tr>
                              <tr>
                                 <td> <b style="color:blue"> Heure et ville d arivee  </b>  &agrave <?php echo $voyageData->arriveeFormat?>, <?php echo $voyageData->voyage->trajet->arrivee;?></td>
                              </tr>
                              <tr>
                                 <td> <b style="color:blue"> Duree de voyage </b>  <?php echo $voyageData->dureeFormat?></td>
                              </tr>
                              <?php if(trim($voyageData->voyage->contraintes) !=="") { ?>
                              <tr>
                                 <td> <b style="color:blue;">Contraintes </b> <?php echo trim($voyageData->voyage->contraintes) ?></td>
                              </tr>
                              <?php } ?>
                              <tr>
                                 <td colspan="2"><b><?php echo $voyageData->placeReserve?> place propos&eacute pour le voyage</b></td>
                              </tr>
                           </table>
                        </div>
                     </div>
                     <div class="table table-striped reservations" style="display: none" >
                        <table style="width: 100%">
                           <?php foreach($voyageData->reservations as $reservation) ?>
                           <tr>
                              <td><b> <?php echo $reservation->voyageur->nom . " ".$reservation->voyageur->prenom;?></b><br> </td>
                           </tr>
                           <?php  ?>
                        </table>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <?php } ?>
      </div>
   </div>
</div>