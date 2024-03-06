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
    var tablaLibros = document.getElementById('tablaLibros');
    var librosFav =  document.getAttribute("librosfav") ;
    if (librosFav) {
        tablaLibros.innerHTML = librosFav;
    }
}

function buscarLibro() {
    var inputBusqueda = document.getElementById('inputBusqueda').value.toLowerCase();
    var rows = document.querySelectorAll('#tablaLibros tbody tr');

    rows.forEach(function(row) {
        var titulo = row.cells[1].innerText.toLowerCase();
        if (titulo.includes(inputBusqueda)) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}
    function newfavorito(idlibro, idusuario) {
        $.ajax({
            type: "POST",
            url: "api", // Reemplaza "apiservlet" con la URL correcta de tu API
            data: {
                idlibro: idlibro,
                idusuario: idusuario
            },
            success: function(response) {
                // Manejar la respuesta de la API aquí
                alert("Favorito agregado correctamente");
            },
            error: function(xhr, status, error) {
                // Manejar el error de la solicitud AJAX aquí
                alert("Error al agregar favorito: " + error);
            }
        });
}