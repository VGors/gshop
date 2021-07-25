angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http({
            url: "http://localhost:8189/gshop/products",
            method: 'GET',
            params: {}
        }).then(function (response) {
            console.log(response);
            $scope.products = response.data;
        });
    };

    $scope.loadPage = function (pageIndex = 1) {
        $http({
            url: "http://localhost:8189/gshop/product_pages",
            method: 'GET',
            params: {
                'p': pageIndex
            }
        }).then(function (response) {
            console.log(response);
        });
    };

    $scope.showProductInfo = function (productID) {
        $http({
            url: "http://localhost:8189/gshop/products/" + productID,
            method: 'GET'
        }).then(function (response) {
            alert(response.data.title);
        });
    }

    $scope.deleteProduct = function (productID) {
        $http({
            url: "http://localhost:8189/gshop/delete_product/" + productID,
            method: 'GET'
        }).then(function (response){
            $scope.loadProducts();
        });
    }

    $scope.loadProducts();
});