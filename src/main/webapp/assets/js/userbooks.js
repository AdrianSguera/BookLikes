function buscarLibro() {
    const inputBusqueda = document.getElementById('inputBusqueda').value.toLowerCase();
    const rows = document.querySelectorAll('#tablaLibros tbody tr');

    rows.forEach(function(row) {
        const titulo = row.cells[1].innerText.toLowerCase();
        if (titulo.includes(inputBusqueda)) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}