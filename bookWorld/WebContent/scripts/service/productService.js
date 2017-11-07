angular.module('myApp')
	.service("productService",['$http','$state',function ($http,$state)
    {

      this.getallproduct = function getallproduct(cbSucess){
        var url = "http://localhost:8080/BookWorld/rest/bookDetail/getAllBookDetails";
        //serviceCall.get();
         $http.get(url).then(cbSucess, function(error){
            return (error);
         });         
     }
      
      this.doCheckForSubscription = function doCheckForSubscription(bookid,userid,callback) {
    	  var url = "http://localhost:8080/BookWorld/rest/subscribe/checkForSubscription?bookId="+bookid+"&userId="+userid;
    	  $http.get(url)
    	  .then(function (response) {
    		  callback(response.data);
    	  });
      }
      
      
   }]);
