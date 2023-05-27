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

const stat = document.getElementById('status-select-button');
if (stat) {
    stat.addEventListener("click", async function (e) {
        e.preventDefault();
        const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
        const name = document.getElementById('status-select').value;
        await fetch(base + `status?name=${name}`, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        })
    })
}

async function getFile() {
    const id = localStorage.getItem('worklog');
    const digits = id.match(/\d/g);
    const newId = digits.join('');
    await fetch(base + `file?id=${newId}`).then(response => response.text())
        .then(data => {
            console.log(data)
            const fileDiv = document.createElement('div');
            const elem = document.getElementById('worklog');
            const fileLink = document.createElement('a');
            fileLink.innerText = data;
            fileLink.addEventListener('click', () => getFiles(data));
            const button = document.createElement('button');
            button.appendChild(fileLink);
            fileDiv.appendChild(button);
            elem.appendChild(fileDiv);
        })
}

async function getFiles(fileName) {
    await fetch(`static/${fileName}`)
        .then(response => response.blob())
        .then(blob => {
            const link = document.createElement('a');
            link.href = URL.createObjectURL(blob);
            link.download = fileName;
            link.click();
        }).catch(error => {
            console.log('error: ', error);
        })
}

async function uploadFile() {
    const file = document.getElementById('file-input');
    const id = localStorage.getItem('worklog');
    const digits = id.match(/\d/g);
    const newId = digits.join('');
    const formData = new FormData();
    formData.append('file', file.files[0]);
    formData.append('id', newId);
    const csrfToken = document.querySelector('meta[name="csrf-token"]').getAttribute('content');
    await fetch(base + 'upload-files', {
        method: 'POST',
        headers: {
            'X-CSRF-TOKEN': csrfToken
        },
        body: formData
    })
    await getFile();
}