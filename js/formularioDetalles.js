
    const idDetallePedido = document.querySelector('#id_detalle_pedido');
    const idCliente = document.querySelector('#id_cliente');
    const idProducto = document.querySelector('#id_producto');
    const fecha = document.querySelector('#fecha');
    const cantidad = document.querySelector('#cantidad');
    const unidad = document.querySelector('#unidad');
    const precioUnitario = document.querySelector('#precio_unitario');
    const subtotal = document.querySelector('#subtotal');
    const fechaEntrega = document.querySelector('#fecha_entrega');
    const form = document.querySelector('#formulario');
    const mensaje = document.querySelector('#mensajes');

    form.addEventListener('submit', function (event) {
        event.preventDefault();
        let error = `<div class='alert alert-danger' role='alert'>`;
        let centinela = false;
        const regExpNum = /^[0-9]+?$/;
        const regExpDate = /^(0[1-9]|[1-2]\d|3[01])\/(0[1-9]|1[012])\/(\d{2}|\d{4})$/;

        if (!regExpNum.test(idDetallePedido.value)) {
            error += `<p>El campo ID del detalle de pedido debe contener solo números.</p>`;
            centinela = true;
        }
        if (!regExpNum.test(idCliente.value)) {
            error += `<p>El campo ID del cliente debe contener solo números.</p>`;
            centinela = true;
        }
        if (!regExpNum.test(idProducto.value)) {
            error += `<p>El campo ID del producto debe contener solo números.</p>`;
            centinela = true;
        }
        if (!regExpDate.test(fecha.value)) {
            error += `<p>Debes ingresar una fecha válida (dd/mm/aa).</p>`;
            centinela = true;
        }
        if (!regExpNum.test(cantidad.value)) {
            error += `<p>El campo cantidad debe contener solo números.</p>`;
            centinela = true;
        }
        if (!regExpNum.test(unidad.value)) {
            error += `<p>El campo unidad debe contener solo números.</p>`;
            centinela = true;
        }
        if (!regExpNum.test(precioUnitario.value)) {
            error += `<p>El campo precio unitario debe contener solo números.</p>`;
            centinela = true;
        }
        if (!regExpNum.test(subtotal.value)) {
            error += `<p>El campo subtotal debe contener solo números.</p>`;
            centinela = true;
        }
        if (!regExpDate.test(fechaEntrega.value)) {
            error += `<p>Debes ingresar una fecha válida de entrega (dd/mm/aa).</p>`;
            centinela = true;
        }

        if (centinela) {
            error += `</div>`;
            mensaje.innerHTML = error;
        } else {
            error = '';
            limpiar();
        }
    });

    function limpiar() {
        idDetallePedido.value = '';
        idCliente.value = '';
        idProducto.value = '';
        fecha.value = '';
        cantidad.value = '';
        unidad.value = '';
        precioUnitario.value = '';
        subtotal.value = '';
        fechaEntrega.value = '';
    }
