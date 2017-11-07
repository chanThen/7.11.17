var myApp = angular.module("myApp",['ui.router']);

myApp.config(function($stateProvider, $urlRouterProvider){

	$urlRouterProvider.otherwise("/index");
	$stateProvider
	.state('root', {
		abstract: true,
		url:''
	})
	
	.state('root.index',{
		url:'/index',
		controller:'indexPageControl',
		templateUrl:'views/login.html'
	})
	
	.state('root.userRegister',{
		url:'/userRegister',
		controller:'signInPageControl',
		templateUrl:'views/createaccount.html'	
	})
	
	.state('root.dashBoard', {
		url:'/dashboard',
		templateUrl:'views/home.html'	
	})
	
	.state('root.dashBoard.aboutpage',{
		url:'/about',	
		templateUrl:'views/about.html'
	})
	
	.state('root.dashBoard.categorypage',{
		url:'/categories',
		templateUrl:'views/category.html',
		controller:'categoryCtrl'
	})
	
		
	.state('root.dashBoard.products',{
		url:'/products/:id',
		templateUrl:'views/product.html',
		controller:'productCtrl'
	})
	
	.state('root.dashBoard.singleProduct',{
		url:'/singleProduct/:bookid',
		templateUrl:'views/singleProduct.html',
		controller:'singleProductCtrl'
	})
	
	.state('root.dashBoard.wishlistpage',{
		url:'/wishList',
		templateUrl:'views/wishList.html',
		controller:'wishListCtrl'
	})
	
	.state('root.dashBoard.subscribePage', {
		url:'/subscribe/:bookid' , 
		templateUrl: 'views/SubscriptionPage.html' ,
		controller: 'subscribeCtrl'
	})

	.state('root.dashBoard.subscribedPage',{
		url:'/SubscribedBooks',
		templateUrl:'views/subscribedBooks.html',
		controller:'subscribeCtrl'
	})
})