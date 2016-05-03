var app = angular.module('jogadorModule',[]);

app.controller('jogadorControl',function($scope,$http){
	
	var url = 'http://localhost:8080/TimeDeFutebol/rs/jogador';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (jogadoresRetorno) {
			$scope.jogadores = jogadoresRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.jogador = {};
	}

    $scope.salvar = function() {
		if ($scope.jogador.codigo == '') {
			$http.post(url,$scope.jogador).success(function(jogador) {
				$scope.jogadores.push($scope.jogador);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.jogador).success(function(jogador) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.jogador.codigo == '') {
			alert('Selecione um jogador');
		} else {
			urlExcluir = url+'/'+$scope.jogador.codigo;
			$http delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(jogadorTabela) {
		$scope.jogador = jogadorTabela;
	}
});