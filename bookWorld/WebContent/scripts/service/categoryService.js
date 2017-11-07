angular.module('myApp')
	.service("categoryService",['$http',function ($http)
    {

      this.getallcategory = function getallcategory(cbSucess){
        var url = "http://localhost:8080/BookWorld/rest/categories/getAllCategories";
         $http.get(url).then(cbSucess, function(error){
            return (error);
         });         
     }
   }]);
