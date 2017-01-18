'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
   
	$scope.users={name:'',id:'',pwd:'',login_id:''};
    $scope.userlist=[];
	
    $scope.getAll=function(){
    	UserService.fetchAllUsers()
        .then(
        function(d) {
        	$scope.users = d;
        	 console.log($scope.users);
        	 console.log('Done');
        	 
        },
        function(errResponse){
            console.error('Error while fetching Users');
        });
    }
    $scope.regiUser=function(users)
    {
    	console.log('DoneA');
    	UserService.regiUser(users)
        .then(
        		
        		function(errResponse){
            console.error('Error while creating Users');
        });
    }
    $scope.doLogin=function(users)
    {	
    	console.log('DoneA');
    	 console.log(users.id);
    	UserService.doLogin(users)
        .then(
        		function (response) {
                	alert("You are authorised");
        			console.log('doneD',users.id);
        			
        			 window.location = "home.html";
                },
        		function(errResponse){
                	alert("You are not authorised");
                	console.error('Error while creating Users');
        });
    }

      
   

}]);
