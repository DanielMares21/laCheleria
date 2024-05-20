const nombre = document.querySelector('#nombre');
const apellidoPaterno = document.querySelector('#apellido_paterno');
const apellidoMaterno = document.querySelector('#apellido_materno');
const email = document.querySelector('#email');
const telefono = document.querySelector('#telefono');
const direccion = document.querySelector('#direccion');
const form = document.querySelector('#formulario');
const mensaje = document.querySelector('#mensajes');

form.addEventListener('submit', function (event) {
    event.preventDefault();
    let error = `<div class='alert alert-danger' role='alert'>`;
    let centinela = false;
    const regExpNum = /^[0-9]+?$/;
    const regExpLetra = /^[a-zA-Z\s]+$/;
    const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    
    if (!regExpLetra.test(nombre.value)) {
        error += `<p>El campo Nombre solo debe contener letras.</p>`;
        centinela = true;
    }
    if (!regExpLetra.test(apellidoPaterno.value)) {
        error += `<p>El campo Apellido Paterno solo debe contener letras.</p>`;
        centinela = true;
    }
    if (!regExpLetra.test(apellidoMaterno.value)) {
        error += `<p>El campo Apellido Materno solo debe contener letras.</p>`;
        centinela = true;
    }
    if (!emailRegex.test(email.value)) {
        error += `<p>El campo Email debe contener un formato valido.</p>`;
        centinela = true;
    }
    if (!regExpNum.test(telefono.value)) {
        error += `<p>El campo Telefono debe contener solo números.</p>`;
        centinela = true;
    }

    if (centinela) {
        error += `</div>`;
        mensaje.innerHTML = error;
    } else {
        error = '';
   
    }
});

