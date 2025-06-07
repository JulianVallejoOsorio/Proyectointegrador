const productos = [
  {
    id: 1,
    nombre: "Tijeras de Poda",
    categoria: "Herramientas",
    precio: 25000,
    imagen:
      "https://github.com/JulianVallejoOsorio/Proyectointegrador/blob/main/src/images/productos/fs120R-removebg-preview.png?raw=true",
  },
  {
    id: 2,
    nombre: "Guantes de Jardinería",
    categoria: "Accesorios",
    precio: 10000,
    imagen:
      "https://github.com/JulianVallejoOsorio/Proyectointegrador/blob/main/src/images/productos/fs120R-removebg-preview.png?raw=true",
  },
  {
    id: 3,
    nombre: "Regadera Manual",
    categoria: "Herramientas",
    precio: 18000,
    imagen: "img/regadera.jpg",
  },
  {
    id: 4,
    nombre: "Planta de Interior",
    categoria: "Plantas",
    precio: 35000,
    imagen: "img/planta.jpg",
  },
  {
    id: 5,
    nombre: "Manguera Flexible",
    categoria: "Accesorios",
    precio: 28000,
    imagen: "img/manguera.jpg",
  },
];

function mostrarProductos(productosFiltrados) {
  const grid = document.getElementById("productGrid");
  grid.innerHTML = "";

  if (productosFiltrados.length === 0) {
    grid.innerHTML = "<p>No se encontraron productos.</p>";
    return;
  }

  productosFiltrados.forEach((producto) => {
    const card = document.createElement("div");
    card.classList.add("product-card");
    card.innerHTML = `
      <img src="${producto.imagen}" alt="${producto.nombre}">
      <h3>${producto.nombre}</h3>
      <p>$${producto.precio.toLocaleString()}</p>
      <button onclick="agregarAlCarrito(${producto.id
      })">Agregar al carrito</button>
    `;
    grid.appendChild(card);
  });
}

function filtrarProductos() {
  const textoBusqueda = document
    .getElementById("searchInput")
    .value.toLowerCase();
  const checkboxes = document.querySelectorAll(
    ".filters input[type='checkbox']"
  );
  const categoriasSeleccionadas = Array.from(checkboxes)
    .filter((ch) => ch.checked)
    .map((ch) => ch.value);

  const productosFiltrados = productos.filter((prod) => {
    const coincideCategoria =
      categoriasSeleccionadas.length === 0 ||
      categoriasSeleccionadas.includes(prod.categoria);
    const coincideBusqueda = prod.nombre.toLowerCase().includes(textoBusqueda);
    return coincideCategoria && coincideBusqueda;
  });

  mostrarProductos(productosFiltrados);
}

function agregarAlCarrito(idProducto) {
  const producto = productos.find((p) => p.id === idProducto);
  if (!producto) return;

  let carrito = JSON.parse(localStorage.getItem("carrito")) || [];
  const index = carrito.findIndex((item) => item.id === idProducto);
  if (index >= 0) {
    carrito[index].cantidad += 1;
  } else {
    carrito.push({ ...producto, cantidad: 1 });
  }

  localStorage.setItem("carrito", JSON.stringify(carrito));
  alert(`"${producto.nombre}" agregado al carrito`);
}

document.addEventListener("DOMContentLoaded", () => {
  mostrarProductos(productos);
});
