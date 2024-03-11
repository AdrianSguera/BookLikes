document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.getElementById('searchInput');
    const books = document.querySelectorAll('.card');

    searchInput.addEventListener('input', function() {
        const searchTerm = searchInput.value.trim().toLowerCase();

        // Filtra los libros que coincidan con el término de búsqueda
        books.forEach(book => {
            const title = book.querySelector('.card-title').innerText.toLowerCase();
            const author = book.querySelector('.card-author').innerText.toLowerCase();

            // Muestra u oculta el libro según si coincide con el término de búsqueda
            if (title.includes(searchTerm) || author.includes(searchTerm)){
                book.style.display = 'block'; // Muestra el libro
            } else {
                book.style.display = 'none'; // Oculta el libro
            }
        });
    });
});