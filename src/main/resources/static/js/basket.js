$(document).ready(()=>{
    $(".clear-button").click(()=>{
        axios.post('/api/clear_basket',{}).then(()=>{
            showAlert("basket cleared!").then(()=>{
                location.reload();
            });
        })
    })
})