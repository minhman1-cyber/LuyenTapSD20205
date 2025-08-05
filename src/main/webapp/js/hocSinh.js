function checkLogin(){
    let username = $('#username').val();
    let password = $('#password').val();

    $.ajax({
        url: '/hocsinh/dang-nhap1',
        type: 'POST',
        dataType: 'json',
        data: { username: username, password: password },
        success: function(response){
            if(response.success){
                window.location.href = response.redirect; // Chuyển trang nếu đăng nhập thành công
            } else {
                alert(response.message); // Hiển thị lỗi
            }
        },
        error: function(){
            alert("Lỗi hệ thống. Vui lòng thử lại sau.");
        }
    });
}
