$(document).ready(function(){
    mostrarContactos();
});

//función mostrarContactos
async function mostrarContactos(){

    const request = await fetch('contacto',{
        method: 'GET',
        headers:{
            'Accept': 'application/json',
            'Content-type':'application/json'
        }
    });

    const contactos = await request.json();

    let i=0;

    for(contacto of contactos){

        const request = await fetch('pariente/'+ contacto.parent_id, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        const parentesco = await request.json();

        let tarjetaHTML =
        '<div class="card mx-auto m-fluid m-4" style="background-color: #DF78EF">'+
                 				'<div class="accordion accordion-flush" id="ejemplo'+i+'" > <!--inicio de acordion-->'+
             				  		'<div class="accordion-item" >'+
             				  			'<h2 class="accordion-header" id="encabezado'+i+'" style="background-color: #DF78EF"><!--cabeza de acordion-->'+
                     				  		'<div class="card-body">'+
                     				    		'<div class="row">'+
                     				    			'<div class="col" id="nombre">'+ contacto.cont_nombre+'</div>'+
                     				    			'<div class="col"><a href="https://web.whatsapp.com/"><i class="bi bi-chat-square-text-fill" style="color: black" title="WHATSAPP"></i></a></div>'+
                     				    			'<div class="col"><a href="#"><i class="bi bi-telephone-outbound-fill" style="color: black" title="LLAMAR"></i></a></div>'+
                     				    			'<div class="col ">foto</div>'+
                                                     '<div class="col-xl-1"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#aco'+i+'" aria-expanded="false" aria-controls="aco'+i+'" style="background-color: #DF78EF"></button></div>'+
                     				    		'</div>'+
                     				    	'</div>'+
             				  			'</h2>'+
             				  			'<div id="aco'+i+'" class="accordion-collapse collapse" aria-labelledby="encabezado'+i+'" data-bs-parent="#ejemplo'+i+'">'+
             				  				'<div class="accordion-body">'+
             				  					'<!--aqui va toda la información del contacto-->'+
             				  					'<div class="row"><!--fotografía-->'+
                                                     '<div class="col-4 ">foto</div>'+
                                                     '<div class="col-7 ">INFORMACIÓN'+
                                                         '<div class="row " id="nombre"> Nombre: '+
                                                             contacto.cont_nombre+
                                                         '</div>'+
                                                         '<div class="row" id="años"> Apellido: '+
                                                             contacto.cont_apellido+
                                                         '</div>'+
                                                         '<div class="row " id="fechanaci"> Fecha nacimiento: '+
                                                             contacto.cont_fecha_nacimiento+
                                                         '</div>'+
                                                         '<div class="row " id="parentesco"> Parentesco: '+
                                                             parentesco.parent_tipo +
                                                         '</div>'+
                                                         '<div class="row " id="telefono"> Teléfono: '+
                                                             contacto.cont_numero_telefono+
                                                         '</div>'+
                                                         '<div class="row " id="gustos"> Gustos: '+
                                                             contacto.cont_gustos+
                                                         '</div>'+
                                                         '<div class="row ">'+
                                                             '<div class="col">'+
                                                             '<a href="#" onclick="eliminar('+contacto.cont_id+')"><i class="bi bi-trash3-fill" style="color: black" title="ELIMINAR"></i></a>'+
                                                             '</div>'+
                                                             '<div class="col-4 col-sm-9"></div>'+
                                                             '<div class="col">'+
                                                             '<a href="editar.html" onclick="localStorage.id= ' +contacto.cont_id +'"><i class="bi bi bi-pen-fill" style="color: black" title="EDITAR"></i></a>'+
                                                             '</div>'+
                                                         '</div>'+
                                                     '</div>'+
                                                 '</div>'+
             				  				'</div>'+
               							'</div>'+
               						'</div>'+
               					'</div>'+
                 			'</div>';
        document.querySelector('#contactoComponente').innerHTML += tarjetaHTML;
        i++;
    }
}

//función para eliminar
async function eliminar(cont_id){
    if(!confirm("¿Quieres eliminar el contacto?")){
        return;
    }
    const request = await fetch('contacto/'+cont_id,{
        method: 'DELETE',
        headers:{
            'Accept': 'application/json',
            'Context-Type': 'application/json'
        }
    });
    location.reload();
}

