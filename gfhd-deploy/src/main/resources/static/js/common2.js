//撖潸⏛
$(".nav li:last").addClass("navbr");
//banner
$(".banner").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"fold",autoPlay:true,interTime:5000,delayTime:2000});

//weixin
$(".m-wx").hover(function(){
    $(this).children(".fenxiang").toggle(400);
});