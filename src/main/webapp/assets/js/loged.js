window.onload = () => {
};

//function newfavorito(idlibro, idusuario) {
    /*var baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikes/api/?idlibro=" + idlibro + "&idusuario=" + idusuario;

    fetch(baseUrl, {
        headers: {
            'Content-Type': 'text/plain', // Corregido el tipo de contenido
        },
    })
        .then(response => response.text())
        .then(data => {
            document.body.innerHTML = data; // Cambiado de document.getElementById("libros").innerHTML
        })
        .catch(error => {
            console.error('Error:', error);
        });
        }

     */
// scripts.js
function cambiarTabla() {
    const tablaLibros = document.getElementById('tablaLibros');
    const tablaLibrosFav = document.getElementById('tablaLibrosFav');
    const btnCambiarTabla = document.getElementById("cambiarTabla");

    if (tablaLibrosFav.style.display !== 'none') {
        tablaLibrosFav.style.display = 'none';
        tablaLibros.style.display = 'table';
        btnCambiarTabla.textContent = "Mostrar libros favoritos"
    } else {
        tablaLibros.style.display = 'none';
        tablaLibrosFav.style.display = 'table';
        btnCambiarTabla.textContent = "Mostrar todos los libros"
    }
}
var resultadosBusqueda = [];

function buscarLibro() {
    var inputBusqueda = document.getElementById('inputBusqueda').value.toLowerCase();
    var rows = document.querySelectorAll('#tablaLibros tbody tr');

    // Limpiar los resultados anteriores
    resultadosBusqueda = [];

    rows.forEach(function(row) {
        var titulo = row.cells[1].innerText.toLowerCase();
        if (titulo.includes(inputBusqueda)) {
            row.style.display = '';
            resultadosBusqueda.push(row);
        } else {
            row.style.display = 'none';
        }
    });
}

function newfavorito(idlibro,iduser){
    const baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikes_war/loged?idlibro=" + idlibro + "&idUser=" + iduser;

    fetch(baseUrl, {
        method: 'POST', // Puedes cambiar este método según tu necesidad (POST, PUT, DELETE, etc.)
        headers: {
            'Content-Type': 'text', // Puedes ajustar el tipo de contenido según tu necesidad
        },
        // Puedes agregar otros parámetros como body si estás enviando datos
    })
        .then(response => response.text()) // Procesamos la respuesta como JSON
        .then(data => {
            document.getElementById("tabladeLibrosFav").innerHTML=data;
        })
        .catch(error => {
            console.error('Error:', error); // Manejamos los errores
        });
}

function deletefavorito(idlibro,iduser,titulo){
    const baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikes_war/loged?idlibro=" + idlibro + "&idUser=" + iduser + "&titulo" + titulo;

    fetch(baseUrl, {
        method: 'POST', // Puedes cambiar este método según tu necesidad (POST, PUT, DELETE, etc.)
        headers: {
            'Content-Type': 'text', // Puedes ajustar el tipo de contenido según tu necesidad
        },
        // Puedes agregar otros parámetros como body si estás enviando datos
    })
        .then(response => response.text()) // Procesamos la respuesta como JSON
        .then(data => {
            document.getElementById("tabladeLibrosUser").innerHTML=data;
        })
        .catch(error => {
            console.error('Error:', error); // Manejamos los errores
        });
}
