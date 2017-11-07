angular.module('myApp')
	.controller('categoryCtrl', [
			'$scope',
			'$http','$state','categoryService', function (
			$scope,
			$http,$state,
			categoryService) {

	   var init = function init() {
		   $scope.category={};
		   categoryService.getallcategory(cbSucess);
		   
	   };
		 
	   function cbSucess(payload){
		   
		   $scope.category = payload.data;
		   console.log($scope.category);
			
		 }
			init();
			
			$scope.getProductById = function getProductById(id){
				$state.go('root.dashBoard.products',{id:id});
			}
			
			
 }]);



