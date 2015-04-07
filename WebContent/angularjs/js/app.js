'use strict';

var SERVER_URL = 'http://127.0.0.1:8080/WSProvider/rest/';

var ProductSensei = angular.module('productApp', [
    'ngRoute',
    'ngCookies'
]);

ProductSensei.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider
        .when('/produits', {
            templateUrl: 'partials/ListProduits.html',
            controller: 'ProduitListCtrl'
        })
        .otherwise({
            redirectTo: '/produits'
        });
    }
]);

