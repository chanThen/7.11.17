angular.module('myApp')
.controller('indexPageControl',function($scope,$state,userServices){  
	
	$scope.email;
	$scope.pwd;
	$scope.login = function login (){
		userServices.loginAuthentication($scope.email,$scope.pwd);
		
	}
		$scope.createUserAccount = function(){
			userServices.createUserAccount();
		}
	});
	


	
	
	
	