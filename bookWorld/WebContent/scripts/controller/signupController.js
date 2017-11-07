angular.module('myApp')
.controller('signInPageControl',function($scope,userServices){
	$scope.name;
	$scope.email;
	$scope.pwd;
	$scope.addUser = function(){
		userServices.addUser($scope.name,$scope.email,$scope.pwd);
	}
});