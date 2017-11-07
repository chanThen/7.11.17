angular.module('myApp')
.controller('productCtrl', [
	'$scope',
	'$http','$state','productService', function (
			$scope,
			$http,$state,
			productService) {

		var init = function init() {

			$scope.products={};
			$scope.categoryid={};
			$scope.categoryid = $state.params.id;
			console.log($scope.categoryId);
			productService.getallproduct(cbSucess);  
		};

		function cbSucess(payload){
			$scope.products = payload.data;
		}



		$scope.checkForSubscription = function checkForSubscription(bookId) {
			var user = sessionStorage.getItem('userData');
			var userData = JSON.parse(user);
			productService.doCheckForSubscription(bookId,userData.userid,function(response){
				if(response == ""){
					alert("Not yet Subscribed");
					$state.go('root.dashBoard.subscribePage',{bookid:bookId});
				} else {
					alert("Already Subscribed");
					$state.go('root.dashBoard.singleProduct',{bookid:bookId});
				}
			});
		}
		init();	
	}]);
