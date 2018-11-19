var app=angular.module("MyApp",[]);
app.controller("myController", function($scope,$http){
	$scope.pageEntreprises=[];
	$http.get("http://localhost:8080/listEntreprises?page=1&size=3")
	.success(function(data){
		$scope.pageEntreprises=data;
	});
	.errir(function(err){
		Console.log(err);
	});
});