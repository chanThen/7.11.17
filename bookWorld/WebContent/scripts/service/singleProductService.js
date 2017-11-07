angular.module('myApp')
.service("singleProductService",['$http',function ($http)
	{
	this.getProductById = function getProductById(bookid,callback){
		var url = "http://localhost:8080/BookWorld/rest/bookDetail/getBookDetailById?bookId="+bookid;
		console.log(url);
		$http({
			method:'GET',
			url: url
		}).then(function(response) {
			callback(response.data);
		});

	}

	this.addToWishList = function addToWishList(userid,bookid) {

		var url = "http://localhost:8080/BookWorld/rest/wishList/addToWishList?userId="+userid+"&bookId="+bookid;
		$http.post(url)
		.then(function successCallback(response) {
			if(response.data == "Success"){
				alert("Added To favourites");
			} else {
				alert("already added To Favourites!!");
			}		
		});
	}


	this.addToReview = function addToReview(data) {

		var url = "http://localhost:8080/BookWorld/rest/ratingandreview/addRatingAndReview";
		$http.post(url,data)
		.then(function successCallback(response) {
			
		}, function errorCallback(response) {
			alert("something went wrong - server error");
		});
	}


	this.getAllReviews = function getAllReviews(bookid,callback) {
		var url = "http://localhost:8080/BookWorld/rest/ratingandreview/getAllReviews?bookId="+bookid;
		$http.get(url)
		.then( function (responses) {
			callback(responses.data);
		})
	}
}]);


