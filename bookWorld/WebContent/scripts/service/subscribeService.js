angular.module('myApp')
	.service("subscribeService",['$http',function ($http)
    {

      this.payToSubscribe = function payToSubscribe(userId,bookId,callback){
        var url = "http://localhost:8080/BookWorld/rest/subscribe/addToSubscribe?userId="+userId+"&bookId="+bookId;
        $http.post(url).then(callback, function(error){
            return (error);
        });     
     }   
      
      
      this.getAllSubscribedBooksByUserId = function getAllSubscribedBooksByUserId(userId,success) {
    	  
    	  var url = "http://localhost:8080/BookWorld/rest/subscribe/getAllSubscribedListByUserId?userId="+userId;
	        $http({
				method:'GET',
				url: url
	        }).then( function(response) {	
	        	success(response.data);
		  	   },function(error) {
		  		   console.log(error);
		  	   });
      }
   }]);
