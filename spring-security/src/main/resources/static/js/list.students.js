/**
 * 
 */

var saveStudent = angular.module("listStudent", []);

saveStudent.controller("ListStudentController", function($scope, $http, $log){

	$scope.student = {};
	$scope.errors = {};
	$scope.mode = {value:"form"};
	$scope.studentPage = null;
	$scope.currentPage = 0;
	$scope.size = 10;
	

	$scope.studentList = function(){
		$http.get("students?page="+$scope.currentPage+"&size="+$scope.size)
		.then(function onSuccess(response) {
		    // Handle success
			if(!response.data.errors){

				$scope.studentPage = response.data;
				$scope.errors = null;
				$log.info("data => "+ $scope.studentPage);
			}else{
				$scope.errors = response.data;
				$log.info("data => "+ $scope.errors);
			}
		}, function onError(response) {
		    // Handle error
			  $log.error("ERROR Occured : " + response);
		  });
	};
	$scope.studentList();
	$log.info($scope.errors);
	
});