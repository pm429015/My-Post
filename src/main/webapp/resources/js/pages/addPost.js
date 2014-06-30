

function AddPost($scope, $http) {
	$scope.title = '';
	$scope.description = '';
	$scope.nickname = '';
	$scope.email = '';
	$scope.zipcode = '';
	$scope.server_response='init';
	
	
	

	$scope.savePost = function() {
		var user_email = getCookie("Email");
		var user_name = getCookie("Name");
		
		if (!user_email) {
			user_email= $("#Uemail").val();
		}
		
		if (!user_name) {
			user_name = $("#name").val();
		}
		
		if ($scope.title && $scope.description && user_name && user_email) {
			$.ajax({
				type : 'POST',
				url : 'insertPost',
				data : {
					title : $scope.title,
					description : $scope.description,
					name : user_name,
					email : user_email
					
				}
				
			});
					    
			window.location.href='postDone';
		}else{
			if (!$scope.title) {
				$("label#subject_error").show();
				$("#subject").focus();
			}else if(!$scope.description){
				$("label#descritpion_error").show();
				$("#descritpion").focus();
			}else if(!user_name){
				$("label#name_error").show();
				$("#name").focus();
			}else if(!user_email){
				$("label#email_error").show();
				$("#email").focus();
			}
			
		}
		
		
		
		
	};
	
	$scope.clear = function() {
		$scope.title = '';
		$scope.description = '';
		$scope.name = '';
		$scope.server_response= 'Good Start';
		
	};
	
}

