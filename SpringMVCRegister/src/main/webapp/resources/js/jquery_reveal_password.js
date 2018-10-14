$(document).ready(function(){

	$("#confirmPassword_icon").click(
			
			function(){
				
				console.log('click');
				
				$("#confirmPassword").prop('type', 'text');
				$("#confirm_eye_icon").removeClass('glyphicon-eye-close');
				$("#confirm_eye_icon").addClass('glyphicon-eye-open');
				
			});
	
});