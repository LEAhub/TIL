

$(document).ready(function(){
    $(".button_shop").hide();
    $("#button_shop").mouseover(function(){
        $(".button_shop").show();
    });

    $(".button_shop").mouseover(function(){
        $(".button_shop").show();
    });

    $(".button_shop").mouseout(function(){
        $(".button_shop").hide();
    });

    // var imageUrl = "../breezefy_clone_coding/cherryblossom.png";
    // document.getElementById(img_phone5).style.backgroundImage = "url('" + imageUrl + "')";



    // $("#img_phone5").mouseover(function(){
    //     var imageUrl = "../breezefy_clone_coding/cherryblossom.png";
    //     var back = document.getElementById("img_phone5");
    //     back.style.backgroundImage= "url('" + imageUrl + "')";
    // });
    //
    // $("#img_phone5").mouseout(function(){
    //     var back = document.getElementById("img_phone5");
    //     back.style.backgroundImage= "none";
    // });
    //
    // $("#img_phone5").mouseout(function(){
    //     console.log(document.getElementById("img_phone5"))
    // });

    $(window).scroll(function () {
          if ($(this).scrollTop() > 200) {
            $('.move_page').fadeIn(500);
          } else {
            $('.move_page').fadeOut('slow');
          }
        });
        $('.move_up').click(function (e) {
          e.preventDefault();
          $('html, body').animate({scrollTop: 0}, 200);
    });

});

function backImg(instance){
    const backImglist = ["cherryblossom.png", "apple.png", "orangeColorFlower.png"
        ,"leaf.png", "lemon.png","deepsea.png","neon.png", "violet.png", "purple.png"];

    console.log(instance);
    console.log(typeof(instance["id"]));
    const getId = instance["id"];
    for(var i = 0; i < backImglist.length; i++){
        if(getId.includes(i)){
            var imageUrl = "../breezefy_clone_coding/"+backImglist[i];
            var back = document.getElementById(getId);
            back.style.transition = "all 0.5s ease-in-out";
            back.style.backgroundImage= "url('" + imageUrl + "')";
        }
    }
}

function removeBackImg(instance){
    const getId = instance["id"];
    var back = document.getElementById(getId);
        back.style.backgroundImage= "none";
}
    // var lis = document.getElementsByClassName("phones");
    //
    // for(var i = 0; i < lis.length; i++){
    //     if(i == 5){
    //     console.log(lis[i].getElementsByTagName("img")[0]["id"]);
    //     }
    // }
