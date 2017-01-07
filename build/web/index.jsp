<%@page import="modelado.*" %>
<%@page import="uml.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css'>
        <script src="js/jquery-3.1.0.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/funcionesPi.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h1 class="text-center">Bienvenido ${sessionScope.usuario}</h1>
                    <% if(session.getAttribute("usuario")!=null){
                        %>
                        <a href="consulta.jsp">Consulta de vuelos</a><br>
                        <a href="reservacion.jsp">Reservacion de vuelos</a><br>
                        <a href="#" id="verReservas">Estado de vuelos</a>
                        <%
                       }else{
                        %>
                        <a href="#">Consulta de vuelos</a><br>
                        <a href="#">Reservacion de vuelos</a><br>
                        <a href="#">Estado de vuelos</a>
                        <%
                       }
                    %>
                </div>
            </div>
        </div>
            

        
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Iniciar sesion</h2>
                    <form name="forLogin" action="" method="post">
                        <div class="form-group">
                            <label for="txtLogin">Login</label>
                            <input type="email" id="txtLogin"  class="form-control" name="txtLogin" placeholder="Escriba su correo">
                        </div>
                        <div class="form-group">
                            <label for="txtPass">Contraseña</label>
                            <input type="password" id="txtPass" class="form-control" name="txtPass"><br>
                        </div>

                        <input type="submit" id="btnEntrar" class="btn btn-primary" name="btnEntrar" value="Entrar">
                        <input type="submit" id="btnSalir" class="btn btn-primary" name="btnSalir" value="Salir">
                    </form>
                </div>
                <% if(session.getAttribute("usuario")==null){
                        %>
                <div class="col-sm-6">
                    <h2>Registrarse</h2>
                    <form name="forRes" action="" method="post">
                        <div class="form-group">
                            <label for="txtCc">Cedula</label>
                            <input type="text" id="txtCc" class="form-control" name="txtCc">
                        </div>
                        <div class="form-group">
                            <label for="txtNombres">Nombres</label>
                            <input type="text" id="txtNombres" class="form-control" name="txtNombres">
                        </div>
                        <div class="form-group">
                            <label for="txtApellidos">Apellidos</label> 
                            <input type="text" id="txtApellidos" class="form-control" name="txtApellidos">
                        </div>
                        <div class="form-group">
                            <label for="txtEdad">Edad</label>
                            <input type="text" id="txtEdad" class="form-control" name="txtEdad"> 
                        </div>
                        <div class="form-group">
                            <label for="txtCorreo">Correo</label>
                            <input type="email" id="txtCorreo" class="form-control" name="txtCorreo">
                        </div>
                        <input type="submit" id="btnEnviar" name="btnEnviar" class="btn btn-primary" value="Enviar">
                    </form>
                </div>
                <%
                  }
                %>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div id="result">
                        
                    </div>
                </div>
            </div>
        </div>       
    </body>
</html>
