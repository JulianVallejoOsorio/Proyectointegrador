function obtenerCarrito() {
    return JSON.parse(localStorage.getItem("carrito")) || [];
}

function mostrarCarrito() {
    const carrito = obtenerCarrito();
    const contenedor = document.getElementById("carritoItems");
    contenedor.innerHTML = "";

    if (carrito.length === 0) {
        contenedor.innerHTML = "<p>Tu carrito está vacío.</p>";
        actualizarTotal(0);
        return;
    }

    let total = 0;

    carrito.forEach((producto, index) => {
        const item = document.createElement("div");
        item.classList.add("carrito-item");

        const precio = producto.precio || 0;
        const cantidad = producto.cantidad || 1;
        const subtotal = precio * cantidad;
        total += subtotal;

        item.innerHTML = `
      <img src="${producto.imagen}" alt="${producto.nombre}">
      <div>
        <h4>${producto.nombre}</h4>
        <p>Precio unitario: $${precio.toLocaleString()}</p>
        <label for="cantidad-${index}">Cantidad:</label>
        <input type="number" id="cantidad-${index}" min="1" value="${cantidad}" onchange="cambiarCantidad(${index}, this.value)">
        <p>Subtotal: $${subtotal.toLocaleString()}</p>
        <button onclick="eliminarDelCarrito(${index})">Eliminar</button>
      </div>
    `;

        contenedor.appendChild(item);
    });

    actualizarTotal(total);
}

function actualizarTotal(total) {
    const totalElemento = document.getElementById("totalCarrito");
    totalElemento.textContent = `Total: $${total.toLocaleString()}`;
}

function eliminarDelCarrito(index) {
    const carrito = obtenerCarrito();
    carrito.splice(index, 1);
    localStorage.setItem("carrito", JSON.stringify(carrito));
    mostrarCarrito();
}

function cambiarCantidad(index, nuevaCantidad) {
    const carrito = obtenerCarrito();
    const cantidad = parseInt(nuevaCantidad);

    if (isNaN(cantidad) || cantidad < 1) return;

    carrito[index].cantidad = cantidad;
    localStorage.setItem("carrito", JSON.stringify(carrito));
    mostrarCarrito();

    // Opcional: mensaje visual
    Swal.fire({
        toast: true,
        position: "top-end",
        icon: "success",
        title: "Cantidad actualizada",
        showConfirmButton: false,
        timer: 1200,
        background: "#e8f5e9",
        color: "#2e7d32",
    });
}
function finalizarCompra() {
    const carrito = obtenerCarrito();

    if (carrito.length === 0) {
        Swal.fire({
            icon: 'info',
            title: 'Tu carrito está vacío',
            text: 'Agrega productos antes de finalizar la compra.',
            timer: 2000,
            showConfirmButton: false,
        });
        return;
    }

    Swal.fire({
        title: '¿Confirmas la compra?',
        text: `Total a pagar: $${carrito.reduce((acc, p) => acc + (p.precio * (p.cantidad || 1)), 0).toLocaleString()}`,
        icon: 'question',
        showCancelButton: true,
        confirmButtonText: 'Sí, finalizar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            //servidor

            
            localStorage.removeItem("carrito");
            mostrarCarrito();

            Swal.fire({
                icon: 'success',
                title: 'Compra finalizada',
                text: 'Gracias por tu compra.',
                timer: 2500,
                showConfirmButton: false,
            });
        }
    });
}

document.getElementById("finalizarCompraBtn").addEventListener("click", finalizarCompra);

document.addEventListener("DOMContentLoaded", mostrarCarrito);
