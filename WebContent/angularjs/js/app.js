'use strict';

var SERVER_URL = 'http://127.0.0.1:8080/WSProvider/rest/';

/* App Module */
var productApp = angular.module('productApp', [
  'ngRoute',
  'ngCookies'
]);

productApp.config(['$routeProvider',
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

productApp.controller('ProductListCtrl', ['$scope', '$http', '$cookieStore',
    function ($scope, $http, $cookieStore) {
        $http.get(SERVER_URL + 'product').success(function(data) {
            $scope.produits = data;
        });
        $scope.orderProp = 'quantity';

        $scope.orderProduct = function (ref, quantity) {
            console.log(arguments);
        };
    }
]);

productApp.controller('LoginCtrl', ['$scope', '$http', '$cookieStore',
    function ($scope, $http, $cookieStore) {
        $scope.handleLogin = function () {
            var data, headers;
            data = 'username=' + $scope.username +'&password=' + $scope.password;
            headers = {'Content-Type': 'application/x-www-form-urlencoded'};

            $http
                .post(SERVER_URL + 'connect', data, {headers: headers})
                .success(function (data, status) {
                    console.log('youpi', data, status);
                    $cookieStore.put('user_token', data.guid);
                })
                .error(function (data, status) {
                    alert('nope');
                });
        };
    }
]);
