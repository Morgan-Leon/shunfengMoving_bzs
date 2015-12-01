//mainCtrl.js
var ctrls = angular.module('nourControllers', ['nourConfig', 'ngResource',
    'movingServices']);

ctrls.controller('mainController',['$scope','GetMoving',function($scope,GetMoving){

  $scope.name = "查询";

  GetMoving.get({page:0,size:3},function(data){
    console.log(data);
    $scope.movingInfo = data;

  })
}]);
