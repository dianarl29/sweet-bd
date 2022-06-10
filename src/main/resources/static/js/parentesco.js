$(document).ready(function(){
    mostrarParentescos();
});

//función mostrarParentescos
async function mostrarParentescos(){

    const request = await fetch('parentescos',{
        method: 'GET',
        headers:{
            'Accept': 'application/json',
            'Content-type':'application/json'
        }
    });

    const parentescos = await request.json();

    let i=1;
    let cabeza = '<option selected disabled value="">...Elije...</option>';
    let cmbParentescos = '';
    for(parentesco of parentescos){
        cmbParentescos += '<option value="'+ i +'">'+ parentesco.parent_tipo +'</option>';

    i++;
    }
    let cmbValor = cabeza + cmbParentescos;
    document.querySelector('#cmbParentesco').innerHTML = cmbValor;
}