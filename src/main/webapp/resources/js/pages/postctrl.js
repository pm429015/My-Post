

function PostCtrl($scope, $http) {
	$scope.id = '';
	$scope.content = '';


	$scope.saveDeal = function() {
		$http({
			method : 'POST',
			url : _context + '/insertDeal',
			data : {
				content : $scope.content,
				refPost : $scope.id
			}

//			
//		}).then(function(response) {
//			//$scope.articleList = response.data.articleList;
//			//$scope.server_response= response.data.server_response;
//			
		});
		
		
	};
	
}

