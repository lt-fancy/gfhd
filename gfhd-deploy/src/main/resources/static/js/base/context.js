/**
 * Created by fingertap on 2017/9/16.
 */
var path = window.document.location.href;
var pathName=window.document.location.pathname;
function getContextPath() {
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=path.substring(0,getContextPosition);
    return localhostPaht;
}
function getContextPosition() {
    return pathName;
}
function getFirstMenu(ename) {
    var menu = '';
    $.ajax({
        type : "get",
        url : "menu/getFirstChildMenu",
        data : "ename=" + ename,
        async : false,
        success : function(result){
            if(result.code==0){
                menu = result.data;
            }
        }
    });
    return menu;
}
function getMenuByEname(ename) {
    var menu = '';
    $.ajax({
        type : "get",
        url : "menu/getMenuByEname",
        data : "ename=" + ename,
        async : false,
        success : function(result){
            if(result.code==0){
                menu = result.data;
            }
        }
    });
    return menu;
}

function getTextByMenuEname(ename) {
    var content = '';
    $.ajax({
        type : "get",
        url : "text/getTextByMenuEname",
        data : "ename=" + ename,
        async : false,
        success : function(result){
            if(result.code==0){
                content = result.data;
            }
        }
    });
    return content;
}
function getImageByEname(ename) {
    var imageUri = '';
    $.ajax({
        type : "get",
        url : "image/getImageByEname",
        data : "ename=" + ename,
        async : false,
        success : function(result){
            if(result.code==0){
                imageUri = result.data;
            }
        }
    });
    return imageUri;
}
function getCommonByEname(ename) {
    var common = '';
    $.ajax({
        type : "get",
        url : "common/getByEname",
        data : "ename=" + ename,
        async : false,
        success : function(result){
            if(result.code==0){
                common = result.data;
            }
        }
    });
    return common;
}