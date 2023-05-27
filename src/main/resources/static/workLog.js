'use strict'

const base = 'http://localhost:8089/';

window.addEventListener('load', async function (e) {
    e.preventDefault();
    const id = localStorage.getItem('worklog');
    const digits = id.match(/\d/g);
    const newId = digits.join('');
    await fetch(base + `worklogs?id=${newId}`)
        .then(response => response.json())
        .then(data => {
            removeChildWork();
           formWorklogs(data);
        });
});

function removeChildWork() {
    const created = document.getElementById('created');
    const description = document.getElementById('description');
    const time = document.getElementById('time');
    while (created.firstChild) {
        created.removeChild(created.firstChild);
        description.removeChild(description.firstChild);
        time.removeChild(time.firstChild);
    }
}

function formWorklogs(data) {
    for (const p of data) {
        const form = new FormData();
        form.append('time', p.time);
        form.append('created', p.created);
        form.append('description', p.description)
        createWorkLogs(form);
    }
}

function createWorkLogs(form) {
    const created = document.getElementById('created');
    const description = document.getElementById('description');
    const time = document.getElementById('time');

    const crea = document.createElement('p')
    crea.innerHTML = form.get('created');
    created.appendChild(crea);

    const desc = document.createElement('p');
    desc.innerHTML = form.get('description');
    description.appendChild(desc);

    const tim = document.createElement('p');
    tim.innerHTML = form.get('time');
    time.appendChild(tim);
}

const worklogButton = document.getElementById('worklog-button');
if (worklogButton) {
    worklogButton.addEventListener('click', worklogSend)
}

async function worklogSend(e) {
    e.preventDefault();
    const id = localStorage.getItem('worklog');
    const digits = id.match(/\d/g);
    const newId = digits.join('');
    const desc = document.getElementById('worklog-description').value;
    const time = document.getElementById('worklog-time').value;
    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
    await fetch(base + `work-save?id=${newId}&description=${desc}&time=${time}`, {
        method: 'POST',
        headers: {
            'Content-type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        }
    })
    const idW = localStorage.getItem('worklog');
    const digitsS = idW.match(/\d/g);
    const newIds = digitsS.join('');
    await fetch(base + `worklogs?id=${newIds}`)
        .then(response => response.json())
        .then(data => {
            removeChildWork();
            formWorklogs(data);
        });
}

