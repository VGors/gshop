angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/gshop'

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: contextPath + "/api/v1/products",
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data.content;
        });
    };

    $scope.showProductInfo = function (productID) {
        $http({
            url: contextPath + "/api/v1/products/" + productID,
            method: 'GET'
        }).then(function (response) {
            alert(response.data.title);
        });
    }

    $scope.deleteProduct = function (productID) {
        $http({
            url: contextPath + "/api/v1/products/" + productID,
            method: 'DELETE'
        }).then(function (response) {
            $scope.loadPage();
        });
    }

    $scope.loadPage();
});