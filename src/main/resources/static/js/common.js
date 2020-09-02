/**
 * @author milowang
 */

/**
 * 展示提示框
 * @param text 警告框的文本
 * @returns {Promise<>} 标志成功和失败的promise
 */
function showAlert(text) {

    // 返回一个一定会成功的promise
    return new Promise(resolve => {

        // 找到alert元素，设定到初始位置，变为可见
        $(".xf-alert").css("bottom", "10vh").text(text).show().animate({

            // 动画变换到指定位置
            bottom: '15vh'

            // 时长为100ms
        }, 100, () => {

            // 倒数两秒，淡出提示框
            setTimeout(() => {
                $(".xf-alert").fadeOut();

                // resolve promise
                resolve();
            }, 2000);
        })
    })

}