function showAlert(text){
    return new Promise(resolve=>{
        $(".xf-alert").css("bottom", "10vh").text(text).show().animate({
            bottom: '15vh'
        }, 100, ()=>{
            setTimeout(()=>{
                $(".xf-alert").fadeOut();
                resolve();
            },2000);
        })
    })

}