'use strict';

/* Controllers */
var produitcatControllers = angular.module('productApp', []);

produitcatControllers.controller('ProductListCtrl', ['$scope', '$http',
  function ($scope, $http) {
    $http.get('http://127.0.0.1/wsprovider/WSProvider/rest/product').success(function(data) {
      $scope.produits = data;
    });
    $scope.orderProp = 'quantity';
  }]);

