ctrls.controller('detailController',['$scope','$state','$stateParams','GetOneMoving'
,function($scope,$state,$stateParams,GetOneMoving){

  $scope.moving = GetOneMoving.get({id:$stateParams.id},function(){
    console.log($scope.moving);
  });


}]);
