/**
 * @author milowang
 */

/**
 * 脚本函数，当文档加载完成后执行
 */
$(document).ready(() => {

    // 点击添加购物车按钮时
    $(".add-button").click(e => {

        // 发起post请求，发送商品ID
        axios.post('/api/add_to_basket', {
            goodsId: e.target.dataset.goodsId
        }).then(res => {

            // 完成后提示
            showAlert(e.target.dataset.goodsName+" added to basket!");
        })
    })
})