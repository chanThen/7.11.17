myApp.service('userServices',function($state,$http){
	
	this.createUserAccount = function(){
		$state.go('root.userRegister');
	}

	this.addUser = function(name,email,pwd){
		var data={
			name : name,
			email : email,
			pwd : pwd,
			isActive : 1
	};
		var url = "http://localhost:8080/BookWorld/rest/user/add";
			$http.post(url, data)
				.then(function successCallback(response) {
					alert("Succesfully signed in");
					
					console.log(response.data);
					$state.go('root.index');
				 
			
				}, function errorCallback(response) {
					alert("something went wrong - server error");
					$state.go('root.index');
				});
			}
		
	this.loginAuthentication = function(email,pwd){
		
		var data={
					email : email,
					pwd : pwd
		};
		var url = "http://localhost:8080/BookWorld/rest/user/auth";
		console.log(url);
		$http.post(url, data)
			.then(function successCallback(response) {
				
				if(response.status ==200){
					var userData = JSON.parse(response.data);
					sessionStorage.setItem('userData', JSON.stringify(userData));
					console.log(response.data);
					alert("Successfully Logged in..");
					
					$state.go('root.dashBoard.aboutpage');
				}else{
					alert("provided credentials are wrong!");
					$state.go('root.index');
				}
			});
	}
});
	

