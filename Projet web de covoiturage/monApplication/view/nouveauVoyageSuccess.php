<div style="margin-left:5px;margin-top:30px;" class="container">

      <form method="GET" action="" id="newvoyage">
 <div class="row">

 <p class="h3">Ajouter un nouveau voyage</p>  <br> <br>
 </div>

 <div class="row"> 

<div class="col">
  
	<input type="hidden" name="action" value="nouveauVoyagePost">	
	<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text p-2 mb-1 bg-info text-white" for="depart">Ville de depart</label>
  </div>
<select name="depart" id="depart" class="custom-select">
	
	<?php foreach($context->villes as $ville) { ?>
		<?php if(isset($_REQUEST['depart']) && $_REQUEST['depart'] == $ville['ville']){ ?>
		<option value="<?php echo $ville['ville'] ?>" selected><?php echo $ville['ville'] ?></option>
		<?php }else{ ?>
		<option value="<?php echo $ville['ville'] ?>"><?php echo $ville['ville'] ?></option>
	<?php } } ?> 
</select>
</div>
</div>
<div class="col">
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <label class="input-group-text p-2 mb-1 bg-info text-white" for="arrivee">Ville d arivee</label>
  </div>
<select name="arrivee" id="arrivee" class="custom-select">
	<?php foreach($context->villes as $ville) { ?>
		<?php if(isset($_REQUEST['arrivee']) && $_REQUEST['arrivee'] == $ville['ville']){ ?>
		<option value="<?php echo $ville['ville'] ?>" selected><?php echo $ville['ville'] ?></option>
		<?php }else{ ?>
		<option value="<?php echo $ville['ville'] ?>"><?php echo $ville['ville'] ?></option>
	<?php } } ?> 
</select>
</div>
</div>

</div>
<div class="row">
<div class="col">
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text p-2 mb-1 bg-info text-white">Tarif </div>
        </div>
        <input type="number" max="50" min="0" step="0.001" class="form-control" name="tarifparkm" id="tarifparkm" value="1">
      </div>
</div>
<div class="col">
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text p-2 mb-1 bg-info text-white">Nombre de place</div>
        </div>
        <input type="number" max="10" min="1"  class="form-control" name="nbplace" id="nbplace" value="1">
      </div>
</div>
	<div class="col">
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text p-2 mb-1 bg-info text-white">Heure De Depart</div>
        </div>
        <input type="number" max="23" min="0" class="form-control" name="heuredepart"  id="heuredepart" value="0">
      </div>
</div>
</div>
</div>


<div class="col">
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text p-2 mb-1 bg-info text-white">Contraintes</div>
        </div>
        <textarea name="contraintes" id="contraintes"  cols="111" ></textarea>
       
      </div>
</div>
</div>

<div class="col">
 <br> <br> 
<button type="submit" class="btn btn-dark" style="margin-left:400px">Ajouter le voyage</button>
<a href="monApplication.php?action=mesvoyages" class="btn btn-dark style="margin-left:70px">Mes Voyages</a>

</div>
</div>
</form>
</div>
<div id="resultat">
</div>