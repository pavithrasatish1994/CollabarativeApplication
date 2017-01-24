'use strict';

angular.module('myApp').factory('JobService', ['$http', '$q', function($http, $q){

  
    var factory = {
    		fetchAllJob: fetchAllJob,
     		fetchAllCom:fetchAllCom
    };
  
    return factory;

    function fetchAllJob() {
        var deferred = $q.defer();
        $http.get('http://localhost:8080/OrgValleyBackend/job')
            .then(
            function (response) {
            	console.log('Got data');
            	deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Job');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
   
    
    function fetchAllCom(jid) {
        var deferred = $q.defer();
        console.log('22222222222222222222222',jid);
        
        $http.get('http://localhost:8080/OrgValleyBackend/coments/'+jid)
            .then(
            function (response) {
            	console.log('Goooooooooooooooooooooooot');
            	deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Data');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
    

}]);
