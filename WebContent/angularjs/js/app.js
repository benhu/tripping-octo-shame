'use strict';

var SERVER_URL = 'http://127.0.0.1:8080/WSProvider/rest/';

angular.module('productApp', [
    'ngRoute',
    'ngCookies'
    ])

    .config(['$routeProvider',
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
    ])

    .controller('ProductListCtrl', ['$scope', '$http', '$cookieStore',
        function ($scope, $http, $cookieStore) {
            $http.get(SERVER_URL + 'product').success(function(data) {
            	data.forEach(function (product) {
            		product.number = 0;
            	});
                $scope.produits = data;
            });
            $scope.orderProp = 'quantity';
            
            $scope.getProduct = function (ref) {
            	return $scope.produits.filter(function (product) {
            		return product.reference == ref;
            	})[0];
            };

            $scope.orderProduct = function (ref) {
            	var product = $scope.getProduct(ref),
                    params = {
                        reference: product.reference,
                        quantity: product.number,
                        token: $cookieStore.get('user_token')
                    },
                    data = [],
                    headers = {'Content-Type': 'application/x-www-form-urlencoded'};
            	for (var k in params) data.push(k + '=' + params[k]);
            	console.log(data.join('&'));
            	$http
                    .post(SERVER_URL + 'order', data.join('&'), {headers: headers})
            		.success(function (data, status) {
            			product.quantity -= data.quantity;
            		})
            		.error(function (data, status) {
            			if (status == 400) {
            				alert("Wrong quantity");
            			} else if (status == 403) {
            				alert("You must be logged in");
            			}
            		});
            };
        }
    ])

    .controller('LoginCtrl', ['$scope', '$http', '$cookieStore',
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
