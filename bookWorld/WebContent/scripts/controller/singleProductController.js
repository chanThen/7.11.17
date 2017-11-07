angular.module('myApp')
	.controller('singleProductCtrl', [
			'$scope',
			'$http','$state','singleProductService', function (
			$scope,
			$http,$state,
			singleProductService) {

	   var init = function init() {
		   $scope.bookId={};
		   $scope.data ={};
		   $scope.reviewData={};
		   $scope.bookId = $state.params.bookid;
		   singleProductService.getProductById($scope.bookId, function(response) {
			   $scope.data = response;
			   console.log($scope.data);   
			  
		   });
		   
		   singleProductService.getAllReviews(JSON.parse($scope.bookId),function(reviewResponse) {
			   $scope.reviewdata = reviewResponse;
		   });
	   };
	  
	   $scope.addToWishList = function addToWishList(){
		   
		   var user = sessionStorage.getItem('userData');
		   var userData = JSON.parse(user);
		   
 		  singleProductService.addToWishList(userData.userid,$scope.bookId);
	   }
	   
	   $scope.addToReview = function addToReview() {
		   
		   var user = sessionStorage.getItem('userData');
		   var userData = JSON.parse(user);
		   
		   $scope.reviewData.bookId =JSON.parse( $scope.bookId);
		   $scope.reviewData.userId = userData.userid;
		   $scope.reviewData.bookComment = $scope.comment;
		   $scope.reviewData.bookRating = JSON.parse($scope.rating);
		   $scope.reviewData.name = userData.name;
		   
		   singleProductService.addToReview($scope.reviewData);
		   
		   document.getElementById("commentbox").value=""
			   $('input[name=optradio]').attr('checked',false);
		   
		   init();
		   
	   }
	   
	   init();
}]);
