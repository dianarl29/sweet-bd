$(document).ready(function(){

});
//función para editar
async function editar(){

let cont_id= localStorage.id;
let dato = {};
dato.cont_id = cont_id;
dato.parent_id = document.getElementById('cmbParentesco').value;

const request = await fetch('editar', {
        method:'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dato)
    });
location.reload();

alert("Ya se edito");
}

