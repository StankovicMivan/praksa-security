var app = angular.module("praksa", [ "ngRoute" ]);

app.controller("ctrl", function($scope) {
	
});

app.controller("IgraciCtrl", function($scope, $http, $location) {

	var baseUrl = "/api/igraci";
	var baseUrlT = "/api/klubovi";

	$scope.igraci = [];
	$scope.klubovi = [];
	
	$scope.noviIgrac = {};
	
	$scope.noviIgrac.ime = "";
	$scope.noviIgrac.prezime = "";
	$scope.noviIgrac.pozicija = "";
	$scope.noviIgrac.D = "";
	$scope.noviIgrac.klubNaziv ="";	
	$scope.noviIgrac.id ="";

	
	$scope.pPretrage = {};
	$scope.pPretrage.klubid = "";
	$scope.pPretrage.ime = "";
	$scope.pPretrage.prezime = "";
	$scope.pPretrage.pozicija = "";
	$scope.pPretrage.pPoStrani = "";
	
	
	$scope.pageNum = 0;
	$scope.totalPages = 1;
	
	var getIgraci = function() {

		var config = {
				params : {}
			};

			if ($scope.pPretrage.klubid != "") {
				config.params.klubid = $scope.pPretrage.klubid;
			}
			if ($scope.pPretrage.ime != "") {
				config.params.ime = $scope.pPretrage.ime;
			}
			if ($scope.pPretrage.prezime != "") {
				config.params.prezime = $scope.pPretrage.prezime;
			}
			if ($scope.pPretrage.pPoStrani != "") {
				config.params.pPoStrani = $scope.pPretrage.pPoStrani;
			}

			config.params.pageNum = $scope.pageNum;
			
			
		$http.get(baseUrl, config).then(function success(res) {
			$scope.igraci = res.data;
			$scope.totalPages = res.headers("totalPages");
		}, function error() {
			alert("Neuspela pretraga.");
		});
	}
	
	getIgraci();
	$scope.pretraga2 = function(){
		$scope.pageNum = 0;
		getIgraci();
		
	}
	$scope.pretraga = function(){
		$scope.pageNum = 0;
		$scope.prikazi = true;
		getIgraci();
		
	}
	var getKlubovi = function() {
		$http.get(baseUrlT).then(function success(res) {
			$scope.klubovi = res.data;
		}, function error(res) {
			alert("Something went wrong");
		});
	}

	getKlubovi();

	$scope.dodaj = function() {
		$http.post(baseUrl, $scope.noviIgrac).then(function success() {
			getIgraci();
			$scope.noviIgrac.ime = "";
			$scope.noviIgrac.prezime = "";
			$scope.noviIgrac.pozicija = "";
			$scope.noviIgrac.klubId = "";
			$scope.noviIgrac.klubNaziv ="";	
			$scope.noviIgrac.id ="";
			
		}, function error() {
			alert("Could not create.")
		});
	}

	
	$scope.delete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getIgraci();
			},
			function error(){
				alert("Could not delete.");
			}
		);
	}
	$scope.goToEdit = function(id){
		$location.path("/igraci/edit/" + id);
	}
	$scope.go = function(direction) {
		$scope.pageNum = $scope.pageNum + direction;
		getIgraci();
	}
	
});
app.controller("editIgracCtrl", function($scope, $routeParams, $http, $location){
	
	// console.log($routeParams);
	var uId = $routeParams.uId;
	var baseUrl = "/api/igraci";
	var baseUrlT = "/api/klubovi";

	$scope.klubovi = [];
	$scope.noviIgrac = {};
	
	$scope.noviIgrac.ime = "";
	$scope.noviIgrac.prezime = "";
	$scope.noviIgrac.pozicija = "";
	$scope.noviIgrac.klubId = "";
	$scope.noviIgrac.klubNaziv ="";	
	$scope.noviIgrac.id ="";
	

	var getUcesnik = function(){		
		$http.get(baseUrl + "/" + uId).then(
			function success(res){
				$scope.noviIgrac = res.data;
			},
			function error(res){
				console.log("Something went wrong!");
			}	
		);
	}	
	getUcesnik();
	
	var getKlubovi = function(){		
		$http.get(baseUrlT).then(
			function success(res){
				$scope.klubovi = res.data;
			},
			function error(res){
				console.log("Something went wrong!");
			}	
		);
	}	
	getKlubovi();
	
	$scope.edit = function(){
		$http.put(baseUrl + "/" + uId, $scope.noviIgrac).then(
			function success(res){			
				$location.path("/igraci");
			},
			function error(res){
				alert("Something went wrong");
			}
		);
	}
	$scope.nazad = function(){
		$location.path("/igraci");
	}
	
});

app.controller("loginCtrl", function($scope, $routeParams, $http, $location){
//
//
});

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : '/app/html/partial/login.html',
		controller : 'ctrl'
	}).when('/igraci', {
		templateUrl : '/app/html/partial/igraci.html'
	}).when('/igraci/edit/:uId', {
		templateUrl : '/app/html/partial/edit-igraca.html'
	}).otherwise({
		redirectTo : '/'
	});
} ]);