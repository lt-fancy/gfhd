$(document).ready(function() {
	
	var AO=$("#advsexDiv");
	var AL=$("#advsex");
	var AOF=AO.offset();

	//¼æÈÝÎ´Éý¼¶°æ±¾ÅÐ¶Ï£¬·ÀÖ¹Î´Éý¼¶Ê±²åÈë±¾²å¼þ³ö´í
	if(AL.length>0 && AO.length){      
		AL[0].style.background=AO[0].style.background;
		AL.css({height: AO[0].offsetHeight+"px",top:AOF.top+"px"});
		AL.show();
	}

});
