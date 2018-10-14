$(document).ready(function(){
			
	$("#confirmPassword").keyup(
			function(){

				$("#confirmPassword_icon").removeClass('hidden');
				
				if($("#password").val() == '' && $(this).val() == ''){
					$("#confirmPassword_icon").removeClass('glyphicon-ok-circle');
					$("#confirmPassword_icon").removeClass('glyphicon-remove-circle');
					$("#confirmPassword_p").addClass('hidden');
				}
				else if($(this).val() == $("#password").val()){
					$("#confirmPassword_icon").removeClass('glyphicon-remove-circle');
					$("#confirmPassword_p").addClass('hidden');
					$("#confirmPassword_icon").addClass('glyphicon-ok-circle');
					$("#confirmPassword_icon").css('color','green');
					$("#confirmPassword_icon").css('font-size', '20px');
				}
				else{
					$("#confirmPassword_p").removeClass('hidden');
					$("#confirmPassword_icon").removeClass('glyphicon-ok-circle');
					$("#confirmPassword_icon").addClass('glyphicon-remove-circle');
					$("#confirmPassword_icon").css('color', 'red');
					$("#confirmPassword_icon").css('font-size', '20px');
				}
			}
	);	
	
	$("#password").keyup(
			function(){

				$("#confirmPassword_icon").removeClass('hidden');				

				if($(this).val() == '' && $("#confirmPassword").val() == ''){
					$("#confirmPassword_icon").removeClass('glyphicon-ok-circle');
					$("#confirmPassword_icon").removeClass('glyphicon-remove-circle');
					$("#confirmPassword_p").addClass('hidden');
				}
				else if($(this).val() == $("#confirmPassword").val()){
					$("#confirmPassword_icon").removeClass('glyphicon-remove-circle');
					$("#confirmPassword_p").addClass('hidden');
					$("#confirmPassword_icon").addClass('glyphicon-ok-circle');
					$("#confirmPassword_icon").css('color','green');
					$("#confirmPassword_icon").css('font-size', '20px');
				}
				else{
					$("#confirmPassword_p").removeClass('hidden');
					$("#confirmPassword_icon").removeClass('glyphicon-ok-circle');
					$("#confirmPassword_icon").addClass('glyphicon-remove-circle');
					$("#confirmPassword_icon").css('color', 'red');
					$("#confirmPassword_icon").css('font-size', '20px');
				}
			}
	);	
});