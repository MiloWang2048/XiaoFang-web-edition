/**
 * @author milowang
 */

// 文档加载完成后
$(document).ready(() => {

    // 点击清除按钮时
    $(".clear-button").click(() => {

        // 调用清除接口
        axios.post('/api/clear_basket', {}).then(() => {

            // 成功时展示警告框
            showAlert("basket cleared!").then(() => {

                // 刷新页面
                location.reload();
            });
        })
    })

    // 点击结算按钮时
    $(".checkout-button").click(() => {

        // 调用结算按钮
        axios.post('/api/checkout', {}).then(res => {

            // 提示金额
            alert(`$${res.data} please!\nThank you!`);
        })
    })
})