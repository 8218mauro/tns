<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css'>
        <script src="js/jquery-3.1.0.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/funcionesPc.js"></script>
        <%  RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("index.jsp");
            String nombre=(String)session.getAttribute("nombre");
            if(nombre==null)
            {
                out.print(nombre);
                rd.forward(request, response);
        }else{}
        %>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <h1>Seleccione el tipo de consulta</h1>
                    <input type="button" id="btnHorarios" name="btnHorarios" class="btn btn-primary" value="Horarios">
                    <input type="button" id="btnTarifas" name="btnTarifas" class="btn btn-primary" value="Tarifas">
                    <hr>
                    <!--<input type="button" id="btnEstado" name="btnEstado" value="Estado">-->
                    <input type="hidden" id="Tarifa" name="Tarifa">
                    <div id="consulta">
                        <form name="fHorario" id="fHorario" class="form-inline">
                            
                            <div class="form-group">
                                <label>Ciudad de origen</label>
                                <select id="ciudadOrigen" name="ciudadOrigen" class="form-control">
                                    <option>- - -</option>
                                    <option value="Monteria">Monteria</option>
                                    <option value="Medellin">Medellin</option>
                                    <option value="Bogota">Bogota</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label>Ciudad de destino</label>
                                <select id="ciudadDestino" name="ciudadDestino" class="form-control">
                                    <option>- - -</option>
                                    <option value="Monteria">Monteria</option>
                                    <option value="Medellin">Medellin</option>
                                    <option value="Bogota">Bogota</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label for="txtHorario">Fecha de salida</label>
                                <input type="date" name="txtHorario" id="txtHorario" class="form-control"> 
                            </div>
                            
                            <input type="button" id="btnChorario" name="btnChorario" value="horario" class="btn btn-primary">
                        </form>
                        <form name="fCosto" id="fCosto" class="form-inline">
                            <div class="form-group">
                                <label>Ciudad de origen</label>
                                <select id="cOrigen" name="cOrigen" class="form-control">
                                    <option>- - -</option>
                                    <option value="Monteria">Monteria</option>
                                    <option value="Medellin">Medellin</option>
                                    <option value="Bogota">Bogota</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label>Ciudad de destino</label>
                                <select id="cDestino" name="cDestino" class="form-control">
                                    <option>- - -</option>
                                    <option value="Monteria">Monteria</option>
                                    <option value="Medellin">Medellin</option>
                                    <option value="Bogota">Bogota</option>
                                </select>
                            </div>
                            
                            <div class="form-group">
                                <label>Fecha de salida</label>
                                <input type="date" name="tHorario" id="tHorario" class="form-control">
                            </div>
                            <hr>
                            <div class="form-group">
                                <label>Precios entre:</label>
                                <input type="text" id="txtCinicial" name="txtCinicial" class="form-control"> y
                                <input type="text" id="txtCfinal" name="txtCfinal" class="form-control">
                            </div>
                            <input type="button" id="btnCosto" name="btnCosto" value="Buscar" class="btn bg-primary">
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div id="result">
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
