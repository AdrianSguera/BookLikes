// Función para mostrar el modal
function showNewCommentForm() {
    const modalContainer = document.getElementById('modalContainer');
    modalContainer.classList.add('active'); // Agrega la clase 'active' para mostrar el modal
}

// Función para ocultar el modal
function hideNewCommentForm() {
    const modalContainer = document.getElementById('modalContainer');
    modalContainer.classList.remove('active'); // Remueve la clase 'active' para ocultar el modal
}