angular.module('myApp')
.controller('subscribeCtrl', [
	'$scope',
	'$http','$state','subscribeService', function (
			$scope,
			$http,$state,
			subscribeService) {
				$scope.bookId = $state.params.bookid;
				var bookid = $scope.bookId ;
				
				
				$scope.payToSubscribe = function payToSubscribe() {
						/*$scope.username;
						$scope.phonenumber;
						$scope.accountnumber;
						$scope.cardtype;*/
						$scope.bookId = JSON.parse($state.params.bookid);
						var user = sessionStorage.getItem('userData');
						var userData = JSON.parse(user);

						subscribeService.payToSubscribe(userData.userid,bookid,callback);
				};

		function callback(payload){
					$state.go('root.dashBoard.singleProduct',{bookid:bookid});
					/*bootbox.confirm("Cick to Confirm? ", function(result) {
					if(result == true){*//*	}				
			});*/}

		var init = function init() {
			  var user = sessionStorage.getItem('userData');
			  var userData = JSON.parse(user);
			  subscribeService.getAllSubscribedBooksByUserId(userData.userid,function(response){
				  $scope.subscribedData = response;
				  console.log($scope.subscribedData);
			 });					   
		};
		
		$scope.viewDetails = function viewDetails(bookId) {
			$state.go('root.dashBoard.singleProduct',{bookid:bookId});
		}
		
		init();
	}]);




