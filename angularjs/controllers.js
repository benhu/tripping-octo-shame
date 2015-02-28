'use strict';

/* Controllers */
var produitcatControllers = angular.module('produitcatControllers', []);

produitcatControllers.controller('ProduitListCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('produits/produits.json').success(function(data) {
      $scope.produits = data;
    });
    $scope.orderProp = 'quantity';
  }]);

