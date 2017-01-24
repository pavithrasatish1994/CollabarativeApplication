'use strict';

angular.module('myApp').controller('JobController', ['$scope', 'JobService', function($scope, JobService) {
   
	$scope.jobm={jid:'',title:'',qualification:'',description:'',jdat:''};
    $scope.job=[];
    
    $scope.coment={cid:'',jid:'',jusr:''};
    $scope.coments=[];
    
    fetchAllJob();
    $scope.titl="OrgValleyBackendJob"
    
    	 function fetchAllJob(){
    	JobService.fetchAllJob()
        .then(
        function(d) {
        	$scope.job = d;
        	 console.log($scope.job);
        	 console.log('Done');
        	 
        },
        function(errResponse){
            console.error('Error while fetching blogs');
        });
    }
    
    function fetchAllCom(jusr){
    	console.log('1111111111111111111111111111');
    	JobService.fetchAllCom(jusr)
        .then(
        function(d) {
        	$scope.coments = d;
        	 console.log($scope.coms);
        	 console.log('Done');
        	 
        },
        function(errResponse){
            console.error('Error while fetching coms');
        });
    }
    
    $scope.addBlog=function(blogm)
    {
    	 console.log(blogm);
    	 BlogService.addBlog(blogm)
        .then(
        		function(errResponse){
            console.error('Error while creating blog');
        });
    }
    $scope.addCom=function(comment,bid,blogm)
    {
    	 comment.bid=bid;
    	 console.log(comment);
    	 BlogService.addCom(comment)
        .then(
        		function(response){
        			blogm.bcmtct=blogm.bcmtct+1;
        			BlogService.addBlog(blogm);
                },
        		
        		function(errResponse){
            console.error('Error while creating comnt');
        });
    }
   
$scope.tab = 'jtb';
    
$scope.selectTab = function(setTab){
	$scope.tab = setTab;
      console.log($scope.tab)
      $scope.jid=setTab;
      fetchAllCom($scope.jid);
    };
    
    $scope.isSelected = function(checkTab){
      return $scope.tab === checkTab;
    };

    
   
}]);