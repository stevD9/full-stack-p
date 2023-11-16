$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/users"
    }).then(function(response) {
       const $card = $('<div>').addClass("users").appendTo('body');

        for (let i = 0; i < response.length; i++) {
               $('<h3>').addClass('id').text("id: " + response[i].id).appendTo($card);
               $('<p>').addClass('name').text("Name : " + response[i].firstName + " " + response[i].lastName).appendTo($card);
               $('<p>').addClass('email').text("Email : " + response[i].email).appendTo($card);
        }
    });
});