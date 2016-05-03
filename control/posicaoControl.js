var app = angular.module('posicaoModule',[]);

app.controller('posicaoControl',function($scope,$http){
	
	var url = 'http://localhost:8080/TimeDeFutebol/rs/posicao';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (posicoesRetorno) {
			$scope.posicoes = posicoesRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.posicao = {};
	}

    $scope.salvar = function() {
		if ($scope.posicao.codigo == '') {
			$http.post(url,$scope.posicao).success(function(posicao) {
				$scope.posicoes.push($scope.posicao);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.posicao).success(function(posicao) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.posicao.codigo == '') {
			alert('Selecione um posicao');
		} else {
			urlExcluir = url+'/'+$scope.posicao.codigo;
			$http delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(posicaoTabela) {
		$scope.posicao = posicaoTabela;
	}
});