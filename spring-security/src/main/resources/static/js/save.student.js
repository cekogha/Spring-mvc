/**
 * 
 */

var saveStudent = angular.module("saveStudent", []);

saveStudent.controller("SaveStudentController", function($scope, $http, $log){

	$scope.student = {};
	$scope.errors = {};
	$scope.mode = {value:"form"};

	$scope.saveStudent = function(){
		$http.post("saveStudent", $scope.student)
		.then(function onSuccess(response) {
		    // Handle success
			if(!response.data.errors){

				$scope.student = response.data;
				$scope.errors = null;
				$scope.mode.value = "confirm";
				$log.info("data => "+ $scope.student);
			}else{
				$scope.errors = response.data;
				$log.info("data => "+ $scope.errors);
			}
		}, function onError(response) {
		    // Handle error
			  $log.error("ERROR Occured : " + response);
		  });
	};
	
	$log.info($scope.errors);
	
});