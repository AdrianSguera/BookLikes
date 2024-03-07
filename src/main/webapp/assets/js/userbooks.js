window.onload=()=>{}
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
function borrar(idlibro){
    var baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikes/mybooks?idlibro="+idlibro;

    fetch(baseUrl, {
        method: 'POST', // Puedes cambiar este método según tu necesidad (POST, PUT, DELETE, etc.)
        headers: {
            'Content-Type': 'text', // Puedes ajustar el tipo de contenido según tu necesidad
        },
        // Puedes agregar otros parámetros como body si estás enviando datos
    })
        .then(response => response.text()) // Procesamos la respuesta como JSON
        .then(data => {
            document.getElementById("tabladelibros").innerHTML=data;
            console.log(data);
        })
        .catch(error => {
            console.error('Error:', error); // Manejamos los errores
        });

}