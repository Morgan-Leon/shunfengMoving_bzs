$(document).ready(function(){

  $("#btn-login").on('click', function() {
    event.preventDefault();
    /* Act on the event */
    var username = $("#username").val();
    var password = $("#password").val();

    $(this).attr("disabled", true).text("登录中...");
  //   $.ajax({
  //     type: 'GET',
  //     url: '/api/user/'+username,
  //     success:function(){
  //       window.location.href="./prototype/index.html";
  //     },
  //     error:function() {
  //       /* Act on the event */
  //
  //       alert("用户名密码错误");
  //       $("#btn-login").attr("disabled", false).text("登录");
  //     },
  //
  // });
  $.ajax({
    type: 'POST',
    url: '/api/login',
    contentType: "application/json",
    dataType: "json",
    data:JSON.stringify({ 'name': username,'password':password}),
    success:function(){
      window.location.href="./prototype/index.html";
    },
    error:function() {
      /* Act on the event */

      alert("用户名密码错误");
      $("#btn-login").attr("disabled", false).text("登录");
    },

});
});

});
