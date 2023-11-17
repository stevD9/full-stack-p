$(document).ready(function() {
    const $registerBtn = $(".registerBtn");
    $registerBtn.click(function() {
        const $fname = $("#fname").val();
        const $lname = $("#lname").val();
        const $email = $("#email").val();

        let user = new Object();

        user.firstName = $fname;
        user.lastName = $lname;
        user.email = $email;

        let req = JSON.stringify(user);

        $.ajax({
            url: "http://localhost:8080/users",
            type: "POST",
            data: req,
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(){
                alert("YEH YOU CUNT");
            }});
    });
});