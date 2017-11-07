 angular.module('myApp')
	.service("wishListService",['$http',function ($http)
    {
		this.getAllWishListByUserId = function getAllWishListByUserId(userId,cbSucess){
	        var url = "http://localhost:8080/BookWorld/rest/wishList/getAllWishListByUserId?userId="+userId;
	        $http({
				method:'GET',
				url: url
	        }).then( function(response) {	
	        	 cbSucess(response.data);
		  	   });
        }
		
		this.removeFromwishList = function removeFromwishList(wishListId) {
			var url = "http://localhost:8080/BookWorld/rest/wishList/deleteSelectedWishList?wishListId="+wishListId;
			$http({
				method:'DELETE',
					url: url
			}).then( function(response){
				alert("Deleted Successfully");
			});
		}
	 }]);


