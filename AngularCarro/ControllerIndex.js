angular.module("AppIndex", [])
   .controller("ControllerIn", function ($scope, $http) {
      $scope.nombre = "Juan";
      $scope.newPost = {};
      $scope.responses = [];
      $scope.gets = null;
      $scope.moviments = "";
      $scope.columns = 0;
      $scope.rows = 0;

      $scope.configSurface = function () {
         if($scope.columns > 0 && $scope.rows > 0){
            $http({
               method: 'POST',
               url: 'http://localhost:9090/Servicios/configSurface',
               headers: {
                  "Content-Type": "application/json"
               },
               data: { "rows": $scope.rows,
                     "columns" : $scope.columns
                     }
            }).then(function (response) {
               console.log(response);
               $scope.posts = response;
               alert("Matriz creada");
            }, function (error) {
               console.log(error);
            });
         }else{
            alert("Debe ingresar datos mayores a 0 y no nulos");
         }

      }

      $scope.displacement = function () {
         $http({
            method: 'POST',
            url: 'http://localhost:9090/Servicios/displacement',
            headers: {
               "Content-Type": "application/json"
            },
            data: { "moviments": $scope.moviments }
         }).then(function (response) {
            console.log(response);
            $scope.posts = response;
            alert($scope.moviments);
         }, function (error) {
            console.log(error);
         });
      }

      $scope.getPosition = function () {
         $http({
            method: 'GET',
            url: 'http://localhost:9090/Servicios/getPosition',
            headers: {
               "Content-Type": "application/json"
            },
            data: {}
         }).then(function (response) {
            console.log(response);
            $scope.gets = response;
         }, function (error) {
            console.log(error);
         });
      }
   })