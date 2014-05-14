

function AddPost($scope, $http) {
	$scope.title = '';
	$scope.description = '';
	$scope.nickname = '';
	$scope.email = '';
	$scope.zipcode = '';
	$scope.server_response='init';
	
	

	$scope.savePost = function() {
		$http({
			method : 'POST',
			url : _context + '/newPost/save',
			data : {
				title : $scope.title,
				description : $scope.description,
//				nickname : $scope.nickname,
//				email : $scope.email,
//				zipcode : $scope.zipcode
				
			}
			
		}).then(function(response) {
			//$scope.articleList = response.data.articleList;
			//$scope.server_response= response.data.server_response;
			
		});
		
		
	};
	
	$scope.clear = function() {
		$scope.title = '';
		$scope.description = '';
		$scope.nickname = '';
		$scope.server_response= 'Good Start';
		
	};
	
}

