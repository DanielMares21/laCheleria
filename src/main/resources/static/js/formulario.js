const precio = document.querySelector('#precio');
const tipo = document.querySelector('#tipo');
const marca = document.querySelector('#marca');
const cantidad = document.querySelector('#cantidad_disponible');
const form = document.querySelector('#formulario');
const  _mensaje = document.querySelector('#mensajes');



form.addEventListener('submit', (event) => {

    event.preventDefault();
    let error = `<div class='alert alert-danger' role='alert'>`;
    let centinela = false;
    const regExpLetras = /^[a-zA-Z À-Ÿ\s]{1,40}$/;
    let regExpnum = /^[0-9]+?$/;

    if (!regExpnum.test(precio.value)) {
        error += `<p>El campo precio solo acepta números</p>`;
        centinela = true;
    }
    if(!regExpLetras.test(tipo.value)){
        error+=`<p>El campo tipo solo acepta, Minusculas, Mayusculas y espacios </p>`;
        centinela=true;
    }
    if(!regExpLetras.test(marca.value)){
        error+=`<p>El campo marca solo acepta, Minusculas, Mayusculas y espacios</p>`;
        centinela=true;
    }
    if(!regExpnum.test(cantidad.value)){
        error+=`<p>El campo cantidad solo acepta números </p>`;
        centinela=true;
    }
   
    if (centinela) {
        error += `</div>`;
        _mensaje.innerHTML = error;
    } else {
        error = '';
    }
});

