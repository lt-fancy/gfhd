
//����堒之撠誩��揢

function fontZoom(size)
{
    document.getElementById('con').style.fontSize=size+'px';
}


//霂餃�𤥁祕��蝧駁△
(function($){
    $.fn.contentPages = function(newsid){

        $("div#contentpages").empty();

        $.ajax({
            type: "POST",
            url:PDV_RP+"news/post.php",
            data: "act=contentpages&newsid="+newsid,
            success: function(msg){
                $("div#contentpages").append("<ul>");
                $("div#contentpages").append("<li id='pl' class='cbutton'>銝𠹺�憿�</li>");
                $("div#contentpages").append(msg);
                $("div#contentpages").append("<li id='pn' class='pbutton'>銝衤�憿�</li>");
                $("div#contentpages").append("</ul>");
                //$("li#pl").hide();


                var getObj = $('li.pages');

                if(getObj.length<2){
                    $("div#contentpages").hide();
                    $().setBg();
                    return false;
                }

                $('li.pages')[0].className='pagesnow';

                getObj.each(function(id) {

                    var obj = this.id;

                    $("li#"+obj).click(function() {

                        $('li.pagesnow')[0].className="pages";
                        this.className='pagesnow';
                        var clickid=obj.substr(2);
                        $().getContent(newsid,clickid);
                        if($(".pagesnow").next()[0].id=="pn"){$("li#pn")[0].className="cbutton";}else{$("li#pn")[0].className="pbutton";}
                        if($(".pagesnow").prev()[0].id=="pl"){$("li#pl")[0].className="cbutton";}else{$("li#pl")[0].className="pbutton";}


                    });

                });


                //銝𠹺�憿�
                $("li#pl").click(function() {
                    if($("li#pl")[0].className=="pbutton"){
                        var nowObj=$(".pagesnow").prev()[0].id;
                        var nextpageid=nowObj.substr(2);
                        $().getContent(newsid,nextpageid);
                        $('li.pagesnow')[0].className="pages";
                        $("#"+nowObj)[0].className="pagesnow";
                        if($(".pagesnow").prev()[0].id=="pl"){$("li#pl")[0].className="cbutton";}else{$("li#pl")[0].className="pbutton";}
                        if($(".pagesnow").next()[0].id=="pn"){$("li#pn")[0].className="cbutton";}else{$("li#pn")[0].className="pbutton";}

                    }else{
                        return false;
                    }


                });


                //銝衤�憿�
                $("li#pn").click(function() {
                    if($("li#pn")[0].className=="pbutton"){
                        var nowObj=$(".pagesnow").next()[0].id;
                        var nextpageid=nowObj.substr(2);
                        $().getContent(newsid,nextpageid);
                        $('li.pagesnow')[0].className="pages";
                        $("#"+nowObj)[0].className="pagesnow";
                        if($(".pagesnow").prev()[0].id=="pl"){$("li#pl")[0].className="cbutton";}else{$("li#pl")[0].className="pbutton";}
                        if($(".pagesnow").next()[0].id=="pn"){$("li#pn")[0].className="cbutton";}else{$("li#pn")[0].className="pbutton";}

                    }else{
                        return false;
                    }
                });

            }
        });
    };
})(jQuery);


//霂餃�𤥁祕蝏���摰�

(function($){
    $.fn.getContent = function(newsid,newspageid){

        $.ajax({
            type: "POST",
            url:PDV_RP+"news/post.php",
            data: "act=getcontent&newspageid="+newspageid+"&newsid="+newsid+"&RP="+PDV_RP,
            success: function(msg){
                $("#con").html(msg);
                $("#con").find("img").each(function(){
                    if(this.offsetWidth>600){
                        this.style.width="600px";
                    }
                });
                $().setBg();
            }
        });
    };
})(jQuery);


//霂行���㦛���偕撖詨���
$(window).load(function(){
    $("#con").find("img").hide();
    var w=$("#con")[0].offsetWidth;
    $("#con").find("img").each(function(){
        $(this).show();
        if(this.offsetWidth>w){
            this.style.width=w + "px";
            $().setBg();
        }
    });

});


//�𣈲����滚笆��閧巨
$(document).ready(function(){

    $("span#zhichi").click(function(){

        var newsid=$("input#newsid")[0].value;

        $.ajax({
            type: "POST",
            url:PDV_RP+"news/post.php",
            data: "act=zhichi&newsid="+newsid,
            success: function(msg){
                if(msg=="L0"){
                    $().popLogin(0);
                }else if(msg=="L1"){
                    $().alertwindow("撖嫣�滩絲嚗峕�典歇蝏𤩺�閗��巨鈭�","");
                }else{
                    $("span#zhichinum").html(msg);
                }
            }
        });
    });


    $("span#fandui").click(function(){

        var newsid=$("input#newsid")[0].value;

        $.ajax({
            type: "POST",
            url:PDV_RP+"news/post.php",
            data: "act=fandui&newsid="+newsid,
            success: function(msg){
                if(msg=="L0"){
                    $().popLogin(0);
                }else if(msg=="L1"){
                    $().alertwindow("撖嫣�滩絲嚗峕�典歇蝏𤩺�閗��巨鈭�","");
                }else{
                    $("span#fanduinum").html(msg);
                }
            }
        });
    });

});


//��惩�交𤣰���
$(document).ready(function(){

    $("div#addfav").click(function(){

        var newsid=$("input#newsid")[0].value;

        $.ajax({
            type: "POST",
            url:PDV_RP+"news/post.php",
            data: "act=addfav&newsid="+newsid+"&url="+window.location.href,
            success: function(msg){
                if(msg=="L0"){
                    $().popLogin(0);
                }else if(msg=="L1"){
                    $().alertwindow("�典歇蝏𤩺𤣰��譍�敶枏�滨�穃�","");
                }else if(msg=="OK"){
                    $().alertwindow("撌脩�誩�惩�亙��𤣰��誩允",PDV_RP+"member/member_fav.php");
                }else{
                    alert(msg);
                }
            }
        });
    });

});


//��隞嗡�贝蝸�緍��
$(document).ready(function(){
    var downcentstr=$("input#downcent")[0].value;
    if(downcentstr!=""){
        $("#downcentnotice").html("(銝贝蝸�𧋦��隞園�閬�"+downcentstr+")");
    }
    $("#downlink").click(function(){
        var newsid=$("input#newsid")[0].value;

        $.ajax({
            type: "POST",
            url:PDV_RP+"news/post.php",
            data: "act=download&newsid="+newsid+"&RP="+PDV_RP,
            success: function(msg){
                if(msg=="1000"){
                    alert("銝贝蝸�𧋦��隞嗉窈��蒈敶�");
                }else if(msg=="1001"){
                    alert("銝贝蝸�𧋦��隞園�閬�"+downcentstr);
                }else{
                    window.location=msg;
                }
            }
        });

    });
});


//���蜓蝞∠�
$(document).ready(function(){

    var newsid=$("input#newsid")[0].value;

    $.ajax({
        type: "POST",
        url:PDV_RP+"news/post.php",
        data: "act=ifbanzhu&newsid="+newsid,
        success: function(msg){
            if(msg=="YES"){
                $("#banzhu").append("���蜓蝞∠� | <span id='banzhutj'>�綫���</span> | <span id='banzhudel'>��𣳇膄</span> | <span id='banzhudelmincent'>��𣳇膄撟嗆緍��</span> |").show();
                $().setBg();

                //�綫��鞉�滢��
                $("#banzhutj").click(function(){
                    $.ajax({
                        type: "POST",
                        url:PDV_RP+"news/post.php",
                        data: "act=banzhutj&newsid="+newsid,
                        success: function(msg){
                            if(msg=="OK"){
                                $().alertwindow("�綫��鞉�𣂼��","");
                            }else{
                                alert(msg);
                            }
                        }
                    });

                });

                //��𣳇膄��滢��
                $("#banzhudel").click(function(){
                    $.ajax({
                        type: "POST",
                        url:PDV_RP+"news/post.php",
                        data: "act=banzhudel&newsid="+newsid,
                        success: function(msg){
                            if(msg=="OK"){
                                $().alertwindow("��𣳇膄��𣂼��","../class/");
                            }else{
                                alert(msg);
                            }
                        }
                    });

                });


                //��𣳇膄撟嗆緍����滢��
                $("#banzhudelmincent").click(function(){
                    $.ajax({
                        type: "POST",
                        url:PDV_RP+"news/post.php",
                        data: "act=banzhudel&koufen=yes&newsid="+newsid,
                        success: function(msg){
                            if(msg=="OK"){
                                $().alertwindow("��𣳇膄撟嗆緍����𣂼��","../class/");
                            }else{
                                alert(msg);
                            }
                        }
                    });

                });

            }else{
                $("#banzhu").empty().hide();
            }
        }
    });

});
