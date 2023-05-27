'use strict'

const basicUrl = 'http://localhost:8089/';

window.addEventListener('load', async function (e) {
    e.preventDefault();
    await fetch(basicUrl + 'user/current-user')
        .then(response => {
            if (!response.ok) {
                throw new Error('Ошибка получения данных');
            }
            return response.json();
        })
        .then(data => {
            //исчезновение кнопки и появление data.user
        });
});

window.addEventListener('load', async function (e) {
    e.preventDefault();
    await fetch(basicUrl + 'tasks')
        .then(response => response.json())
        .then(data => {
            removeChild();
            createTasks(data);
        });
});

function createTasks(data) {
    const num = data.length;
    const numString = data.length + 'num';
    if (numString === '4num') {
        const sum = num / 4;
        const roundedNum = Math.ceil(sum);
        for (let i = 0; i < roundedNum; i++) {
            const number = document.createElement('button');
            const pages = document.getElementById('pages');
            const summa = i + 1;
            const idButton = document.getElementById('page-' + summa);
            if (!idButton) {
                number.type = 'button';
                number.innerHTML = summa;
                number.id = 'page-' + i;
                number.setAttribute('onclick', 'nextPage("page-' + summa + '", event)');
                pages.appendChild(number);
            }
        }
    }
    for (const p of data) {
        const form = new FormData();
        form.append('name', p.name);
        form.append('status', p.status);
        form.append('username', p.username);
        form.append('id', p.id);
        insertProductsElem(form);
    }
}

function insertProductsElem(form) {
    const id = document.getElementById('PName');
    const nameDiv = document.getElementById('name');
    const statusDiv = document.getElementById('status');
    const developerDiv = document.getElementById('developer');
    if (!id) {
        const name = document.createElement('p');
        name.innerHTML = 'Name';
        name.id = 'PName';
        name.style.fontWeight = 'bold';
        name.classList.add('lineTask');
        nameDiv.appendChild(name);

        const status = document.createElement('p');
        status.innerHTML = 'Status';
        status.classList.add('lineTask');
        status.style.fontWeight = 'bold';
        statusDiv.appendChild(status);

        const developer = document.createElement('p');
        developer.innerHTML = 'Developer';
        developer.classList.add('lineTask');
        developer.style.fontWeight = 'bold';
        developerDiv.appendChild(developer);
    }
    const names = document.createElement('p');
    names.innerHTML = form.get('name');
    names.classList.add('lineTask');
    nameDiv.appendChild(names);

    const statuses = document.createElement('p');
    statuses.innerHTML = form.get('status');
    statuses.classList.add('lineTask');
    statusDiv.appendChild(statuses);

    const developers = document.createElement('p');
    developers.innerHTML = form.get('username');
    developers.classList.add('lineTask');
    developerDiv.appendChild(developers);
}

async function nextPage(id, event) {
    event.preventDefault();
    const digits = id.match(/\d/g);
    const newId = digits.join('');
    await fetch(basicUrl + `tasks?page=${newId}`)
        .then(response => response.json())
        .then(data => {
            removeChild();
            createTasks(data);
        });
}

function removeChild() {
    const element = document.getElementById('name');
    const elem = document.getElementById('status');
    const develop = document.getElementById('developer');
    while (element.firstChild) {
        element.removeChild(element.firstChild);
        elem.removeChild(elem.firstChild);
        develop.removeChild(develop.firstChild);
    }
}

const loginButton = document.getElementById('login-button');
window.addEventListener('load', async function (e) {
    await fetch(basicUrl + 'user/current-user').then(response => {
        if (!response.ok) {
            throw new Error('Ошибка получения данных');
        }
        return response.json();
    }).then(data => {
        console.log(data.user)
        const username = document.getElementById('username');
        const logout = document.getElementById('logout-button');
        if (loginButton) {
            if (data.user) {
                username.innerHTML = data.user;
                username.style.display = 'block';
                loginButton.style.display = 'none';
                logout.style.display = 'block';
            } else {
                username.innerHTML = '';
                username.style.display = 'none';
                loginButton.style.display = 'block';
                logout.style.display = 'none';
            }
        }
    });
});