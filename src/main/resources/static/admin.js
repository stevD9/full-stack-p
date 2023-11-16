$(document).ready(function() {
    const $showBtn = $(".showBtn");
    $showBtn.click(function() {
        const $name = $("#name").val();
        const $descr = $("#descr").val();

        let show = new Object();

        show.name = $name;
        show.description = $descr;

        let req = JSON.stringify(show);

        $.ajax({
            url: "http://localhost:8080/shows",
            type: "POST",
            data: req,
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(){
                alert("YEH YOU BEAUTIFUL THING");
            }});
    });
});