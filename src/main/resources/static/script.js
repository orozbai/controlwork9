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
            //исчезновение кнопки и появление
        });
})