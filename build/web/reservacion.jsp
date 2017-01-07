<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservacion</title>
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
        <h1>Ve a consultas, filtra segun tu criterio, selecciona y reserva tu vuelo!!</h1>
    </body>
</html>
