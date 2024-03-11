// Función para mostrar el modal
function showEditForm(idBookDTO) {
    const modalContainer = document.getElementById('modalContainer' + idBookDTO);
    modalContainer.classList.add('active'); // Agrega la clase 'active' para mostrar el modal
}

// Función para ocultar el modal
function hideEditForm(idBookDTO) {
    const modalContainer = document.getElementById('modalContainer' + idBookDTO);
    modalContainer.classList.remove('active'); // Remueve la clase 'active' para ocultar el modal
}

function deleteBook(idBookDTO) {
    let baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikes_war/deleteBook?idBookDTO=" + idBookDTO;

    fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'text',
        },

    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("bookInfoDiv").innerHTML = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

function manageLikes(idBookDTO) {
    let baseUrl = window.location.protocol + "//" + window.location.host + "/BookLikes_war/likes?idBookDTO=" + idBookDTO;

    fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'text',
        },

    })
        .then(response => response.text())
        .then(data => {
            document.getElementById("likesManager" + idBookDTO).innerHTML = data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

