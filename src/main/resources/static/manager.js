'use strict'

const basic = 'http://localhost:8089/';

window.addEventListener('load', async function (e) {
    e.preventDefault();
    await fetch(basic + 'user/get-users')
        .then(response => response.json())
        .then(data => {
            for (const p of data) {
                const form = new FormData();
                form.append('name', p.name);
                form.append('id', p.id);
                createNames(form);
            }
        });
});

function createNames(form) {
    const select = document.getElementById('create-select');
    if (select) {
        const create = document.createElement('option');
        create.id = form.get('id');
        create.value = form.get('id');
        create.innerHTML = form.get('name');
        select.appendChild(create);
    }
}

const submitCreate = document.getElementById('submit-create')
if (submitCreate) {
    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
    submitCreate.addEventListener('click', async function (e) {
        e.preventDefault();
        const name = document.getElementById('select-input-name').value;
        let div = document.getElementById('create-select').value;
        const newId = parseInt(div);
        await fetch(basic + `save-task?name=${name}&id=${newId}`, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        })
    })
}