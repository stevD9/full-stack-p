$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/shows"
    }).then(function(response) {
       const $card = $('<div>').addClass("shows").appendTo('body');

        for (let i = 0; i < response.length; i++) {
               $('<h3>').addClass('name').text("Name: " + response[i].name).appendTo($card);
               $('<p>').addClass('descr').text(response[i].description).appendTo($card);
        }
    });
});