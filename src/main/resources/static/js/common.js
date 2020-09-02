function showAlert(text){
    $(".xf-alert").css("bottom", "10vh").text(text).show().animate({
        bottom: '15vh'
    }, 100, ()=>{
        setTimeout(()=>{
            $(".xf-alert").fadeOut();
        },2000);
    })
}