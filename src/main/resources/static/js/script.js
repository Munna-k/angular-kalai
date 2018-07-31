 var sampleApp = angular.module('RoutingApp', ['ngRoute']);
	sampleApp.config( ['$routeProvider', function($routeProvider) {
	
		$routeProvider
			.when('/first', {
				templateUrl: 'html/form.html',
				controller:'formController'
			})
			
			.when('/second', {
				templateUrl: 'html/second.html'
				
			})
			
			.when('/third', {
				templateUrl: 'html/third.html',
				controller:'thirdController'
				
			})

			.when('/employee', {
				templateUrl: 'html/employee.html',
				controller:'empController'
				
			})
			
			.otherwise({
				redirectTo: 'html/first'
			});
			
			
	}]);

	sampleApp.controller('thirdController', function($scope){
				$scope.tutorial = [
            {Name:"Controllers",Description :"Controllers in action"},
            {Name:"Models",Description :"Models and binding data"},
            {Name:"Directives",Description :"Flexibility of Directives"}
        ]


			});	
	sampleApp.controller('formController',function($scope){
		$scope.IsHidden = true;
		$scope.submitEmployee = function(){
        var firstName = angular.element(document.getElementById("fname")); 
        var lastName = angular.element(document.getElementById("lname")); 
        var employeeId = angular.element(document.getElementById("empid")); 
        var mailId = angular.element(document.getElementById("mail")); 
        var designation = angular.element(document.getElementById("designation")); 
        var projectName = angular.element(document.getElementById("projectName")); 
       $scope.first = firstName.val();
        $scope.last = lastName.val();
          $scope.idd = employeeId.val(); 
           $scope.gmail = mailId.val();
            $scope.desig = designation.val();
             $scope.pname = projectName.val();
             $scope.IsHidden = false;
		
	}
		
	})

	sampleApp.controller('empController', function($scope, $http, $location){
		$scope.data = [{ firstName:"Jayaram",lastName:"P",email:"jayaram@gmail.com",
	                   project:"javasavvy",designation:"Software Engineer",empId:"10001"},
	              {firstName:"Arjun",lastName:"D",email:"Arjun@gmail.com",
	                   project:"Sample Project",designation:"Test",empId:"10002"                 
	              },{firstName:"kalai",lastName:"K",email:"Kalai@gmail.com",
	                   project:"First Project",designation:"Developer",empId:"10003"                 
	              } ];
		
			
		

	$scope.employees = angular.copy( $scope.data);
	 $scope.enabledEdit =[];
	 $scope.ShowSave = false;
	 $scope.ShowEdit = true;
	
	 
	
	 
    $scope.addEmployee = function(){
	    var emp ={ firstName:"",lastName:"",email:"",
	                   project:"",designation:"",empId:"",disableEdit:false};
		$scope.employees.push(emp);
		 $scope.enabledEdit[$scope.employees.length-1]=true;
	}

	$scope.editEmployee = function(index){
		console.log("edit index"+index);
		$scope.enabledEdit[index] = true;
		$scope.ShowEdit = false;
		$scope.ShowSave = true;
	}

	$scope.saveEmployee = function(index){
		 $scope.ShowEdit = true;
		 $scope.ShowSave = false;
		 $scope.enabledEdit[index] = false;
		console.log("form submitted:"+angular.toJson($scope.employees[index]));
	}

	$scope.deleteEmployee = function(index) {
		console.log("deleted index");
		  $scope.employees.splice(index,1);
	}

	
	//////######  working fine code #######///////
	
	/*$scope.submitEmployee = function(){
		
		$http.get('getContent').
        success(function(data) {
              alert("success");
              $scope.Data = data;
              console.log(data);
        }).
        error(function(data){
             alert("Exception details: " + JSON.stringify({data: data}));
        });*/
	
	
//////######  working fine code #######///////
	
	
	
	
	$scope.submitEmployee = function(){
		
		
		$scope.headerText = 'Pass Below JSON Array using AngularJS Spring MVC Controller';
		 $scope.list = [];
		 
		 $scope.formData = angular.toJson($scope.employees);
		 
		 console.log($scope.formData);
		 	
		
	var response = $http.post('PostFormDataJSONArray', $scope.formData);
	response.success(function(data, status, headers, config) {
		console.log(data);
		alert("success");
	});
	response.error(function(data, status, headers, config) {
		alert( "Exception details: " + JSON.stringify({data: data}));
	});
	
	}

	});