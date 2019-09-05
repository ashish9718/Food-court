<%@page import="com.javaproject.models.OrderMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import="com.javaproject.models.*" %>

<%
List<OrderMaster> list=(List<OrderMaster>)request.getAttribute("list");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="dashboard/plugins/images/favicon.png">
    <title>All Orders</title>
    <!-- Bootstrap Core CSS -->
    <link href="dashboard/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="dashboard/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <!-- toast CSS -->
    <link href="dashboard/plugins/bower_components/toast-master/css/jquery.toast.css" rel="stylesheet">
    <!-- morris CSS -->
    <link href="dashboard/plugins/bower_components/morrisjs/morris.css" rel="stylesheet">
    <!-- chartist CSS -->
    <link href="dashboard/plugins/bower_components/chartist-js/dist/chartist.min.css" rel="stylesheet">
    <link href="dashboard/plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.css" rel="stylesheet">
    <!-- animation CSS -->
    <link href="dashboard/css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="dashboard/css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="dashboard/css/colors/default.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>


<body class="fix-header">
    <!-- ============================================================== -->
    <!-- Preloader -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" />
        </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Wrapper -->
    <!-- ============================================================== -->
    <div id="wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <nav class="navbar navbar-default navbar-static-top m-b-0">
            <div class="navbar-header">
                <div class="top-left-part">
                    <!-- Logo -->
                    <strong><a href="dashboard.jsp">FoodCourt</a></strong>
                </div>
                <!-- /Logo -->
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <form role="search" class="app-search hidden-sm hidden-xs m-r-10">
                            <input type="text" placeholder="Search..." class="form-control"> <a href=""><i class="fa fa-search"></i></a> </form>
                    </li>
                    <li>
                        <a class="profile-pic" href="#"><b class="hidden-xs">Welcome ${username }</b></a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->
            <!-- /.navbar-static-side -->
        </nav>
        <!-- End Top Navigation -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav slimscrollsidebar">
                <div class="sidebar-head">
                    <h3><span class="fa-fw open-close"><i class="ti-close ti-menu"></i></span> <span class="hide-menu">Navigation</span></h3>
                </div>
                <ul class="nav" id="side-menu">
                    <li style="padding: 70px 0 0;">
                        <a href="Admin.jsp" class="waves-effect"><i class="fa fa-clock-o fa-fw" aria-hidden="true"></i>Dashboard</a>
                    </li>
                    <li>
                        <a href="UserController?action=searchBynameForUpdate" class="waves-effect"><i class="fa fa-user fa-fw" aria-hidden="true"></i>Profile</a>
                    </li>
                    <li>
                        <a href="menu_add.jsp" class="waves-effect"><i class="fa fa-table fa-fw" aria-hidden="true"></i>Add menu</a>
                    </li>
                    <li>
                        <a href="item_add.jsp" class="waves-effect"><i class="fa fa-font fa-fw" aria-hidden="true"></i>Add item</a>
                    </li>
                    <li>
                        <a href="UserController?action=getAll" class="waves-effect"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>Get All Users</a>
                    </li>
                    <li>
                        <a href="MenuController?action=getAll" class="waves-effect"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>Get All Menus</a>
                    </li>
                    <li>
                        <a href="ItemController?action=getAll" class="waves-effect"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>Get All Items</a>
                    </li>
                    <li>
                        <a href="OrderController?action=getallorders" class="waves-effect"><i class="fa fa-columns fa-fw" aria-hidden="true"></i>Get All Orders</a>
                    </li>
                    <li>
                        <a href="UserController?action=logout" class="waves-effect"><i class="fa fa-globe fa-fw" aria-hidden="true"></i>Logout</a>
                    </li>
                    
                </ul>
            </div>
            
        </div>
        <!-- ============================================================== -->
        <!-- End Left Sidebar -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page Content -->
        <!-- ============================================================== -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row bg-title">
                    <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                        <h4 class="page-title">Dashboard</h4> </div>
                    <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12">
                        <ol class="breadcrumb">
                            <li><a href="#">Dashboard</a></li>
                        </ol>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
               
                <!-- /.row -->
                <!-- ============================================================== -->
		
		        <div class="row">
                    <div class="col-sm-12">
                        <div class="white-box">
                            <h3 class="box-title">All orders</h3>
                              <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                        	<th>#</th>
                                            <td>OrderID
											<td>Username
											<td>Date
	                                     </tr>
                                     </thead>
                                     <tbody>
                                    <% for(OrderMaster u : list){ %>
										<tr>
											<td><ul><li></ul>
											<td><%=u.getId() %>
											<td><a href="OrderController?action=getorderbyusername&username=<%=u.getUsername() %>&orderid=<%=u.getId() %>"><%=u.getUsername() %></a>
											<td><%=u.getDate() %>
										</tr>
									<%} %>
								                                    
                                    </tbody>
                                    
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
				
              <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
            <footer class="footer text-center">  2019 &copy; FOOD COURT </footer>
        </div>
        <!-- /#page-wrapper -->
    </div>     
         
<!-- ============================================================== -->

    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="dashboard/plugins/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="dashboard/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- Menu Plugin JavaScript -->
    <script src="dashboard/plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
    <!--slimscroll JavaScript -->
    <script src="dashboard/js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="dashboard/js/waves.js"></script>
    <!--Counter js -->
    <script src="dashboard/plugins/bower_components/waypoints/lib/jquery.waypoints.js"></script>
    <script src="dashboard/plugins/bower_components/counterup/jquery.counterup.min.js"></script>
    <!-- chartist chart -->
    <script src="dashboard/plugins/bower_components/chartist-js/dist/chartist.min.js"></script>
    <script src="dashboard/plugins/bower_components/chartist-plugin-tooltip-master/dist/chartist-plugin-tooltip.min.js"></script>
    <!-- Sparkline chart JavaScript -->
    <script src="dashboard/plugins/bower_components/jquery-sparkline/jquery.sparkline.min.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="dashboard/js/custom.min.js"></script>
    <script src="dashboard/js/dashboard1.js"></script>
    <script src="dashboard/plugins/bower_components/toast-master/js/jquery.toast.js"></script>


</body>
</html>