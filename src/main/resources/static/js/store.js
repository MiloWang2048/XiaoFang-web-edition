$(document).ready(() => {
    $(".add-button").click(e => {
        axios.post('/api/add_to_basket', {
            goodsId: e.target.dataset.goodsId
        }).then(res => {
            showAlert(e.target.dataset.goodsName+" added to basket!");
        })
    })
})