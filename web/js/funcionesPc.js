$(document).ready(function() {
        
	
        $("#btnHorarios").on('click', function() {
		event.preventDefault();
		horarios();
	});
        $("#btnTarifas").on('click', function() {
		event.preventDefault();
		tarifas();
	});
        
        $("#btnChorario").on('click', function() {
		event.preventDefault();
		consultaHorario();
	});
        
        $("#btnCosto").on('click', function() {
		event.preventDefault();
		consultaPorCosto();
	});
        
        $("#fHorario").css("display", "none");
        $("#fCosto").css("display", "none");

	function horarios(){
            $("#fHorario").css("display", "block");
            $("#fCosto").css("display", "none");
            $("#result").html("");
	}
        
        function tarifas(){
            $("#fCosto").css("display", "block");
            $("#fHorario").css("display", "none");
            $("#result").html("");
        }
        
        function consultaHorario(){
                    var ciudadOrigen = $("#ciudadOrigen").val();
                    var ciudadDestino = $("#ciudadDestino").val();
                    var fechaSalida = $("#txtHorario").val();
                    //console.log(fechaSalida);
                    var operacion = "filtrarPorHorario";
            $.ajax({
			url: 'SERVOperaciones',
			type: 'POST',
			data: {origen: ciudadOrigen, destino: ciudadDestino, fecha: fechaSalida, operacion:operacion},
				success:function(data){
				$("#result").html("<h3 class='text-center'>Su busqueda arrojo los siguientes resultados</h3><table class='table table-hover'>"+data+"</table>");
                                $(".Estado").click(btnEstado);
                                
			},
			error:function(jq,es,error){
				console.log(es);
			}
		});
        }
        
        function consultaPorCosto(){
                    var ciudadOrigen = $("#cOrigen").val();
                    var ciudadDestino = $("#cDestino").val();
                    var fechaSalida = $("#tHorario").val();
                    var costoInicial = $("#txtCinicial").val(); 
                    var costoFinal = $("#txtCfinal").val(); 
                    var operacion = "filtrarPorCosto";
                    $.ajax({
			url: 'SERVOperaciones',
			type: 'POST',
			data: {origen: ciudadOrigen, destino: ciudadDestino, fecha: fechaSalida, costoInicial: costoInicial, costoFinal:costoFinal, operacion:operacion},
				success:function(data){
				$("#result").html("<h3>Su busqueda arrojo los siguientes resultados</h3><table class='table table-hover'>"+data+"</table>");
                                //btnEstado();
                                $(".Estado").click(btnEstado);
			},
			error:function(jq,es,error){
				console.log(es);
			},
                        
		});
        }
        
        function btnEstado(){
            //$("button#Estado").on('click', function(){
                    event.preventDefault();
                    //console.log($(this).val());

                    var campo = $(this).val();
                    var operacion = "filtrarPorEstado";
                    var dataT = $(this).attr("data-idtarifa");
                    var dataA = $(this).attr("data-idavion");
                    var operacion = "mostrarAdisponibles";
                    console.log(dataT+"  "+dataA);
                    
                    $.ajax({
                            url: 'SERVOperaciones',
                            type: 'POST',
                            data: {idvuelo: dataA, idtarifa: dataT, operacion: operacion},
                            success:function(data){
                                   $("#result").html("<h3 class='text-center'>Los asientos disponibles para el avion seleccionado son:</h3><table class='table table-hover'>"+data+"</table>");
                                   reservar();
                                   $("#Tarifa").attr("value",dataT);
                            },
                            error:function(jq,es,error){
                                    console.log(es);
                            }
                    });
            //});
        }
        
        function reservar(){
            $("button#Reservar").on('click', function(){
                    event.preventDefault();
                    var codigoavion = $(this).attr("data-cavion");
                    var idasiento = $(this).attr("data-asiento");
                    var codigotarifa = $("#Tarifa").val();
                    
                    console.log(codigoavion+" "+idasiento+" "+codigotarifa)
                    
                    var operacion = "reserva";

                    $.ajax({
                            url: 'SERVOperaciones',
                            type: 'POST',
                            data: {cavion: codigoavion, asiento:idasiento, tarifa:codigotarifa, operacion:operacion},
                            success:function(data){
                                   $("#result").html(data);
                                   $("#Reservar").attr("value","");
                            },
                            error:function(jq,es,error){
                                    console.log(es);
                            }
                    });
            });
        }
});

