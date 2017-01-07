$(document).ready(function() {

	$("#btnEnviar").on('click', function(event) {
		event.preventDefault();
		$("#result").html("hola mundo");
		registrarUsuario();
	});

	function registrarUsuario(){
		var cc = $("#txtCc").val();
		var nom = $("#txtNombres").val();
		var ape = $("#txtApellidos").val();
		var ed = $("#txtEdad").val();
		var email = $("#txtCorreo").val();

		$.ajax({
			url: 'SERVRegistro',
			type: 'POST',
			data: {cedula: cc, nombres: nom, apellidos: ape, edad: ed, correo: email},
			success:function(data){
				$("#result").html(data);
			},
			error:function(jq,es,error){
				console.log(es)
			}
		})
	}

	$("#btnEntrar").on('click', function(event) {
		event.preventDefault();
		iniciarSesion();
	});

	function iniciarSesion(){
		var email = $("#txtLogin").val();
		var pass = $("#txtPass").val();

		$.ajax({
			url: 'SERVlogin',
			type: 'POST',
			data: {login: email, password: pass},
			success: function(data){
				if(data!=null){
					console.log(data)
					location.reload();
				}else{
					console.log(data)
				}
			},
			error:function(jq,es,error){
				console.log(es)
			}
		})
	}

	$("#btnSalir").on('click', function(event) {
		event.preventDefault();
		cerrarSesion();
	});

	function cerrarSesion(){
		$.ajax({
			url: 'SERVLogout',
			type: 'POST',
			success: function(data){
				console.log(data)
				location.reload();
			},
			error:function(jq,es,error){
				console.log(es)
			}
		})
	}
        
        $("a#verReservas").on('click', function(event) {
		event.preventDefault();
		consultarReservas();
	});
        
        function consultarReservas(){
            var operacion = "consultaReservas";
            $.ajax({
                    url: 'SERVOperaciones',
                    type: 'POST',
                    data: {operacion: operacion},
                    success:function(data){
                           $("#result").html("<h3 class='text-center'>Usted tiene las siguientes reservas</h3><table class='table table-hover'>"+data+"</table>");
                    },
                    error:function(jq,es,error){
                            console.log(es);
                    }
            });
        }
});