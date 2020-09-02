$(document).ready(() => {
    $(".clear-button").click(() => {
        axios.post('/api/clear_basket', {}).then(() => {
            showAlert("basket cleared!").then(() => {
                location.reload();
            });
        })
    })

    $(".checkout-button").click(() => {
        axios.post('/api/checkout', {}).then(res => {
            alert(`$${res.data} please!\nThank you!`);
        })
    })
})