/**
 * 
 */

var myIndex = angular.module("myIndex", []);

myIndex.controller("IndexController", function($scope, $http, $log){

	$scope.menu = ["Home", "Students", "Users", "Logout"];
	$scope.selectedMenu = 'Home';
	
	$scope.select = function(m){
		
		$scope.selectedMenu=m;
		$log.info(m);
	}
	
});