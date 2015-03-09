'use strict';

/* App Module */
var phonecatApp = angular.module('produitcatApp', [
  'ngRoute',
  'produitcatControllers'
]);

phonecatApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/produits', {
        templateUrl: 'partials/ListProduits.html',
        controller: 'ProduitListCtrl'
      }).
       otherwise({
        redirectTo: '/produits'
      });
  }]);

