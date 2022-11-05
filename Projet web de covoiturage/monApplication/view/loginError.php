 <div class="container">ss
            <div class="alert alert-danger" role="alert">
              <?php echo $context->errorMSG; ?>
            </div>
            <div class="col-lg"> 
                  <form method="POST">
                    <input type="hidden" name="action" value="login">
                   <div class="col-lg-5 m-auto">
			<div class="card mt-5 bg-light">
				<div class="card-title text-center mt-3" >
					<img src="images/bj.png" width="150px" height="150px">
				</div>
				<div class="card-body">
					<form method="POST">
           <input type="hidden" name="action" value="login">
						<div class="input-group mb-3"><div class="input-group-prepend">
							<span class="input-group-text">
								<i class="fa fa-user fa-2x"></i>
							</span>
							</div>
								<input type="text" id="identifiant" class="form-control py-4" name="identifiant" required="required" placeholder="nom d'utilisateur">
				</div>
				<div class="input-group mb-3"><div class="input-group-prepend">
							<span class="input-group-text">
								<i class="fa fa-lock fa-2x"></i>
							</span>
							</div>
    <input type="password" class="form-control py-4" name="password" id="password"  required="required" placeholder="mot de passe">               
				</div>
        </br></br>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                  <button type="submit" class="btn btn-success" style ="margin:auto;"> Connexion</button>
                  </form>
            </div>
</div>
 </div>
                             </div>