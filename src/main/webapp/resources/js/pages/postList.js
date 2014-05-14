

function PostListCtrl($scope, $http) {
	$scope.id = '';
	$scope.response = '';

	$scope.view = function(){
		
		console.log("view start");
		$http({    
            		url: _context+'/viewPost',    
            		method: "POST",   
            		data: $scope.id,   
            		headers: {'Content-Type': 'application/json'}    
			}).success(function (data, status, headers, config) {    
            // data contains the model which is provided by Spring
            // $scope.comments.push is the way to add new comments into $scope
				
                                                                                                
			}).error(function (data, status, headers, config) {    
//				alert("Something Wrong "+status);    
			});     
     	};
	
	
	


	
}

