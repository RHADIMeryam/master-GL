<div class="container">
<div class="col-lg">
   <?php if($context->success) { ?>
   <div class="alert alert-success" role="alert">
      Votre compte a &eacutet&eacute ajouter a notre application veuillez <a href="?action=login">vous connect&eacute</a>
   </div>
   <?php } ?>
   <div 
      id="main" 
      style="max-width:700px;
      margin-top:50px;">
      <div id="menu"
         style ="width:300px;
         position:absolute;">
         <img src="https://covoiturage-lasterrenas.com/img/logo.png"
            height="100px"
            width="100px">
         <br>
         <h3 style="color:blue;"> Ceri Car </h3>
         <h4> Avec Ceri Car, On roule ensemble ! </h4>
      </div>
   </div>
</div>
<div id="contenu" style ="margin-left:90px;width:1400px;">
   <div class="col-lg-5 m-auto">
      <div class="card mt-5 bg-light">
         <div class="card-title text-center mt-3" >
            <img src="images/bj.png" width="80px" height="80px">
         </div>
         <div class="card-body">
            <form method="POST">
               <input type="hidden" name="action" value="register">
               <div class="form-row">
                  <div class="col">
                     <label >Nom</label>
                     <input type="text" class="form-control" placeholder="Entrez votre nom" name="prenom" required="required">
                  </div>
                  <div class="col">
                     <label >Prenom</label>
                     <input type="text" class="form-control" placeholder="Entrez votre prenom" name="nom" required="required">
                  </div>
               </div>
               <br>
               <label> Date de naissance </label> &nbsp&nbsp&nbsp&nbsp
               <input type="date" id="start" name="trip-start" value="2021-01-01"
                  min="1900-01-01" max="2018-12-31">
               </br>
               <label >Pseudo</label>
               <input type="text" class="form-control" id="identifiant" placeholder="Merci de choisir votre pseudo" name="identifiant" required="required">
               <label> Mot de passe </label>
               <input type="password" class="form-control py-4" name="password" id="password"  required="required" placeholder="mot de passe">               
               </br></br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
               <button type="submit" class="btn btn-success" style ="margin:auto;"> Connexion</button>
               <button type="reset" class="btn btn-danger" style ="margin:auto;" > Annuler</button>
            </form>
         </div>
      </div>
   </div>
</div>