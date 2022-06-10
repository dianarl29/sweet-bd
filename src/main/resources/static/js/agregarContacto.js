$(document).ready(function(){

});

async function agregarContactos(){

    let datos = {};
    datos.cont_nombre = document.getElementById('txtNombre').value;
    datos.cont_apellido = document.getElementById('txtApellido').value;
    datos.cont_fecha_nacimiento = document.getElementById('txtFecha').value;
    datos.cont_numero_telefono = document.getElementById('txtTelefono').value;
    datos.cont_gustos = document.getElementById('txtGustos').value;
    datos.parent_id = parseInt(document.getElementById('cmbParentesco').value);

if(datos.cont_nombre == ''){
    alert("Falta el nombre");
    return;
}
if(datos.cont_fecha_nacimiento == ''){
    alert("Falta la fecha de nacimiento");
    return;
}
if(datos.cont_numero_telefono == ''){
    alert("Falta el número de teléfono");
    return;
}
if(datos.cont_gustos == ''){
    alert("Faltan los gustos");
    return;
}
if(datos.parent_id == ' '){
    alert("Falta el parentesco");
    return;
}

const request = await fetch('contactos',{
    method:'POST',
    headers:{
        'Accept': 'application/json',
        'Context-Type': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
    });

alert("Guardado el nuevo contacto");

}
