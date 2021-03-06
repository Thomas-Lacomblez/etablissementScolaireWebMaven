<!--
=========================================================
 Light Bootstrap Dashboard - v2.0.1
=========================================================

 Product Page: https://www.creative-tim.com/product/light-bootstrap-dashboard
 Copyright 2019 Creative Tim (https://www.creative-tim.com)
 Licensed under MIT (https://github.com/creativetimofficial/light-bootstrap-dashboard/blob/master/LICENSE)

 Coded by Creative Tim

=========================================================

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.  -->
 <!DOCTYPE html>
 <html lang="en">
 
 <head>
     <meta charset="utf-8" />
     <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
     <link rel="icon" type="image/png" href="assets/img/favicon.ico">
     <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
     <title>Light Bootstrap Dashboard - Free Bootstrap 4 Admin Dashboard by Creative Tim</title>
     <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
     <!--     Fonts and icons     -->
     <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
     <!-- CSS Files -->
     <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
     <link href="assets/css/light-bootstrap-dashboard.css?v=2.0.0 " rel="stylesheet" />
     <link rel="stylesheet" type="text/css" href="assets/css/style.css" />
 </head>
 
 <body>
     <div class="wrapper" style="display: grid; place-content: center">

        <form method="POST" action="/etablissement/connection">
            <fieldset>
              <legend>Login</legend>
              <label for="email">User:</label>
              <input type="email" name="email" id="email" autocomplete="off" placeholder="John">
              <label for="password">Password:</label>
              <input type="password" name="motdepasse" id="motdepasse" placeholder="mypassword">
              <button type="submit">Access</button>
            </fieldset>
          </form>
        <!--<form method="POST" action="/etablissement/connection" style="display:table-cell; width:100%" >
            <div class="row" style="display:table-cell; width:100%">
                <div class="col-md-4 pl-1" style="display:table-cell; width:100%">
                    <div class="form-group" style="display:table">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="email" name="email" class="form-control" style="display:table-cell; width:100%">
                    </div>
                </div>
            </div><br/>
            <div class="row" style="display:table-cell; width:100%">
                <div class="col-md-4 pl-1" style="display:table-cell; width:100%">
                    <div class="form-group" style="display:table">
                        <label>Mot de passe</label>
                        <input type="password" name="motdepasse" class="form-control" style="display:table-cell; width:100%">
                    </div>
                </div>
            </div>
            <br />
            <div class="row">
                <button type="submit" class="btn btn-info btn-fill pull-right">connection</button>
                <div class="clearfix"></div>
            </div>
        </form>-->
    </div>
 </body>
 <!--   Core JS Files   -->
 <script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
 <script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
 <script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>
 <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
 <script src="../assets/js/plugins/bootstrap-switch.js"></script>
 <!--  Google Maps Plugin    -->
 <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
 <!--  Chartist Plugin  -->
 <script src="../assets/js/plugins/chartist.min.js"></script>
 <!--  Notifications Plugin    -->
 <script src="../assets/js/plugins/bootstrap-notify.js"></script>
 <!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
 <script src="../assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>
 <!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
 <script src="../assets/js/demo.js"></script>
 
 </html>
 