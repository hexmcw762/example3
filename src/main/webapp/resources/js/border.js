/**
 * 
 */

$(function(){

	$('#submit1').click(function(){
	if(valichk()){
		return false;
	}else{
	$('form').submit();
	}
	});
	
	$('#idchck').on("propertychange change input past", function(){
		$.ajax({
			asynk:true,
			type:'post',
			url:"idCheck",
			dataType:"json",
			data:{"id":$("#idchck").val()},
			success:function(data){
				if(data>0){
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color','red');
					$('font[id=warning]').text('이미 존재하는 아이디 입니다.');
					$('#idchck').focus();
				}else{
					$('font[id=warning]').text('');
					$('font[id=warning]').attr('color','blue');
					$('font[id=warning]').text('사용 가능한 아이디 입니다.');
					$('#idchck').focus();
				}
			},
			error:function(error){
				alert("error :"+error);
			}
		});
	});
})

function valichk(){
	var flen = $("form[name='wForm'] .chk").length;
	for(var i=0; i<flen; i++){
		if($('.chk').eq(i).val()=="" || $('.chk').eq(i).val()==null || $('.chk').eq(i).val().trim()==""){
			alert("필수 입력 항목입니다.");
			$('.chk').eq(i).focus();
			return true;
		}
	}
}


function memUpdate(check){
	
	 if(check="update"){
		pw = prompt('비밀번호를 입력하시오.');
		spw = document.getElementById('pass').value;
		if(pw==spw){
			document.form.action="updateForm";
		}else{
			alert('비밀번호가 다릅니다.');
			return;
		}
	 
	}
	document.content.submit();

}

function memDelete(check){
	if(check="delete"){
		pwd = prompt('비밀번호를 입력하시오.');
		spw = document.getElementById('pass').value;
		if(pwd==spw){
			document.form.action="deleteForm";
		}else{
			alert('비밀번호가 다릅니다.');
			return;
		}
	}
	document.content.submit();
}

