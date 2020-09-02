$(document).ready(() => {
    $(".add-button").click(e => {
        axios.post('/api/add_to_basket', {
            goodsId: e.target.dataset.goodsId
        }).then(res => {
            console.log("ok");
        })
    })
})