var app = angular.module('timeModule',[]);

app.controller('timeControl',function($scope,$http){
	
	var url = 'http://localhost:8080/TimeDeFutebol/rs/time';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (timesRetorno) {
			$scope.timees = timesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.time = {};
	}

    $scope.salvar = function() {
		if ($scope.time.codigo == '') {
			$http.post(url,$scope.time).success(function(time) {
				$scope.timees.push($scope.time);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.time).success(function(time) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.time.codigo == '') {
			alert('Selecione um time');
		} else {
			urlExcluir = url+'/'+$scope.time.codigo;
			$http delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(timeTabela) {
		$scope.time = timeTabela;
	}
});