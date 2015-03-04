'use strict';

var productServices = angular.module('productServices', ['ngResource']);

productServices.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}]);

productServices.factory('Product', ['$resource',
    function($resource){
        return $resource('http://127.0.0.1:8080/WSProvider/rest/product', {}, {
            query: {method:'GET'}
        });
    }
]);
