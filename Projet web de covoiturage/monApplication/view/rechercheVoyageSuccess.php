<div style="margin-left:5px;margin-top:30px;" class="container">
 <div class="row">
 <p style="margin-left:20px;" class="h3"> Ou voulez-vous aller ?  </p>
 </div>
</br> 
</br>
<div class="row"> <div class="col"> 
<form method="POST" action="" id="recherche">
<input type="hidden" name="action" value="<?php echo $action ?>">
<div class="input-group mb-3">
  <div class="input-group-prepend">
   <label class="input-group-text p-2 mb-1 bg-info text-white" for="depart" >Ville de depart</label>
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
        <div class="col" > <div class="input-group  mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text p-2 mb-1 bg-info text-white" for="arrivee">Ville d arrivee</>
  </div>
   <select name="arrivee" id="arrivee" class="custom-select">
        <?php foreach($context->villes as $ville) { ?>
                <?php if(isset($_REQUEST['arrivee']) && $_REQUEST['arrivee'] == $ville['ville']){ ?>
                <option value="<?php echo $ville['ville'] ?>" selected><?php echo $ville['ville'] ?></option>
        
                <?php }else{ ?>
                <option value="<?php echo $ville['ville'] ?>"><?php echo $ville['ville'] ?></option>
        <?php 
        }
         }
          ?>
           </select> 

           </div> 
            
           </div> 
           <div class="col">
      <div class="input-group mb-2">
        <div class="input-group-prepend">
          <div class="input-group-text p-2 mb-1 bg-info text-white" >Nombre de voyageurs</div>
        </div>
        <input type="number" max="20" min="1" class="form-control"  id="voyageurnb" value="1">
      </div>
    </div>
<div class="col">
           <div class="col"> <button type="submit" class="btn btn-light fa fa-search p-3 "> Rechercher</button> </div> </form>
         </div>
        </div>
<div id="resultat">





</div>