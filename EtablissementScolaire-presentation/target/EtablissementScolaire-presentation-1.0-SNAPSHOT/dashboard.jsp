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
 <%@ page pageEncoding="UTF-8" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ page session="true" %>
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

</head>

<body>
    <div class="wrapper">
        <div class="sidebar" data-image="assets/img/sidebar-5.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="sidebar-wrapper">
                <div class="logo">
                    <a href="http://www.creative-tim.com" class="simple-text">
                        Gestion etablissement
                    </a>
                </div>
                <ul class="nav">
                    <li class="nav-item active">
                       <a class="nav-link" href="/etablissement/list">
                           <i class="nc-icon nc-chart-pie-35"></i>
                           <p>Accueil</p>
                       </a>
                    </li>
                    <li class="nav-item">
                       <a class="nav-link" href="/etablissement/user.jsp">
                           <i class="nc-icon nc-circle-09"></i>
                           <p>Ajouter un étudiant</p>
                       </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/etablissement/modificationEtudiant">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Modifier un étudiant</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/etablissement/listCours">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Afficher les cours</p>
                        </a>
                    </li>
                    <li class="nav-item ">
                        <a class="nav-link" href="/etablissement/modificationCours">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Modifier un cours</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/etablissement/inscriptionEtudiantCours">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Inscrire un étudiant à un Cours</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/etablissement/ajoutNoteEtudiant">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Ajouter une note à un étudiant</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/etablissement/statistiques">
                            <i class="nc-icon nc-circle-09"></i>
                            <p>Statistique</p>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#pablo"> Dashboard </a>
                    <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                        <span class="navbar-toggler-bar burger-lines"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-end" id="navigation">
                        <ul class="nav navbar-nav mr-auto">
                            <li class="nav-item">
                                <a href="#" class="nav-link" data-toggle="dropdown">
                                    <i class="nc-icon nc-palette"></i>
                                    <span class="d-lg-none">Dashboard</span>
                                </a>
                            </li>
                            <li class="dropdown nav-item">
                                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                                    <!--<i class="nc-icon nc-planet"></i>
                                    <span class="notification">5</span>-->
                                    <span class="d-lg-none">Notification</span>
                                </a>
                                <ul class="dropdown-menu">
                                    <a class="dropdown-item" href="#">Notification 1</a>
                                    <a class="dropdown-item" href="#">Notification 2</a>
                                    <a class="dropdown-item" href="#">Notification 3</a>
                                    <a class="dropdown-item" href="#">Notification 4</a>
                                    <a class="dropdown-item" href="#">Another notification</a>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a href="#" class="nav-link">
                                    <i class="nc-icon nc-zoom-split"></i>
                                    <span class="d-lg-block">&nbsp;Search</span>
                                </a>
                            </li>
                        </ul>
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="#pablo">
                                    <span class="no-icon">${ sessionScope.user.nom } - ${ sessionScope.user.email }</span>
                                </a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="no-icon">Dropdown</span>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <a class="dropdown-item" href="#">Something</a>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                    <div class="divider"></div>
                                    <a class="dropdown-item" href="#">Separated link</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#pablo">
                                    <span class="no-icon">Log out</span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <!-- End Navbar -->
            <div class="content">
                <div class="container-fluid">
                    <c:if test="${ success eq true }" >
                        <div class="alert alert-success" role="alert" >
                            étudiant ajouté avec succès
                        </div>
                    </c:if>
                    <div class="row">
                        <div class="col-md-12 col-lg-12">
                            <div class="card ">
                                <div class="card-header ">
                                    <h4 class="card-title">Liste des étudiants</h4>
                                </div>
                                <div class="card-body ">
                                    <table>
                                        <thead>
                                          <tr>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Adresse</th>
                                            <th>Email</th>
                                            <th>telephone</th>
                                            <th>Date de naissance</th>
                                          </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${ ListEtudiant }" var="etudiant" varStatus="status">
                                              <tr>
                                                <td data-column="First Name">${ etudiant.nom }</td>
                                                <td data-column="Last Name">${ etudiant.prenom }</td>
                                                <td data-column="Adresse">${ etudiant.adresse }</td>
                                                <td data-column="Email">${ etudiant.email }</td>
                                                <td data-column="telephone">${ etudiant.telephone }</td>
                                                <td data-column="Date de naissance">${ etudiant.dateNaissance }</td>
                                                <td> <button type="submit" id="deleteInput" onclick="deleteEtudiant( '${ etudiant.id }' )">Supprimer</button> </td>
                                              </tr>
                                            </c:forEach>
                                        </tbody>
                                      </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav>
                        <ul class="footer-menu">
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                        <p class="copyright text-center">
                            ©
                            <script>
                                document.write(new Date().getFullYear())
                            </script>
                            <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                        </p>
                    </nav>
                </div>
            </footer>
        </div>
    </div>
    <!--   -->
    <!-- <div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
        </a>

        <ul class="dropdown-menu">
			<li class="header-title"> Sidebar Style</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Background Image</p>
                    <label class="switch">
                        <input type="checkbox" data-toggle="switch" checked="" data-on-color="primary" data-off-color="primary"><span class="toggle"></span>
                    </label>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger background-color">
                    <p>Filters</p>
                    <div class="pull-right">
                        <span class="badge filter badge-black" data-color="black"></span>
                        <span class="badge filter badge-azure" data-color="azure"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple active" data-color="purple"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Sidebar Images</li>

            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-1.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-3.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="..//assets/img/sidebar-4.jpg" alt="" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="../assets/img/sidebar-5.jpg" alt="" />
                </a>
            </li>

            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/light-bootstrap-dashboard" target="_blank" class="btn btn-info btn-block btn-fill">Download, it's free!</a>
                </div>
            </li>

            <li class="header-title pro-title text-center">Want more components?</li>

            <li class="button-container">
                <div class="">
                    <a href="http://www.creative-tim.com/product/light-bootstrap-dashboard-pro" target="_blank" class="btn btn-warning btn-block btn-fill">Get The PRO Version!</a>
                </div>
            </li>

            <li class="header-title" id="sharrreTitle">Thank you for sharing!</li>

            <li class="button-container">
				<button id="twitter" class="btn btn-social btn-outline btn-twitter btn-round sharrre"><i class="fa fa-twitter"></i> · 256</button>
                <button id="facebook" class="btn btn-social btn-outline btn-facebook btn-round sharrre"><i class="fa fa-facebook-square"></i> · 426</button>
            </li>
        </ul>
    </div>
</div>
 -->
</body>
    <!--   Core JS Files   -->
    <script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
    <script src="assets/js/core/popper.min.js" type="text/javascript"></script>
    <script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
    <!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/
    <script src="assets/js/plugins/bootstrap-switch.js"></script>-->
    <!--  Google Maps Plugin  
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>  -->
    <!--  Chartist Plugin
    <script src="assets/js/plugins/chartist.min.js"></script>-->
    <!--  Notifications Plugin
    <script src="assets/js/plugins/bootstrap-notify.js"></script>-->
    <!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc
    <script src="assets/js/light-bootstrap-dashboard.js?v=2.0.0 " type="text/javascript"></script>-->
    <!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project!
    <script src="assets/js/demo.js"></script>-->
    <script type="text/javascript">
        function deleteEtudiant(idEtudiant) {
            $.ajax({
                type: "POST",
                url: "/etablissement/supressionEtudiant",
                data: {id : idEtudiant },
                dataType: "json",
                success: function (response) {
                    console.log("in success function");
                    if (response.d == true) {
                        console.log("in success in if function");
                        window.location.reload(true);
                    }
                },
            });
        }
    </script>

</html>
