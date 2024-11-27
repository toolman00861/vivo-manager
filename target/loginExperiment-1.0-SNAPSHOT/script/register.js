function submitForm() {
    let password = document.getElementById("password").value;
    if (!isPasswordValid(password)) {
        console.log("密码无效")
    }
    if (isPasswordValid(password)) {
        return true;
    }else{
        showValidationMessage();
        return false;
    }
}

/**
 * 校验密码是否有效
 * @param {string} password - 密码字符串
 * @returns {boolean} - 密码是否有效
 */
function isPasswordValid(password) {
    let hasUpperCase = /[A-Z]/.test(password);
    let hasLowerCase = /[a-z]/.test(password);
    let hasDigit = /\d/.test(password);
    let hasSpecialChar = /[!@#$%^&*().]/.test(password);
    let length = password.length >= 8;

    return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar && length;
}

/**
 * 显示验证失败的提示信息
 */
function showValidationMessage() {
    alert('密码必须至少8个字符，必须至少包含2个字母或2个数字，必须包含至少一个大写字母和一个小写字母');
}